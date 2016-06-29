<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<div class="pageContent">
    <form id="BK400301Form" method="post" action="BK4003/save.do" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <input type="hidden" id="id" name="id" value="${model.id}" />
        <input type="hidden" id="navTabId" name="navTabId" value="" />
        <div class="pageFormContent" layoutH="56">
	        <div class="titleBar">
	            <div class="navTitle">用户角色管理/</div><div class="pageTitle">用户角色添加【修改】</div>
	        </div>
            
            <dl>
                <dt>角&nbsp;色&nbsp;I&nbsp;D&nbsp;：</dt>
                <dd>
	                <input id="roleid"  name="roleid" type="text" class="required" size="30" value="${model.roleid}" remote="BK4003/checkroleid.do" />
                </dd>
            </dl>
            <dl>
                <dt>角色名称：</dt>
                <dd><input id="rolename"  name="rolename" type="text" size="30" class="required" value="${model.rolename}"  /></dd>
            </dl>
            
            <dl>
                <dt>状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态：</dt>
                <dd>
		            <select class="combox required" id="status" name="status" > 
		            	<option value="1">可用</option>
		            	<option value="2">不可用</option>
	                    <option value="3">暂停使用</option>
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
		$("#status").val("${model.status}");
	})

	$.extend($.validator.messages, {
		remote: "角色ID不能重复"
	});

    if (!!"${model.id}") {
    	$("#BK400301Form").attr("action","BK4003/updaterole.do");
     	$("input[name='roleid']").attr("readonly", true).removeAttr("remote");
    }
    $("#navTabId").val(navTab._getTabs().eq(navTab._currentIndex).attr("tabid"));
    
</script>