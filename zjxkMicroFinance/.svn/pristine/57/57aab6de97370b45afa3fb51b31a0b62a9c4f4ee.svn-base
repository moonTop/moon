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
import com.yzframework.base.BaseController;
import com.yzframework.base.Page;
import com.yzframework.model.Mapply;
import com.yzframework.service.ApplyService;

@Controller
@RequestMapping("/views/BK1003")
public class BK1003Controller extends BaseController {
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Resource
	private ApplyService applyService;
	
	/**
	 * 企业贷信息
	 * @param page
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/houseList")
	public ModelAndView houseList(Page page,Mapply model) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		Page p = applyService.findPage02(page, model);
		
		mav.addObject("page",p);
		mav.addObject("model",model);
		mav.setViewName("BK1003");
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
		Mapply model = applyService.findById(id);
		mav.addObject("model",model);
		mav.setViewName("BK100301");

		return mav;
	}
	
	/**
     * 更新楼易贷客户信息
     * @param model
     * @param navTabId
     * @return
     * @throws Exception
     */
    @RequestMapping("/update")
    @ResponseBody
    public String update(Mapply model,String navTabId) {
        AjaxDone ajaxDone = new AjaxDone();
        try{
        	
        	applyService.update(model);
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
