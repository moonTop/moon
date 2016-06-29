package com.yzframework.base.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.filter.OncePerRequestFilter;

import com.alibaba.fastjson.JSON;
import com.yzframework.base.ActionContext;
import com.yzframework.base.AjaxDone;
import com.yzframework.base.Constant;
import com.yzframework.base.SessionInfo;

public class SessionLocalFilter extends OncePerRequestFilter {

	private final Logger logger = Logger.getLogger(this.getClass());

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		// 获取当前URL
		String requestURI = request.getRequestURI();

		// 后台页面Session验证标记
		boolean doBKFilter = true;

		// 不是以.do 或 .jsp结束的URL，不进行Session验证
		if (requestURI.endsWith(".do") || requestURI.endsWith(".jsp")) {
			String[] notFilterBKURIs = new String[] { "/jsp", "loadMain.do",
					"logout.do", "image.jsp", "index.jsp", "logon.do",
					"login.do", "logon.jsp", "registe.do", "mobileLogon.do",
					"mobileTaskList.do", "mobileFormShow.do",
					"mobileApproval.jsp", "mobileImage.jsp" };
			for (String uri : notFilterBKURIs) {
				if (requestURI.indexOf(uri) != -1) {
					doBKFilter = false;
					break;
				}
			}
		} else {
			doBKFilter = false;
		}

		// 后台Session验证
		SessionInfo sessionInfo = (SessionInfo) request.getSession()
				.getAttribute(Constant.SSESION_INFO);
		String userAgent = request.getHeader("User-Agent");
		// ios 终端
		Boolean isMoblie = false;
		isMoblie = userAgent.matches("/\\(i[^;]+;( U;)? CPU.+Mac OS X/");
		// android终端或者uc浏览器
		if (userAgent.indexOf("Android") > -1
				|| userAgent.indexOf("Linux") > -1) {
			isMoblie = true;
		}
		// 是否为iPhone或者QQHD浏览器
		if (userAgent.indexOf("iPhone") > -1 || userAgent.indexOf("Mac") > -1) {
			isMoblie = true;
		}
		// 是否iPad
		if (userAgent.indexOf("iPad") > -1) {
			isMoblie = true;
		}
		if (doBKFilter && sessionInfo == null) {

			logger.debug("request URI: \"" + requestURI + "\" is denied.");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");

			PrintWriter printWriter = response.getWriter();
			if (!isMoblie) {
				// ajax 请求超时
				if (request.getHeader("x-requested-with") != null
						&& request.getHeader("x-requested-with")
								.equalsIgnoreCase("XMLHttpRequest")) {
					AjaxDone ajaxDone = new AjaxDone();
					ajaxDone.setStatusCode(AjaxDone.TIMEOUT);
					ajaxDone.setMessage(AjaxDone.TIMEOUT_MSG);
					printWriter.print(JSON.toJSON(ajaxDone));
				} else {
					printWriter
							.print("<script language='javascript'>window.top.location.href='../logon.do'</script>");
				}
				printWriter.flush();
				printWriter.close();
				return;
			} else {
				String contextPath = request.getContextPath();
				printWriter
						.print("<script language='javascript'>alert('会话过期，请重新登陆！');window.top.location.href='"
								+ contextPath
								+ "/views/mobileManage/mobilelogon.do'</script>");
				printWriter.flush();
				printWriter.close();
				return;

			}
		}

		// ThreadLocal中加入登录信息
		ActionContext.setSession(sessionInfo);

		// 执行业务方法
		chain.doFilter(request, response);

		// 清理ThreadLocal
		ActionContext.removeSession();
	}
}
