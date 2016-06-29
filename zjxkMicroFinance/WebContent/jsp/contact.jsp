<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<title>联系我们</title>
	<meta name="keywords" content="">
	<meta name="description" content="">
	<link rel="stylesheet" href="<c:url value='/css/styleFront.css'/>" type="text/css">
	<script type="text/javascript" src="<c:url value='/js/jquery-1.8.2.min.js'/>"></script>
	<script type="text/javascript" src="${contextPath}/js/menu.js"></script>
	
	<script src="http://maps.google.com/maps?file=api&amp;v=2&amp;sensor=true;    
          key=ABQIAAAAevysxt9O5lBUCrSalm80MxQx8gmx0K-_Fjj4Tf8bNXH3BBSxZRRmI_CuZM2zQyuXEpG_uxt-aqPr-A"    
          type="text/javascript"></script>    
    <script language="javascript" type="text/javascript">    
      function load() {     //加载地图    
          if (GBrowserIsCompatible()) {     
              var map = new GMap2(document.getElementById("map"));     
              map.addControl(new GSmallMapControl());    //放大缩小    
              map.addControl(new GMapTypeControl());     //地图种类    
              map.enableScrollWheelZoom();    //启用鼠标滚轮    
              map.setCenter(new GLatLng(39.098652,117.118591), 6);   //地图坐标 三个参数分别为 "纬度" "经度" "比例尺"    
             
              function createMarker(point, address,name,tel) {  //创建标记内容及标记的鼠标事件    
                 var marker = new GMarker(point);    
                 var html = '<div>'+    
                     '<a >公司名称:'+ name +'</a><br/>'+    
                     '<a >公司地址:'+address +'</a><br/>'+    
                     '<a >电话:'+tel +'</a>'+    
                     '</div>';    
                 GEvent.addListener(marker, "mouseover", function() {    
                     marker.openInfoWindowHtml(html);    
                 });    
                 GEvent.addListener(marker, "mouseout", function() {    
                     marker.closeInfoWindow();    
                 });    
                 GEvent.addListener(marker, "click", function() {    
                     map.setCenter(point, 12);     
                 });    
                 return marker;    
             }    
             var point = new GLatLng(39.098652,117.118591);     // 设置标记    
             map.addOverlay(createMarker(point,'天津南开华苑高新产业园区海益国际4楼8层','天津中金新科小额贷款有限公司','086-022-23708858'));//加入标记    
         }      
     }        
  </script>    
	
</head>
<body onload="load()">
	<div class="header auto mt20">
		<div class="logo clearfix" style="position: relative;">
			<a href="#" class="l logo_img"> 
				<img src="${contextPath}/imgs/imageFront/logo01.jpg" width="207px" height="49px" title="">
			</a> 
				<img src="${contextPath}/imgs/imageFront/telephone.jpg" alt="" style="position: absolute; right: 5px;" />
			<div>
				<img src="${contextPath}/imgs/imageFront/line.gif" alt="" style="margin-top: 10px"></img>
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
			
			<div style="margin-top: 20px;">
				<img src="${contextPath}/imgs/imageFront/contact_bg.png" width="1100px;" height="200px;" alt="" />
			</div>
		</div>
		
		
	</div>
	
		


	<div class="header auto mt20 clearfix" style="min-height: 400px;">
	
		
	
		<div style="width: 500px; float: left;">
		<div style="margin-left: 30px;"><span style="font-size: 40px; font-weight: bolder;">联系我们</span></div>
		<div style="margin:20px 0px 0px 30px;">
			<table>
				<tr style="height: 50px;width:100%;">
					<td style="font-size: 20px; font-weight: bolder;width:30%" >公司名称：</td>
					<td style="font-size: 20px;width:70%">天津中金新科小额贷款有限公司</td>
				</tr>
				<tr style="height: 50px;">
					<td style="font-size: 20px; font-weight: bolder;">公司地址：</td>
					<td style="font-size: 20px;">天津南开华苑高新产业园区海益国际4楼8层</td>
				</tr>
				<tr style="height: 50px;">
					<td style="font-size: 20px; font-weight: bolder;">电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：</td>
					<td style="font-size: 20px;">086-022-23708858</td>
				</tr>
				<tr style="height: 50px;">
					<td style="font-size: 20px; font-weight: bolder;">传&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;真：</td>
					<td style="font-size: 20px;">086-022-58281806</td>
				</tr>
				<tr style="height: 50px;">
					<td style="font-size: 20px; font-weight: bolder;">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：</td>
					<td style="font-size: 20px;">zhongjinxinke@126.com</td>
				</tr>
				<tr style="height: 50px;">
					<td style="font-size: 20px; font-weight: bolder;">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;编：</td>
					<td style="font-size: 20px;">300384</td>
				</tr>
			</table>
		</div>
		</div>	
		
		<div style="width: 500px; float: right;">
			 <div id="map" style="width: 500px; height: 350px"></div>    
		</div>
		
	</div>
	<div class="footer footer2" style="text-align: center;">
		<div class="footer_inner auto">
			<p class="pt15">
				<a href="#" target="_blank" title="" class="pr10">官方微博</a>|<a
					href="contact.jsp" target="_blank" title="联系我们" class="pl10 pr10">联系我们</a>|<a
					href="about.jsp" target="_blank" title="关于我们" class="pr10 pl10">关于我们</a>|<span
					class="pl10">全国免费咨询电话：400-6666-666</span>
			</p>
		</div>
	</div>
	</div>

</body>
</html>
