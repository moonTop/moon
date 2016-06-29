<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<div class="pageContent">
    <form id="BK200202Form" method="post" action="BK2002/approve.do" class="pageForm -validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
        <input type="hidden" id="id" name="id" value="${model.id}" />
        <input type="hidden" id="taskId" name="taskId" value="${taskId}" />
        <div class="pageFormContent" layoutH="56">
            <div class="titleBar">
                <div class="navTitle">楼易贷申请单/</div><div class="pageTitle">审批</div>
            </div>
            <table class="form" width="800px" style="border:0px;">
                <tr>
                    <td align="center">申请借款人姓名</td>
                    <td><input type="text" id="loanpersonname" name="loanpersonname" value="${model.loanpersonname}" style="width:100px;"></input></td>
                    <td align="center">性别</td>
                    <td>
                        <select id="gender" name="gender" value="${model.gender}"> 
                            <option value="男">男</option>
                            <option value="女">女</option>
                        </select>
                    </td>
                    <td align="center">年龄</td>
                    <td><input type="text" id="age" name="age" value="${model.age}" style="width:50px;"></input></td>
                </tr>
                <tr>
                    <td align="center">身份证号码</td>
                    <td><input type="text" id="idcard" name="idcard" value="${model.idcard}" style="width:200px;"></input></td>
                    <td align="center">婚姻状况</td>
                    <td colspan="3">
                        <label><input type="radio" name="marriage" value="未婚"/>未婚</label>
                        <label><input type="radio" name="marriage" value="已婚"/>已婚</label>
                        <label><input type="radio" name="marriage" value="离异"/>离异</label>
                    </td>
                </tr>
                <tr>
                    <td align="center">户口所在地</td>
                    <td><textarea type="text" id="censusadrress" name="censusadrress" rows="2" style="width:98%;">${model.censusadrress}</textarea></td>
                    <td align="center">联系电话</td>
                    <td colspan="3"><input type="text" id="telephone" name="telephone" value="${model.telephone}" style="width:200px;"></input></td>
                </tr>
                <tr>
                    <td align="center">现住址</td>
                    <td><textarea type="text" id="adrress" name="adrress" rows="2" style="width:98%;">${model.adrress}</textarea></td>
                    <td align="center">工作单位</td>
                    <td colspan="3"><textarea type="text" id="company" name="company" rows="2" style="width:98%;">${model.company}</textarea></td>
                </tr>
                <tr>
                    <td align="center">职位</td>
                    <td><input type="text" id="post" name="post" value="${model.post}" style="width:100px;"></input></td>
                    <td align="center">工作单位电话</td>
                    <td colspan="3"><input type="text" id="companyphone" name="companyphone" value="${model.companyphone}" style="width:200px;"></input></td>
                </tr>
                <tr>
                    <td align="center">第二联系人姓名</td>
                    <td><input type="text" id="sencodcontact" name="sencodcontact" value="${model.sencodcontact}" style="width:100px;"></input></td>
                    <td align="center">第二联系人电话</td>
                    <td colspan="3"><input type="text" id="sencodphone" name="sencodphone" value="${model.sencodphone}" style="width:200px;"></input></td>
                </tr>
                <tr>
                    <td align="center">申请借款金额</td>
                    <td><input type="text" id="loanamount" name="loanamount" value="${model.loanamount}" style="width:100px;"></input><label>万元</label></td>
                    <td align="center">借款用途</td>
                    <td colspan="3"><textarea type="text" id="loanusage" name="loanusage" rows="2" style="width:98%;">${model.loanusage}</textarea></td>
                </tr>
                <tr>
                    <td align="center">借款时长</td>
                    <td ><label style="width:10px;">共</label><input type="text" id="loanlimit" name="loanlimit" value="${model.loanlimit}" style="width:50px;"></input><label style="width:100px;">月</label>
                    </td>
                    <td align="center">借款期限</td>
                    <td colspan="3">
                        <input type="text" id="loanlimitbegin" name="loanlimitbegin" value="${model.loanlimitbegin}" class="date" readonly="true" style="width:100px;"></input><label style="width:20px;">至</label>
                        <input type="text" id="loanlimitend" name="loanlimitend" value="${model.loanlimitend}" class="date" readonly="true" style="width:100px;"></input>
                    </td>
                </tr>
                <tr>
                    <td align="center">房产地址</td>
                    <td colspan="5"><textarea type="text" id="houseadress" name="houseadress" class="" rows="2" style="width:98%;">${model.houseadress}</textarea></td>
                </tr>
                <tr>
                    <td align="center">房产购置时间</td>
                    <td><input type="text" id="housebuytime" name="housebuytime" value="${model.housebuytime}" class="date " readonly="true" style="width:100px;"></input></td>
                    <td align="center">房产价格</td>
                    <td colspan="3"><input type="text" id="houseprice" name="houseprice" class="bumber " value="${model.houseprice}" style="width:50px;"></input><label>万元</label></td>
                </tr>
                <tr>
                    <td align="center">评估价格</td>
                    <td><input type="text" id="evaluateprice" name="evaluateprice" value="${model.evaluateprice}" style="width:50px;"></input><label>万元</label></td>
                    <td align="center">评估人</td>
                    <td align="center" colspan="3"><input type="text" id="evaluator" name="evaluator" value="${model.evaluator}" style="width:100px;"></input></td>
               </tr>
                <tr>
                    <td align="center">评估时间</td>
                    <td><input type="text" id="evaluatetime" name="evaluatetime" value="${model.evaluatetime}" class="date" readonly="true" style="width:100px;"></input></td>
                    <td align="center">贷款月利率</td>
                    <td  colspan="3"><input type="text" id="payrate" name="payrate" value="${model.payrate}" style="width:50px;"></input><label>%</label></td>
                </tr>
                <tr>
                    <td align="center">审批意见</td>
                    <td colspan="5"><textarea type="text" id="commentText" name="commentText" rows="4" style="width:98%;"></textarea></td>
                </tr>
                <tr><td colspan="6"><div class="unit" id="commentList" name="commentList"></div></td></tr>
            </table>
        </div>
        <div class="formBar">
            <ul>
                <li id="submit"><div class="buttonActive"><div class="buttonContent"><button type="submit">通过</button></div></div></li>
                <li id="withdraw"><div class="buttonActive"><div class="buttonContent"><button type="button" onclick="withdraw();">退回</button></div></div></li>
                <li id="abort"><div class="buttonActive"><div class="buttonContent"><button type="button" onclick="abort();">否绝</button></div></div></li>
                <li id="close"><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
            </ul>
        </div>
    </form>
</div>

<script type="text/javascript">
    // 初始化下拉菜单、单选按钮
    $("#BK200202Form").find("#gender").val("${model.gender}");
    $("#BK200202Form").find("input:radio[value=${model.marriage}]").attr("checked",true);
    // 审批意见列表
    $("#BK200202Form").find("#commentList").ajaxUrl({
    	url:"BK6001/commentList.do",
    	data:{taskId:$("#BK200202Form").find("#taskId").val()}
    });
    // 表单项目编辑权限控制
    if("${nodeName}" != "客户经理填写贷款报告"){
    	$("#BK200202Form").find(".form").find("*").attr("disabled","disabled");
    	$("#BK200202Form").find("#commentText").removeAttr("disabled");
    }
    if("${nodeName}" == "放款员审核放款手续" || "${nodeName}" == "财务放款"){
        $("#BK200202Form").find("#withdraw").hide();
        $("#BK200202Form").find("#abort").hide();
    }
    // 退回
    function withdraw(){
    	$("#BK200202Form").attr("action", "BK2002/withdraw.do");
    	$("#BK200202Form").submit();
    }
    // 终止
    function abort(){
        $("#BK200202Form").attr("action", "BK2002/abort.do");
        $("#BK200202Form").submit();
    }
</script>