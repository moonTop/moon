<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<div class="pageContent">
    <form method="post" action="changeps.do"class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone)">
        <div class="pageFormContent" layoutH="56">
	        <div class="titleBar">
	            <div class="navTitle">用户密码修改</div>
	        </div>
	        <dl>
	            <dt>旧密码：</dt>
	            <dd><input id="oldpw" name="oldpw" type="password" class="required" /></dd>
	        </dl>
	        <dl>
	            <dt>新密码：</dt>
	            <dd><input id="newpw" name="newpw" type="password" class="required" /></dd>
	        </dl>
	        <dl>
	            <dt>密码确认：</dt>
	            <dd><input id="confirmpw" name="confirmpw" type="password" class="required" equalto="#newpw"/></dd>
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