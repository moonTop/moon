package com.yzframework.service;

import java.util.List;

import com.yzframework.base.Page;
import com.yzframework.model.Monline;


public interface MonlineService {

	/**
	 * 查询出所有的登录用户信息
	 * @param page
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public Page findByList(Page page,Monline model) throws Exception;

	/**
	 * 保存登录用户的在线登录信息
	 * 
	 * @模块  用户登录
	 * 
	 * @param monline
	 * @return
	 * @throws Exception
	 *
	 */
	public void save(Monline monline) throws Exception;

	/**
	 * 获取当前登录用户存在的登录信息
	 * 
	 * @模块   用户登录
	 * 
	 * @param monline 查询条件 登录帐号
	 * @return
	 * @throws Exception
	 *
	 */
	public List<Monline> find02(Monline monline) throws Exception;
	/**
	 * 删除当前登录用户的登录信息
	 * 
	 * @模块     监听器执行
	 * 
	 * @param monline
	 * @return
	 * @throws Exception
	 *
	 */
	public void delete(Monline monline) throws Exception;

}
