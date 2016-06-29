package com.yzframework.service;

import java.util.List;

import com.yzframework.model.Tuserrole;

public interface JbpmService {

	/**
	 * 取得用户和角色的关系
	 * 
	 * @return Map
	 * @throws Exception
	 */
	public List<Tuserrole> findUserAndRole();
	
	/**
	 * 根据流程ID取得Action
	 * 
	 * @return Action
	 * @throws Exception
	 */
	public String findAction(String processId, String actionName);
	
	/**
	 * 根据流程ID,流程实例ID取得流程历史信息中的业务ID
	 * 
	 * @return 业务ID
	 * @throws Exception
	 */
	public String findBusinessId(String processId, long processInstanceId);

}
