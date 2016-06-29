package com.yzframework.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.yzframework.base.Page;
import com.yzframework.dao.IDAO;
import com.yzframework.model.Mlog;
import com.yzframework.service.MlogService;

@Service
public class MlogServiceImpl implements MlogService {
	
	@Resource
	private IDAO dao;
	
	public void setDao(IDAO dao) {
		this.dao = dao;
	}
    /**
     * 分页查询
     * 
     * @模块名称 试卷管理
     */
	@Override
    public Page findPage01(Page page, Mlog model) throws Exception{
        // 组装Hql
        String hql = " FROM Mlog a WHERE 1=1";
        
        Map<String, Object> parameters = new HashMap<String, Object>();
        
        if (!StringUtils.isEmpty(model.getModulename())) {
            hql += " AND a.modulename LIKE :modulename";
            parameters.put("modulename", '%'+model.getModulename()+'%');
        }
        if (!StringUtils.isEmpty(model.getOpstyle())) {
            hql += " AND a.opstyle LIKE :opstyle";
            parameters.put("opstyle", '%'+model.getOpstyle()+'%');
        }
        if (!StringUtils.isEmpty(model.getOpcontent())) {
            hql += " AND a.opcontent LIKE :opcontent";
            parameters.put("opcontent", '%'+model.getOpcontent()+'%');
        }
        hql += " ORDER BY a.optime DESC";
        Page p = dao.findPageByHql(hql, parameters, page);
        return p;
    }
    /**
     * 增加操作日志记录
     */
	@Override
    public void save(Mlog model) throws Exception {
        dao.save(model);
    }

}
