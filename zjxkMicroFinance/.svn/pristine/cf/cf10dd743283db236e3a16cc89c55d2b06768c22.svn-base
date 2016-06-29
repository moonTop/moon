<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<div class="pageContent">
    <form id="BK500101Form" method="post" action="BK5001/save.do" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <input type="hidden" id="id" name="id" value="${model.id}" />
        <input type="hidden" id="navTabId" name="navTabId" value="" />
        <div class="pageFormContent" layoutH="56">
	        <div class="titleBar">
	            <div class="navTitle">客户管理/</div><div class="pageTitle">客户管理添加【修改】</div>
	        </div>
            <c:if test="${empty model.orgcode}">
            <dl>
                <dt>身份证号码：</dt>
                <dd><input id="idcard"  name="idcard" type="text" size="30" class="required" readonly value="${model.idcard}" /></dd>
            </dl>
            </c:if>
            <c:if test="${!empty model.orgcode}">
            <dl>
                <dt>企业组织机构代码：</dt>
                <dd>
	                <input id="orgcode"  name="orgcode" type="text" class="required" size="30" readonly value="${model.orgcode}" />
                </dd>
            </dl>
            </c:if>
            <dl>
                <dt>名称：</dt>
                <dd>
	                <input id="name"  name="name" type="text" class="required" size="30" readonly value="${model.name}" />
                </dd>
            </dl>
            <dl>
                <dt>性别：</dt>
                <dd>
	                <input id="gender"  name="gender" type="text" class="required" size="30" value="${model.gender}"  />
                </dd>
            </dl>
            <dl>
                <dt>年龄：</dt>
                <dd>
	                <input id="age"  name="age" type="text" class="required" size="30" value="${model.age}"  />
                </dd>
            </dl>
            <dl>
                <dt>婚姻状况：</dt>
                <dd>
	                <input id="marriage"  name="marriage" type="text" class="required" size="30" value="${model.marriage}"  />
                </dd>
            </dl>
            <dl>
                <dt>联系电话：</dt>
                <dd>
                    <input id="telephone"  name="telephone" type="text" class="required" size="30" value="${model.telephone}" />
                </dd>
            </dl>
            <dl class="nowrap">
                <dt>户口所在地：</dt>
                <dd>
	                <textarea id="censusadrress"  name="censusadrress" type="text" class="required" rows="2" style="width:560px;">${model.censusadrress}</textarea>
                </dd>
            </dl>
            <dl class="nowrap">
                <dt>现住址：</dt>
                <dd>
	                <textarea id="adrress"  name="adrress" type="text" class="required" rows="2" style="width:560px;">${model.adrress}</textarea>
                </dd>
            </dl>
            <dl class="nowrap">
                <dt>工作单位：</dt>
                <dd>
	                <textarea id="company"  name="company" type="text" class="required" rows="2" style="width:560px;">${model.company}</textarea>
                </dd>
            </dl>
            <dl>
                <dt>职位：</dt>
                <dd>
	                <input id="post"  name="post" type="text" class="required" size="30" value="${model.post}" />
                </dd>
            </dl>
            <dl>
                <dt>工作单位电话：</dt>
                <dd>
	                <input id="companyphone"  name="companyphone" type="text" class="required" size="30" value="${model.companyphone}" />
                </dd>
            </dl>
            <dl>
                <dt>第二联系人姓名：</dt>
                <dd>
	                <input id="sencodcontact"  name="sencodcontact" type="text" class="required" size="30" value="${model.sencodcontact}" />
                </dd>
            </dl>
            <dl>
                <dt>第二联系人电话：</dt>
                <dd>
	                <input id="sencodphone"  name="sencodphone" type="text" class="required" size="30" value="${model.sencodphone}" />
                </dd>
            </dl>
            <dl>
                <dt>客户状态：</dt>
                <dd>
                	<select class="combox required" id="customerstatus" name="customerstatus" value="${model.customerstatus}"> 
		            	<option value="正常">正常</option>
		            	<option value="黑名单客户">黑名单客户</option>
		            </select>
                </dd>
            </dl>
        </div>
        <div class="formBar">
            <ul>
                <li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
                <li>
                    <div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
                </li>
            </ul>
        </div>
    </form>
</div>
<script type="text/javascript">
	$(function(){
		$("#customerstatus").val("${model.customerstatus}");
		$("#navTabId").val(navTab._getTabs().eq(navTab._currentIndex).attr("tabid"));
	})

    if (!!"${model.id}") {
    	$("#BK500101Form").attr("action","BK5001/updateCustomer.do");
    }
</script>