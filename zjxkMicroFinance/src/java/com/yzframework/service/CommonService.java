package com.yzframework.service;


public interface CommonService {
	
	/**
	 * 流程结束保存客户信息、生成贷款记录、生成还款记录
	 */
	public void saveLoanInfo(String id, String loanType) throws Exception;

}
