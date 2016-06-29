package com.yzframework.model;

import com.yzframework.base.Model;
import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 权限管理
 * @author yuzhuo
 */
public class Tauthority extends Model implements Serializable {

    private static final long serialVersionUID = -1L;

    public Tauthority(){}

    /// 自定义区域 开始

    /// 自定义区域 结束

    /// 工具生成区域 开始
    private String modid;
    public String getModid() {
        return modid;
    }
    public void setModid(String modid) {
        this.firePropertyChange("modid");
        this.modid = modid;
    }

    private String roleid;
    public String getRoleid() {
        return roleid;
    }
    public void setRoleid(String roleid) {
        this.firePropertyChange("roleid");
        this.roleid = roleid;
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

    private Fmodule fmodule;
    public Fmodule getFmodule() {
        return fmodule;
    }
    public void setFmodule(Fmodule fmodule) {
        this.firePropertyChange("fmodule");
        this.fmodule = fmodule;
    }

    private Mrole mrole;
    public Mrole getMrole() {
        return mrole;
    }
    public void setMrole(Mrole mrole) {
        this.firePropertyChange("mrole");
        this.mrole = mrole;
    }
}