package com.yzframework.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yzframework.dao.IDAO;
import com.yzframework.model.Mcompanyloanform;
import com.yzframework.service.MCompanyLoanService;

@Service
public class MCompanyLoanServiceImpl implements MCompanyLoanService {

	@Resource
	private IDAO dao;

	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Mcompanyloanform findById(String id) throws Exception {
		return dao.findById(id, new Mcompanyloanform());
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * @param mcompany
	 * @return
	 * @throws Exception
	 */
	public void save(Mcompanyloanform model) throws Exception {
		dao.save(model);
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * @param mcompany
	 * @return
	 * @throws Exception
	 */
	public void update(Mcompanyloanform model) throws Exception {
		dao.update(model);
	}
}
