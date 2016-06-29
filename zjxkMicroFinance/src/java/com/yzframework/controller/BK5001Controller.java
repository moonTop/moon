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
import com.yzframework.base.AjaxDone;
import com.yzframework.base.Page;
import com.yzframework.model.Mcustomer;
import com.yzframework.service.MCustomerService;

@Controller
@RequestMapping("/views/BK5001")
public class BK5001Controller {
    protected final Log logger = LogFactory.getLog(getClass());
   
    @Resource
    private MCustomerService mcustomerService;
	
    /**
	 * 后台用户角色一览检索
	 * @param page
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/customerList")
	public ModelAndView customerList(Page page, Mcustomer model) throws Exception {
		Page p = mcustomerService.findPageCustomer(page, model);
		ModelAndView mav = new ModelAndView();
		mav.addObject("page",p);
		mav.setViewName("BK5001");

		return mav;
	}
	
	
	/**
	 * 后台用户角色详细页面初始化
	 * @param id 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/editCustomer/{id}")
	public ModelAndView editrole(@PathVariable String id) throws Exception {
		ModelAndView mav = new ModelAndView();
		Mcustomer model = mcustomerService.findById(id);
		mav.addObject("model",model);
		mav.setViewName("BK500101");

		return mav;
	}
	
	
	/**
     * 更新客户管理
     * @param model
     * @param navTabId
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateCustomer")
    @ResponseBody
    public String update(Mcustomer model,String navTabId) {
        AjaxDone ajaxDone = new AjaxDone();
        try{

            mcustomerService.update(model);
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
    
	
	
}
