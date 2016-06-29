package com.yzframework.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yzframework.base.Page;
import com.yzframework.dao.IDAO;
import com.yzframework.model.Mpayrecord;
import com.yzframework.service.MpayrecordService;
import com.yzframework.utils.CheckUtil;

@Service
public class MpayrecordServiceImpl implements MpayrecordService {

	@Resource
	private IDAO dao;

	public void setDao(IDAO dao) {
		this.dao = dao;
	}

	/**
	 * 分页查询
	 * 
	 * @模块名称 还款管理
	 */
	
	@Override
	public Page findPagePayrecord(Page page, Mpayrecord model,String loanpersonname) throws Exception {
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		String loanno = model.getLoanrecordid();
		
		String hql = "FROM Mpayrecord a where 1=1";
		//条件查询
		if (CheckUtil.isRequired(loanno)) {
			hql += " AND a.mloanrecord.loanno = :loanno";
			parameters.put("loanno", loanno );
		}
		
		//条件查询
		if (CheckUtil.isRequired(loanpersonname)) {
			hql += " AND a.mloanrecord.loanpersonname LIKE :loanpersonname";
			parameters.put("loanpersonname", '%'+loanpersonname.trim()+'%');
		}
		
				
		return dao.findPageByHql(hql, parameters, page);
	}
	
	/**
	 * 根据id查询出还款信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public Mpayrecord findById(String id) throws Exception{
		
		return dao.findById(id, new Mpayrecord());
	}
	
	/**
	 * 修改还款信息
	 * @param model
	 * @throws Exception
	 */
	@Override
	public void update(Mpayrecord model) throws Exception{
		dao.update(model);
	}

	/**
	 * 根据贷款信息生成还款信息
	 * @param model
	 * @throws Exception
	 */
	@Override
	public void save(Mpayrecord model,Integer month) throws Exception {

		Calendar calendar = Calendar.getInstance();
		
		for (int i = 0; i < month-1; i++) {
			Mpayrecord mPayrecord = new Mpayrecord();
			mPayrecord.setMloanrecord(model.getMloanrecord());

			if(i==0){
				calendar.setTime(model.getPlanpaydate());
			}
			calendar.add(Calendar.MONTH, 1);
			//最后一天
			final int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);  
		    Date lastDate = calendar.getTime();
		    lastDate.setDate(lastDay);
		    long dt=lastDate.getTime();
		    Timestamp times = new Timestamp(dt);
		    
		    mPayrecord.setPlanpaydate(times);
			mPayrecord.setPlanpayaccrual(model.getPlanpayaccrual());
			mPayrecord.setPlanpayamount( new BigDecimal(0));
			mPayrecord.setPayamount(new BigDecimal(0));
			mPayrecord.setPaystatus("2");
			dao.save(mPayrecord);
		}
		model.setPaystatus("2");
		calendar = Calendar.getInstance();
		calendar.setTime(model.getPlanpaydate());
		calendar.add(Calendar.MONTH,month);
    	final int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    	Date lastDate = calendar.getTime();
	    lastDate.setDate(lastDay);
    	Timestamp time = new Timestamp(lastDate.getTime());
		model.setPlanpaydate(time);
		dao.save(model);
	}
	
	

}
