package com.yzframework.service;

import com.yzframework.base.Page;
import com.yzframework.model.Mapply;

public interface ApplyService {

	/**
	 *  申请信息保存
	 * 
	 * @return Map
	 * @throws Exception
	 */
	public void save(Mapply model) throws Exception;
	
	/**
	 *  查询企业贷信息
	 * 
	 * @return Map
	 * @throws Exception
	 */
	public Page findPage01(Page page, Mapply model);

	/**
	 *  查询楼宜贷信息
	 * 
	 * @return Map
	 * @throws Exception
	 */
	public Page findPage02(Page page, Mapply model);

	/**
	 *  查询车宜贷信息
	 * 
	 * @return Map
	 * @throws Exception
	 */
	public Page findPage03(Page page, Mapply model);
	
	/**
	 * 根据id查询信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Mapply findById(String id) throws Exception;

	/**
	 * 修改企业贷用户信息
	 * @param muser
	 * @return
	 * @throws Exception
	 */
	public Mapply update(Mapply model) throws Exception;

}
