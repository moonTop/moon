<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="pageContent">
    <form id="BK100401Form" method="post" action="BK1004/save.do" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <input type="hidden" id="id" name="id" value="${model.id}" />
        <input type="hidden" id="navTabId" name="navTabId" value="" />
        <div class="pageFormContent" layoutH="56">
	        <div class="titleBar">
	            <div class="navTitle">企业贷客户管理/</div><div class="pageTitle">用户【修改】</div>
	        </div>
            <dl>
                <dt>申请人姓名：</dt>
                <dd><input name="name" type="text" value="${model.name}" size="30" class="required" readonly /></dd>
            </dl>
            <dl>
                <dt>申请人性别：</dt>
                <dd>
	                <select class="required" notBlank name="sex" id="sex" value="${model.sex}" style="width: 190px;">
                            <option value="男">男</option>
                            <option value="女">女</option>
                       </select>
                </dd>
            </dl>
            <dl>
                <dt>手机号码：</dt>
                <dd><input id="phone"  name="phone" type="text" size="30" class="required" value="${model.phone}"  /></dd>
            </dl>
            <dl>
                <dt>电子邮箱：</dt>
                <dd><input id="email"  name="email" type="text" size="30" class="required" value="${model.email}" /></dd>
            </dl>
            
            <dl>
                <dt>贷款金额：</dt>
                <dd><input name="loanamount" type="loanamount" size="30" value="${model.loanamount}" class="required"/></dd>
            </dl>
            <dl>
                <dt>车辆购置时间：</dt>
                <dd><input id="carbuydate" name="carbuydate" size="30" value="${model.carbuydate}" class="required"></input></dd>
            </dl>
            <dl>
                <dt>车辆登记城市：</dt>
                <dd><input id="carcity" name="carcity" size="30" value="${model.carcity}" class="required"></input></dd>
            </dl>
            <dl>
                <dt>车辆购置价格：</dt>
                <dd><input id="carprice" name="carprice" size="30" value="${model.carprice}" class="required"></input></dd>
            </dl>
            <dl>
                <dt>申请日期：</dt>
                <dd><input id="applydate" name="applydate" size="30" value="<fmt:formatDate value='${model.applydate}' pattern='yyyy-MM-dd' />" class="date required" dateFmt="yyyy-MM-dd" readonly></input></dd>
            </dl>
           
            <dl>
                <dt>状态：</dt>
                <dd>
					<select class="required" notBlank name="status" id="status" value="${model.status}" style="width: 190px;">
                            <option value="0">未处理</option>
                            <option value="1">已处理</option>
                    </select>
				</dd>
            </dl>
            <dl>
                <dt>备注：</dt>
                <dd><textarea id="description" name="description" cols="27" value="${model.description}"></textarea></dd>
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
		$("#description").val("${model.description}");
		$("#status").val("${model.status}");
		$("#sex").val("${model.sex}");
	    $("#navTabId").val(navTab._getTabs().eq(navTab._currentIndex).attr("tabid"));
	
	})
	
    if (!!"${model.id}") {
    	$("#BK100401Form").attr("action","BK1004/update.do");
    	$("input[name='userid']").attr("readonly", true).removeAttr("remote");
    	
    }
    
    
    
</script>