package com.yzframework.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yzframework.dao.IDAO;
import com.yzframework.model.Tuserrole;
import com.yzframework.service.TUserRoleService;

@Service
public class TUserRoleServiceImpl implements TUserRoleService {

	@Resource
	private IDAO dao;

	public void setDao(IDAO dao) {
		this.dao = dao;
	}

	/**
	 * 保存用户角色
	 */
	@Override
	public void save(Tuserrole model) throws Exception {
		dao.save(model);

	}

	/**
	 * 修改用户角色
	 */
	@Override
	public void update(Tuserrole model) throws Exception {
		dao.update(model);
	}

	/**
	 * 查询用户的角色信息
	 */

	@Override
	public List<Tuserrole> find01(String id) throws Exception {

		String sql="SELECT b.userid as userid , e.id as id, e.roleid as roleid,e.rolename as rolename from m_user b ";
		 sql += "LEFT JOIN (SELECT a.id as id ,a.userid as userid ,a.roleid as roleid , c.rolename as rolename from m_role c,t_user_role a where a.roleid = c.roleid) e on b.userid=e.userid ";
		 sql += "where b.id ='"+id+"'";


		return dao.findTBySQL(sql, new Tuserrole());
	}
	
	

	/**
	 * 查询用户角色是否存在
	 * 
	 * @param model
	 * @throws Exception
	 */
	@Override
	public List<Tuserrole> findselectid(String userid) throws Exception {

		String sql = "SELECT userid from t_user_role where userid='" + userid + "' ";

		return dao.findTBySQL(sql, new Tuserrole());
	}

}
