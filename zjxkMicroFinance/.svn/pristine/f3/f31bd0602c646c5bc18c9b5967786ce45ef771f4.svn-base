package com.yzframework.service;

import java.util.List;

import com.yzframework.base.Page;
import com.yzframework.model.Mrole;

public interface MRoleService {
	/**
	 * 分页查询角色
	 * @param page
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public Page findPageRole(Page page, Mrole model) throws Exception;

	/**
	 * 通过主键查询角色详细信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Mrole findById(String id) throws Exception;
	
	/**
	 * 角色-保存记录
	 * 
	 * @模块名称 部门
	 */
	public void save(Mrole model) throws Exception;
	
	/**
     * 根据orgno获取角色信息
     * 
     * @模块  通用
     * 
     * @param userid
     * @return
     * @throws Exception
     */
    public List<Mrole> findByRoleid(String roleid) throws Exception;
    
    /**
	 * 修改角色信息
	 * 
	 * @模块     角色信息
	 * 
	 * @param muser  
	 * @return
	 * @throws Exception
	 */
	public Mrole update(Mrole morg) throws Exception;
	
	/**
	 * 通过用户ID查询角色信息
	 * @param id
	 * @return Mrole
	 * @throws Exception
	 */
	public List<Mrole> findMroleByUserId(String userid)throws Exception;
   
}
