package com.yzframework.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yzframework.bean.ProcessForm;
import com.yzframework.dao.IDAO;
import com.yzframework.model.Mcarloanform;
import com.yzframework.model.Mcompanyloanform;
import com.yzframework.model.Mcustomer;
import com.yzframework.model.Mhouseloanform;
import com.yzframework.model.Mloanrecord;
import com.yzframework.model.Mpayrecord;
import com.yzframework.service.CommonService;
import com.yzframework.utils.CheckUtil;

@Service
public class CommonServiceImpl implements CommonService {

	@Resource
	private IDAO dao;

	public void setDao(IDAO dao) {
		this.dao = dao;
	}

	/**
	 * 流程结束保存客户信息、生成贷款记录、生成还款记录
	 * 
	 * @param id 业务ID
	 * @param loanType 贷款类型
	 * @param 
	 */
	public void saveLoanInfo(String id, String loanType) throws Exception {

		ProcessForm processForm = null;
		// 取得表单提交信息
		if ("车易贷".equals(loanType)) {
			processForm = dao.findById(id, new Mcarloanform());
		} else if ("楼易贷".equals(loanType)) {
			processForm = dao.findById(id, new Mhouseloanform());
		} else if ("企业贷".equals(loanType)) {
			processForm = dao.findById(id, new Mcompanyloanform());
		} else {
			return;
		}

		// 客户记录生成
		Mcustomer mCustomer = this.saveCustomer(processForm, loanType);

		// 贷款记录生成
		Mloanrecord mLoanRecord = this.saveLoanRecord(processForm, mCustomer, loanType);

		// 还款记录生成
		this.savePayRecord(processForm, mLoanRecord);

	}

	/**
	 * 贷款记录生成
	 */
	private Mloanrecord saveLoanRecord(ProcessForm processForm, Mcustomer mCustomer, String loanType) throws Exception {

		Mloanrecord mLoanRecord = new Mloanrecord();

		String sql = "select max(loanno) as loanno  from M_LOAN_RECORD";
		List<Map<String, Object>> mapcode = dao.findMapBySQL(sql);
		String retCode = "100001";
		if (mapcode.size() > 0 && CheckUtil.isRequired((String) mapcode.get(0).get("loanno"))) {
			// 取出查询出LOANNO最大值
			String code = (String) mapcode.get(0).get("loanno");
			// 取出数据的最的六位
			String newStr = code.substring(code.length() - 6);

			Integer codeNum = Integer.valueOf(newStr);

			// 格式化000
			DecimalFormat df = new DecimalFormat("000000");
			retCode = df.format(codeNum + 1);
		}
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		String dateStr = sf.format(date);
		mLoanRecord.setLoanno(dateStr + retCode);

		mLoanRecord.setLoanpersonname(processForm.getLoanpersonname());
		mLoanRecord.setLoantype(loanType);
		mLoanRecord.setLiableperson1(processForm.getLiableperson1());
		mLoanRecord.setLiableperson2(processForm.getLiableperson2());
		mLoanRecord.setLoanamount(processForm.getLoanamount());
		mLoanRecord.setLoandate(new Timestamp(new Date().getTime()));
		// 借款期限开始日和结束日
		long begin = processForm.getLoanlimitbegin().getTime();
		mLoanRecord.setLoanlimitbegin(new Timestamp(begin));
		long end = processForm.getLoanlimitend().getTime();
		mLoanRecord.setLoanlimitend(new Timestamp(end));
		mLoanRecord.setMcustomer(mCustomer);
		mLoanRecord.setPayrate(processForm.getPayrate());
		mLoanRecord.setPaystatus("0");
		mLoanRecord.setAccrualperiodization((processForm.getLoanlimit()).toString());

		dao.save(mLoanRecord);

		return mLoanRecord;
	}

	/**
	 * 还款记录生成
	 */
	private void savePayRecord(ProcessForm processForm, Mloanrecord mLoanRecord) throws Exception {

		BigDecimal loanamount = processForm.getLoanamount();
		// 预计还款利息
		BigDecimal rate = new BigDecimal(processForm.getPayrate());
		BigDecimal planpayaccrual = loanamount.multiply(rate).divide(new BigDecimal(100));

		// 预计还款本金 贷款单号 预计还款日期
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(processForm.getLoanlimitbegin());

		Mpayrecord mPayrecords = new Mpayrecord();

		for (int i = 0; i < processForm.getLoanlimit(); i++) {
			mPayrecords = new Mpayrecord();
			// 最后一天
			final int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
			Date lastDate = calendar.getTime();
			lastDate.setDate(lastDay);
			long dt = lastDate.getTime();
			Timestamp times = new Timestamp(dt);

			mPayrecords.setPlanpaydate(times);
			mPayrecords.setPlanpayaccrual(planpayaccrual);
			mPayrecords.setMloanrecord(mLoanRecord);
			if (i == processForm.getLoanlimit() - 1) {
				mPayrecords.setPlanpayamount(loanamount);
			} else {
				mPayrecords.setPlanpayamount(new BigDecimal(0));
			}
			mPayrecords.setPaystatus("2");
			mPayrecords.setStatus("0");
			dao.save(mPayrecords);
			calendar.add(Calendar.MONTH, 1);
		}

	}

	/**
	 * 客户记录生成
	 */
	private Mcustomer saveCustomer(ProcessForm processForm, String loanType) throws Exception {
		
		Mcustomer model = new Mcustomer();
		if ("企业贷".equals(loanType)) {
			model.setOrgcode(processForm.getOrgcode());
		} else {
			model.setIdcard(processForm.getIdcard());
		}
		
		List<Mcustomer> lst = dao.findByModel(model);
		if (lst.size() > 0) {
			return lst.get(0);
		}
		Mcustomer mCustomer = new Mcustomer();
		mCustomer.setIdcard(processForm.getIdcard().trim());
		mCustomer.setName(processForm.getLoanpersonname());
		mCustomer.setGender(processForm.getGender());
		mCustomer.setAge(processForm.getAge());
		mCustomer.setMarriage(processForm.getMarriage());
		mCustomer.setCensusadrress(processForm.getCensusadrress());
		mCustomer.setTelephone(processForm.getTelephone());
		mCustomer.setAdrress(processForm.getAdrress());
		mCustomer.setCompany(processForm.getCompany());
		mCustomer.setPost(processForm.getPost());
		mCustomer.setCompanyphone(processForm.getCompanyphone());
		mCustomer.setSencodcontact(processForm.getSencodcontact());
		mCustomer.setSencodphone(processForm.getSencodphone());
		mCustomer.setCustomerstatus("正常");

		dao.save(mCustomer);

		return mCustomer;
	}

}
