package com.yzframework.bean;


/**
 * 树形结构JSON格式bean类
 */
public class BeanUserList implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
		private String id;
		private String userid;
		private String username;
		private String orgname;
		private String rolename;
		private String mobile;
		private String detail;
		private String status;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getUserid() {
			return userid;
		}
		public void setUserid(String userid) {
			this.userid = userid;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getOrgname() {
			return orgname;
		}
		public void setOrgname(String orgname) {
			this.orgname = orgname;
		}
		public String getRolename() {
			return rolename;
		}
		public void setRolename(String rolename) {
			this.rolename = rolename;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public String getDetail() {
			return detail;
		}
		public void setDetail(String detail) {
			this.detail = detail;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		
}