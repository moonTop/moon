package com.yzframework.base;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public abstract class Model {

	private String id;
	private Map<String, String> modifiedProperties = new HashMap<String, String>();
	private String ASCString;
	private String DESCString;

	private String createid;
	private Timestamp createtime;
	private String updateid;
	private Timestamp updatetime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, String> getModifiedProperties() {
		return modifiedProperties;
	}

	public void setModifiedProperties(Map<String, String> modifiedProperties) {
		this.modifiedProperties = modifiedProperties;
	}

	protected void firePropertyChange(String propertyName) {
		if (modifiedProperties == null) {
			modifiedProperties = new HashMap<String, String>();
		}

		modifiedProperties.put(propertyName, propertyName);
	}

	public String getASCString() {
		return ASCString;
	}

	public void setASCString(String aSCString) {
		ASCString = aSCString;
	}

	public String getDESCString() {
		return DESCString;
	}

	public void setDESCString(String dESCString) {
		DESCString = dESCString;
	}

	public String getCreateid() {
		return createid;
	}

	public void setCreateid(String createid) {
		this.createid = createid;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public String getUpdateid() {
		return updateid;
	}

	public void setUpdateid(String updateid) {
		this.updateid = updateid;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

}
