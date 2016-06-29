package com.yzframework.model;

import com.yzframework.base.Model;
import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 日志管理
 * @author yuzhuo
 */
public class Mlog extends Model implements Serializable {

    private static final long serialVersionUID = -1L;

    public Mlog(){}

    /// 自定义区域 开始
    private String formattedOptime;
    public String getFormattedOptime() {
        return formattedOptime;
    }
    public void setFormattedOptime(String formattedOptime) {
        this.formattedOptime = formattedOptime;
    }
    /// 自定义区域 结束

    /// 工具生成区域 开始
    private String modulename;
    public String getModulename() {
        return modulename;
    }
    public void setModulename(String modulename) {
        this.firePropertyChange("modulename");
        this.modulename = modulename;
    }

    private String opstyle;
    public String getOpstyle() {
        return opstyle;
    }
    public void setOpstyle(String opstyle) {
        this.firePropertyChange("opstyle");
        this.opstyle = opstyle;
    }

    private String opcontent;
    public String getOpcontent() {
        return opcontent;
    }
    public void setOpcontent(String opcontent) {
        this.firePropertyChange("opcontent");
        this.opcontent = opcontent;
    }

    private Timestamp optime;
    public Timestamp getOptime() {
        return optime;
    }
    public void setOptime(Timestamp optime) {
        this.firePropertyChange("optime");
        this.optime = optime;
    }

    private String opperson;
    public String getOpperson() {
        return opperson;
    }
    public void setOpperson(String opperson) {
        this.firePropertyChange("opperson");
        this.opperson = opperson;
    }

    private String orgno;
    public String getOrgno() {
        return orgno;
    }
    public void setOrgno(String orgno) {
        this.firePropertyChange("orgno");
        this.orgno = orgno;
    }

    private String ip;
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.firePropertyChange("ip");
        this.ip = ip;
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