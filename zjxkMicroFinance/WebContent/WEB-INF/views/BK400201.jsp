<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<div class="pageContent">
    <form id="BK400101Form" method="post" action="BK4002/save.do" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <input type="hidden" id="id" name="id" value="${model.id}" />
        <input type="hidden" id="navTabId" name="navTabId" value="" />
        <div class="pageFormContent" layoutH="56">
	        <div class="titleBar">
	            <div class="navTitle">用户管理/</div><div class="pageTitle">用户添加【修改】</div>
	        </div>
            
            <dl>
                <dt>部门编号：</dt>
                <dd>
	                <input id="orgno"  name="orgno" type="text" class="required" size="30" value="${model.orgno}" remote="BK4002/checkorgno.do" />
                </dd>
            </dl>
            <dl>
                <dt>部门名称：</dt>
                <dd><input id="orgname"  name="orgname" type="text" size="30" class="required" value="${model.orgname}"  /></dd>
            </dl>
            
            <dl>
                <dt>状态：</dt>
                <dd>
		            <select class="combox required" id="status" name="status"> 
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
		remote: "部门编号不能重复"
	});

    if (!!"${model.id}") {
    	$("#BK400101Form").attr("action","BK4002/update.do");
    	$("input[name='orgno']").attr("readonly", true).removeAttr("remote");
    }
    $("#navTabId").val(navTab._getTabs().eq(navTab._currentIndex).attr("tabid"));
    
</script>