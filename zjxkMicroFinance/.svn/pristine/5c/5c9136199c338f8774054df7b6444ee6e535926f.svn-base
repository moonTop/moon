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
import com.yzframework.model.Mrole;
import com.yzframework.model.Tauthority;
import com.yzframework.service.TauthorityService;

@Service
public class TauthorityServiceImpl implements TauthorityService {

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

	@Override
	public Page findPageTauthority(Page page, Tauthority model)
			throws Exception {
		// 组装Hql
		Map<String, Object> parameters = new HashMap<String, Object>();
		String sql = " select fm.modname as modname, mr.rolename as rolename, ta.status as status, ta.id as id from t_authority ta, f_module fm, m_role mr where ta.status = '1' and ta.modid = fm.id and ta.roleid = mr.id";

		// // 部门编码
		// if (CheckUtil.isRequired(model.getRoleid())) {
		// sql += " AND mr.rolename LIKE :rolename";
		// parameters.put("rolename", '%'+model.getRolename()+'%');
		// }

		sql += " order by ta.createtime desc";
		return dao.findPageBeanBySQL(sql, parameters, page, new BeanRoleList());
	}

	/**
	 * 通过主键查询企业详细信息
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public Tauthority findById(String id) throws Exception {
		return dao.findById(id, new Tauthority());
	}

	/**
	 * 部门用户-保存记录
	 * 
	 * @模块名称 部门
	 */
	public void save(Tauthority model) throws Exception {
		dao.save(model);
	}

	/**
	 * 根据orgno获取部门信息
	 * 
	 * @模块 通用
	 * 
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Tauthority> findByRoleid(String modelId) throws Exception {
		Tauthority model = new Tauthority();
		model.setRoleid(modelId);
		return dao.findByModel(model);
	}

	/**
	 * 修改部门信息
	 * 
	 * @模块 部门信息
	 * 
	 * @param muser
	 * @return
	 * @throws Exception
	 */
	@Override
	public Tauthority update(Tauthority tAuthority) throws Exception {
		dao.update(tAuthority);
		return tAuthority;

	}

	/**
	 * 权限分配
	 * 
	 * @模块名称 部门
	 */
	public void saveByIds(String roleId, String[] moduleIds) throws Exception {
		
		// 删除已有权限
		StringBuffer sb = new StringBuffer();
		sb.append("delete from T_AUTHORITY where roleId ='" + roleId + "'");
		dao.executeSQL(sb.toString());

		Mrole mRole = dao.findById(roleId, new Mrole());
		if (moduleIds != null) {
			// 追加新的权限
			for (String moduleId : moduleIds) {
				Fmodule fModule = dao.findById(moduleId, new Fmodule());
				Tauthority model = new Tauthority();
				model.setMrole(mRole);
				model.setFmodule(fModule);
				dao.save(model);
			}
		}
	}

}
