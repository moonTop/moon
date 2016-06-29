package com.yzframework.service;

import java.util.List;

import com.yzframework.model.Tuserrole;

public interface TUserRoleService {

	/**
	 * 角色-保存记录
	 * 
	 * @模块名称 角色
	 */
	public void save(Tuserrole model) throws Exception;
	
	/**
	 * 角色-修改记录
	 * 
	 * @模块名称 角色
	 */

	public void update(Tuserrole model)throws Exception;
	
	/**
	 * 查询用户的角色信息
	 * @param model
	 * @throws Exception
	 */

	 public List<Tuserrole> find01(String userid) throws Exception;

	/**
	 * 查询用户角色是否存在
	 * 
	 * @param model
	 * @throws Exception
	 */
	 public List<Tuserrole> findselectid(String userid) throws Exception;

	
}
