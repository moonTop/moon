<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>任务列表</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.1.0/jquery.mobile-1.1.0.min.css" />
<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.1.0/jquery.mobile-1.1.0.min.js"></script>
</head>
<body>
	<div data-role="page" class="type-home">
		<div data-role="header">
			<a href="${contextPath}/views/mobileManage/mobilelogout.do" data-icon="arrow-l" data-ajax='false' id="goBack">退出</a>
			<h1>任务列表</h1>
		</div>
		<div data-role="content">
			<div class="content-primary">
				<div data-role="navbar">
					<ul>
						<li><a href="#"
							onclick="$('.div02').css('display','none');$('.div01').css('display','block');"
							class="ui-btn-active">代办任务</a></li>
						<li><a href="#"
							onclick="$('.div02').css('display','block');$('.div01').css('display','none');">已办任务</a></li>
					</ul>
				</div>
				<!-- /navbar -->
			</div>
			<!--/content-primary -->
			<div class="ui-body ui-body-c div01">
				<h4>
					您好！欢迎使用审批系统！当前有<font style="color: red;">${count}&nbsp;</font>件任务,等待您的审批！
				</h4>
				<div data-role="content">
					<div class="content-primary">
						<ul data-role="listview">
							<c:forEach var="taskBean" items="${tasks}" varStatus="status">
								<li><a href="approval/${taskBean.taskId}.do"  data-ajax='false' >${taskBean.processName}[${taskBean.processInstanceId}]</a></li>
							</c:forEach>
						</ul>
					</div>
					<!--/content-primary -->
				</div>
			</div>
			<div class="ui-body ui-body-c div02" style="display: none;">
				<h4>
					
					您好！欢迎使用审批系统！当前已审批任务<font style="color: red;">${doneCount}&nbsp;</font>件！
				</h4>
				<div data-role="content">
					<div class="content-primary">
						<ul data-role="listview">
							<c:forEach var="taskBean" items="${doneList}" varStatus="status">
								<li><a href="viewdone/${taskBean.taskId}.do"  data-ajax='false' >${taskBean.processName}[${taskBean.processInstanceId}]</a></li>
							</c:forEach>
						</ul>
					</div>
					<!--/content-primary -->
				</div>
			</div>
			
		</div>
		<!-- /content -->
		<div data-role="footer" class="footer-docs" data-theme="c"></div>
	</div>
</body>
</html>