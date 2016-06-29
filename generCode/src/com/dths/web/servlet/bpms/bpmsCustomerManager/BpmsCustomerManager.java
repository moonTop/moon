package com.dths.web.servlet.bpms.bpmsCustomerManager;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.dths.web.servlet.bpms.baseManager.BpmsBaseManager;
import com.dths.web.servlet.utils.JsonUtil;
import com.dths.web.servlet.utils.StringUtil;

/** 
 * @ClassName: BpmsCustomerManager 
 * @Description: 客户信息处理类
 
 * @author zhouziang
 * @date 2016-03-01 16:15
 */ 
public class BpmsCustomerManager extends BpmsBaseManager {

	private static final long serialVersionUID = 1L;

	@Override
	public void doMethod(String key) throws Exception {
		if(StringUtils.isNotEmpty(key)){
			if(key.equals("queryBpmsCustomer")){
				queryBpmsCustomer();
			}else if(key.equals("getBpmsCustomerById")){
				getBpmsCustomerById();
			}else if(key.equals("addBpmsCustomer")){
				addBpmsCustomer();
			}else if(key.equals("updateBpmsCustomer")){
				updateBpmsCustomer();
			}else if(key.equals("deleteBpmsCustomer")){
				deleteBpmsCustomer();
			}
		}
	}

	/**
	 * @throws Exception 
	 * @Title: queryBpmsCustomer
	 * @Class: BpmsCustomerManager.java
	 * @Package: com.dths.web.servlet.bpms.BpmsCustomerManager
	 * @Description:查询
	 
	 
	 * @AuthorOriginally zhouziang
	 * @date  2016-03-01 16:15
	 */
	private void queryBpmsCustomer() throws Exception {
		String sql = "SELECT * FROM BPMS_CUSTOMER WHERE ISDELETE=0";
		
		//多条件查询
			  	Object KHZY = reqMap.get("SEARCH_KHZY");
				if(!StringUtil.isNullOrEmpty(KHZY)){
					sql+=" AND KHZY LIKE '%"+KHZY.toString()+"%'";
				}
			  	Object KHZYID = reqMap.get("SEARCH_KHZYID");
				if(!StringUtil.isNullOrEmpty(KHZYID)){
					sql+=" AND KHZYID LIKE '%"+KHZYID.toString()+"%'";
				}
			  	Object GSJC = reqMap.get("SEARCH_GSJC");
				if(!StringUtil.isNullOrEmpty(GSJC)){
					sql+=" AND GSJC LIKE '%"+GSJC.toString()+"%'";
				}
			  	Object GSQC = reqMap.get("SEARCH_GSQC");
				if(!StringUtil.isNullOrEmpty(GSQC)){
					sql+=" AND GSQC LIKE '%"+GSQC.toString()+"%'";
				}
			  	Object CYLXR = reqMap.get("SEARCH_CYLXR");
				if(!StringUtil.isNullOrEmpty(CYLXR)){
					sql+=" AND CYLXR LIKE '%"+CYLXR.toString()+"%'";
				}
			  	Object GSFR = reqMap.get("SEARCH_GSFR");
				if(!StringUtil.isNullOrEmpty(GSFR)){
					sql+=" AND GSFR LIKE '%"+GSFR.toString()+"%'";
				}
			  	Object GSDZ = reqMap.get("SEARCH_GSDZ");
				if(!StringUtil.isNullOrEmpty(GSDZ)){
					sql+=" AND GSDZ LIKE '%"+GSDZ.toString()+"%'";
				}
			  	Object GSZCDZ = reqMap.get("SEARCH_GSZCDZ");
				if(!StringUtil.isNullOrEmpty(GSZCDZ)){
					sql+=" AND GSZCDZ LIKE '%"+GSZCDZ.toString()+"%'";
				}
			  	Object YYZZ = reqMap.get("SEARCH_YYZZ");
				if(!StringUtil.isNullOrEmpty(YYZZ)){
					sql+=" AND YYZZ LIKE '%"+YYZZ.toString()+"%'";
				}
			  	Object YYZZH = reqMap.get("SEARCH_YYZZH");
				if(!StringUtil.isNullOrEmpty(YYZZH)){
					sql+=" AND YYZZH LIKE '%"+YYZZH.toString()+"%'";
				}
			  	Object SWDJZ = reqMap.get("SEARCH_SWDJZ");
				if(!StringUtil.isNullOrEmpty(SWDJZ)){
					sql+=" AND SWDJZ LIKE '%"+SWDJZ.toString()+"%'";
				}
			  	Object KHKHYH = reqMap.get("SEARCH_KHKHYH");
				if(!StringUtil.isNullOrEmpty(KHKHYH)){
					sql+=" AND KHKHYH LIKE '%"+KHKHYH.toString()+"%'";
				}
			  	Object KHYHZH = reqMap.get("SEARCH_KHYHZH");
				if(!StringUtil.isNullOrEmpty(KHYHZH)){
					sql+=" AND KHYHZH LIKE '%"+KHYHZH.toString()+"%'";
				}
			  	Object SJHM = reqMap.get("SEARCH_SJHM");
				if(!StringUtil.isNullOrEmpty(SJHM)){
					sql+=" AND SJHM LIKE '%"+SJHM.toString()+"%'";
				}
			  	Object GSFRDZ = reqMap.get("SEARCH_GSFRDZ");
				if(!StringUtil.isNullOrEmpty(GSFRDZ)){
					sql+=" AND GSFRDZ LIKE '%"+GSFRDZ.toString()+"%'";
				}
			  	Object JYFW = reqMap.get("SEARCH_JYFW");
				if(!StringUtil.isNullOrEmpty(JYFW)){
					sql+=" AND JYFW LIKE '%"+JYFW.toString()+"%'";
				}
			  	Object GSZJ = reqMap.get("SEARCH_GSZJ");
				if(!StringUtil.isNullOrEmpty(GSZJ)){
					sql+=" AND GSZJ LIKE '%"+GSZJ.toString()+"%'";
				}
			  	Object CZHM = reqMap.get("SEARCH_CZHM");
				if(!StringUtil.isNullOrEmpty(CZHM)){
					sql+=" AND CZHM LIKE '%"+CZHM.toString()+"%'";
				}
			  	Object SWDJH = reqMap.get("SEARCH_SWDJH");
				if(!StringUtil.isNullOrEmpty(SWDJH)){
					sql+=" AND SWDJH LIKE '%"+SWDJH.toString()+"%'";
				}
			  	Object GSQCJP = reqMap.get("SEARCH_GSQCJP");
				if(!StringUtil.isNullOrEmpty(GSQCJP)){
					sql+=" AND GSQCJP LIKE '%"+GSQCJP.toString()+"%'";
				}
		json=dbUtils.queryByPage(request, sql," ID DESC");
	}
	
	/**
	 * @throws Exception 
	 * @Title: getBpmsCustomerById
	 * @Class: BpmsCustomerManager.java
	 * @Package: com.dths.web.servlet.bpms.BpmsCustomerManager
	 * @Description:根据Id获取对象信息
	 
	 
	 * @AuthorOriginally zhouziang
	 * @date  2016-03-01 16:15
	 */
	private void getBpmsCustomerById() throws Exception {
		String id = request.getParameter("ID");
		HashMap<String,String> mp=null;
		String querySql="SELECT * FROM BPMS_CUSTOMER WHERE ISDELETE=0 AND ID='"+id+"'";
		mp = (HashMap<String, String>) dbUtils.get( querySql);
		if (mp.size()>0){
			json = JsonUtil.getJsonObject(mp);
		}
	}
	/**
	 * @throws Exception 
	 * @Title: addBpmsCustomer
	 * @Class: BpmsCustomerManager.java
	 * @Package: com.dths.web.servlet.bpms.BpmsCustomerManager
	 * @Description:新增
	 
	 
	 * @AuthorOriginally zhouziang
	 * @date  2016-03-01 16:15
	 */
	private void addBpmsCustomer() throws Exception {
		String code = request.getParameter("CODE");
	    if(StringUtils.isNotEmpty(code)){
	    	String sql = "SELECT *  FROM BPMS_CUSTOMER WHERE ISDELETE=0 AND CODE='"+code+"'";//查询是否重复
			if (dbUtils.ifExists(sql, null)) {
				json.put("result", "exists");
				return;
			}
	    }
		int result = 0;
		result = dbUtils.save2("BPMS_CUSTOMER", reqMap);
		json.put("result", String.valueOf(result));
	}

	/**
	 * @throws Exception 
	 * @Title: updateBpmsCustomer
	 * @Class: BpmsCustomerManager.java
	 * @Package: com.dths.web.servlet.bpms.BpmsCustomerManager
	 * @Description:修改
	 
	 
	 * @AuthorOriginally zhouziang
	 * @date  2016-03-01 16:15
	 */
	private void updateBpmsCustomer() throws Exception {
		String ID = request.getParameter("ID");
		int result=0;
		result = dbUtils.update("BPMS_CUSTOMER", reqMap, Long.parseLong(ID));
		json.put("result", String.valueOf(result));
	}


	/**
	 * @throws Exception 
	 * @Title: deleteBpmsCustomer
	 * @Class: BpmsCustomerManager.java
	 * @Package: com.dths.web.servlet.bpms.BpmsCustomerAttrManager
	 * @Description:删除
	 
	 
	 * @AuthorOriginally zhouziang
	 * @date  2016-03-01 16:15
	 */
	private void deleteBpmsCustomer() throws Exception {
		String ids =request.getParameter("IDS");
		int result = 0;
		if(StringUtils.isNotEmpty(ids)){
			String sql = "UPDATE BPMS_CUSTOMER SET ISDELETE=1 WHERE ID IN("+ids+")  AND ISDELETE=0";
			result = dbUtils.execute(sql);
		}
		json.put("result", String.valueOf(result));
	}
}
