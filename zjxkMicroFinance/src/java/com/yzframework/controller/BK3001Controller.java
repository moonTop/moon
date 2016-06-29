package com.yzframework.controller;

import java.math.BigDecimal;

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
import com.yzframework.base.BaseController;
import com.yzframework.base.Page;
import com.yzframework.model.Mloanrecord;
import com.yzframework.model.Mpayrecord;
import com.yzframework.service.MloanrecordService;
import com.yzframework.service.MpayrecordService;

@Controller
@RequestMapping("/views/BK3001")
public class BK3001Controller extends BaseController {
    protected final Log logger = LogFactory.getLog(getClass());
   
    @Resource
    private MloanrecordService mloanrecordService;
    
    @Resource
    private MpayrecordService mpayrecordService;
    
    /**
	 * 后台用户角色一览检索
	 * @param page
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/loanList")
	public ModelAndView loanList(Page page, Mloanrecord model) throws Exception {
		Page p = mloanrecordService.findPageMloanrecord(page, model);
		ModelAndView mav = new ModelAndView();
		mav.addObject("page",p);
		mav.setViewName("BK3001");

		return mav;
	}
	
	
	/**
	 * 后台用户角色详细页面初始化
	 * @param id 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/editMloanrecord/{id}")
	public ModelAndView editrole(@PathVariable String id) throws Exception {
		ModelAndView mav = new ModelAndView();
		Mloanrecord model = mloanrecordService.findById(id);
		mav.addObject("model",model);
		mav.setViewName("BK300101");

		return mav;
	}
	
	/**
	 * 后台用户角色详细页面初始化
	 * @param id 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/viewMloanrecord/{id}")
	public ModelAndView viewMloanrecord(@PathVariable String id) throws Exception {
		ModelAndView mav = new ModelAndView();
		Mloanrecord model = mloanrecordService.findById(id);
		mav.addObject("model",model);
		mav.setViewName("BK300102");

		return mav;
	}
	
	/**
     * 更新客户管理
     * @param model
     * @param navTabId
     * @return 
     * @throws Exception
     */
    @RequestMapping("/updateMloanrecord")
    @ResponseBody
    public String update(Mloanrecord model,String navTabId) {
        AjaxDone ajaxDone = new AjaxDone();
        try{

        	mloanrecordService.update(model);
        	
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
