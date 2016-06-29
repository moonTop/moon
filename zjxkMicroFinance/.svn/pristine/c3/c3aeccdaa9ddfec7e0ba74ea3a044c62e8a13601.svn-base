package com.yzframework.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 树形结构JSON格式bean类
 */
public class BeanTreeModule implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
		// 根节点ID
		private String id;
		// 根节点名称
		private String modname;
		// 节点图片路径
		private String picurl = "";
		// 节点链接路径
		private String linkurl = "";
		// 是否有子节点
		private String endflg = "";
		// 子结点
		private List<BeanTreeModule> children = new ArrayList<BeanTreeModule>();
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getModname() {
			return modname;
		}
		public void setModname(String modname) {
			this.modname = modname;
		}
		public String getPicurl() {
			return picurl;
		}
		public void setPicurl(String picurl) {
			this.picurl = picurl;
		}
		public String getLinkurl() {
			return linkurl;
		}
		public void setLinkurl(String linkurl) {
			this.linkurl = linkurl;
		}
		public String getEndflg() {
			return endflg;
		}
		public void setEndflg(String endflg) {
			this.endflg = endflg;
		}
		public List<BeanTreeModule> getChildren() {
			return children;
		}
		public void setChildren(List<BeanTreeModule> children) {
			this.children = children;
		}
}