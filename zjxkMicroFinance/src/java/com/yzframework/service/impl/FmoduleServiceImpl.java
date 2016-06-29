package com.yzframework.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yzframework.base.ActionContext;
import com.yzframework.dao.IDAO;
import com.yzframework.model.Fmodule;
import com.yzframework.service.FmoduleService;
import com.yzframework.utils.CheckUtil;

@Service
public class FmoduleServiceImpl implements FmoduleService {
	
	@Resource
	private IDAO dao;
	
	public void setDao(IDAO dao) {
		this.dao = dao;
	}

	/**
     * 系统菜单查询
     * 
     * @模块名称 系统主页面
     */
	@Override
    public List<Fmodule> findModuleList(String parentid) throws Exception{
		
		 Map<String, Object> parameters = new HashMap<String, Object>();
		// 组装SQL
		String sql = "SELECT id,modname,parentid,linkurl,picurl,sort,level,"
				   + "endflg,status from f_module where 1=1 ";
		// 子节点查询
        if (CheckUtil.isRequired(parentid)) {
        	sql += " AND parentid = :parentid";
            parameters.put("parentid",  parentid);
        }
        
        // 一级目录全部查询
        if (!"0".equals(parentid)) {
			sql += " AND ID in";
			sql += " (SELECT DISTINCT t_authority.MODID from t_user_role,t_authority, m_role where 1=1 ";
			if (CheckUtil.isRequired(ActionContext.getSession().getUserid())) {
				sql += " AND t_user_role.userid = :userid";
				parameters.put("userid", ActionContext.getSession().getUserid());
			}
			sql += " and m_role.id = t_authority.roleid and m_role.roleid = t_user_role.roleid)";
		}
        
        sql += " ORDER BY sort asc";
        return dao.findTBySQL(sql, parameters, new Fmodule());
    }
	
    /**
     * 增加操作日志记录
     */
	@Override
    public void save(Fmodule model) throws Exception {
        dao.save(model);
    }

	/**
	 * 查询出没有存在的角色权限
	 */
	@Override
	public List<Fmodule> findByIsnotModule(String id) throws Exception {
		String sql = "select  a.id, a.modname FROM f_module a left outer join t_authority b on a.id = b.MODID  and  b.ROLEID = '"+id+"' where a.ENDFLG = '1' and b.ROLEID is NULL";
		return dao.findTBySQL(sql, new Fmodule());
	}
	
	/**
	 * 查询出已存在的角色权限
	 */
	@Override
	public List<Fmodule> findByExistModel(String id) throws Exception{
		String sql = "select a.id as id, a.modname as modname from f_module a,  t_authority b where a.ID = b.modid and b.ROLEID ='"+id+"'";
		return dao.findTBySQL(sql, new Fmodule());
	}

}
