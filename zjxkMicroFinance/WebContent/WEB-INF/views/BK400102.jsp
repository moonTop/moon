<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<div class="pageContent">
    <form id="BK400101Form" method="post" action="BK4001/roleSave.do" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <input type="hidden" id="id" name="id" value="${model.id}" />
        <input type="hidden" id="navTabId" name="navTabId" value="" />
        <div class="pageFormContent" layoutH="56">
	        <div class="titleBar">
	            <div class="navTitle">用户管理/</div><div class="pageTitle">用户添加【修改】</div>
	        </div>
            <dl>
                <dt>用&nbsp;户&nbsp;I&nbsp;D&nbsp;：</dt>
                <dd><input name="userid" type="text" value="${model.userid}" size="30" class="required" readonly/></dd>
            </dl>
            <dl>
                <dt>角&nbsp;色&nbsp;I&nbsp;D&nbsp;：</dt>
                <dd>
	                <input id="role.roleid" name="roleid" type="hidden" value="${model.roleid}"/>
	                <input id="role.roleid"  name="roleroleid" type="text" class="required" size="25" value="${model.roleid}" readonly />
	                <a class="btnLook" href="Lookup/roles.do" rel="lookup" lookupGroup=role width="500" height="350">查找带回</a>
                </dd>
            </dl>
            <dl>
                <dt>角色名称：</dt>
                <dd><input id="role.rolename"  name="rolerolename" type="text" size="30" class="required" value="${model.rolename}" readonly /></dd>
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
//     if (!!"${model.id}") {
//     	$("#BK400101Form").attr("action","BK4001/update.do");
//      	$("input[name='userid']").attr("readonly", true).removeAttr("remote");
    	
//     }
    $("#navTabId").val(navTab._getTabs().eq(navTab._currentIndex).attr("tabid"));
</script>