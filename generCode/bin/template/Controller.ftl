package ${packageName};

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tw.sys.controller.BaseController;
import com.tw.sys.model.easyui.Grid;
import com.tw.sys.model.easyui.Json;
import com.tw.sys.util.BeanUtils;
import com.tw.sys.util.DateUtil;

import ${beanPackage};
import ${servicePackage};

/** 
 * @ClassName: ${beanName} 
 * @Description: ${tableRemark}
 
 * @author ${authorOriginally}
 * @date ${currentTime}
 */ 
@Controller
@RequestMapping("/${beanNameLower}")
public class ${beanName}Controller extends BaseController{
	@Autowired
	I${beanName}Service ${beanNameLower}Service;
	
	/**
	 * @Title: getById
	 * @Class: ${beanName}Controller.java
	 * @Package: ${packageName}
	 * @Description: 根据Id查询
	 
	 *@param ${beanNameLower}
	 *@return
	 
	 * @AuthorOriginally ${authorOriginally}
	 * @date ${currentTime}
	 */
	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	@ResponseBody
	public String getById(${beanName} ${beanNameLower}) {
		<#assign  num=0>
		<#list fields as field>
		<#if field.isPK?index_of("true")!=-1>
		<#assign  num=1>
		if (${beanNameLower} != null && !StringUtils.isBlank(${beanNameLower}.get${field.gsFiel}())) {
			${beanName} t = ${beanNameLower}Service.queryForObject("${beanNameLower}Mapper.selectById", ${beanNameLower}.get${field.gsFiel}());
			return getJson(t);
		}else {
			Json json = new Json();
			json.setMsg("主键不可为空！");
			return getJson(json);
		}
	    </#if>
		</#list>
		<#if num==0>
		//因未读取到主键信息，所以转为对象查询
		if (${beanNameLower} != null)) {
			${beanName} t = ${beanNameLower}Service.queryForObject("${beanNameLower}Mapper.selectByEntiry", ${beanNameLower});
			return getJson(t);
		}else {
			Json json = new Json();
			json.setMsg("主键不可为空！");
			return getJson(json);
		}
		</#if>
	}
	
	/**
	 * @Title: grid
	 * @Class: ${beanName}Controller.java
	 * @Package: ${packageName}
	 * @Description: 查询Grid数据列表
	 
	 *@param ${beanNameLower}
	 *@return
	 
	 * @AuthorOriginally ${authorOriginally}
	 * @date ${currentTime}
	 */
	@RequestMapping(value = "/grid", method = RequestMethod.POST)
	@ResponseBody
	public String grid() {
		Grid grid = ${beanNameLower}Service.queryForGrid("${beanNameLower}Mapper.queryPage",dto);
		return getJson(grid);
	}
	
	/**
	 * @Title: save
	 * @Class: ${beanName}Controller.java
	 * @Package: ${packageName}
	 * @Description: 保存
	 
	 *@param ${beanNameLower}
	 *@return
	 
	 * @AuthorOriginally ${authorOriginally}
	 * @date ${currentTime}
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public String save(${beanName} ${beanNameLower}) {
		Json json = new Json();
		if (${beanNameLower} != null) {
			${beanNameLower}.setCreatedatetime(DateUtil.getDate());
			${beanNameLower}.setUpdatedatetime(DateUtil.getDate());
			${beanNameLower}Service.insert("${beanNameLower}Mapper.insert",${beanNameLower});
			json.setSuccess(true);
		}
		return getJson(json);
	}
	
	/**
	 * @Title: update
	 * @Class: ${beanName}Controller.java
	 * @Package: ${packageName}
	 * @Description: 更新
	 
	 *@param ${beanNameLower}
	 *@return
	 
	 * @AuthorOriginally ${authorOriginally}
	 * @date ${currentTime}
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public String update(${beanName} ${beanNameLower}) {
		Json json = new Json();
		<#list fields as field>
		<#if field.isPK?index_of("true")!=-1>
		if (${beanNameLower} != null && !StringUtils.isBlank(${beanNameLower}.get${field.gsFiel}())) {
			${beanName} t = ${beanNameLower}Service.queryForObject("${beanNameLower}Mapper.selectById", ${beanNameLower}.get${field.gsFiel}());
			BeanUtils.copyNotNullProperties(${beanNameLower}, t, new String[] { "createdatetime" });
			t.setUpdatedatetime(DateUtil.getDate());
			${beanNameLower}Service.update("${beanNameLower}Mapper.updateByPrimaryKey", t);
			json.setSuccess(true);
			json.setMsg("更新成功！");
		}
		</#if>
		</#list>
		return getJson(json);
	}
	
	/**
	 * @Title: delete
	 * @Class: ${beanName}Controller.java
	 * @Package: ${packageName}
	 * @Description: 删除
	 
	 *@param ${beanNameLower}
	 *@return
	 
	 * @AuthorOriginally ${authorOriginally}
	 * @date ${currentTime}
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public String delete(${beanName} ${beanNameLower}) {
		Json json = new Json();
		<#list fields as field>
		<#if field.isPK?index_of("true")!=-1>
		if (${beanNameLower} != null && !StringUtils.isBlank(${beanNameLower}.get${field.gsFiel}())) {
			${beanNameLower}Service.delete("${beanNameLower}Mapper.delete",${beanNameLower});
			json.setSuccess(true);
			json.setMsg("删除成功！");
		}
		</#if>
		</#list>
		return getJson(json);
	}
}
