package com.yzframework.service;

import com.yzframework.base.Page;
import com.yzframework.model.Mlog;

public interface MlogService {
    /**
     * 分页查询
     * 
     * @模块名称 试卷管理
     */
    public Page findPage01(Page page, Mlog model) throws Exception;
	/**
	 * 增加操作日志记录
	 */
	public void save(Mlog model) throws Exception;
}
