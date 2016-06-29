<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>车易贷流程审批</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.1.0/jquery.mobile-1.1.0.min.css" />
<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.1.0/jquery.mobile-1.1.0.min.js"></script>
<style type="text/css">
.approvalForm {
	border: solid 1px silver;
}

.approvalForm tr td {
	height: 2.5em;
	border: 1px solid #aaa;
	color: #333;
	text-shadow: 0 1px 0 #fff;
	background: #f9f9f9;
	background-image: -webkit-gradient(linear, left top, left bottom, from(#f9f9f9),
		to(#eee) );
	background-image: -webkit-linear-gradient(#f9f9f9, #eee);
	background-image: -moz-linear-gradient(#f9f9f9, #eee);
	background-image: -ms-linear-gradient(#f9f9f9, #eee);
	background-image: -o-linear-gradient(#f9f9f9, #eee);
	background-image: linear-gradient(#f9f9f9, #eee)
}
</style>
</head>

<body>

	<form id="approveForm01" action="" method="post" >
		<div data-role="page" class="type-home">
			<div data-role="header">
				<a href="#" data-icon="arrow-l" id="goBack" data-ajax='false' >返回</a>
				<h1>车易贷流程审批</h1>
			</div>
			<div data-role="content">
				<div class="ui-body ui-body-c" style="text-align: center;">

				<input type="hidden" name="taskId" value="${taskId}"/>
				<input type="hidden" name="id" value="${model.id}"/>
					<table width="100%" border="1" class="approvalForm" cellspacing="0"
						cellpadding="0">
						<tr>
							<td align="center">借款人姓名</td>
							<td style="width: 70%">${model.loanpersonname}</td>
						</tr>
						<tr>
							<td align="center">性别</td>
							<td>${model.gender}</td>
						</tr>
						<tr>
							<td align="center">年龄</td>
							<td>${model.age}</td>
						</tr>
						<tr>
							<td align="center">身份证号码</td>
							<td>${model.idcard}</td>
						</tr>
						<tr>
							<td align="center">婚姻状况</td>
							<td>${model.marriage}</td>
						</tr>
						<tr>
							<td align="center">户口所在地</td>
							<td>${model.censusadrress}</td>
						</tr>
						<tr>
							<td align="center">联系电话</td>
							<td>${model.telephone}</td>
						</tr>
						<tr>
							<td align="center">现住址</td>
							<td>${model.adrress}</td>
						</tr>
						<tr>
							<td align="center">工作单位</td>
							<td>${model.company}</td>
						</tr>
						<tr>
							<td align="center">职位</td>
							<td>${model.post}</td>
						</tr>
						<tr>
							<td align="center">单位电话</td>
							<td>${model.companyphone}</td>
						</tr>
						<tr>
							<td align="center">第二联系人姓名</td>
							<td>${model.sencodcontact}</td>
						</tr>
						<tr>
							<td align="center">第二联系人电话</td>
							<td colspan="3">${model.sencodphone}</td>
						</tr>
						<tr>
							<td align="center">借款金额（万元）</td>
							<td>${model.loanamount}</td>
						</tr>
						<tr>
							<td align="center">月利率</td>
							<td>${model.loanamount}</td>
						</tr>
						<tr>
							<td align="center">借款用途</td>
							<td>${model.loanusage}</td>
						</tr>
						<tr>
							<td align="center">借款期限</td>
							<td>${model.loanlimitbegin}&nbsp;至&nbsp;${model.loanlimitend}
							</td>
						</tr>
						<tr>
							<td align="center">借款时长（月）</td>
							<td>${model.loanlimit}</td>
						</tr>
						<tr>
							<td align="center">车贷类型</td>
							<td>${model.carloantype}</td>
						</tr>
						<tr>
							<td align="center">车辆品牌型号</td>
							<td>${model.carbrandstyle}</td>
						</tr>
						<tr>
							<td align="center">车辆牌号</td>
							<td>${model.cartrademark}</input></td>
						</tr>
						<tr>
							<td align="center">车辆登记城市</td>
							<td>${model.carregcity}</td>
						</tr>
						<tr>
							<td align="center">车辆发动机号</td>
							<td>${model.carengineno}</td>
						</tr>
						<tr>
							<td align="center">识别代码(车架号)</td>
							<td>${model.carframeno}</td>
						</tr>
						<tr>
							<td align="center">车辆购置时间</td>
							<td>${model.carbuytime}</td>
						</tr>
						<tr>
							<td align="center">购车价格（万元）</td>
							<td>${model.carprice}</td>
						</tr>
						<tr>
							<td align="center">评估价格（万元）</td>
							<td>${model.evaluateprice}</td>
						</tr>
						<tr>
							<td align="center">评估人</td>
							<td align="center">${model.evaluator}</td>
						</tr>
						<tr>
							<td align="center">评估时间</td>
							<td>${model.evaluatetime}</td>
						</tr>
					</table>
				
				</div>
				<div class="ui-bar ui-bar-a">
					<div data-role="controlgroup" data-type="horizontal"
						style="text-align: center;" >
							<a href="#" data-role="button" data-inline="true"  data-theme="b" id="back">返回</a> 					
					</div>
				</div>
				<div >
					<table width="100%" border="1" class="approvalForm" cellspacing="0"
						cellpadding="0">
						<tr>
							<td align="center" style="background-color: blue;">审批者</td>
							<td style="width: 70%; background-color: blue;" align="center">
								审批意见</td>
						</tr>
						<c:forEach var="bean" items="${commentList}" varStatus="status">
							<tr>
								<td align="center">${bean.username}</td>
								<td>${bean.comment}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
			<div data-role="footer" class="footer-docs" data-theme="c"></div>
		</div>
		</form>	
</body>
</html>
<script type="text/javascript">
$("div[data-role='page']").live('pageshow',function(event,ui){
	//表单提交  
    $("#back").bind("click", function() {
    	 $.mobile.changePage("${contextPath}/views/mobileManage/todoList.do?","slideleft", false, false);  
    }); 
	//表单提交  
    $("#goBack").bind("click", function() {
    	 $.mobile.changePage("${contextPath}/views/mobileManage/todoList.do?","slideleft", false, false);  
    }); 
});
</script>

