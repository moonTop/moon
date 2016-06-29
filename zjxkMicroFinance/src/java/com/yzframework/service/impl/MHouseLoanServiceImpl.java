package com.yzframework.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yzframework.dao.IDAO;
import com.yzframework.model.Mhouseloanform;
import com.yzframework.service.MHouseLoanService;

@Service
public class MHouseLoanServiceImpl implements MHouseLoanService {

	@Resource
	private IDAO dao;

	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Mhouseloanform findById(String id) throws Exception {
		return dao.findById(id, new Mhouseloanform());
	}

	/**
	 * 
	 * <p>
	 * </p>
	 * @param mcompany
	 * @return
	 * @throws Exception
	 */
	public void save(Mhouseloanform model) throws Exception {
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
	public void update(Mhouseloanform model) throws Exception {
		dao.update(model);
	}
}
