package com.yzframework.utils;

import javax.servlet.http.HttpServletRequest;

public class CommonUtil {

	/**
	 * 系统常用共同方法类
	 */
	public CommonUtil() {}


	/**
	 * 获取当前用户IP地址
	 * 
	 * @param value
	 * @return true：验证内容非空   false：验证内容为空
	 */
	public static String getIp(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
