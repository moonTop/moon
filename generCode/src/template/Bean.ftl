package ${packageName};

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;

/** 
 * @ClassName: ${beanName} 
 * @Description: ${tableRemark}
 
 * @author ${authorOriginally}
 * @date ${currentTime}
 */ 
@SuppressWarnings("all")
public class ${beanName} implements Serializable {
	<#list fields as field>
	/** ${field.remark} */
	private ${field.fieldType} ${field.fieldName};
	</#list>
	
	<#list fields as field>
	/** ${field.remark} */
	public ${field.fieldType} get${field.gsFiel}() {
		return this.${field.fieldName};
	}
	/** ${field.remark} */
	public void set${field.gsFiel}(${field.fieldType} ${field.fieldName}) {
		this.${field.fieldName} = ${field.fieldName};
	}
	</#list>
	
	public Map toMap(){
		Map map = new HashMap();
		<#list fields as field>
		map.put("${field.fieldName}",this.${field.fieldName});
		</#list>
		return map;
	}
}