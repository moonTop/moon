package com.tw.sys.codeGenerate.util;

import java.util.ResourceBundle;

import com.tw.sys.codeGenerate.dbTools.DBConnection;
import com.tw.sys.codeGenerate.model.TableForm;
import com.tw.sys.codeGenerate.util.FormatUtil;
import com.tw.sys.codeGenerate.util.StringUtil;

public class FilteUtil {
	/**
	 * 公共过滤器
	 * @param readLine
	 * @param tableForm
	 * @return
	 */
	public static String filterCommon(String readLine,TableForm tableForm){
		String packageName = tableForm.getPackageName();
		String objectName = tableForm.getObjectName();
		String tabRemark = tableForm.getSelecedTable().split("━")[1];
		String currentTime = FormatUtil.getCurrentDate(FormatUtil.Y_M_D_H_M);
		readLine = readLine.replaceAll("@packageName;","package "+packageName);
		readLine = readLine.replaceAll("@currentTime",currentTime);
//		readLine = readLine.replaceAll("@tableName",StringUtil.initialStrToLower(objectName));
		readLine = readLine.replaceAll("@Object",objectName);
		readLine = readLine.replaceAll("@object",StringUtil.initialStrToLower(objectName));
		readLine = readLine.replaceAll("@tabRemark",tabRemark);
		return readLine;
	}
	
	/**
	 * 数据类型转换
	 * 读取datatype.properties配置文件
	 * @param dbType
	 * @param columnType
	 * @return
	 */
	public static String translateToJavaType(String dbType,String columnType){
		ResourceBundle bundle = ResourceBundle.getBundle("datatype");
		if(DBConnection.ORACLE_FLAG.equals(dbType)){
			columnType = bundle.getString(DBConnection.ORACLE_FLAG+"."+columnType.toUpperCase());
		}
		if(DBConnection.MYSQL_FLAG.equals(dbType)){
			columnType = bundle.getString(DBConnection.MYSQL_FLAG+"."+columnType.toUpperCase());
		}
		return columnType;
	}
	
}
