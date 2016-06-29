package com.yzframework.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import com.yzframework.base.Model;
/**
 * 客户管理
 * @author yuzhuo
 */
public class Mcustomer extends Model implements Serializable {

    private static final long serialVersionUID = -1L;

    public Mcustomer(){}

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
    private String idcard;
    public String getIdcard() {
        return idcard;
    }
    public void setIdcard(String idcard) {
        this.firePropertyChange("idcard");
        this.idcard = idcard;
    }
    private String orgcode;
    public String getOrgcode() {
        return orgcode;
    }
    public void setOrgcode(String orgcode) {
        this.firePropertyChange("orgcode");
        this.orgcode = orgcode;
    }
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.firePropertyChange("name");
        this.name = name;
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
    private String customerstatus;
    public String getCustomerstatus() {
        return customerstatus;
    }
    public void setCustomerstatus(String customerstatus) {
        this.firePropertyChange("customerstatus");
        this.customerstatus = customerstatus;
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
    private Set<Mloanrecord> mloanrecords;
    public Set<Mloanrecord> getMloanrecords() {
        return mloanrecords;
    }
    public void setMloanrecords(Set<Mloanrecord> mloanrecords) {
        this.firePropertyChange("mloanrecords");
        this.mloanrecords = mloanrecords;
    }

    public String toJSONString(){
        return "{\"id\":\"" + id + "\",\"idcard\":\"" + idcard + "\",\"orgcode\":\"" + orgcode + "\",\"name\":\"" + name + "\",\"gender\":\"" + gender + "\",\"age\":\"" + age + "\",\"marriage\":\"" + marriage + "\",\"censusadrress\":\"" + censusadrress + "\",\"telephone\":\"" + telephone + "\",\"adrress\":\"" + adrress + "\",\"company\":\"" + company + "\",\"post\":\"" + post + "\",\"companyphone\":\"" + companyphone + "\",\"sencodcontact\":\"" + sencodcontact + "\",\"sencodphone\":\"" + sencodphone + "\",\"customerstatus\":\"" + customerstatus + "\",\"status\":\"" + status + "\",\"createid\":\"" + createid + "\",\"createtime\":\"" + createtime + "\",\"updateid\":\"" + updateid + "\",\"updatetime\":\"" + updatetime + "\"}";
    }
    /// 工具生成区域 结束
}
