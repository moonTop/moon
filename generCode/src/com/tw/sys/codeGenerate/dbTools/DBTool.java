package com.tw.sys.codeGenerate.dbTools;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.tw.sys.codeGenerate.model.DBModel;
import com.tw.sys.codeGenerate.util.configUtil;

/**
 * @ClassName: DBTool
 * @Description: 数据库操作工具类
 * 
 * @author DHL
 * @date 2014-3-12 下午8:53:24
 */
@SuppressWarnings("all")
public class DBTool {
	private static final Log log = LogFactory.getLog(DBTool.class);

	/**
	 * @Title: getAllTableName
	 * @Class: DBTool.java
	 * @Package: com.tw.sys.createcode.tool
	 * @Description: 获取所有表表名
	 * 
	 * @param cnn
	 * @return
	 * @throws SQLException
	 * 
	 * @AuthorOriginally DHL
	 * @date 2014-3-12 下午8:54:10
	 */
	public static List getAllTableName(Connection cnn) throws SQLException {
		List tables = new ArrayList();
		DatabaseMetaData dbMetaData = cnn.getMetaData();
		// 可为:"TABLE", "VIEW", "SYSTEM   TABLE",
		// "GLOBAL   TEMPORARY", "LOCAL   TEMPORARY", "ALIAS", "SYNONYM"
		ResultSet tabs = null;
		if("mysql".equals(configUtil.getValue("db.dialect"))){
			String[] types = { "TABLE" };
			tabs = dbMetaData.getTables(null, null, null, types);
		}else if ("oracle".equals(configUtil.getValue("db.dialect"))) {
			String table_name = configUtil.getValue("table_name");
			PreparedStatement pstmt = cnn.prepareStatement("select table_name from user_tables WHERE table_name LIKE '"+table_name+"%'");
			tabs = pstmt.executeQuery();
		}
		while (tabs.next()) {
			// 只要表名这一列
			Object tabName = tabs.getObject("TABLE_NAME");
			tables.add(tabName + "━" + getCommentByTableName(cnn,tabName));
		}
		log.info(tables);
		return tables;
	}

	/**
	 * @Title: getCommentByTableName
	 * @Class: DBTool.java
	 * @Package: com.tw.sys.createcode.tool
	 * @Description: 根据表名获取表注释
	 
	 *@param cnn
	 *@param tabName
	 *@return
	 
	 * @AuthorOriginally DHL
	 * @date 2014-3-14 下午11:11:37
	 */
	public static String getCommentByTableName(Connection cnn, Object tabName) throws SQLException {
		String dialect = configUtil.getValue("db.dialect");
		String comment = null;
		if("mysql".equals(dialect)){
			PreparedStatement pstmt = cnn.prepareStatement("SHOW CREATE TABLE " + tabName);
			ResultSet rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
				String all = rs.getString(2);
				int index = all.indexOf("COMMENT='");
				if (index < 0) {
					return "";
				}
				comment = all.substring(index + 9);
				comment = comment.substring(0, comment.length() - 1);
			}
		}else if("oracle".equals(dialect)){
			PreparedStatement pstmt = cnn.prepareStatement("select comments from user_tab_comments where table_name = '"+tabName.toString().toUpperCase()+"'");
			ResultSet rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
				comment = rs.getString(1);
			}
		}
		
		return comment;
	}

	/**
	 * @Title: getAllColumnInfoV2
	 * @Class: DBTool.java
	 * @Package: com.tw.sys.createcode.tool
	 * @Description: 获取某表下所有字段
	 * 
	 * @param conn
	 * @param tableName
	 * @return
	 * @throws SQLException
	 * 
	 * @AuthorOriginally DHL
	 * @date 2014-3-12 下午8:54:33
	 */
	public static List getAllColumnInfoV2(Connection conn, String tableName) throws SQLException {
		List columns = new ArrayList();
		String sql = "";
		if("mysql".equals(configUtil.getValue("db.dialect"))){
			sql = "SELECT * FROM " + tableName;
		}else if ("oracle".equals(configUtil.getValue("db.dialect"))) {
			sql = "select * from user_col_comments where table_name = '" + tableName +"'";
		}
		// 预编译的 SQL 语句
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// 获取结果集
		ResultSet rs = pstmt.executeQuery();
		// 获取所有字段名
		ResultSetMetaData rsmd = rs.getMetaData();
		if (rsmd != null) {
			int count = rsmd.getColumnCount();
			for (int i = 1; i <= count; i++) {
				String columnLabel = rsmd.getColumnLabel(i);
				log.info(tableName + "->ColumnNameType======" + rsmd.getColumnTypeName(i));
				log.info(tableName + "->ColumnDisplaySize======" + rsmd.getColumnDisplaySize(i));
				log.info(tableName + "->ColumnName======" + rsmd.getColumnName(i));
				columns.add(rsmd.getColumnTypeName(i) + "-" + rsmd.getColumnDisplaySize(i) + "-" + rsmd.getColumnName(i) + "-" + columnLabel);
				// //判断当前字段是否为主键，如果不是主键则加入到Vector集合中
				// if(!DBFactory.isPrimaryKey(conn,tableName, rsmd.getColumnName(i)))
			}
		}
		return columns;
	}

	/**
	 * @Title: getAllColumnInfo
	 * @Class: DBTool.java
	 * @Package: com.tw.sys.createcode.tool
	 * @Description: 获取某表下所有字段
	 * 
	 * @param conn
	 * @param tableName
	 * @return
	 * @throws SQLException
	 * 
	 * @AuthorOriginally DHL
	 * @date 2014-3-12 下午8:55:20
	 */
	public static List getAllColumnInfo(Connection conn, String tableName) throws SQLException {
		List<String> columns = new ArrayList<String>();
		DatabaseMetaData databaseMetaData = conn.getMetaData();
		ResultSet columnSet = databaseMetaData.getColumns(null, "%", tableName, "%");
		if (columnSet != null) {
			while (columnSet.next()) {
				String columnTypeName = columnSet.getString("TYPE_NAME");
				String columnName = columnSet.getString("COLUMN_NAME");
				String columnLength = getColumnLength(conn, columnSet, tableName, columnName);
				System.out.println(columnName);
				String columnComment = getColumnRemarks(conn,columnSet,tableName,columnName);
				columnComment = ("".equals(columnComment)) ? " " : columnComment;
				String item = columnTypeName + "━" + columnName + "━" + columnComment+"━"+columnLength;
				if (!columns.contains(item)) {
					columns.add(item);
				}
			}
		}
		//columns = new ArrayList(new HashSet(columns));
		return columns;
	}

	/**
	 * @Title: getColumnRemarks
	 * @Class: DBTool.java
	 * @Package: com.tw.sys.codeGenerate.dbTools
	 * @Description: 获取表字段注释
	 
	 *@param columnSet
	 *@return
	 *@throws SQLException
	 
	 * @AuthorOriginally DHL
	 * @date 2014年4月29日 下午7:28:28
	 */
	private static String getColumnRemarks(Connection conn, ResultSet columnSet, String tabName, String columnName) throws SQLException {
		String columnComment = columnSet.getString("REMARKS");
		if("mysql".equals(configUtil.getValue("db.dialect"))){
			columnComment = columnSet.getString("REMARKS");
		}else if ("oracle".equals(configUtil.getValue("db.dialect"))) {
			String sql = "select comments from user_col_comments where table_name = '"+tabName+"' and column_name = '"+columnName+"'";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
				columnComment = rs.getString(1);
			}
		}
		return columnComment;
	}
	
	/**
	 * @Title: getColumnLength
	 * @Class: DBTool.java
	 * @Package: com.tw.sys.codeGenerate.dbTools
	 * @Description:获取字符串长度
	 
	 *@param conn
	 *@param columnSet
	 *@param tabName
	 *@param columnName
	 *@return
	 *@throws SQLException
	 
	 * @AuthorOriginally DSY
	 * @date 2014年6月12日 下午4:54:46
	 */
	private static String getColumnLength(Connection conn, ResultSet columnSet, String tabName, String columnName) throws SQLException {
		String columnLength = "";
		if("mysql".equals(configUtil.getValue("db.dialect"))){//未实现
			columnLength = columnSet.getString("REMARKS");
		}else if ("oracle".equals(configUtil.getValue("db.dialect"))) {
			String sql = "select DATA_LENGTH from user_tab_columns where table_name='"+tabName+"' AND COLUMN_NAME='"+columnName+"'";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
				columnLength = rs.getString(1);
			}
		}
		return columnLength;
	}

	/**
	 * @Title: isPrimaryKey
	 * @Class: DBTool.java
	 * @Package: com.tw.sys.createcode.tool
	 * @Description: 判断某表中的字段是否是主键
	 * 
	 * @param conn
	 * @param tableName
	 * @param columnName
	 * @return 返回 true 为是主键 ，返回false则不是
	 * @throws SQLException
	 * 
	 * @AuthorOriginally DHL
	 * @date 2014-3-12 下午8:55:45
	 */
	public static boolean isPrimaryKey(Connection conn, String tableName, String columnName) throws SQLException {
		boolean flag = false;
		DatabaseMetaData dbMeta = conn.getMetaData();
		tableName = tableName.substring(0, tableName.indexOf("━"));
		ResultSet primaryKey = dbMeta.getPrimaryKeys(null, null, tableName);
		while (primaryKey.next()) {
			log.info("表名:" + primaryKey.getString(3));
			log.info("  列名:" + primaryKey.getString(4));
			log.info("  主键名:" + primaryKey.getString(6));
			if (columnName.equals(primaryKey.getString(4))) {
				flag = true;
				break;
			}
		}
		return flag;
	}
}