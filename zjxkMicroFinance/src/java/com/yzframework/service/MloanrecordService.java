package com.yzframework.service;

import com.yzframework.base.Page;
import com.yzframework.model.Mloanrecord;

public interface MloanrecordService {

	/**
	 * 查询出所有的借贷信息
	 * @param page
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public Page findPageMloanrecord(Page page,Mloanrecord model) throws Exception;
	
	/**
	 * 根据id查询出借贷信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Mloanrecord findById(String id) throws Exception;

	/**
	 * 修改借贷信息
	 * @param model
	 * @throws Exception
	 */
	public void update(Mloanrecord model) throws Exception;
	
}
