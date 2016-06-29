package com.yzframework.base;

import javax.servlet.ServletContext;


/**
 * 功能概要：存放系统共用信息Bean文件
 */
public class SystemInfo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	//ID每层编码位数
	private static int enCodeCount;

	// 用户登录允许失败次数
    private static String failCount = "";

    // 用户锁定时间
    private static String lockTime = "";

    // 文件上传路径
    private static String uploadPath = "";
    
    public static int getEnCodeCount() {
		return enCodeCount;
	}

	public static String getFailCount() {
		return failCount;
	}

	public static String getLockTime() {
		return lockTime;
	}

	public static String getUploadPath() {
		return uploadPath;
	}
    
	/*
	 * 服务启动时构造函数
	 */
    public SystemInfo(ServletContext context)
    {
    	// 用户登录允许失败次数
        failCount = context.getInitParameter("LoginFailCount");

        // 用户锁定时间
        lockTime = context.getInitParameter("LockTime");

        // 一页显示记录数
        uploadPath = context.getInitParameter("FileUploadPath");
        
    }
}