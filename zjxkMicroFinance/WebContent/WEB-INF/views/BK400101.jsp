<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<div class="pageContent">
    <form id="BK400101Form" method="post" action="BK4001/conserveUser.do" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <input type="hidden" id="id" name="id" value="${model.id}" />
        <input type="hidden" id="navTabId" name="navTabId" value="" />
        <div class="pageFormContent" layoutH="56">
	        <div class="titleBar">
	            <div class="navTitle">用户管理/</div><div class="pageTitle">用户添加【修改】</div>
	        </div>
            <dl>
                <dt>用&nbsp;户&nbsp;I&nbsp;D&nbsp;：</dt>
                <dd><input name="userid" type="text" value="${model.userid}" size="30" class="required" remote="BK4001/checkuserid.do" /></dd>
            </dl>
            <dl>
                <dt>部门编号：</dt>
                <dd>
	                <input id="org.id" name="orgid" type="hidden" value="${model.morg.id}"/>
	                <input id="org.orgno"  name="orgorgno" type="text" class="required" size="25" value="${model.morg.orgno}" readonly />
	                <a class="btnLook" href="Lookup/org.do" rel="lookup" lookupGroup="org" width="500" height="350">查找带回</a>
                </dd>
            </dl>
            <dl>
                <dt>部门名称：</dt>
                <dd><input id="org.orgname"  name="orgorgname" type="text" size="30" class="required" value="${model.morg.orgname}" readonly /></dd>
            </dl>
            <dl>
                <dt>用户名称：</dt>
                <dd><input id="username"  name="username" type="text" size="30" class="required" value="${model.username}" /></dd>
            </dl>
            
            <dl>
                <dt>联系电话：</dt>
                <dd><input name="mobile" type="text" size="30" value="${model.mobile}" class="required"/></dd>
            </dl>
            <dl>
                <dt>职位描述：</dt>
                <dd><textarea id="detail" name="detail" cols="27" value="${model.detail}"></textarea></dd>
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
		$("#detail").val("${model.detail}");
	})
	
	$.extend($.validator.messages, {
		remote: "用户ID不能重复"
	});
    if (!!"${model.id}") {
    	$("#BK400101Form").attr("action","BK4001/reviseUser.do");
    	$("input[name='userid']").attr("readonly", true).removeAttr("remote");
    	
    }
    $("#navTabId").val(navTab._getTabs().eq(navTab._currentIndex).attr("tabid"));
    
    
</script>