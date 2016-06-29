package com.tw.sys.codeGenerate.frame;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;

import com.tw.sys.codeGenerate.dbTools.DBFactory;
import com.tw.sys.codeGenerate.dbTools.DBTool;
import com.tw.sys.codeGenerate.model.DBModel;

@SuppressWarnings("all")
public class FrameItemUtil {
	/**
	 * @Title: tablesComboBox
	 * @Class: FrameItemTool.java
	 * @Package: com.tw.sys.createcode.tool
	 * @Description: 将数据库中所有表设置到JComboBox中
	 
	 *@param model
	 *@return
	 
	 * @AuthorOriginally DHL
	 * @date 2014-3-12 下午9:08:59
	 */
	public static JComboBox tablesComboBox(DBModel model){
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("请选择");
		DBFactory db = new DBFactory();
		// 获取数据库连接
		Connection conn = db.getDBConnectionInstance(model).getConnection();
		try {
			List tableList = DBTool.getAllTableName(conn);
			for (int i = 0; i < tableList.size(); i++) {
				comboBox.addItem(tableList.get(i));
			}
			comboBox.setMaximumRowCount(tableList.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comboBox;
	}
	
	/**
	 * @Title: columnsComboBox
	 * @Class: FrameItemTool.java
	 * @Package: com.tw.sys.createcode.tool
	 * @Description: 将某表中所有字段设置到JComboBox中
	 
	 *@param model
	 *@param tableName
	 *@return
	 
	 * @AuthorOriginally DHL
	 * @date 2014-3-12 下午9:09:18
	 */
	public static JComboBox columnsComboBox(DBModel model,String tableName){
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("请选择");
		DBFactory db = new DBFactory();
		// 获取数据库连接
		Connection conn = db.getDBConnectionInstance(model).getConnection();
		try {
			List columnList = DBTool.getAllColumnInfo(conn, tableName);
			for (int i = 0; i < columnList.size(); i++) {
				comboBox.addItem(columnList.get(i));
			}
			comboBox.setMaximumRowCount(columnList.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comboBox;
	}
	
	/**
	 * @Title: columnsJList
	 * @Class: FrameItemTool.java
	 * @Package: com.tw.sys.createcode.tool
	 * @Description: 将某表中所有字段设置到JComboBox中
	 
	 *@param listModel
	 *@param model
	 *@param tableName
	 
	 * @AuthorOriginally DHL
	 * @date 2014-3-12 下午9:09:46
	 */
	public static void columnsJList(DefaultListModel listModel,DBModel model,String tableName){
//		JList jlist = new JList();
//		DefaultListModel listModel = new DefaultListModel();
		DBFactory db = new DBFactory();
		// 获取数据库连接
		Connection conn = db.getDBConnectionInstance(model).getConnection();
		try {
			List columnList = DBTool.getAllColumnInfo(conn, tableName);
			listModel.clear();
			for (int i = 0; i < columnList.size(); i++) {
				listModel.addElement(columnList.get(i));
			}
//			jlist = new JList(listModel);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}