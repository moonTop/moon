package com.yzframework.service;

import com.yzframework.base.Page;
import com.yzframework.model.Mcustomer;

public interface MCustomerService {
	/**
	 * 查询所有客户信息
	 * @param page
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public Page findPageCustomer(Page page,Mcustomer model) throws Exception;
	
	/**
	 * 根据id查询客户信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Mcustomer findById(String id) throws Exception;

	/**
	 * 修改客户信息
	 * @param model
	 * @throws Exception
	 */
	public void update(Mcustomer model) throws Exception;
	
	/**
	 * 添加客户信息
	 * @param model
	 * @throws Exception
	 */
	public void save(Mcustomer model) throws Exception;
}
