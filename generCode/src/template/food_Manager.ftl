package ${packageName};

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.dths.web.servlet.foods.baseManager.FoodBaseManager;
import com.dths.web.servlet.utils.JsonUtil;
import com.dths.web.servlet.utils.PageParam;
import com.dths.web.servlet.utils.StringUtil;

/** 
 * @ClassName: Co${beanName}Manager 
 * @Description: 
 
 * @author ${authorOriginally}
 * @date ${currentTime}
 */ 
public class Co${beanName}Manager extends FoodBaseManager {
	
	private static final long serialVersionUID = 1L;
	@Override
	public void doMethod(String key) throws Exception {
		if (!StringUtils.isEmpty(key)) {
			if ("add${beanName}".equals(key)) {
				add${beanName}();
			} else if ("delete${beanName}".equals(key)) {
				delete${beanName}();
			} else if ("update${beanName}".equals(key)) {
				update${beanName}();
			} else if ("query${beanName}s".equals(key)) {
				query${beanName}s();
			} else if("query${beanName}ByID".equals(key)){
				query${beanName}ByID();
			}
		}
	}

	/**
	 * @Title: add${beanName}
	 * @Class: Co${beanName}Manager.java
	 * @Description:新增
	 *@throws Exception
	 * @AuthorOriginally ${authorOriginally}
	 * @date  ${currentTime}
	 */
	public void add${beanName}() throws Exception {
	    String name = request.getParameter("NAME");//此处需要修改，根据表的唯一键判断是否允许添加，如果没有唯一键约束，则删除此段代码。
		String sql = "SELECT *  FROM ${tableName} WHERE ISDELETE=0 AND NAME='"+name+"'";//此处需要修改
		if (dbUtils.ifExists(sql, null)) {
			json.put("result", "exists");
			pw = response.getWriter();
			pw.write(json.toString());
			pw.flush();
			pw.close();
			return;
		}
		int result = 0;
		result = dbUtils.save2("${tableName}", reqMap);
		json.put("result", String.valueOf(result));
	 }
	
	/**
	 * @Title: update${beanName}
	 * @Class: Co${beanName}Manager.java
	 * @Description:更新
	 *@throws Exception
	 * @AuthorOriginally ${authorOriginally}
	 * @date  ${currentTime}
	 */
	public void update${beanName}() throws Exception {
		
		String ID = request.getParameter("ID");
		int result=0;
		result = dbUtils.update("${tableName}", reqMap, Long.parseLong(ID));
		json.put("result", String.valueOf(result));

	 }
	
	/**
	 * @Title: delete${beanName}
	 * @Class: Co${beanName}Manager.java
	 * @Description:删除
	 *@throws Exception
	 * @AuthorOriginally ${authorOriginally}
	 * @date  ${currentTime}
	 */
	public void delete${beanName}() throws Exception {
		String ID_REAL = request.getParameter("ID");
		int result=0;
		result = dbUtils.delete(operationUserName, "${tableName}", Long.parseLong(ID_REAL));
		json.put("result", String.valueOf(result));

	 }
	
	/**
	 * @Title: query${beanName}ByID
	 * @Class: Co${beanName}Manager.java
	 * @Description:id查询
	 *@throws Exception
	 * @AuthorOriginally ${authorOriginally}
	 * @date  ${currentTime}
	 */
	public void query${beanName}ByID(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String ID = request.getParameter("ID");
		HashMap<String,String> mp=null;
		String querySql="SELECT * FROM ${tableName} WHERE ISDELETE=0 AND ID='"+ID+"'";
		mp = (HashMap<String, String>) dbUtils.get( querySql);
		if (mp.size()>0)
			json = JsonUtil.getJsonObject(mp);
	}
	
	
	/**
	 * @Title: query${beanName}s
	 * @Class: Co${beanName}Manager.java
	 * @Description:分页查询
	 *@throws Exception
	 * @AuthorOriginally ${authorOriginally}
	 * @date  ${currentTime}
	 */
	public void query${beanName}s(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String queryWord = request.getParameter("queryWord");
		String querySql="SELECT * FROM ${tableName} WHERE ISDELETE=0 ";
		if(queryWord!=null&&!"".equals(queryWord))
			  querySql=querySql+"and ( "+
			<#list fields as field>
			<#if field.isPK?index_of("true")==-1>
			  "${field.fieldName} like '%"+queryWord+"%'"<#if field_has_next>+" or "+</#if>
		    </#if>
			</#list>
			+")";
		json=dbUtils.queryByPage(request, querySql,null);
	}
}
