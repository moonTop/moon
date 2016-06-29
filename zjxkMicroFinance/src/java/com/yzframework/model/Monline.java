package com.yzframework.model;

import com.yzframework.base.Model;
import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 在线用户
 * @author yuzhuo
 */
public class Monline extends Model implements Serializable {

    private static final long serialVersionUID = -1L;

    public Monline(){}

    /// 自定义区域 开始

    /// 自定义区域 结束

    /// 工具生成区域 开始
    private String username;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.firePropertyChange("username");
        this.username = username;
    }

    private String password;
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.firePropertyChange("password");
        this.password = password;
    }

    private String mobile;
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.firePropertyChange("mobile");
        this.mobile = mobile;
    }

    private String email;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.firePropertyChange("email");
        this.email = email;
    }

    private String loanamount;
    public String getLoanamount() {
        return loanamount;
    }
    public void setLoanamount(String loanamount) {
        this.firePropertyChange("loanamount");
        this.loanamount = loanamount;
    }

    private String birthday;
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.firePropertyChange("birthday");
        this.birthday = birthday;
    }

    private String isloaned;
    public String getIsloaned() {
        return isloaned;
    }
    public void setIsloaned(String isloaned) {
        this.firePropertyChange("isloaned");
        this.isloaned = isloaned;
    }

    private String status;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.firePropertyChange("status");
        this.status = status;
    }

    private String createid;
    public String getCreateid() {
        return createid;
    }
    public void setCreateid(String createid) {
        this.firePropertyChange("createid");
        this.createid = createid;
    }

    private Timestamp createtime;
    public Timestamp getCreatetime() {
        return createtime;
    }
    public void setCreatetime(Timestamp createtime) {
        this.firePropertyChange("createtime");
        this.createtime = createtime;
    }

    private String updateid;
    public String getUpdateid() {
        return updateid;
    }
    public void setUpdateid(String updateid) {
        this.firePropertyChange("updateid");
        this.updateid = updateid;
    }

    private Timestamp updatetime;
    public Timestamp getUpdatetime() {
        return updatetime;
    }
    public void setUpdatetime(Timestamp updatetime) {
        this.firePropertyChange("updatetime");
        this.updatetime = updatetime;
    }
}