package com.yzframework.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yzframework.dao.IDAO;
import com.yzframework.model.Tuserrole;
import com.yzframework.service.JbpmService;

@Service("jbpmService")
public class JbpmServiceImpl implements JbpmService {

	@Resource
	private IDAO dao;

	@Override
	public List<Tuserrole> findUserAndRole(){
		String hql = "FROM Tuserrole Where status = '1'";

		return dao.findTByHql(hql);
	}

	@Override
    public String findAction(String processId, String actionName) {
	    String sql = "select actionvalue from p_processbinding where processid = '" + processId +"' and actionName = '" + actionName + "'";
	    
	    List<Map<String, Object>> data = dao.findMapBySQL(sql);
	    if (data.size() > 0) {
	    	return (String)data.get(0).get("actionvalue");
	    }
	    return null;
    }

	@Override
    public String findBusinessId(String processId, long processInstanceId) {
	   String sql = "select value from variableinstancelog where processid = '" + processId +"' AND processinstanceid = "+ processInstanceId +" AND variableid = 'businessId'";
	    List<Map<String, Object>> data = dao.findMapBySQL(sql);
	    if (data.size() > 0) {
	    	return (String)data.get(0).get("value");
	    }
	    return null;
    }

}
