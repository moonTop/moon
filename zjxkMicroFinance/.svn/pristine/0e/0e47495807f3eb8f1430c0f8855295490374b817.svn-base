package com.yzframework.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import com.yzframework.base.Model;
/**
 * 还款管理
 * @author yuzhuo
 */
public class Mpayrecord extends Model implements Serializable {

    private static final long serialVersionUID = -1L;

    public Mpayrecord(){}

    /// 自定义区域 开始

    /// 自定义区域 结束

    /// 工具生成区域 开始
    private String id;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.firePropertyChange("id");
        this.id = id;
    }
    private String loanrecordid;
    public String getLoanrecordid() {
        return loanrecordid;
    }
    public void setLoanrecordid(String loanrecordid) {
        this.firePropertyChange("loanrecordid");
        this.loanrecordid = loanrecordid;
    }
    private Timestamp planpaydate;
    public Timestamp getPlanpaydate() {
        return planpaydate;
    }
    public void setPlanpaydate(Timestamp planpaydate) {
        this.firePropertyChange("planpaydate");
        this.planpaydate = planpaydate;
    }
    private BigDecimal planpayaccrual;
    public BigDecimal getPlanpayaccrual() {
        return planpayaccrual;
    }
    public void setPlanpayaccrual(BigDecimal planpayaccrual) {
        this.firePropertyChange("planpayaccrual");
        this.planpayaccrual = planpayaccrual;
    }
    private BigDecimal planpayamount;
    public BigDecimal getPlanpayamount() {
        return planpayamount;
    }
    public void setPlanpayamount(BigDecimal planpayamount) {
        this.firePropertyChange("planpayamount");
        this.planpayamount = planpayamount;
    }
    private Timestamp paydate;
    public Timestamp getPaydate() {
        return paydate;
    }
    public void setPaydate(Timestamp paydate) {
        this.firePropertyChange("paydate");
        this.paydate = paydate;
    }
    private BigDecimal payaccrual;
    public BigDecimal getPayaccrual() {
        return payaccrual;
    }
    public void setPayaccrual(BigDecimal payaccrual) {
        this.firePropertyChange("payaccrual");
        this.payaccrual = payaccrual;
    }
    private BigDecimal payamount;
    public BigDecimal getPayamount() {
        return payamount;
    }
    public void setPayamount(BigDecimal payamount) {
        this.firePropertyChange("payamount");
        this.payamount = payamount;
    }
    private String payperson;
    public String getPayperson() {
        return payperson;
    }
    public void setPayperson(String payperson) {
        this.firePropertyChange("payperson");
        this.payperson = payperson;
    }
    private String description;
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.firePropertyChange("description");
        this.description = description;
    }
    private String paystatus;
    public String getPaystatus() {
        return paystatus;
    }
    public void setPaystatus(String paystatus) {
        this.firePropertyChange("paystatus");
        this.paystatus = paystatus;
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
    private Mloanrecord mloanrecord;
    public Mloanrecord getMloanrecord() {
        return mloanrecord;
    }
    public void setMloanrecord(Mloanrecord mloanrecord) {
        this.firePropertyChange("mloanrecord");
        this.mloanrecord = mloanrecord;
    }

    public String toJSONString(){
        String loanrecordid = (mloanrecord!=null)?mloanrecord.getId():"";
        return "{\"id\":\"" + id + "\",\"loanrecordid\":\"" + loanrecordid + "\",\"planpaydate\":\"" + planpaydate + "\",\"planpayaccrual\":\"" + planpayaccrual + "\",\"planpayamount\":\"" + planpayamount + "\",\"paydate\":\"" + paydate + "\",\"payaccrual\":\"" + payaccrual + "\",\"payamount\":\"" + payamount + "\",\"payperson\":\"" + payperson + "\",\"description\":\"" + description + "\",\"paystatus\":\"" + paystatus + "\",\"status\":\"" + status + "\",\"createid\":\"" + createid + "\",\"createtime\":\"" + createtime + "\",\"updateid\":\"" + updateid + "\",\"updatetime\":\"" + updatetime + "\"}";
    }
    /// 工具生成区域 结束
}
