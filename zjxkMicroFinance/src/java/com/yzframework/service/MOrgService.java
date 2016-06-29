package com.yzframework.service;

import java.util.List;

import com.yzframework.base.Page;
import com.yzframework.model.Morg;
import com.yzframework.model.Mrole;

public interface MOrgService {
	/**
	 * 分页查询企业
	 * @param page
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public Page findPage(Page page, Morg model) throws Exception;

	/**
	 * 通过主键查询企业详细信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Morg findById(String id) throws Exception;
	
	/**
	 * 部门-保存记录
	 * 
	 * @模块名称 部门
	 */
	public void save(Morg model) throws Exception;
	
	/**
     * 根据orgno获取部门信息
     * 
     * @模块  通用
     * 
     * @param userid
     * @return
     * @throws Exception
     */
    public List<Morg> findByOrgno(String orgno) throws Exception;
    
    /**
	 * 修改部门信息
	 * 
	 * @模块     部门信息
	 * 
	 * @param muser  
	 * @return
	 * @throws Exception
	 */
	public Morg update(Morg morg) throws Exception;

	

	
   
}
