package com.yzframework.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yzframework.base.Page;
import com.yzframework.dao.IDAO;
import com.yzframework.model.Mapply;
import com.yzframework.model.Muser;
import com.yzframework.service.ApplyService;
import com.yzframework.utils.CheckUtil;

@Service
public class ApplyServiceImpl implements ApplyService {

	@Resource
	private IDAO dao;

	@Override
	public void save(Mapply model) throws Exception{
		dao.save(model);
	}
	
	/**
     * 后台企业贷管理分页查询
     * 
     * @模块名称 后台企业贷管理
     */
    @Override
    public Page findPage01(Page page, Mapply model) {
    	
        // 组装Hql
        String hql = " FROM Mapply a WHERE a.loantype = '企业贷' ";
        
        Map<String, Object> parameters = new HashMap<String, Object>();
        
        if (CheckUtil.isRequired(model.getName())) {
            hql += " AND a.name LIKE :name";
            parameters.put("name", '%'+model.getName()+'%');
        }
        
        hql += " ORDER BY updatetime desc";
        Page p = dao.findPageByHql(hql, parameters,page);
        return p;
    }
    
    /**
     * 后台楼易贷管理分页查询
     * 
     * @模块名称 后台楼易贷管理
     */
    @Override
    public Page findPage02(Page page, Mapply model) {
    	
        // 组装Hql
        String hql = " FROM Mapply a WHERE a.loantype = '楼易贷' ";
        
        Map<String, Object> parameters = new HashMap<String, Object>();
        
        if (CheckUtil.isRequired(model.getName())) {
            hql += " AND a.name LIKE :name";
            parameters.put("name", '%'+model.getName()+'%');
        }
        
        hql += " ORDER BY updatetime desc";
        Page p = dao.findPageByHql(hql, parameters,page);
        return p;
    }
	
    /**
     * 后台车易贷管理分页查询
     * 
     * @模块名称 后台车易贷管理
     */
    @Override
    public Page findPage03(Page page, Mapply model) {
    	
        // 组装Hql
        String hql = " FROM Mapply a WHERE a.loantype = '车易贷' ";
        
        Map<String, Object> parameters = new HashMap<String, Object>();
        
        if (CheckUtil.isRequired(model.getName())) {
            hql += " AND a.name LIKE :name";
            parameters.put("name", '%'+model.getName()+'%');
        }
       
        hql += " ORDER BY updatetime desc";
        Page p = dao.findPageByHql(hql, parameters,page);
        return p;
    }

    /**
     * 根据id查询信息
     */
	@Override
	public Mapply findById(String id) throws Exception {
		
		return dao.findById(id, new Mapply());
	}
	
	/**
	 * 修改企业贷用户信息
	 * @param muser
	 * @return
	 * @throws Exception
	 */
	@Override
	public Mapply update(Mapply model) throws Exception {
		dao.update(model);
		return model;
	}

}
