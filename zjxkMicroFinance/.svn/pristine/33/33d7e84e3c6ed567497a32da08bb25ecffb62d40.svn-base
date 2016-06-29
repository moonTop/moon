<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="pageContent">
    <form id="BK300201Form" method="post" action="BK3002/updateMpayrecord.do" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <input type="hidden" id="id" name="id" value="${model.id}" />
        <input type="hidden" id="navTabId" name="navTabId" value="" />
        <div class="pageFormContent" layoutH="56">
	        <div class="titleBar">
	            <div class="navTitle">还款管理/</div><div class="pageTitle">客户还款信息【查看】</div>
	        </div>
            
            <dl>
                <dt>贷款单号：</dt>
                <dd><input id="loanrecordid"  name="loanrecordid" type="text" size="30" class="required" readonly value="${model.mloanrecord.loanno}"   disabled='disabled' /></dd>
            </dl>
            <dl>
                <dt>客户姓名：</dt>
                <dd><input id="loanpersonname"  name="loanpersonname" type="text" size="30" class="required" readonly value="${model.mloanrecord.loanpersonname}"  disabled='disabled' /></dd>
            </dl>
            <dl>
                <dt>预计还款日期：</dt>
                <dd>
	                <input id="planpaydate"  name="planpaydate" type="text" size="30" value="<fmt:formatDate value='${model.planpaydate}' pattern='yyyy-MM-dd' />" class="date required" dateFmt="yyyy-MM-dd" readonly  disabled='disabled'/>
                </dd>
            </dl>
            <dl>
                <dt>预计还款利息：</dt>
                <dd>
	                <input id="planpayaccrual"  name="planpayaccrual" type="text" class="required" size="30" value="${model.planpayaccrual}" readonly  disabled='disabled'/>
                </dd>
            </dl>
             <dl>
                <dt>预计还款金额：</dt>
                <dd>
	                <input id="planpayamount"  name="planpayamount" type="text" class="required" size="30" value="${model.planpayamount}" readonly  disabled='disabled'/>
                </dd>
            </dl>
             <dl>
                <dt>实际还款日期：</dt>
                <dd>
	                <input id="paydate"  name="paydate" type="text" size="30" value="<fmt:formatDate value='${model.paydate}' pattern='yyyy-MM-dd' />" class="date required" dateFmt="yyyy-MM-dd" readonly   disabled='disabled'/>
                </dd>
            </dl>
            <dl>
                <dt>实际还款利息：</dt>
                <dd>
	                <input id="payaccrual"  name="payaccrual" type="text" class="required" size="30" value="${model.payaccrual}"  disabled='disabled' />
                </dd>
            </dl>
             <dl>
                <dt>实际还款金额：</dt>
                <dd>
	                <input id="payamount"  name="payamount" type="text" class="required" size="30" value="${model.payamount}"  disabled='disabled'/>
                </dd>
            </dl>
            <dl>
                <dt>还款人：</dt>
                <dd>
	                <input id="payperson"  name="payperson" type="text" size="30" value="${model.payperson}"  disabled='disabled' />
                </dd>
            </dl>
           
            <dl>
                <dt>还款状态：</dt>
                <dd>
                	<select id="paystatus"  name="paystatus" class="required" style="width: 185px;" value="${model.paystatus}" disabled='disabled'>
                		<option value="1">已还</option>
                		<option value="2">未还</option>
                	</select>
                </dd>
            </dl>
            <dl>
                <dt>说明：</dt>
                <dd>
                	<textarea rows="2" style="width:560px;" id="description"  name="description" disabled='disabled'>${model.description}</textarea>
                </dd>
            </dl>
            
        </div>
        <div class="formBar">
            <ul>
                <li>
                    <div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
                </li>
            </ul>
        </div>
    </form>
</div>
<script type="text/javascript">
	$(function(){
		$("#loanrecordid").val("${model.mloanrecord.loanno}");
		$("#description").val("${model.description}");
		$("#paystatus").val("${model.paystatus}");
		$("#status").val("${model.status}");
		$("#navTabId").val(navTab._getTabs().eq(navTab._currentIndex).attr("tabid"));
	})
</script>