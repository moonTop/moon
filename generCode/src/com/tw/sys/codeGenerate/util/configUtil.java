package com.tw.sys.codeGenerate.util;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

@SuppressWarnings("all")
public class configUtil {
	private static ResourceBundle bundle = ResourceBundle.getBundle("config");

	/**
	 * @Title: getConnInfo
	 * @Class: configUtil.java
	 * @Package: com.tw.sys.codeGenerate.util
	 * @Description: 获取数据库连接信息
	 
	 *@return
	 
	 * @AuthorOriginally DHL
	 * @date 2014-4-4 下午3:23:20
	 */
	public static Map<String,String> getConnInfo() {
		Map<String,String> map = new HashMap<String,String>();
		String dialect = bundle.getString("db.dialect");//数据库方言
		map.put("dialect", dialect);
		String url = bundle.getString("db."+dialect+".url");//连接字符串
		map.put("url", url);
		String username = bundle.getString("db."+dialect+".username");//用户名
		map.put("username", username);
		String password = bundle.getString("db."+dialect+".password");//密码
		map.put("password", password);
		return map;
	}
	
	/**
	 * @Title: getValue
	 * @Class: configUtil.java
	 * @Package: com.tw.sys.codeGenerate.util
	 * @Description:
	 
	 *@param key
	 *@return
	 
	 * @AuthorOriginally DHL
	 * @date 2014-4-7 上午9:38:42
	 */
	public static String getValue(String key) {
		String value = bundle.getString(key);
		return value;
	}
}
