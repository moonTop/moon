package com.yzframework.controller;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.yzframework.base.AjaxDone;
import com.yzframework.base.BaseController;
import com.yzframework.base.Model;
import com.yzframework.base.Page;
import com.yzframework.model.Mpayrecord;
import com.yzframework.service.MpayrecordService;

@Controller
@RequestMapping("/views/BK3002")
public class BK3002Controller extends BaseController {
	protected final Log logger = LogFactory.getLog(getClass());

	@Resource
	private MpayrecordService mpayrecordService;

	/**
	 * 后台还款信息检索
	 * 
	 * @param page
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/payList")
	public ModelAndView loanList(Page page, Mpayrecord model,String loanpersonname) throws Exception {
		ModelAndView mav = new ModelAndView();
		Page p = mpayrecordService.findPagePayrecord(page, model,loanpersonname);
		Date date = new Date(System.currentTimeMillis());
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(date);

		List<Model> lst = p.getResultList();
		for (Model item : lst) {
			Mpayrecord mpayrecord = (Mpayrecord) item;
			String paystatus = mpayrecord.getPaystatus();
			if (!StringUtils.isEmpty(paystatus) && "1".equals(paystatus)) {
				mpayrecord.setStatus("0");
				continue;
			}
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(mpayrecord.getPlanpaydate());
			if (calendar1.compareTo(calendar) < 0) {
				calendar.add(Calendar.DATE, -3);
				if (calendar1.compareTo(calendar) < 0) {
					mpayrecord.setStatus("0");
					continue;
				} else {
					// 三天之内橙色预警
					mpayrecord.setStatus("1");
					continue;
				}
			} else {
				// 当天或超期红色预警
				mpayrecord.setStatus("2");
				continue;
			}
		}

		mav.addObject("page", p);
		mav.setViewName("BK3002");

		return mav;
	}

	/**
	 * 后台用户角色详细页面初始化
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/editMpayrecord/{id}")
	public ModelAndView editMpayrecord(@PathVariable String id)
			throws Exception {
		ModelAndView mav = new ModelAndView();
		Mpayrecord model = mpayrecordService.findById(id);
		mav.addObject("model", model);
		mav.setViewName("BK300201");

		return mav;
	}

	/**
	 * 后台用户角色详细页面初始化
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/viewMpayrecord/{id}")
	public ModelAndView viewMpayrecord(@PathVariable String id)
			throws Exception {
		ModelAndView mav = new ModelAndView();
		Mpayrecord model = mpayrecordService.findById(id);
		mav.addObject("model", model);
		mav.setViewName("BK300202");

		return mav;
	}
	/**
	 * 更新客户管理
	 * 
	 * @param model
	 * @param navTabId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateMpayrecord")
	@ResponseBody
	public String update(Mpayrecord model, String navTabId) {
		AjaxDone ajaxDone = new AjaxDone();
		try {

			mpayrecordService.update(model);
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
