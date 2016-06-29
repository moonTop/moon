package com.tw.sys.codeGenerate.model;

import java.io.Serializable;

public class TableForm implements Serializable {
	private static final long serialVersionUID = 1L;
	Object rightAllValues[];
	private String selecedTable;
	private String objectName;
	private String basePath;
	private String storePath;
	private String writeFilePath;
	private String packageName;
	private String fileName;
	private boolean isBeanBol;
	private boolean isServiceBol;
	private boolean isXmlBol;
	private boolean isJspBol;
	private boolean isControllerBol;
	private boolean isJsBol;
	private boolean isManagerBol;
	
	private DBModel model;
	
	public Object[] getRightAllValues() {
		return rightAllValues;
	}
	public void setRightAllValues(Object[] rightAllValues) {
		this.rightAllValues = rightAllValues;
	}
	public String getSelecedTable() {
		return selecedTable;
	}
	public void setSelecedTable(String selecedTable) {
		this.selecedTable = selecedTable;
	}
	public String getObjectName() {
		return objectName;
	}
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
	public String getBasePath() {
		return basePath;
	}
	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}
	public String getStorePath() {
		return storePath;
	}
	public void setStorePath(String storePath) {
		this.storePath = storePath;
	}
	public String getWriteFilePath() {
		return writeFilePath;
	}
	public void setWriteFilePath(String writeFilePath) {
		this.writeFilePath = writeFilePath;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public boolean isBeanBol() {
		return isBeanBol;
	}
	public void setBeanBol(boolean isBeanBol) {
		this.isBeanBol = isBeanBol;
	}
	public boolean isServiceBol() {
		return isServiceBol;
	}
	public void setServiceBol(boolean isServiceBol) {
		this.isServiceBol = isServiceBol;
	}
	public boolean isXmlBol() {
		return isXmlBol;
	}
	public void setXmlBol(boolean isXmlBol) {
		this.isXmlBol = isXmlBol;
	}
	public boolean isJspBol() {
		return isJspBol;
	}
	public void setJspBol(boolean isJspBol) {
		this.isJspBol = isJspBol;
	}
	public boolean isControllerBol() {
		return isControllerBol;
	}
	public void setControllerBol(boolean isControllerBol) {
		this.isControllerBol = isControllerBol;
	}
	public DBModel getModel() {
		return model;
	}
	public void setModel(DBModel model) {
		this.model = model;
	}
	public boolean isJsBol() {
		return isJsBol;
	}
	public void setJsBol(boolean isJsBol) {
		this.isJsBol = isJsBol;
	}
	public boolean isManagerBol() {
		return isManagerBol;
	}
	public void setManagerBol(boolean isManagerBol) {
		this.isManagerBol = isManagerBol;
	}
	
	
}
