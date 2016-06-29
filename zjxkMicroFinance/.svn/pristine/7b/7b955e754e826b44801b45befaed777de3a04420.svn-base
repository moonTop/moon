package com.yzframework.service.impl;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yzframework.base.Page;
import com.yzframework.dao.IDAO;
import com.yzframework.model.Mcustomer;
import com.yzframework.service.MCustomerService;
import com.yzframework.utils.CheckUtil;

@Service
public class MCustomerServiceImpl implements MCustomerService{

	@Resource
	private IDAO dao;
	public void setDao(IDAO dao) {
		this.dao = dao;
	}


	@Override
	public Page findPageCustomer(Page page, Mcustomer model) throws Exception {
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		String hql = "from Mcustomer a where 1 = 1";
		
		//条件查询
		if (CheckUtil.isRequired(model.getIdcard())) {
            hql += " AND ( a.idcard = :idcard or a.orgcode =  :idcard)";
            parameters.put("idcard", model.getIdcard().trim());
        }
		
		if (CheckUtil.isRequired(model.getName())) {
			hql += " AND a.name LIKE :name";
			parameters.put("name", '%'+model.getName().trim()+'%');
		}
		return dao.findPageByHql(hql, parameters, page);
	}

	/**
	 * 根据id查询客户信息
	 */
	@Override
	public Mcustomer findById(String id) throws Exception {
		
		return dao.findById(id, new Mcustomer());
	}
	
	/**
	 * 修改客户信息
	 */
	@Override
	public void update(Mcustomer model) throws Exception{
		dao.update(model);
	}
	
	/**
	 * 添加客户信息
	 */
	@Override
	public void save(Mcustomer model) throws Exception{
		dao.save(model);
	}

}
