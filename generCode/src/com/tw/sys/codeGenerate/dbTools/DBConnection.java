package com.tw.sys.codeGenerate.dbTools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

import com.tw.sys.codeGenerate.model.DBModel;

/**
 * @ClassName: DBConnection
 * @Description: 数据库链接类 适用于oracle，db2，mysql 通过构造函数传入值区别是那种数据库
 * 
 * @author DHL
 * @date 2014-3-12 下午8:39:18
 */
public class DBConnection {
	public static final String ORACLE_FLAG = "oracle";
	public static final String DB2_FLAG = "db2";
	public static final String MYSQL_FLAG = "mysql";

	/** 数据库连接URL */
	private String DBurl;

	/** 数据库连接驱动 */
	private String DBdriver;

	/** 数据库用户名 */
	private String DBuser;

	/** 数据库密码 */
	private String DBpwd;

	/**
	 * @param model
	 *            数据库类型 如：oracle,mysql
	 */
	public DBConnection(DBModel model) {
		this.initDBConfig(model);
	}

	/**
	 * @Title: initDBConfig
	 * @Class: DBConnection.java
	 * @Package: com.tw.sys.createcode.common
	 * @Description: 初始化数据库值
	 * 
	 * @param model
	 *            数据库类型 如：oracle,mysql
	 * 
	 * @AuthorOriginally DHL
	 * @date 2014-3-12 下午8:41:55
	 */
	private void initDBConfig(DBModel model) {
		try {
			ResourceBundle bundle = ResourceBundle.getBundle("config");
			if (ORACLE_FLAG.equals(model.getDBtype())) {
				DBdriver = bundle.getString("db.oracle.driver");
				DBurl = (checkIsNull(model.getDBurl())) ? bundle.getString("db.oracle.url") : model.getDBurl();
				// DBurl = bundle.getString("db.oracle.url");
				DBuser = (checkIsNull(model.getDBname())) ? bundle.getString("db.oracle.username") : model.getDBname();
				DBpwd = (checkIsNull(model.getDBpwd())) ? bundle.getString("db.oracle.password") : model.getDBpwd();
			}
			if (DB2_FLAG.equals(model.getDBtype())) {
				DBdriver = bundle.getString("db.db2.driver");
				DBurl = (checkIsNull(model.getDBurl())) ? bundle.getString("db.db2.url") : model.getDBurl();
				DBuser = (checkIsNull(model.getDBname())) ? bundle.getString("db.db2.username") : model.getDBname();
				DBpwd = (checkIsNull(model.getDBpwd())) ? bundle.getString("db.db2.password") : model.getDBpwd();
				// DBuser = bundle.getString("db.db2.username");
				// DBpwd = bundle.getString("db.db2.password");
			}
			if (MYSQL_FLAG.equals(model.getDBtype())) {
				DBdriver = bundle.getString("db.mysql.driver");
				// DBurl = bundle.getString("db.mysql.url");
				DBurl = (checkIsNull(model.getDBurl())) ? bundle.getString("db.mysql.url") : model.getDBurl();
				DBuser = (checkIsNull(model.getDBname())) ? bundle.getString("db.mysql.username") : model.getDBname();
				DBpwd = (checkIsNull(model.getDBpwd())) ? bundle.getString("db.mysql.password") : model.getDBpwd();
				// DBuser = bundle.getString("db.mysql.username");
				// DBpwd = bundle.getString("db.mysql.password");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * @Title: checkIsNull
	 * @Class: DBConnection.java
	 * @Package: com.tw.sys.createcode.common
	 * @Description: 判断字符串是否为空
	 * 
	 * @param str
	 * @return
	 * 
	 * @AuthorOriginally DHL
	 * @date 2014-3-12 下午8:42:45
	 */
	private boolean checkIsNull(String str) {
		boolean flag = false;
		if ("".equals(str) || str == null) {
			flag = true;
		}
		return flag;
	}

	/**
	 * @Title: getConnection
	 * @Class: DBConnection.java
	 * @Package: com.tw.sys.createcode.common
	 * @Description: 获取数据库连接
	 * 
	 * @return
	 * 
	 * @AuthorOriginally DHL
	 * @date 2014-3-12 下午8:43:02
	 */
	public Connection getConnection() {
		/** 声明Connection连接对象 */
		Connection conn = null;
		try {
			/** 使用Class.forName()方法自动创建这个驱动程序的实例且自动调用DriverManager来注册它 */
			Class.forName(DBdriver);
			/** 通过DriverManager的getConnection()方法获取数据库连接 */
			conn = (Connection) DriverManager.getConnection(DBurl, DBuser, DBpwd);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return conn;
	}

	/**
	 * @Title: closeConnection
	 * @Class: DBConnection.java
	 * @Package: com.tw.sys.createcode.common
	 * @Description: 关闭数据库连接
	 
	 *@param conn
	 
	 * @AuthorOriginally DHL
	 * @date 2014-3-12 下午8:43:26
	 */
	public void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				/** 判断当前连接连接对象如果没有被关闭就调用关闭方法 */
				if (!conn.isClosed()) {
					conn.close();
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("关闭数据库连接异常：" + ex);
		}
	}
	
	public static void main(String[] args) {
		//new DBConnection(MYSQL_FLAG).getConnection();
	}
}
