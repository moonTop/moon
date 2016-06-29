<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<title>管理平台</title>
	<meta name="keywords" content="">
	<meta name="description" content="">
	<link rel="stylesheet" href="<c:url value='/css/styleFront.css'/>" type="text/css">
	<script type="text/javascript" src="<c:url value='/js/jquery-1.8.2.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/sharejs.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/nav.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/slides.min.jquery.js'/>"></script>
	<script type="text/javascript" src="${contextPath}/js/menu.js"></script>
	<script>
		$(function() {
			$('#slides').slides({
				preload : true,
				preloadImage : '../../imageFront/loading.gif',
				play : 5000,
				pause : 2500,
				hoverPause : true
			});
		});
	</script>
</head>
<body>
<!-- 	<script type="text/javascript" src="../../js/nav.js"></script> -->
	<div class="header auto mt20">
		<div class="logo clearfix" style="position:relative;">
			<a href="#" class="l logo_img"><img src="${contextPath}/imgs/imageFront/logo01.jpg" width="207px" height="49px" title=""></a>
			<img src="${contextPath}/imgs/imageFront/telephone.jpg" alt="" style="position:absolute;right:5px;"/>
			<div><img src="${contextPath}/imgs/imageFront/line.gif" alt="" style="margin-top: 10px"></img></div>
		</div>
		<div class="menu_box center" style="margin-top: 20px;">
			<div id="menu" class="menu">
            <ul>
                <li><a href="mainPage.jsp" title="首页">
                	<span class="out" style="top: 0px;">首页</span>
                </a></li>
                <li>
                	<a href="companyCredit.jsp" title="企业贷">
					<span class="out">企业贷</span>
					</a>
                </li>
                <li> 
                	<a href="houseCredit.jsp" title="楼易贷">
                	<span class="out">楼易贷</span>
                	</a> 
                </li>
                <li> 
                	<a href="carloan.jsp" title="车易贷">
                	<span class="out">车易贷</span>
                	</a> 
                </li>
                <li> 
                	<a href="about.jsp" title="关于我们">
                	<span class="out">关于我们</span>
                	</a>
				</li>
                <li> 
                	<a href="contact.jsp" title="联系我们">
                	<span class="out">联系我们</span>
                	</a> 
                </li>
            </ul>
        </div>
		
	</div>
	</div>
	<div class="clearfix main2">
		<div class="main-content clearfix">
			<div class="jianqing">
				<div class="big-bar">
					<div id="imgPlay">
						<ul class="imgs" id="actor" style="width: 7700px;">
							<li>
							    <img src="${contextPath}/imgs/imageFront/113.jpg"	width="1100" height="422">
							</li>
							<li>
							    <img src="${contextPath}/imgs/imageFront/010.jpg" 	width="1100" height="422">
							</li>
							<li>
							    <img src="${contextPath}/imgs/imageFront/011.jpg"	width="1100" height="422">
							</li>
						</ul>
						<div class="num" id="numInner" style="width: 126px; left: 487px;">
							<span class="on"></span><span></span><span></span><span></span><span></span><span></span><span></span>
						</div>
					</div>
				</div>

			</div>
			<div class="clearfix">
                <div class="con1">
                    <div class="div01"><img src="${contextPath}/imgs/imageFront/business.jpg" alt="" /></div>
                    <div class="div02"><p>解一时之需，赢无限商机，[企业贷]为各类中小企业量身定制最快捷的贷款服务，无需任何抵押担保，快捷审核放款，祝您的企业抢占市场先机。只要您是企业法人，现金即时到手。<p></div>
                </div>  			
				<div class="con1">
				    <div class="div01"><a alt="" href="houseCredit.jsp" style="text-decoration: none;">
				        <img src="${contextPath}/imgs/imageFront/house.jpg" alt="" />
				    </a></div>
				    <div class="div02"><p>[楼易贷]为身为业主的您，提供灵活方便的贷款服务，手续简单，贷款额高，只要您拥有房产，无论按揭与否，现金即时到手。<p></div>
				</div>
			
				<div class="con2">
	                   <div class="div01"><a href="carloan.jsp"><img src="${contextPath}/imgs/imageFront/car.jpg" alt="" style="cursor:pointer;"/></a></div>
	                   <div class="div02"><p>[购车贷]为有资金需求的借款人提供相关信用咨询、车辆评估、抵押借款方案、协议管理、回款管理等多方面的服务，借款人以自有车辆为抵押物通过宜车贷服务从出借人处获得出借资金。<p></div>
				</div>
			</div>
		</div>
	</div>
	<div class="footer footer2" style="text-align:center;">
		<div class="footer_inner auto">
				<p class="pt15">
					<a href="#" target="_blank" title="" class="pr10">官方微博</a>|
					<a href="contact.jsp" target="_blank" title="联系我们" class="pl10 pr10">联系我们</a>|
					<a href="about.jsp" target="_blank" title="关于我们" class="pr10 pl10">关于我们</a>|
					<span class="pl10">全国免费咨询电话：022-2370-8858</span>
				</p>
		</div>
	</div>
	</div>

</body>

</html>
<script type="text/javascript">
</script>