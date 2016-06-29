package com.yzframework.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.yzframework.base.AjaxDone;
import com.yzframework.base.Constant;
import com.yzframework.base.Page;
import com.yzframework.base.YZUserGroupCallbackImpl;
import com.yzframework.model.Morg;
import com.yzframework.model.Muser;
import com.yzframework.model.Tuserrole;
import com.yzframework.service.MOrgService;
import com.yzframework.service.MuserService;
import com.yzframework.service.TUserRoleService;
import com.yzframework.utils.PasswordUtil;

@Controller
@RequestMapping("/views/BK4001")
public class BK4001Controller {
	protected final Log logger = LogFactory.getLog(getClass());

	@Resource
	private MuserService muserService;

	@Resource
	private MOrgService mOrgService;

	@Resource
	private TUserRoleService tUserRoleService;

	@Resource
	private YZUserGroupCallbackImpl yzUserGroupCallback;

	/**
	 * 后台用户一览检索
	 * @param page
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public ModelAndView list(Page page, Muser model) throws Exception {
		Page p = muserService.findPage02(page, model);
		ModelAndView mav = new ModelAndView();

		mav.addObject("page", p);
		// mav.addObject("model",model);
		mav.setViewName("BK4001");

		return mav;
	}

	/**
	 * 后台用户添加
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/add")
	public ModelAndView add() throws Exception {
		ModelAndView mav = new ModelAndView();
		Muser model = new Muser();
		mav.addObject("model", model);
		mav.setViewName("BK400101");

		return mav;
	}

	/**
	 * 后台用户详细页面初始化
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable String id) throws Exception {
		ModelAndView mav = new ModelAndView();
		System.out.println(id);
		Muser model = muserService.findByid(id);
		mav.addObject("model", model);
		mav.setViewName("BK400101");

		return mav;
	}

	/**
	 * 新建 后台管理用户
	 * @param model
	 * @param navTabId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/conserveUser")
	@ResponseBody
	public String save(Muser model, String navTabId) {
		AjaxDone ajaxDone = new AjaxDone();
		try {
			Morg morg = mOrgService.findById(model.getOrgid());
			model.setMorg(morg);
			model.setPassword(PasswordUtil.encryPassword(Constant.RESET_PASSWORD));
			model.setStatus("1");
			muserService.save(model);
			ajaxDone.setNavTabId(navTabId);
			ajaxDone.setStatusCode(AjaxDone.SUCCESS);
			ajaxDone.setCallbackType(AjaxDone.CLOSECURRENT);
		} catch (Exception e) {
			logger.error(null, e);
			ajaxDone.setStatusCode(AjaxDone.FAIL);
			ajaxDone.setMessage(AjaxDone.FAIL_MSG);
		}

		return JSON.toJSONString(ajaxDone);
	}

	/**
	 * 用户名唯一检查
	 * @param model
	 * @param navTabId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/checkuserid")
	@ResponseBody
	public String checkuserid(String userid) throws Exception {
		List<Muser> userList = muserService.findByUserid(userid);
		if (userList.size() > 0) {
			return "false";
		}
		return "true";
	}

	/**
	 * 更新后台管理用户
	 * @param model
	 * @param navTabId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/reviseUser")
	@ResponseBody
	public String updateUser(Muser model, String navTabId) {
		AjaxDone ajaxDone = new AjaxDone();
		try {
			Morg morg = mOrgService.findById(model.getOrgid());
			model.setMorg(morg);

			muserService.update(model);
			ajaxDone.setNavTabId(navTabId);
			ajaxDone.setStatusCode(AjaxDone.SUCCESS);
			ajaxDone.setCallbackType(AjaxDone.CLOSECURRENT);
		} catch (Exception e) {
			logger.error(null, e);
			ajaxDone.setStatusCode(AjaxDone.FAIL);
			ajaxDone.setMessage(AjaxDone.FAIL_MSG);
		}

		return JSON.toJSONString(ajaxDone);
	}

	/**
	 * 重置后台管理用户密码
	 * @param id
	 * @return
	 */
	@RequestMapping("/resetUserPassword")
	@ResponseBody
	public String resetpassword(String id) {
		AjaxDone ajaxDone = new AjaxDone();
		try {
			Muser muser = muserService.findByid(id);
			muser.setPassword(PasswordUtil.encryPassword(Constant.RESET_PASSWORD));
			muserService.update(muser);
			ajaxDone.setStatusCode(AjaxDone.SUCCESS);
		} catch (Exception e) {
			logger.error(null, e);
			ajaxDone.setStatusCode(AjaxDone.FAIL);
			ajaxDone.setMessage(AjaxDone.FAIL_MSG);
		}

		return JSON.toJSONString(ajaxDone);
	}

	/**
	 * 删除后台管理用户
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteUserInfo")
	@ResponseBody
	public String remove(String id) {
		AjaxDone ajaxDone = new AjaxDone();
		try {
			Muser muser = muserService.findByid(id);
			muser.setStatus("2");
			muserService.update(muser);
			ajaxDone.setStatusCode(AjaxDone.SUCCESS);
		} catch (Exception e) {
			logger.error(null, e);
			ajaxDone.setStatusCode(AjaxDone.FAIL);
			ajaxDone.setMessage(AjaxDone.FAIL_MSG);
		}

		return JSON.toJSONString(ajaxDone);
	}

	/**
	 * 审核通过
	 * @param id
	 * @return
	 */
	@RequestMapping("/checkok")
	@ResponseBody
	public String checkok(String id) {
		AjaxDone ajaxDone = new AjaxDone();
		try {
			Muser muser = muserService.findByid(id);
			muser.setStatus("1");
			muserService.update(muser);
			ajaxDone.setStatusCode(AjaxDone.SUCCESS);
		} catch (Exception e) {
			logger.error(null, e);
			ajaxDone.setStatusCode(AjaxDone.FAIL);
			ajaxDone.setMessage(AjaxDone.FAIL_MSG);
		}

		return JSON.toJSONString(ajaxDone);
	}

	/**
	 * 角色分配
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userRoleDetail")
	public ModelAndView role(String id) throws Exception {
		ModelAndView mav = new ModelAndView();
		List<Tuserrole> userRoleLst = tUserRoleService.find01(id);
		if (userRoleLst.size() == 1) {
			Tuserrole useRole = userRoleLst.get(0);
			mav.addObject("model", useRole);
		}

		mav.setViewName("BK400102");
		return mav;
	}

	/**
	 * 保存分配的用户角色
	 * @param model
	 * @param navTabId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/roleSave")
	@ResponseBody
	public String rolesave(Tuserrole model, String navTabId) {
		AjaxDone ajaxDone = new AjaxDone();
		try {
			List<Tuserrole> ruserrole = tUserRoleService.findselectid(model.getUserid());

			if (ruserrole.size() > 0) {
				tUserRoleService.update(model);
			} else {
				model.setStatus("1");
				tUserRoleService.save(model);
			}
			
			// 流程用用户角色关系
			yzUserGroupCallback.addRole(model.getRoleid());
			if (ruserrole.size() > 0){
				yzUserGroupCallback.removeUserFromRole(model.getUserid(), ruserrole.get(0).getRoleid());
			}
			yzUserGroupCallback.addUserToRole(model.getUserid(), model.getRoleid());
			
			ajaxDone.setNavTabId(navTabId);
			ajaxDone.setStatusCode(AjaxDone.SUCCESS);
			ajaxDone.setCallbackType(AjaxDone.CLOSECURRENT);
		} catch (Exception e) {
			logger.error(null, e);
			ajaxDone.setStatusCode(AjaxDone.FAIL);
			ajaxDone.setMessage(AjaxDone.FAIL_MSG);
		}

		return JSON.toJSONString(ajaxDone);
	}
}
