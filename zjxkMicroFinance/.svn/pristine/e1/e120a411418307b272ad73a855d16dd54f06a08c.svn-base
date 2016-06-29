package com.yzframework.service;

import com.yzframework.base.Page;
import com.yzframework.model.Mpayrecord;

public interface MpayrecordService {

	/**
	 * 根据id查询出还款信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Mpayrecord findById(String id) throws Exception;

	/**
	 * 查询出所有的还贷信息
	 * @param page
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public Page findPagePayrecord(Page page, Mpayrecord model,String loanpersonname) throws Exception;

	/**
	 * 修改还款信息
	 * @param model
	 * @throws Exception
	 */
	public void update(Mpayrecord model) throws Exception;
	
	/**
	 * 根据贷款信息生成还款信息
	 * @param model
	 * @throws Exception
	 */
	public void save(Mpayrecord model, Integer month) throws Exception;
	
}
