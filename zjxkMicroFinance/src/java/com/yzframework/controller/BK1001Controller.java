package com.yzframework.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yzframework.base.Page;
import com.yzframework.model.Monline;
import com.yzframework.model.Muser;
import com.yzframework.service.MonlineService;

@Controller
@RequestMapping("/views/BK1001")
public class BK1001Controller {
	
	@Resource
	private MonlineService monlineService;
	
	/**
	 * 查询出所有的在线用户信息
	 * @param page
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/application")
	public ModelAndView application(Page page,Monline model) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		Page p = monlineService.findByList(page, model);
		mav.addObject("page", p);
		mav.setViewName("BK1001");
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
		mav.addObject("model",model);
		mav.setViewName("BK100101");

		return mav;
	}
}
