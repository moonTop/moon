package com.yzframework.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yzframework.base.Page;
import com.yzframework.bean.BeanRoleList;
import com.yzframework.dao.IDAO;
import com.yzframework.model.Fmodule;
import com.yzframework.model.Mloanrecord;
import com.yzframework.model.Mrole;
import com.yzframework.model.Tauthority;
import com.yzframework.service.MloanrecordService;
import com.yzframework.utils.CheckUtil;

@Service
public class MloanrecordServiceImpl implements MloanrecordService {

	@Resource
	private IDAO dao;

	public void setDao(IDAO dao) {
		this.dao = dao;
	}

	/**
	 * 分页查询
	 * 
	 * @模块名称 角色权限管理
	 */

//	@Override
//	public Page findPageTauthority(Page page, Tauthority model)
//			throws Exception {
//		// 组装Hql
//		Map<String, Object> parameters = new HashMap<String, Object>();
//		String sql = " select fm.modname as modname, mr.rolename as rolename, ta.status as status, ta.id as id from t_authority ta, f_module fm, m_role mr where ta.status = '1' and ta.modid = fm.id and ta.roleid = mr.id";
//
//		// // 部门编码
//		// if (CheckUtil.isRequired(model.getRoleid())) {
//		// sql += " AND mr.rolename LIKE :rolename";
//		// parameters.put("rolename", '%'+model.getRolename()+'%');
//		// }
//
//		sql += " order by ta.createtime desc";
//		return dao.findPageBeanBySQL(sql, parameters, page, new BeanRoleList());
//	}

	@Override
	public Page findPageMloanrecord(Page page, Mloanrecord model)
			throws Exception {
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		String hql = "FROM Mloanrecord a where 1=1";
		//条件查询
		if (CheckUtil.isRequired(model.getLoanpersonname())) {
			hql += " AND a.loanpersonname LIKE :loanpersonname";
			parameters.put("loanpersonname", '%'+model.getLoanpersonname().trim()+'%');
		}
		
		//条件查询
		if (CheckUtil.isRequired(model.getLoanno())) {
			hql += " AND a.loanno = :loanno";
			parameters.put("loanno",model.getLoanno().trim());
		}
	
		return dao.findPageByHql(hql, parameters, page);
	}
	
	/**
	 * 根据id查询出借贷信息
	 */
	@Override
	public Mloanrecord findById(String id) throws Exception {
		return dao.findById(id, new Mloanrecord());
	}
	
	/**
	 * 修改借贷信息
	 * @param model
	 * @throws Exception
	 */
	@Override
	public void update(Mloanrecord model) throws Exception{
		dao.update(model);
	}


}
