package com.yzframework.service;

import java.util.List;

import com.yzframework.model.Fmodule;

public interface FmoduleService {
   
	/**
     * 系统菜单查询
     * 
     * @模块名称 系统主页面
     */
    public List<Fmodule> findModuleList(String parentid) throws Exception;
    
	/**
	 * 系统菜单添加
	 */
	public void save(Fmodule model) throws Exception;
	
	/**
	 * 查询出所有的权限
	 * @return
	 * @throws Exception
	 */
	public List<Fmodule> findByIsnotModule(String id) throws Exception;

	public List<Fmodule> findByExistModel(String id) throws Exception;

	
}
