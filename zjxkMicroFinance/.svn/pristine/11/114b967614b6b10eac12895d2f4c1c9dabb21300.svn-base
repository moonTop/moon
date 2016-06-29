<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>

<div class="pageContent">
    <form id="BK200201Form" method="post" action="BK2002/save.do" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
        <div class="pageFormContent" layoutH="56">
            <div class="titleBar">
                <div class="navTitle">楼易贷申请单/</div><div class="pageTitle">提交申请</div>
            </div>
            <table class="form" width="800px" style="border:0px;" >
                <tr>
                    <td align="center">申请借款人姓名</td>
                    <td><input type="text" id="loanpersonname" name="loanpersonname" class="required" value="${model.loanpersonname}" style="width:100px;"></input></td>
                    <td align="center">性别</td>
                    <td>
                        <select id="gender" name="gender" class="required" value="${model.gender}"> 
                            <option value="男">男</option>
                            <option value="女">女</option>
                        </select>
                    </td>
                    <td align="center">年龄</td>
                    <td><input type="text" id="age" name="age" class="digits required" value="${model.age}" style="width:50px;"></input></td>
                </tr>
                <tr>
                    <td align="center">身份证号码</td>
                    <td><input type="text" id="idcard" name="idcard" class="required" value="${model.idcard}" style="width:200px;"></input></td>
                    <td align="center">婚姻状况</td>
                    <td colspan="3">
                        <label><input type="radio" name="marriage" class="required" value="未婚"/>未婚</label>
                        <label><input type="radio" name="marriage" class="required" value="已婚"/>已婚</label>
                        <label><input type="radio" name="marriage" class="required" value="离异"/>离异</label>
                    </td>
                </tr>
                <tr>
                    <td align="center">户口所在地</td>
                    <td><textarea type="text" id="censusadrress" name="censusadrress"class="required" rows="2" style="width:98%;"></textarea></td>
                    <td align="center">联系电话</td>
                    <td colspan="3"><input type="text" id="telephone" name="telephone" class="phone required" value="${model.telephone}" style="width:200px;"></input></td>
                </tr>
                <tr>
                    <td align="center">现住址</td>
                    <td><textarea type="text" id="adrress" name="adrress" class="required" rows="2" style="width:98%;"></textarea></td>
                    <td align="center">工作单位</td>
                    <td colspan="3"><textarea type="text" id="company" name="company" class="required" rows="2" style="width:98%;"></textarea></td>
                </tr>
                <tr>
                    <td align="center">职位</td>
                    <td><input type="text" id="post" name="post" class="required" value="${model.post}" style="width:100px;"></input></td>
                    <td align="center">工作单位电话</td>
                    <td colspan="3"><input type="text" id="companyphone" name="companyphone" class="phone required" value="${model.companyphone}" style="width:200px;"></input></td>
                </tr>
                <tr>
                    <td align="center">第二联系人姓名</td>
                    <td><input type="text" id="sencodcontact" name="sencodcontact" class="required" value="${model.sencodcontact}" style="width:100px;"></input></td>
                    <td align="center">第二联系人电话</td>
                    <td colspan="3"><input type="text" id="sencodphone" name="sencodphone" class="phone required" value="${model.sencodphone}" style="width:200px;"></input></td>
                </tr>
                <tr>
                    <td align="center">申请借款金额</td>
                    <td><input type="text" id="loanamount" name="loanamount" class="number required" value="${model.loanamount}" style="width:100px;"></input><label>万元</label></td>
                    <td align="center">借款用途</td>
                    <td colspan="3"><textarea type="text" id="loanusage" name="loanusage" class="required" rows="2" style="width:98%;"></textarea></td>
                </tr>
                <tr>
                    <td align="center">借款时长</td>
                    <td ><label style="width:10px;">共</label><input type="text" id="loanlimit" name="loanlimit" class="digits required" value="${model.loanlimit}" style="width:50px;"></input><label style="width:100px;">月</label>
                    </td>
                    <td align="center">借款期限</td>
                    <td colspan="3">
                        <input type="text" id="loanlimitbegin" name="loanlimitbegin" value="${model.loanlimitbegin}" class="date required" readonly="true" style="width:100px;"></input><label style="width:20px;">至</label>
                        <input type="text" id="loanlimitend" name="loanlimitend" value="${model.loanlimitend}" class="date required" readonly="true" style="width:100px;"></input>
                    </td>
                </tr>
                <tr>
                    <td align="center">房产地址</td>
                    <td colspan="5"><textarea type="text" id="houseadress" name="houseadress" class="required" rows="2" style="width:98%;"></textarea></td>
                </tr>
                <tr>
                    <td align="center">房产购置时间</td>
                    <td><input type="text" id="housebuytime" name="housebuytime" value="${model.housebuytime}" class="date required" readonly="true" style="width:100px;"></input></td>
                    <td align="center">房产价格</td>
                    <td colspan="3"><input type="text" id="houseprice" name="houseprice" class="bumber required" value="${model.houseprice}" style="width:50px;"></input><label>万元</label></td>
                </tr>
                <tr>
                    <td align="center">评估价格</td>
                    <td><input type="text" id="evaluateprice" name="evaluateprice" class="bumber required" value="${model.evaluateprice}" style="width:50px;"></input><label>万元</label></td>
                    <td align="center">评估人</td>
                    <td align="center" colspan="3"><input type="text" id="evaluator" name="evaluator" class="required" value="${model.evaluator}" style="width:100px;"></input></td>
               </tr>
                <tr>
                    <td align="center">评估时间</td>
                    <td><input type="text" id="evaluatetime" name="evaluatetime" value="${model.evaluatetime}" class="date required" readonly="true" style="width:100px;"></input></td>
                    <td align="center">贷款月利率</td>
                    <td  colspan="3"><input type="text" id="payrate" name="payrate" class="bumber required" value="${model.payrate}" style="width:50px;"></input><label>%</label></td>
                </tr>
                <tr>
                    <td align="center">撰写责任人意见</td>
                    <td colspan="5"><textarea type="text" id="commentText" name="commentText" class="required" rows="4" style="width:98%;"></textarea></td>
                </tr>
            </table>
        </div>
        <div class="formBar">
            <ul>
                <li><div class="buttonActive"><div class="buttonContent"><button type="submit" onclick="submits();">提交</button></div></div></li>
                <li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
            </ul>
        </div>
    </form>
</div>