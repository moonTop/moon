package com.tw.sys.codeGenerate.freemarker;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tw.sys.codeGenerate.dbTools.DBFactory;
import com.tw.sys.codeGenerate.dbTools.DBTool;
import com.tw.sys.codeGenerate.model.FieldModel;
import com.tw.sys.codeGenerate.model.TableForm;
import com.tw.sys.codeGenerate.util.FilteUtil;
import com.tw.sys.codeGenerate.util.StringUtil;

@SuppressWarnings("all")
public class FilteBean {
	
	/**
	 * 过滤Bean文件
	 * @param readLine
	 * @param tableForm
	 * @return
	 * @throws Exception 
	 */
	public Map filteBeanFile(TableForm tableForm) throws Exception{
		Map field = getField(tableForm);
		return field;
	}
	
	/**
	 * @Title: getField
	 * @Class: FilteBean.java
	 * @Package: com.tw.sys.codeGenerate.freemarker
	 * @Description: 获取数据库字段
	 
	 *@param tableForm
	 *@return
	 * @throws SQLException 
	 
	 * @AuthorOriginally DHL
	 * @date 2014-4-7 上午11:32:36
	 */
	private Map getField(TableForm tableForm) throws SQLException {
		Map map = new HashMap();
		String fieldStr = "";
		List<FieldModel> list = new ArrayList<FieldModel>();
		FieldModel fieldModel;
		Object columns[] = tableForm.getRightAllValues();
		for (int i = 0; i < columns.length; i++) {
			fieldModel = new FieldModel();
			String columnType = columns[i].toString().split("━")[0];
			String column = columns[i].toString().split("━")[1];
			String remark = columns[i].toString().split("━")[2];
			String fieldLength = columns[i].toString().split("━")[3];
			String fieldType = FilteUtil.translateToJavaType(tableForm.getModel().getDBtype(),columnType);
			String fieldName = columns[i].toString().split("━")[1].toUpperCase();
			String gsFiel = StringUtil.initialStrToUpper(fieldName);
			
			if ("iconcls".equals(fieldName.toLowerCase())) {
				fieldName = "iconCls";
			}
			fieldModel.setFieldName(fieldName);
			fieldModel.setFieldType(fieldType);
			fieldModel.setColumn(column.toUpperCase());
			fieldModel.setColumnType(columnType);
			fieldModel.setRemark(remark);
			if(fieldType.equals("String")){//可输入长度为数据库长度的1/2，避免中文字符过长
				fieldLength = (Integer)(Integer.parseInt(fieldLength)/2)+"";
			}
			fieldModel.setFieldLength(fieldLength);
			fieldModel.setGsFiel(gsFiel);
			
			
			fieldStr += fieldType + " " +fieldName + " " +fieldLength + ",";
			
			if (isPrimaryKey(tableForm, column)) {
				fieldModel.setIsPK("true");
			}else {
				fieldModel.setIsPK("false");
			}
			list.add(fieldModel);
		}
		fieldStr = fieldStr.substring(0, fieldStr.length()-1);
		map.put("fieldStr", fieldStr);
		map.put("list", list);
		return map;
	}
	
	/**
	 * @Title: isPrimaryKey
	 * @Class: FilteBean.java
	 * @Package: com.tw.sys.codeGenerate.freemarker
	 * @Description:判断是否为主键
	 
	 *@param tableForm
	 *@param columnName
	 *@return
	 *@throws SQLException
	 
	 * @AuthorOriginally DHL
	 * @date 2014-4-7 下午12:48:44
	 */
	public boolean isPrimaryKey(TableForm tableForm,String columnName) throws SQLException {
		DBFactory db = new DBFactory();
		// 获取数据库连接
		Connection conn = db.getDBConnectionInstance(tableForm.getModel()).getConnection();
		return DBTool.isPrimaryKey(conn, tableForm.getSelecedTable(), columnName);
	}
}
