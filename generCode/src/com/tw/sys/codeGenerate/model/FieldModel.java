package com.tw.sys.codeGenerate.model;

/** 
 * @ClassName: FieldModel 
 * @Description: 字段属性
 
 * @author DHL
 * @date 2014-4-7 上午11:14:42 
 */ 
public class FieldModel {
	/** 字段 */
	private String fieldName;
	/** 字段类型 */
	private String fieldType;
	/** 字段备注 */
	private String remark;
	/** 数据库列名 */
	private String column;
	/** 数据库类型 */
	private String columnType;
	/** get、set方法名称 */
	private String gsFiel;
	/** 字段是否为主键 */
	private String isPK;
	/** 字段长度 */
	private String fieldLength;
	
	/** 字段 */
	public String getFieldName() {
		return fieldName;
	}
	/** 字段 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	/** 字段类型 */
	public String getFieldType() {
		return fieldType;
	}
	/** 字段类型 */
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	/** 字段备注 */
	public String getRemark() {
		return remark;
	}
	/** 字段备注 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/** 数据库列名 */
	public String getColumn() {
		return column;
	}
	/** 数据库列名 */
	public void setColumn(String column) {
		this.column = column;
	}
	/** 数据库类型 */
	public String getColumnType() {
		return columnType;
	}
	/** 数据库类型 */
	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}
	/** get、set方法名称 */
	public String getGsFiel() {
		return gsFiel;
	}
	/** get、set方法名称 */
	public void setGsFiel(String gsFiel) {
		this.gsFiel = gsFiel;
	}
	/** 字段是否为主键 */
	public String getIsPK() {
		return isPK;
	}
	/** 字段是否为主键 */
	public void setIsPK(String isPK) {
		this.isPK = isPK;
	}
	public String getFieldLength() {
		return fieldLength;
	}
	public void setFieldLength(String fieldLength) {
		this.fieldLength = fieldLength;
	}
	
	
}
