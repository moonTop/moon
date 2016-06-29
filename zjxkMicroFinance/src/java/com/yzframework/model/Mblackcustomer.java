package com.yzframework.model;

import com.yzframework.base.Model;
import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 黑名单客户
 * @author yuzhuo
 */
public class Mblackcustomer extends Model implements Serializable {

    private static final long serialVersionUID = -1L;

    public Mblackcustomer(){}

    /// 自定义区域 开始

    /// 自定义区域 结束

    /// 工具生成区域 开始
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.firePropertyChange("name");
        this.name = name;
    }

    private String idcard;
    public String getIdcard() {
        return idcard;
    }
    public void setIdcard(String idcard) {
        this.firePropertyChange("idcard");
        this.idcard = idcard;
    }

    private String description;
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.firePropertyChange("description");
        this.description = description;
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