package com.yzframework.controller;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yzframework.base.Page;
import com.yzframework.model.Mlog;
import com.yzframework.service.MlogService;
import com.yzframework.utils.ConvertUtil;

@Controller
@RequestMapping("/views/BK4005")
public class BK4005Controller {
   
	@Resource
	private MlogService mlogService;
	
    /**
	 * 测试方案一览检索
	 * @param page
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/logList")
	public ModelAndView list(Page page, Mlog model) throws Exception {
		Page p = mlogService.findPage01(page, model);
		for (int i = 0; i < p.getResultList().size(); i++) {
		    Mlog mlog = (Mlog)p.getResultList().get(i);
		    mlog.setFormattedOptime(ConvertUtil.formatTimeStamp(mlog.getOptime(), "yyyy-MM-dd HH:mm:ss"));
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("page",p);
		mav.addObject("model",model);
		mav.setViewName("BK4005");

		return mav;
	}
}
