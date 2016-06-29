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
import com.yzframework.model.Morg;
import com.yzframework.model.Muser;
import com.yzframework.service.MOrgService;
import com.yzframework.service.MuserService;
import com.yzframework.utils.PasswordUtil;

@Controller
@RequestMapping("/views/BK4002")
public class BK4002Controller {
    protected final Log logger = LogFactory.getLog(getClass());
    
	@Resource
	private MuserService muserService;
	
	@Resource
	private MOrgService mOrgService;

    /**
	 * 后台用户一览检索
	 * @param page
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/department")
	public ModelAndView department(Page page, Morg model) throws Exception {
		Page p = mOrgService.findPage(page, model);
//		for (int i = 0; i < p.getResultList().size(); i++) {
//		    Muser m = (Muser)p.getResultList().get(i);
//			if ("1".equals(m.getRoleid())) {
//			    m.setRoleid("人才港管理员");
//			} else if ("2".equals(m.getRoleid())) {
//                m.setRoleid("人才港普通用户");
//            } else {
//                m.setRoleid("企业用户");
//            }
//		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("page",p);
		mav.addObject("model",model);
		mav.setViewName("BK4002");

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
		Morg model = new Morg();
		mav.addObject("model",model);
		mav.setViewName("BK400201");

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
		Morg model = mOrgService.findById(id);
		mav.addObject("model",model);
		mav.setViewName("BK400201");

		return mav;
	}
	
	/**
	 * 新建 后台管理用户
	 * @param model
	 * @param navTabId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	@ResponseBody
	public String save(Morg model,String navTabId) {
		AjaxDone ajaxDone = new AjaxDone();
		try{
		    mOrgService.save(model);
			ajaxDone.setNavTabId(navTabId);
			ajaxDone.setStatusCode(AjaxDone.SUCCESS);
			ajaxDone.setCallbackType(AjaxDone.CLOSECURRENT);
		}catch(Exception e){
		    logger.error(null, e);
			ajaxDone.setStatusCode(AjaxDone.FAIL);
			ajaxDone.setMessage(AjaxDone.FAIL_MSG);
		}
		
		return JSON.toJSONString(ajaxDone);
	}
	
    /**
     * 部门唯一检查
     * @param model
     * @param navTabId
     * @return
     * @throws Exception
     */
    @RequestMapping("/checkorgno")
    @ResponseBody
    public String checkuserid(String orgno) throws Exception {
        List<Morg> userList = mOrgService.findByOrgno(orgno);
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
    @RequestMapping("/update")
    @ResponseBody
    public String update(Morg model,String navTabId) {
        AjaxDone ajaxDone = new AjaxDone();
        try{

            mOrgService.update(model);
            ajaxDone.setNavTabId(navTabId);
            ajaxDone.setStatusCode(AjaxDone.SUCCESS);
            ajaxDone.setCallbackType(AjaxDone.CLOSECURRENT);
        }catch(Exception e){
            logger.error(null, e);
            ajaxDone.setStatusCode(AjaxDone.FAIL);
            ajaxDone.setMessage(AjaxDone.FAIL_MSG);
        }
        
        return JSON.toJSONString(ajaxDone);
    }
    
	
	/**
	 * 删除后台部门
	 * @param id
	 * @return
	 */
	@RequestMapping("/remove")
	@ResponseBody
	public String remove(String id) {
		AjaxDone ajaxDone = new AjaxDone();
		try {
            Morg morg = mOrgService.findById(id);
            morg.setStatus("2");
            mOrgService.update(morg);
			ajaxDone.setStatusCode(AjaxDone.SUCCESS);
		} catch(Exception e) {
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
            Morg morg = mOrgService.findById(id);
            morg.setStatus("1");
            mOrgService.update(morg);
            ajaxDone.setStatusCode(AjaxDone.SUCCESS);
        } catch(Exception e) {
            logger.error(null, e);
            ajaxDone.setStatusCode(AjaxDone.FAIL);
            ajaxDone.setMessage(AjaxDone.FAIL_MSG);
        }

        return JSON.toJSONString(ajaxDone);
    }
}
