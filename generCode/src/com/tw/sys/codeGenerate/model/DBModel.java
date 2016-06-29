package com.tw.sys.codeGenerate.model;

public class DBModel {
	/**  数据库连接URL */
	private String DBurl;

	/**  数据库连接驱动 */
	private String DBdriver;
	
	/**  数据库类型 */
	private String DBtype ;
	
	/**  数据库名称 */
	private String DBname ;
	
	/** 数据库用户名 */
	private String DBuser;

	/** 数据库密码 */
	private String DBpwd;

	public String getDBurl() {
		return DBurl;
	}

	public void setDBurl(String dBurl) {
		DBurl = dBurl;
	}

	public String getDBdriver() {
		return DBdriver;
	}

	public void setDBdriver(String dBdriver) {
		DBdriver = dBdriver;
	}

	public String getDBtype() {
		return DBtype;
	}

	public void setDBtype(String dBtype) {
		DBtype = dBtype;
	}

	public String getDBname() {
		return DBname;
	}

	public void setDBname(String dBname) {
		DBname = dBname;
	}

	public String getDBuser() {
		return DBuser;
	}

	public void setDBuser(String dBuser) {
		DBuser = dBuser;
	}

	public String getDBpwd() {
		return DBpwd;
	}

	public void setDBpwd(String dBpwd) {
		DBpwd = dBpwd;
	}
}

