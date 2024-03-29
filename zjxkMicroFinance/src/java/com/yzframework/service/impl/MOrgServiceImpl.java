package com.yzframework.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yzframework.base.Page;
import com.yzframework.dao.IDAO;
import com.yzframework.model.Morg;
import com.yzframework.service.MOrgService;
import com.yzframework.utils.CheckUtil;

@Service
public class MOrgServiceImpl implements MOrgService {
	
	@Resource
	private IDAO dao;
	
	public void setDao(IDAO dao) {
		this.dao = dao;
	}
    /**
     * 分页查询
     * 
     * @模块名称 部门管理
     */

	@Override
	public Page findPage(Page page, Morg model) throws Exception {
		// 组装Hql
				Map<String, Object> parameters = new HashMap<String, Object>();
				String hql = " from Morg a where status != '2' ";
				
				// 部门编码
				if (CheckUtil.isRequired(model.getOrgno())) {
					hql += " AND a.orgno LIKE :orgno";
					parameters.put("orgno", '%'+model.getOrgno()+'%');
				}

//				// 企业名称
//				if (CheckUtil.isRequired(model.getName())) {
//					hql += " AND a.name = :name";
//					parameters.put("name", model.getName());
//				}
//				hql += " order by a.createtime desc";
				Page p = dao.findPageByHql(hql,parameters, page);
				return p;
	}
	
	/**
	 * 通过主键查询企业详细信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public Morg findById(String id) throws Exception{
		return dao.findById(id, new Morg());
	}


	/**
	 * 部门用户-保存记录
	 * 
	 * @模块名称 部门
	 */
	public void save(Morg model) throws Exception{
	    dao.save(model);
	}


	/**
     * 根据orgno获取部门信息
     * 
     * @模块  通用
     * 
     * @param userid
     * @return
     * @throws Exception
     */
    @Override
    public List<Morg> findByOrgno(String orgno) throws Exception {
        Morg model = new Morg();
        model.setOrgno(orgno);
        return dao.findByModel(model);
    }
    
    /**
	 * 修改部门信息
	 * 
	 * @模块     部门信息
	 * 
	 * @param muser  
	 * @return
	 * @throws Exception
	 */
	@Override
	public Morg update(Morg morg) throws Exception {
		dao.update(morg);
		return morg;
	
	}

}
