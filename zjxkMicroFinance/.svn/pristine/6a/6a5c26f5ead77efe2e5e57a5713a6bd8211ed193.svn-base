package com.yzframework.base.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.yzframework.base.SystemInfo;

public class StartServiceListener implements ServletContextListener {
	
	/**
	 * 功能描述：tomca服务停止
	 */
	public void contextDestroyed(ServletContextEvent event) { }

	/**
	 * 功能描述：Tomcat服务启动时读取配置信息
	 */
	public void contextInitialized(ServletContextEvent event) {
		try {
			// 将共同信息放入到systemInfo中
			ServletContext context = event.getServletContext();
			new SystemInfo(context);

		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
