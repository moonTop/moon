<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="pageContent">
    <form id="BK300101Form" method="post" action="BK3001/updateMloanrecord.do" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <input type="hidden" id="id" name="id" value="${model.id}" />
        <input type="hidden" id="navTabId" name="navTabId" value="" />
        <div class="pageFormContent" layoutH="56">
	        <div class="titleBar">
	            <div class="navTitle">贷款管理/</div><div class="pageTitle">客户贷款信息【修改】</div>
	        </div>
            
            <dl>
                <dt>贷款单号：</dt>
                <dd><input id="loanno"  name="loanno" type="text" size="30" class="required" readonly value="${model.loanno}"  /></dd>
            </dl>
            
            <dl>
                <dt>客户姓名：</dt>
                <dd>
	                <input id="loanpersonname"  name="loanpersonname" type="text" class="required" size="30" readonly value="${model.loanpersonname}" />
                </dd>
            </dl>
            
             <dl>
                <dt>贷款种类：</dt>
                <dd>
	                <input id="loantype"  name="loantype" type="text" class="required" size="30" value="${model.loantype}" readonly />
                </dd>
            </dl>
             <dl>
                <dt>责任人1：</dt>
                <dd>
	                <input id="liableperson1"  name="liableperson1" type="text" class="required" size="30" value="${model.liableperson1}"  />
                </dd>
            </dl>
             <dl>
                <dt>责任人2：</dt>
                <dd>
	                <input id="liableperson2"  name="liableperson2" type="text" class="required" size="30" value="${model.liableperson2}"  />
                </dd>
            </dl>
             <dl>
                <dt>贷款金额：</dt>
                <dd>
	                <input id="loanamount"  name="loanamount" type="text" class="required" size="30" value="${model.loanamount}" />
                </dd>
            </dl>
            <dl>
                <dt>贷款日期：</dt>
                <dd>
	                <input id="loandate"  name="loandate" type="text" size="30" value="<fmt:formatDate value='${model.loandate}' pattern='yyyy-MM-dd' />" class="date required" dateFmt="yyyy-MM-dd" readonly />
                </dd>
            </dl>
            <dl>
                <dt>还款方式：</dt>
                <dd>
	                <input id="paytype"  name="paytype" type="text" class="required" size="30" value="${model.paytype}" />
                </dd>
            </dl>
            <dl>
                <dt>还款日期：</dt>
                <dd>
	                <input id="paydate"  name="paydate" type="text" size="30" value="<fmt:formatDate value='${model.paydate}' pattern='yyyy-MM-dd' />" class="date required" dateFmt="yyyy-MM-dd" readonly  />
                </dd>
            </dl>
            <dl>
                <dt>贷款利率：</dt>
                <dd>
	                <input id="payrate"  name="payrate" type="text" class="required" size="30" value="${model.payrate}" readonly />
                </dd>
            </dl>
             <dl>
                <dt>本金偿还方式：</dt>
                <dd>
	                <input id="paymode"  name="paymode" type="text" class="required" size="30" value="${model.paymode}" />
                </dd>
            </dl>
            <dl>
                <dt>借款期限开始日：</dt>
                <dd>
	                <input id="loanlimitbegin"  name="loanlimitbegin" type="text" size="30" value="<fmt:formatDate value='${model.loanlimitbegin}' pattern='yyyy-MM-dd' />" class="date required" dateFmt="yyyy-MM-dd" readonly  />
                </dd>
            </dl>
            <dl>
                <dt>借款期限结束日：</dt>
                <dd>
	                <input id="loanlimitend"  name="loanlimitend" type="text" size="30" value="<fmt:formatDate value='${model.loanlimitend}' pattern='yyyy-MM-dd' />" class="date required" dateFmt="yyyy-MM-dd" readonly  />
                </dd>
            </dl>
            <dl>
                <dt>还款金额：</dt>
                <dd>
	                <input id="payamount"  name="payamount" type="text" class="required" size="30" value="${model.payamount}" />
                </dd>
            </dl>
            <dl>
                <dt>贷款周期（月）：</dt>
                <dd>
                	<select id="accrualperiodization"  name="accrualperiodization" class="required" style="width: 185px;" value="${model.accrualperiodization}">
                		<option value="1">一月</option>
                		<option value="2">二月</option>
                		<option value="3">三月</option>
                		<option value="4">四月</option>
                		<option value="5">五月</option>
                		<option value="6">六月</option>
                		<option value="7">七月</option>
                		<option value="8">八月</option>
                		<option value="9">九月</option>
                		<option value="10">十月</option>
                		<option value="11">十一月</option>
                		<option value="12">十二月</option>
                	</select>
                </dd>
            </dl>
            <dl>
                <dt>还款状态：</dt>
                <dd>
                	<select id="paystatus"  name="paystatus" class="required" style="width: 185px;" value="${model.paystatus}">
                		<option value="0">未还款</option>
                		<option value="1">还款中</option>
                		<option value="2">还款完了</option>
                	</select>
                </dd>
            </dl>
            <dl>
                <dt>说明：</dt>
                <dd>
                	<textarea rows="2" style="width:560px;" id="description"  name="description">${model.description}</textarea>
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
		$("#loanpersonname").val("${model.loanpersonname}");
		$("#description").val("${model.description}");
		$("#paystatus").val("${model.paystatus}");
		$("#accrualperiodization").val("${model.accrualperiodization}");
		$("#navTabId").val(navTab._getTabs().eq(navTab._currentIndex).attr("tabid"));
	})

</script>