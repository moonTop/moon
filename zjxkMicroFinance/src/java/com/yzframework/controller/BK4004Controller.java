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
import com.yzframework.model.Fmodule;
import com.yzframework.model.Morg;
import com.yzframework.model.Mrole;
import com.yzframework.model.Muser;
import com.yzframework.model.Tauthority;
import com.yzframework.service.FmoduleService;
import com.yzframework.service.MOrgService;
import com.yzframework.service.MRoleService;
import com.yzframework.service.MuserService;
import com.yzframework.service.TauthorityService;
import com.yzframework.utils.PasswordUtil;

@Controller
@RequestMapping("/views/BK4004")
public class BK4004Controller {
    protected final Log logger = LogFactory.getLog(getClass());
   
//	@Resource
//	private MOrgService mOrgService;
//	
//	@Resource
//	private MRoleService mRoleService;
	
	@Resource
	private TauthorityService tauthorityService;
	
	

    /**
	 * 后台用户角色一览检索
	 * @param page
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/authority")
	public ModelAndView authority(Page page, Tauthority model) throws Exception {
		Page p = tauthorityService.findPageTauthority(page, model);
		ModelAndView mav = new ModelAndView();
		mav.addObject("page",p);
		mav.setViewName("BK4004");

		return mav;
	}
	
	
	
//	/**
//	 * 后台用户角色详细页面初始化
//	 * @param id 
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping("/editrole/{id}")
//	public ModelAndView editrole(@PathVariable String id) throws Exception {
//		ModelAndView mav = new ModelAndView();
//		Mrole model = mRoleService.findById(id);
//		mav.addObject("model",model);
//		mav.setViewName("BK400301");
//
//		return mav;
//	}
//	
//	/**
//	 * 新建 后台管理用户角色
//	 * @param model
//	 * @param navTabId
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping("/save")
//	@ResponseBody
//	public String save(Morg model,String navTabId) {
//		AjaxDone ajaxDone = new AjaxDone();
//		try{
//		    mOrgService.save(model);
//			ajaxDone.setNavTabId(navTabId);
//			ajaxDone.setStatusCode(AjaxDone.SUCCESS);
//			ajaxDone.setCallbackType(AjaxDone.CLOSECURRENT);
//		}catch(Exception e){
//		    logger.error(null, e);
//			ajaxDone.setStatusCode(AjaxDone.FAIL);
//			ajaxDone.setMessage(AjaxDone.FAIL_MSG);
//		}
//		
//		return JSON.toJSONString(ajaxDone);
//	}
//	
//    /**
//     * 角色唯一检查
//     * @param model
//     * @param navTabId
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping("/checkroleid")
//    @ResponseBody
//    public String checkuserid(String roleid) throws Exception {
//        List<Mrole> userList = mRoleService.findByRoleid(roleid);
//        if (userList.size() > 0) {
//            return "false";
//        }
//        return "true";
//    }
//	
//	/**
//     * 更新后台管理用户角色
//     * @param model
//     * @param navTabId
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping("/updaterole")
//    @ResponseBody
//    public String update(Mrole model,String navTabId) {
//        AjaxDone ajaxDone = new AjaxDone();
//        try{
//
//            mRoleService.update(model);
//            ajaxDone.setNavTabId(navTabId);
//            ajaxDone.setStatusCode(AjaxDone.SUCCESS);
//            ajaxDone.setCallbackType(AjaxDone.CLOSECURRENT);
//        }catch(Exception e){
//            logger.error(null, e);
//            ajaxDone.setStatusCode(AjaxDone.FAIL);
//            ajaxDone.setMessage(AjaxDone.FAIL_MSG);
//        }
//        
//        return JSON.toJSONString(ajaxDone);
//    }
//    
//	
//	/**
//	 * 删除后台用户角色
//	 * @param id
//	 * @return
//	 */
//	@RequestMapping("/removerole")
//	@ResponseBody
//	public String removerole(String id) {
//		AjaxDone ajaxDone = new AjaxDone();
//		try {
//            Mrole mrole = mRoleService.findById(id);
//            mrole.setStatus("2");
//            mRoleService.update(mrole);
//			ajaxDone.setStatusCode(AjaxDone.SUCCESS);
//		} catch(Exception e) {
//		    logger.error(null, e);
//			ajaxDone.setStatusCode(AjaxDone.FAIL);
//			ajaxDone.setMessage(AjaxDone.FAIL_MSG);
//		}
//
//		return JSON.toJSONString(ajaxDone);
//	}
//	
//    /**
//     * 审核通过
//     * @param id
//     * @return
//     */
//    @RequestMapping("/checkok")
//    @ResponseBody
//    public String checkok(String id) {
//        AjaxDone ajaxDone = new AjaxDone();
//        try {
//            Morg morg = mOrgService.findById(id);
//            morg.setStatus("1");
//            mOrgService.update(morg);
//            ajaxDone.setStatusCode(AjaxDone.SUCCESS);
//        } catch(Exception e) {
//            logger.error(null, e);
//            ajaxDone.setStatusCode(AjaxDone.FAIL);
//            ajaxDone.setMessage(AjaxDone.FAIL_MSG);
//        }
//
//        return JSON.toJSONString(ajaxDone);
//    }
}
