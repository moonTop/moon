package com.yzframework.controller;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.yzframework.base.ActionContext;
import com.yzframework.base.AjaxDone;
import com.yzframework.base.JbpmBase;
import com.yzframework.model.Mhouseloanform;
import com.yzframework.service.CommonService;
import com.yzframework.service.MHouseLoanService;

@Controller
@RequestMapping("/views/BK2002")
public class BK2002Controller extends JbpmBase {

    protected final Log logger = LogFactory.getLog(getClass());

    @Resource
    private MHouseLoanService mHouseLoanService;
    
    @Resource
	private CommonService commonService;
    
	@RequestMapping("/new")
	public ModelAndView add() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("BK200201");

		return mav;
	}
	
	@RequestMapping("/edit/{taskId}/{id}")
	public ModelAndView edit(@PathVariable String taskId, @PathVariable String id) throws Exception {
		ModelAndView mav = new ModelAndView();
		Mhouseloanform model = mHouseLoanService.findById(id);
		
		// 当前任务名称
		String nodeName = super.getCurrentNodeName(Long.parseLong(taskId));
		
		mav.addObject("model", model);
		mav.addObject("taskId", taskId);
		mav.addObject("nodeName", nodeName);
		mav.setViewName("BK200202");

		return mav;
	}
	
	@RequestMapping("/show/{taskId}/{id}")
	public ModelAndView show(@PathVariable String taskId, @PathVariable String id) throws Exception {
		
		Mhouseloanform model = mHouseLoanService.findById(id);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("model", model);
		mav.addObject("taskId", taskId);
		mav.setViewName("BK200203");

		return mav;
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public String save(Mhouseloanform model,String commentText, String navTabId) throws Exception {
		AjaxDone ajaxDone = new AjaxDone();
		try{
			String userId = ActionContext.getSession().getUserid();
			String userName = ActionContext.getSession().getUserName();
			model.setLiableperson1(userName);
			mHouseLoanService.save(model);

			// 创建并启动流程
			long processInstanceId = super.createAndStartProcess("HouseLoanProcess", userId, model.getId(), commentText);
			// 动态设定下一任务参与者
			//super.claimNextTask(processInstanceId, "zhaoyun");
	       
			ajaxDone.setStatusCode(AjaxDone.SUCCESS);
			ajaxDone.setMessage(AjaxDone.SUCCESS_MSG);
			ajaxDone.setCallbackType(AjaxDone.CLOSECURRENT);
		}catch(Exception e){
	        logger.error(null, e);
			ajaxDone.setStatusCode(AjaxDone.FAIL);
			ajaxDone.setMessage(AjaxDone.FAIL_MSG);
		}
		
		return JSON.toJSONString(ajaxDone);
	}
	
	@RequestMapping("/approve")
	@ResponseBody
	public String approve(Mhouseloanform model, String taskId, String commentText) throws Exception {
		AjaxDone ajaxDone = new AjaxDone();
		try{
			// 当前任务名称
			String nodeName = super.getCurrentNodeName(Long.parseLong(taskId));
			if ("客户经理填写贷款报告".equals(nodeName)) {
				mHouseLoanService.update(model);
			} else if ("风险部审批".equals(nodeName)) {
				String userName = ActionContext.getSession().getUserName();
				model.setLiableperson2(userName);
				mHouseLoanService.update(model);
			} else if ("财务放款".equals(nodeName)) {
				commonService.saveLoanInfo(model.getId(), "楼易贷");
			}
			String userId = ActionContext.getSession().getUserid();
			// 开始并完成任务
			super.startAndCompleteTask(Long.parseLong(taskId), userId, commentText, false);
			// 动态设定下一任务参与者
			// put your code here

			ajaxDone.setStatusCode(AjaxDone.SUCCESS);
			ajaxDone.setMessage(AjaxDone.SUCCESS_MSG);
			ajaxDone.setNavTabId(AjaxDone.TODOLIST_NAVTAB_ID);
			ajaxDone.setCallbackType(AjaxDone.CLOSECURRENT);
		}catch(Exception e){
	        logger.error(null, e);
			ajaxDone.setStatusCode(AjaxDone.FAIL);
			ajaxDone.setMessage(AjaxDone.FAIL_MSG);
		}
		
		return JSON.toJSONString(ajaxDone);
	}
	
	@RequestMapping("/withdraw")
	@ResponseBody
	public String withdraw(Mhouseloanform model, String taskId, String commentText) throws Exception {
		AjaxDone ajaxDone = new AjaxDone();
		try{
			String userId = ActionContext.getSession().getUserid();
			// 开始并完成任务
			super.startAndCompleteTask(Long.parseLong(taskId), userId, commentText, true);
			ajaxDone.setStatusCode(AjaxDone.SUCCESS);
			ajaxDone.setMessage(AjaxDone.SUCCESS_MSG);
			ajaxDone.setNavTabId(AjaxDone.TODOLIST_NAVTAB_ID);
			ajaxDone.setCallbackType(AjaxDone.CLOSECURRENT);
		}catch(Exception e){
	        logger.error(null, e);
			ajaxDone.setStatusCode(AjaxDone.FAIL);
			ajaxDone.setMessage(AjaxDone.FAIL_MSG);
		}
		
		return JSON.toJSONString(ajaxDone);
	}
	
	@RequestMapping("/abort")
	@ResponseBody
	public String abort(Mhouseloanform model, String taskId, String commentText) throws Exception {
		AjaxDone ajaxDone = new AjaxDone();
		try{
			String userId = ActionContext.getSession().getUserid();
			// 开始并完成任务
			long processInstanceId = super.startAndCompleteTask(Long.parseLong(taskId), userId, commentText, true);
			super.abortProcess(processInstanceId);
			ajaxDone.setStatusCode(AjaxDone.SUCCESS);
			ajaxDone.setMessage(AjaxDone.SUCCESS_MSG);
			ajaxDone.setNavTabId(AjaxDone.TODOLIST_NAVTAB_ID);
			ajaxDone.setCallbackType(AjaxDone.CLOSECURRENT);
		}catch(Exception e){
	        logger.error(null, e);
			ajaxDone.setStatusCode(AjaxDone.FAIL);
			ajaxDone.setMessage(AjaxDone.FAIL_MSG);
		}
		
		return JSON.toJSONString(ajaxDone);
	}
}
