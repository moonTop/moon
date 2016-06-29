package com.yzframework.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yzframework.dao.IDAO;
import com.yzframework.model.Mcarloanform;
import com.yzframework.service.MCardLoanService;

@Service
public class MCarLoanServiceImpl implements MCardLoanService {

	@Resource
	private IDAO dao;

	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Mcarloanform findById(String id) throws Exception {
		return dao.findById(id, new Mcarloanform());
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * @param mcompany
	 * @return
	 * @throws Exception
	 */
	public void save(Mcarloanform model) throws Exception {
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
	public void update(Mcarloanform model) throws Exception {
		dao.update(model);
	}
}
