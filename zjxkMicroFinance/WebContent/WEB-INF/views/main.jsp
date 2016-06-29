﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=8" />
<link rel="stylesheet" type="text/css" rel="stylesheet" href="<c:url value='/themes/default/style.css'/>" media="screen">
<link rel="stylesheet" type="text/css"  rel="stylesheet" href="<c:url value='/themes/css/core.css'/>"  media="screen">

<!--[if IE]>
<link rel="stylesheet" type="text/css"  rel="stylesheet" href="<c:url value='/themes/css/ieHack.css'/>"  media="screen">
<![endif]-->

<script type="text/javascript" src="<c:url value='/js/jquery-1.8.2.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery.cookie.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery.validate.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery.bgiframe.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/raphael/raphael-min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/raphael/graffle.js'/>"></script>

<script type="text/javascript" src="<c:url value='/js/dwz.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/dwz.regional.zh.js'/>"></script>

<!--[if lte IE 9]>
<script type="text/javascript" src="<c:url value='/js/speedup.js'/>"></script>
<![endif]-->
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<title>天津中金新科小额贷款管理系统</title>

<style type="text/css">
	#header{height:85px}
	#leftside, #container, #splitBar, #splitBarProxy{top:90px}
</style>

<script type="text/javascript">
	$(function(){
	 	DWZ.init("${contextPath}/js/yz.frag.xml", {
	 		statusCode:{ok:200, error:300, timeout:301}, //【可选】
			pageInfo:{pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
			debug:false,	// 调试模式 【true|false】
			loginUrl:"../logon.do",
			callback:function(){
				initEnv();
				$("#themeList").theme({themeBase:"themes"});
			}
		});
	});
	function logout(){
		if(confirm("退出系统？")){
			window.location="logout.do";
		}
	}

	function addfavorite() {
		if (document.all) {
			window.external.addFavorite('http://www.zjxkxd.cn/logon.jsp', '天津中金新科小额贷款管理系统');
		} else if (window.sidebar) {
			try {
				window.sidebar.addPanel('天津中金新科小额贷款管理系统', 'http://www.zjxkxd.cn/logon.jsp', "");
			} catch(e){
				if ($.browser.mozilla){
					return;
				}
				alert("加入收藏失败，请使用Ctrl+D进行添加");
			}
		}
	}
	  
</script>
</head>

<body scroll="no">
	<div id="layout">
		<div id="header"  >
			<div class="headerNav">
				<a class="logo">标志</a>
				<ul class="nav" >
					<li><a href="changepsinit.do" target="dialog" width="480" rel="changeps">修改密码</a></li>
					<li><a href="#" onclick="addfavorite();" rel="sidebar">收藏</a></li>
					<li><a href="#" onclick="logout();">退出</a></li>
				</ul>
				<ul class="themeList" id="themeList">
				</ul>
			</div>
		
			<div id="navMenu">
				<ul><li><span>用户：<c:out value="${sessionScope.CURRENT_USERNAME}" /></span><c:if test="${!empty sessionScope.orgname}"><li><span>部门：<c:out value="${sessionScope.orgname}" /></span></li></c:if><li><span>角色：<c:out value="${sessionScope.roleName}" /></span></li></ul>
			</div>
		</div>

		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div></div></div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse"><h2>主菜单</h2><div>收缩</div></div>
				<div class="accordion" fillSpace="sidebar">
					<c:forEach var="firstmenu" items="${menuList}">
						<div class="accordionHeader">
							<h2><span>Folder</span><c:out value="${firstmenu.modname}" /></h2>
						</div>
		                <div class="accordionContent">
							<ul class="tree treeFolder">
								<c:forEach var="secondmenu" items="${firstmenu.children}">
									<li><a href="${secondmenu.linkurl}"  target="navTab" rel="${secondmenu.id}"> <c:out value="${secondmenu.modname}" /></a></li>
								</c:forEach>
							</ul>
						</div>
	                 </c:forEach>
                 </div>
			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:;"><span><span class="home_icon">主页</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:;">主页</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div class="page unitBox">

					</div>
				</div>
			</div>
		</div>
	</div>

	<div id="footer">Copyright &copy; 2013 <a>天津中金新科小额贷款有限公司</a></div>
</body>
</html>