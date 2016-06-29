package ${packageName};

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.dths.web.servlet.bpms.baseManager.BpmsBaseManager;
import com.dths.web.servlet.utils.JsonUtil;
import com.dths.web.servlet.utils.StringUtil;

/** 
 * @ClassName: ${beanName}Manager 
 * @Description: ${tableRemark}处理类
 
 * @author ${authorOriginally}
 * @date ${currentTime}
 */ 
public class ${beanName}Manager extends BpmsBaseManager {

	private static final long serialVersionUID = 1L;

	@Override
	public void doMethod(String key) throws Exception {
		if(StringUtils.isNotEmpty(key)){
			if(key.equals("query${beanName}")){
				query${beanName}();
			}else if(key.equals("get${beanName}ById")){
				get${beanName}ById();
			}else if(key.equals("add${beanName}")){
				add${beanName}();
			}else if(key.equals("update${beanName}")){
				update${beanName}();
			}else if(key.equals("delete${beanName}")){
				delete${beanName}();
			}
		}
	}

	/**
	 * @throws Exception 
	 * @Title: query${beanName}
	 * @Class: ${beanName}Manager.java
	 * @Package: com.dths.web.servlet.bpms.${beanName}Manager
	 * @Description:查询
	 
	 
	 * @AuthorOriginally ${authorOriginally}
	 * @date  ${currentTime}
	 */
	private void query${beanName}() throws Exception {
		String sql = "SELECT * FROM ${tableName} WHERE ISDELETE=0";
		
		//多条件查询
		<#list fields as field>
			<#if field.isPK?index_of("true")==-1>
			  	Object ${field.fieldName} = reqMap.get("SEARCH_${field.fieldName}");
				if(!StringUtil.isNullOrEmpty(${field.fieldName})){
					sql+=" AND ${field.fieldName} LIKE '%"+${field.fieldName}.toString()+"%'";
				}
		    </#if>
		</#list>
		json=dbUtils.queryByPage(request, sql," ID DESC");
	}
	
	/**
	 * @throws Exception 
	 * @Title: get${beanName}ById
	 * @Class: ${beanName}Manager.java
	 * @Package: com.dths.web.servlet.bpms.${beanName}Manager
	 * @Description:根据Id获取对象信息
	 
	 
	 * @AuthorOriginally ${authorOriginally}
	 * @date  ${currentTime}
	 */
	private void get${beanName}ById() throws Exception {
		String id = request.getParameter("ID");
		HashMap<String,String> mp=null;
		String querySql="SELECT * FROM ${tableName} WHERE ISDELETE=0 AND ID='"+id+"'";
		mp = (HashMap<String, String>) dbUtils.get( querySql);
		if (mp.size()>0){
			json = JsonUtil.getJsonObject(mp);
		}
	}
	/**
	 * @throws Exception 
	 * @Title: add${beanName}
	 * @Class: ${beanName}Manager.java
	 * @Package: com.dths.web.servlet.bpms.${beanName}Manager
	 * @Description:新增
	 
	 
	 * @AuthorOriginally ${authorOriginally}
	 * @date  ${currentTime}
	 */
	private void add${beanName}() throws Exception {
		String code = request.getParameter("CODE");
	    if(StringUtils.isNotEmpty(code)){
	    	String sql = "SELECT *  FROM ${tableName} WHERE ISDELETE=0 AND CODE='"+code+"'";//查询是否重复
			if (dbUtils.ifExists(sql, null)) {
				json.put("result", "exists");
				return;
			}
	    }
		int result = 0;
		result = dbUtils.save2("${tableName}", reqMap);
		json.put("result", String.valueOf(result));
	}

	/**
	 * @throws Exception 
	 * @Title: update${beanName}
	 * @Class: ${beanName}Manager.java
	 * @Package: com.dths.web.servlet.bpms.${beanName}Manager
	 * @Description:修改
	 
	 
	 * @AuthorOriginally ${authorOriginally}
	 * @date  ${currentTime}
	 */
	private void update${beanName}() throws Exception {
		String ID = request.getParameter("ID");
		int result=0;
		result = dbUtils.update("${tableName}", reqMap, Long.parseLong(ID));
		json.put("result", String.valueOf(result));
	}


	/**
	 * @throws Exception 
	 * @Title: delete${beanName}
	 * @Class: ${beanName}Manager.java
	 * @Package: com.dths.web.servlet.bpms.${beanName}AttrManager
	 * @Description:删除
	 
	 
	 * @AuthorOriginally ${authorOriginally}
	 * @date  ${currentTime}
	 */
	private void delete${beanName}() throws Exception {
		String ids =request.getParameter("IDS");
		int result = 0;
		if(StringUtils.isNotEmpty(ids)){
			String sql = "UPDATE ${tableName} SET ISDELETE=1 WHERE ID IN("+ids+")  AND ISDELETE=0";
			result = dbUtils.execute(sql);
		}
		json.put("result", String.valueOf(result));
	}
}
