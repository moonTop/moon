package com.yzframework.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.drools.KnowledgeBase;
import org.drools.definition.process.Connection;
import org.drools.definition.process.Node;
import org.drools.definition.process.Process;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.process.NodeInstance;
import org.drools.runtime.process.ProcessInstance;
import org.jbpm.ruleflow.core.RuleFlowProcess;
import org.jbpm.ruleflow.instance.RuleFlowProcessInstance;
import org.jbpm.task.Comment;
import org.jbpm.task.Status;
import org.jbpm.task.Task;
import org.jbpm.task.User;
import org.jbpm.task.query.TaskSummary;
import org.jbpm.task.service.local.LocalTaskService;
import org.jbpm.workflow.instance.WorkflowProcessInstance;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.yzframework.base.ActionContext;
import com.yzframework.base.AjaxDone;
import com.yzframework.base.JbpmBase;
import com.yzframework.base.Page;
import com.yzframework.bean.CommentBean;
import com.yzframework.bean.TaskBean;
import com.yzframework.model.Mcarloanform;
import com.yzframework.model.Muser;
import com.yzframework.service.CommonService;
import com.yzframework.service.JbpmService;
import com.yzframework.service.MCardLoanService;
import com.yzframework.service.MCustomerService;
import com.yzframework.service.MuserService;
import com.yzframework.utils.ConvertUtil;

@Controller
@RequestMapping("/views/mobileManage")
public class MobileManageController extends JbpmBase {

	protected final Log logger = LogFactory.getLog(getClass());

	@Resource
	private KnowledgeBase kbase;

	@Resource
	private StatefulKnowledgeSession ksession;

	@Resource
	private LocalTaskService taskService;

	@Resource
	private JbpmService jbpmService;

	@Resource
	private MuserService muserService;

	@Resource
	private MCardLoanService mCarLoanService;

	@Resource
	private MCustomerService mCustomerService;

	@Resource
	private CommonService commonService;

	@RequestMapping("/todoList")
	public ModelAndView todoList(Page page, HttpSession session) {

		String currentUser = (String) session.getAttribute("CURRENT_USER");
		ModelAndView mav = new ModelAndView();

		List<Status> statusList = new ArrayList<Status>();
		statusList.add(Status.Ready);
		List<TaskSummary> tasks = taskService
				.getTasksAssignedAsPotentialOwnerByStatus(currentUser,
						statusList, "en-UK");

		List<TaskBean> todoList = new ArrayList<TaskBean>();

		Set<TaskSummary> taskSet = new TreeSet<TaskSummary>(
				new Comparator<TaskSummary>() {
					@Override
					public int compare(TaskSummary o1, TaskSummary o2) {
						if (o1.equals(o2)) {
							return 0;
						}
						if (o1.getCreatedOn().after(o2.getCreatedOn())) {
							return -1;
						} else {
							return 1;
						}
					}
				});
		taskSet.addAll(tasks);

		for (Iterator<TaskSummary> taskIt = taskSet.iterator(); taskIt
				.hasNext();) {
			TaskSummary taskSummary = taskIt.next();
			User actualOwner = taskSummary.getActualOwner();
			if (actualOwner == null || StringUtils.isEmpty(actualOwner.getId())
					|| currentUser.equals(actualOwner.getId())) {
				todoList.add(convertTaskBean(taskSummary));
			}
		}
		List<TaskBean> doneList = this.findDoneList(currentUser);
		// Page p = new Page();
		// p.setNumPerPage(page.getNumPerPage());
		// p.setTotalCount(new Long(todoList.size()));
		// p.setPageNum(page.getPageNum());
		//
		// mav.addObject("page", p);
		mav.addObject("tasks", todoList);
		mav.addObject("count", todoList.size());
		mav.addObject("doneList", doneList);
		mav.addObject("doneCount", doneList.size());
		mav.setViewName("mobileTaskList");

		return mav;
	}

	@RequestMapping("/approval/{taskId}")
	public ModelAndView approval(@PathVariable String taskId) throws Exception {

		Task task = taskService.getTask(Long.parseLong(taskId));
		long processInstanceId = task.getTaskData().getProcessInstanceId();
		ProcessInstance processInstance = ksession
				.getProcessInstance(processInstanceId);
		WorkflowProcessInstance wkProcessInstance = (WorkflowProcessInstance) processInstance;
		String businessId = (String) wkProcessInstance
				.getVariable("businessId");

		// String processId = task.getTaskData().getProcessId();
		// 取得action
		// String action = jbpmService.findAction(processId, "editMobile");

		ModelAndView mav = new ModelAndView();
		Mcarloanform model = mCarLoanService.findById(businessId);

		// 当前任务名称
		String nodeName = super.getCurrentNodeName(Long.parseLong(taskId));
		mav.addObject("model", model);
		mav.addObject("taskId", taskId);
		mav.addObject("nodeName", nodeName);
		List<CommentBean> commentList = this.findComment(taskId);
		mav.addObject("commentList", commentList);
		mav.setViewName("mobileApproval");

		return mav;

	}

	@RequestMapping("approve")
	@ResponseBody
	public String approve(Mcarloanform model, String taskId, String commentText)
			throws Exception {
		AjaxDone ajaxDone = new AjaxDone();
		try {
			// 当前任务名称
			String nodeName = super.getCurrentNodeName(Long.parseLong(taskId));
			if ("客户经理填写贷款报告".equals(nodeName)) {
				mCarLoanService.update(model);
			}
			if ("财务放款".equals(nodeName)) {
				commonService.saveLoanInfo(model.getId(),"车易贷");
			}
			String userId = ActionContext.getSession().getUserid();
			// 开始并完成任务
			super.startAndCompleteTask(Long.parseLong(taskId), userId,
					commentText, false);
			ajaxDone.setStatusCode(AjaxDone.SUCCESS);
		} catch (Exception e) {
			logger.error(null, e);
			ajaxDone.setStatusCode(AjaxDone.FAIL);
			ajaxDone.setMessage(AjaxDone.FAIL_MSG);
		}

		return JSON.toJSONString(ajaxDone);
	}

	@RequestMapping("/viewflow/{taskId}")
	public ModelAndView viewflow(@PathVariable String taskId) {

		ModelAndView mav = new ModelAndView();

		Task task = taskService.getTask(Long.parseLong(taskId));

		long processInstanceId = task.getTaskData().getProcessInstanceId();
		String processId = task.getTaskData().getProcessId();

		Process process = kbase.getProcess(processId);
		RuleFlowProcess ruleFlowProcess = (RuleFlowProcess) process;

		ProcessInstance processInstance = ksession
				.getProcessInstance(processInstanceId);

		// 所有节点
		List<Node> nodes = Arrays.asList(ruleFlowProcess.getNodes());
		List<Connection> connections = new ArrayList<Connection>();
		// 节点连线
		for (Node node : nodes) {
			connections.addAll(node.getOutgoingConnections("DROOLS_DEFAULT"));
		}
		// 当前节点
		List<Node> currentNodes = new ArrayList<Node>();
		if (processInstance != null) {
			RuleFlowProcessInstance ruleFlowProcessInstance = (RuleFlowProcessInstance) processInstance;
			Collection<NodeInstance> nodeInstances = ruleFlowProcessInstance
					.getNodeInstances();
			for (NodeInstance nodeInstance : nodeInstances) {
				long nodeId = nodeInstance.getNodeId();
				currentNodes.add(ruleFlowProcess.getNode(nodeId));
			}
		}

		mav.addObject("allNodes", nodes);
		mav.addObject("connections", connections);
		mav.addObject("currentNodes", currentNodes);
		mav.setViewName("BK6003");

		return mav;
	}

	@RequestMapping("/viewdone/{taskId}")
	public ModelAndView viewdone(@PathVariable String taskId) throws Exception {
		Task task = taskService.getTask(Long.parseLong(taskId));
		long processInstanceId = task.getTaskData().getProcessInstanceId();
		String processId = task.getTaskData().getProcessId();
		// 取得action
		String businessId = jbpmService.findBusinessId(processId,
				processInstanceId);
		Mcarloanform model = mCarLoanService.findById(businessId);

		ModelAndView mav = new ModelAndView();

		// 当前任务名称
		String nodeName = super.getCurrentNodeName(Long.parseLong(taskId));
		mav.addObject("model", model);
		mav.addObject("taskId", taskId);
		mav.addObject("nodeName", nodeName);
		List<CommentBean> commentList = this.findComment(taskId);
		mav.addObject("commentList", commentList);
		mav.setViewName("mobileViewDone");

		return mav;
	}

	@RequestMapping("/withdraw")
	@ResponseBody
	public String withdraw(Mcarloanform model, String taskId, String commentText)
			throws Exception {
		AjaxDone ajaxDone = new AjaxDone();
		try {
			String userId = ActionContext.getSession().getUserid();
			// 开始并完成任务
			super.startAndCompleteTask(Long.parseLong(taskId), userId,
					commentText, true);
			ajaxDone.setStatusCode(AjaxDone.SUCCESS);
		} catch (Exception e) {
			logger.error(null, e);
			ajaxDone.setStatusCode(AjaxDone.FAIL);
			ajaxDone.setMessage(AjaxDone.FAIL_MSG);
		}

		return JSON.toJSONString(ajaxDone);
	}

	@RequestMapping("/abort")
	@ResponseBody
	public String abort(Mcarloanform model, String taskId, String commentText)
			throws Exception {
		AjaxDone ajaxDone = new AjaxDone();
		try {
			String userId = ActionContext.getSession().getUserid();
			// 开始并完成任务
			long processInstanceId = super.startAndCompleteTask(
					Long.parseLong(taskId), userId, commentText, true);
			super.abortProcess(processInstanceId);
			ajaxDone.setStatusCode(AjaxDone.SUCCESS);
		} catch (Exception e) {
			logger.error(null, e);
			ajaxDone.setStatusCode(AjaxDone.FAIL);
			ajaxDone.setMessage(AjaxDone.FAIL_MSG);
		}

		return JSON.toJSONString(ajaxDone);
	}

	private List<TaskBean> findDoneList(String currentUser) {

		List<Status> statusList = new ArrayList<Status>();
		statusList.add(Status.Completed);
		List<TaskSummary> tasks = taskService.getTasksOwned(currentUser,
				statusList, "en-UK");

		List<TaskBean> doneList = new ArrayList<TaskBean>();

		Set<TaskSummary> taskSet = new TreeSet<TaskSummary>(
				new Comparator<TaskSummary>() {
					@Override
					public int compare(TaskSummary o1, TaskSummary o2) {
						if (o1.equals(o2)) {
							return 0;
						}
						if (o1.getCreatedOn().after(o2.getCreatedOn())) {
							return -1;
						} else {
							return 1;
						}
					}
				});
		taskSet.addAll(tasks);
		for (Iterator<TaskSummary> taskIt = taskSet.iterator(); taskIt
				.hasNext();) {
			TaskSummary taskSummary = taskIt.next();
			doneList.add(convertTaskBean(taskSummary));
		}

		return doneList;
	}

	private List<CommentBean> findComment(String taskId) throws Exception {
		List<CommentBean> commentLst = new ArrayList<CommentBean>();
		if (StringUtils.isEmpty(taskId)) {
			return commentLst;
		}

		Task task = taskService.getTask(Long.parseLong(taskId));
		long processInstanceId = task.getTaskData().getProcessInstanceId();

		List<Status> statusList = new ArrayList<Status>();
		statusList.add(Status.Completed);
		List<TaskSummary> tasks = taskService.getTasksByStatusByProcessId(
				processInstanceId, statusList, "en-UK");
		Set<TaskSummary> taskSet = new TreeSet<TaskSummary>(
				new Comparator<TaskSummary>() {
					@Override
					public int compare(TaskSummary o1, TaskSummary o2) {
						if (o1.getCreatedOn().after(o2.getCreatedOn())) {
							return -1;
						} else {
							return 1;
						}
					}
				});
		taskSet.addAll(tasks);
		int i = 1;
		for (Iterator<TaskSummary> taskIt = taskSet.iterator(); taskIt
				.hasNext();) {

			TaskSummary taskSummary = taskIt.next();
			long localTaskId = taskSummary.getId();
			Task localTask = taskService.getTask(localTaskId);
			List<Comment> comments = localTask.getTaskData().getComments();
			Collections.sort(comments, new Comparator<Comment>() {
				@Override
				public int compare(Comment o1, Comment o2) {
					if (o1.equals(o2)) {
						return 0;
					}
					if (o1.getAddedAt().after(o2.getAddedAt())) {
						return -1;
					} else {
						return 1;
					}
				}
			});
			if (comments != null && comments.size() > 0) {
				CommentBean comment = new CommentBean();
				List<Muser> users = muserService.findByUserid(comments.get(0)
						.getAddedBy().getId());
				comment.setUsername(users.get(0).getUsername());
				comment.setComment(comments.get(0).getText());
				commentLst.add(comment);
			}
		}
		return commentLst;
	}

	private TaskBean convertTaskBean(TaskSummary taskSummary) {
		TaskBean taskBean = new TaskBean();

		taskBean.setTaskId(String.valueOf(taskSummary.getId()));
		taskBean.setTaskName(taskSummary.getName());
		taskBean.setCreateTime(ConvertUtil.dateToYMDStr(
				taskSummary.getCreatedOn(), "yyyy-MM-dd HH:mm:ss"));
		Task task = taskService.getTask(taskSummary.getId());
		taskBean.setCompleteTime(ConvertUtil.dateToYMDStr(task.getTaskData()
				.getCompletedOn(), "yyyy-MM-dd HH:mm:ss"));
		switch (taskSummary.getStatus()) {
		case Ready:
			taskBean.setTaskStatus("待处理");
			break;
		case Completed:
			taskBean.setTaskStatus("完成");
			break;
		default:
			taskBean.setTaskStatus("处理中");
		}
		String processId = taskSummary.getProcessId();
		Process process = kbase.getProcess(processId);
		taskBean.setProcessId(processId);
		taskBean.setProcessName(process.getName());
		taskBean.setProcessInstanceId(String.valueOf(taskSummary
				.getProcessInstanceId()));

		return taskBean;
	}

}
