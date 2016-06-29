package com.yzframework.model;

import com.yzframework.base.Model;
import com.yzframework.bean.ProcessForm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
/**
 * 车易贷申请单
 * @author yuzhuo
 */
public class Mcarloanform extends Model implements Serializable,ProcessForm {

    private static final long serialVersionUID = -1L;

    public Mcarloanform(){}

    /// 自定义区域 开始
    public String getOrgcode(){
    	return "";
    }
    /// 自定义区域 结束

    /// 工具生成区域 开始
    private String appno;
    public String getAppno() {
        return appno;
    }
    public void setAppno(String appno) {
        this.firePropertyChange("appno");
        this.appno = appno;
    }

    private String loanpersonname;
    public String getLoanpersonname() {
        return loanpersonname;
    }
    public void setLoanpersonname(String loanpersonname) {
        this.firePropertyChange("loanpersonname");
        this.loanpersonname = loanpersonname;
    }

    private String idcard;
    public String getIdcard() {
        return idcard;
    }
    public void setIdcard(String idcard) {
        this.firePropertyChange("idcard");
        this.idcard = idcard;
    }

    private String gender;
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.firePropertyChange("gender");
        this.gender = gender;
    }

    private Integer age;
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.firePropertyChange("age");
        this.age = age;
    }

    private String marriage;
    public String getMarriage() {
        return marriage;
    }
    public void setMarriage(String marriage) {
        this.firePropertyChange("marriage");
        this.marriage = marriage;
    }

    private String censusadrress;
    public String getCensusadrress() {
        return censusadrress;
    }
    public void setCensusadrress(String censusadrress) {
        this.firePropertyChange("censusadrress");
        this.censusadrress = censusadrress;
    }

    private String telephone;
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.firePropertyChange("telephone");
        this.telephone = telephone;
    }

    private String adrress;
    public String getAdrress() {
        return adrress;
    }
    public void setAdrress(String adrress) {
        this.firePropertyChange("adrress");
        this.adrress = adrress;
    }

    private String company;
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.firePropertyChange("company");
        this.company = company;
    }

    private String post;
    public String getPost() {
        return post;
    }
    public void setPost(String post) {
        this.firePropertyChange("post");
        this.post = post;
    }

    private String companyphone;
    public String getCompanyphone() {
        return companyphone;
    }
    public void setCompanyphone(String companyphone) {
        this.firePropertyChange("companyphone");
        this.companyphone = companyphone;
    }

    private String sencodcontact;
    public String getSencodcontact() {
        return sencodcontact;
    }
    public void setSencodcontact(String sencodcontact) {
        this.firePropertyChange("sencodcontact");
        this.sencodcontact = sencodcontact;
    }

    private String sencodphone;
    public String getSencodphone() {
        return sencodphone;
    }
    public void setSencodphone(String sencodphone) {
        this.firePropertyChange("sencodphone");
        this.sencodphone = sencodphone;
    }

    private BigDecimal loanamount;
    public BigDecimal getLoanamount() {
        return loanamount;
    }
    public void setLoanamount(BigDecimal loanamount) {
        this.firePropertyChange("loanamount");
        this.loanamount = loanamount;
    }

    private String loanusage;
    public String getLoanusage() {
        return loanusage;
    }
    public void setLoanusage(String loanusage) {
        this.firePropertyChange("loanusage");
        this.loanusage = loanusage;
    }

    private Integer loanlimit;
    public Integer getLoanlimit() {
        return loanlimit;
    }
    public void setLoanlimit(Integer loanlimit) {
        this.firePropertyChange("loanlimit");
        this.loanlimit = loanlimit;
    }

    private Date loanlimitbegin;
    public Date getLoanlimitbegin() {
        return loanlimitbegin;
    }
    public void setLoanlimitbegin(Date loanlimitbegin) {
        this.firePropertyChange("loanlimitbegin");
        this.loanlimitbegin = loanlimitbegin;
    }

    private Date loanlimitend;
    public Date getLoanlimitend() {
        return loanlimitend;
    }
    public void setLoanlimitend(Date loanlimitend) {
        this.firePropertyChange("loanlimitend");
        this.loanlimitend = loanlimitend;
    }

    private String payrate;
    public String getPayrate() {
        return payrate;
    }
    public void setPayrate(String payrate) {
        this.firePropertyChange("payrate");
        this.payrate = payrate;
    }

    private String carloantype;
    public String getCarloantype() {
        return carloantype;
    }
    public void setCarloantype(String carloantype) {
        this.firePropertyChange("carloantype");
        this.carloantype = carloantype;
    }

    private String carbrandstyle;
    public String getCarbrandstyle() {
        return carbrandstyle;
    }
    public void setCarbrandstyle(String carbrandstyle) {
        this.firePropertyChange("carbrandstyle");
        this.carbrandstyle = carbrandstyle;
    }

    private String cartrademark;
    public String getCartrademark() {
        return cartrademark;
    }
    public void setCartrademark(String cartrademark) {
        this.firePropertyChange("cartrademark");
        this.cartrademark = cartrademark;
    }

    private String carregcity;
    public String getCarregcity() {
        return carregcity;
    }
    public void setCarregcity(String carregcity) {
        this.firePropertyChange("carregcity");
        this.carregcity = carregcity;
    }

    private String carengineno;
    public String getCarengineno() {
        return carengineno;
    }
    public void setCarengineno(String carengineno) {
        this.firePropertyChange("carengineno");
        this.carengineno = carengineno;
    }

    private String carframeno;
    public String getCarframeno() {
        return carframeno;
    }
    public void setCarframeno(String carframeno) {
        this.firePropertyChange("carframeno");
        this.carframeno = carframeno;
    }

    private Date carbuytime;
    public Date getCarbuytime() {
        return carbuytime;
    }
    public void setCarbuytime(Date carbuytime) {
        this.firePropertyChange("carbuytime");
        this.carbuytime = carbuytime;
    }

    private BigDecimal carprice;
    public BigDecimal getCarprice() {
        return carprice;
    }
    public void setCarprice(BigDecimal carprice) {
        this.firePropertyChange("carprice");
        this.carprice = carprice;
    }

    private BigDecimal evaluateprice;
    public BigDecimal getEvaluateprice() {
        return evaluateprice;
    }
    public void setEvaluateprice(BigDecimal evaluateprice) {
        this.firePropertyChange("evaluateprice");
        this.evaluateprice = evaluateprice;
    }

    private String evaluator;
    public String getEvaluator() {
        return evaluator;
    }
    public void setEvaluator(String evaluator) {
        this.firePropertyChange("evaluator");
        this.evaluator = evaluator;
    }

    private Date evaluatetime;
    public Date getEvaluatetime() {
        return evaluatetime;
    }
    public void setEvaluatetime(Date evaluatetime) {
        this.firePropertyChange("evaluatetime");
        this.evaluatetime = evaluatetime;
    }

    private String liableperson1;
    public String getLiableperson1() {
        return liableperson1;
    }
    public void setLiableperson1(String liableperson1) {
        this.firePropertyChange("liableperson1");
        this.liableperson1 = liableperson1;
    }

    private String liableperson2;
    public String getLiableperson2() {
        return liableperson2;
    }
    public void setLiableperson2(String liableperson2) {
        this.firePropertyChange("liableperson2");
        this.liableperson2 = liableperson2;
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