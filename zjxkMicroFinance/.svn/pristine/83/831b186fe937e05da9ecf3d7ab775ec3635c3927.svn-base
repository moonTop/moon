package com.yzframework.controller;

import java.net.InetAddress;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yzframework.base.ActionContext;
import com.yzframework.base.Constant;
import com.yzframework.base.SessionInfo;
import com.yzframework.model.Muser;
import com.yzframework.service.MuserService;
import com.yzframework.utils.CheckUtil;
import com.yzframework.utils.PasswordUtil;

/**
 * @author Administrator
 * 
 */
@Controller
@RequestMapping("/views/mobileManage")
public class MobileLoginController {
	protected final Log logger = LogFactory.getLog(getClass());

	@Resource
	private MuserService muserService;

	/**
	 * 退出系统
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("mobilelogon")
	public ModelAndView logon() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mobilelogon");

		return mav;
	}
    @RequestMapping("mobilelogout")
    public ModelAndView logout(HttpSession session) throws Exception{
    	ModelAndView mav = new ModelAndView();
    	session.invalidate();
    	mav.setViewName("mobilelogon");
    	
    	return mav;
    }
	@RequestMapping("mobileTaskList")
	public ModelAndView mobileTaskList(String userid, String password,
			HttpServletRequest request, HttpSession session, String rand)
			throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("userid", userid);

		if (!StringUtils.isEmpty(userid) && userid.contains(",")) {
			String[] useridArry = userid.split(",");
			if (useridArry.length > 0) {
				userid = useridArry[useridArry.length - 1];
			}
		}
		if (!StringUtils.isEmpty(password) && password.contains(",")) {
			String[] passwordArry = password.split(",");
			if (passwordArry.length > 0) {
				password = passwordArry[passwordArry.length - 1];
			}
		}
		if (!StringUtils.isEmpty(rand) && rand.contains(",")) {
			String[] randArry = rand.split(",");
			if (randArry.length > 0) {
				rand = randArry[randArry.length - 1];
			}
		}
		if (!CheckUtil.isRequired(rand)) {

			mav.addObject("msg", "验证码不能为空!");
			mav.setViewName("mobilelogon");
			return mav;
		} else {
			if (!rand.equals(session.getAttribute("rand"))) {

				mav.addObject("msg", "验证码不正确!");
				mav.setViewName("mobilelogon");
				return mav;
			}
		}

		// 判断当前登录用户是否存在
		Muser muser = new Muser();
		muser.setUserid(userid);
		List<Muser> list = muserService.findByModel(muser);
		if (list.size() <= 0) {
			mav.addObject("msg", "帐号不存在");
			mav.setViewName("mobilelogon");
			return mav;
		}
		if ((list.get(0).getStatus()).equals("0")) {
			mav.addObject("msg", "帐号已锁定");
			mav.setViewName("mobilelogon");
			return mav;
		}
		Muser user = (Muser) list.get(0);

		System.out.println(list.get(0).getPassword());
		// 检查密码
		if (!PasswordUtil.validatePassword(user.getPassword(), password)) {
			mav.addObject("msg", "密码不正确");
			mav.setViewName("mobilelogon");
			return mav;
		}

		// 根据登录帐号判断用户是否登录
		ServletContext application = session.getServletContext();
		@SuppressWarnings("unchecked")
		HashSet<HttpSession> logonUserSessions = (HashSet<HttpSession>) application
				.getAttribute("logonUserSessions");
		outline(user.getUserid(), session, logonUserSessions);

		// 将登录用户信息存入到SESSION
		SessionInfo sessioninfo = ActionContext.getSession();
		sessioninfo.setUserid(user.getUserid());
		sessioninfo.setUserUUid(user.getId());

		InetAddress address = InetAddress.getLocalHost();

		sessioninfo.setIp(address.getHostAddress());
		session.setAttribute(Constant.SSESION_INFO, sessioninfo);
		ActionContext.setSession(sessioninfo);

		session.setAttribute("userId", userid);

		session.setAttribute("CURRENT_USER", userid);

		// =========登录用户SESSION管理================ //
		if (logonUserSessions == null) {
			logonUserSessions = new HashSet<HttpSession>();
			application.setAttribute("logonUserSessions", logonUserSessions);
		}
		logonUserSessions.add(session);
		logger.info("用户登录,用户名=" + session.getAttribute("userId"));

		String redirectURI = "redirect:/views/mobileManage/todoList.do";
		mav.setViewName(redirectURI);

		return mav;

	}

	/**
	 * 根据用户登录的帐号和密码信息判断用户是否存在，是否在线等信息
	 * 
	 * @param userid
	 * @param session
	 * @param sessions
	 */
	private void outline(String userid, HttpSession session,
			HashSet<HttpSession> sessions) {
		if (sessions == null) {
			return;
		}
		Iterator<HttpSession> it = sessions.iterator();
		while (it.hasNext()) {
			HttpSession insession = it.next();
			if (userid.equals(insession.getAttribute("userId"))
					&& session != insession) {
				insession.invalidate();
			}
		}
	}
}