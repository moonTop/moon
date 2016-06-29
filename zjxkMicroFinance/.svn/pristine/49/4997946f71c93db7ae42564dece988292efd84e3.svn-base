<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<title>车易贷</title>
	<meta name="keywords" content="">
	<meta name="description" content="">
	<link rel="stylesheet" href="<c:url value='/css/styleFront.css'/>" type="text/css">
	<script type="text/javascript" src="<c:url value='/js/jquery-1.8.2.min.js'/>"></script>
	<script type="text/javascript" src="${contextPath}/js/validateFront.js"></script>
	<script type="text/javascript" src="${contextPath}/js/menu.js"></script>
	<script>
		//提交申请
		function applyCommit() {
			
			if(!$("#Theform").validate()){
				return false;
			}
			
				$.ajax({
					type : "POST",
					url : "saveApply.do",
					data : $("#Theform").serialize(),
					dataType : "json",
					success : function(data) {
						alert(data);
					},
					error : function(msg) {
						alert("申请失败，请重试！");
					}
				});
			}
	</script>
</head>
<body>
	<div class="header auto mt20">
		<div class="logo clearfix" style="position: relative;">
			<a href="#" class="l logo_img"> 
			<img src="${contextPath}/imgs/imageFront/logo01.jpg" width="207px" height="49px" title=""></a> 
			<img src="${contextPath}/imgs/imageFront/telephone.jpg" alt="" style="position: absolute; right: 5px;" />
			<div>
				<img src="${contextPath}/imgs/imageFront/line.gif" alt="" style="margin-top: 10px"></img>
			</div>
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

			<div class="main clearfix">
				<div class="mainRight">
					<div style="border:1px solid #d7d7d7;">
					<div class ="rightTitle"  ><span style="color:#1059A6;font-size: 20px;font-weight: bold;padding:15px;">车易贷在线申请</span></div>
						<div class="rightContent applyForm">
							<form class="" action="saveApply.do" id="Theform"
								name="applyForm" method="post">
								<input type="hidden" name="loantype" value="车易贷"></input>
								<div class="control_group">
									<label class="controls_label"><span>*</span>姓&nbsp;&nbsp;&nbsp;&nbsp;名：</label>
									<input class="controls yzui-validatebox" notBlank name="name" id="name" type="text" size="18" />
								</div>
								<div class="control_group">
			                       <label class="controls_label"><span>*</span>姓&nbsp;&nbsp;&nbsp;&nbsp;别：</label>
			                       <select class="controls" name="sex" id="sex" style="height: 25px ;width: 135px;">
			                            <option value="">---请选择---</option>
			                            <option value="男">男</option>
			                            <option value="女">女</option>
			                       </select>
			                    </div>
								<div class="control_group">
									<label class="controls_label"><span>*</span>手机号码：</label> <input
										class="controls yzui-validatebox" notBlank validType="mobile" name="phone" id="phone" type="text" size="18" />
								</div>
								<div class="control_group">
									<label class="controls_label"><span>*</span>电子邮箱：</label> <input
										class="controls yzui-validatebox" notBlank validType="email" name="email" id="email" type="text" size="18" />
								</div>
								<div class="control_group">
									<label class="controls_label"><span>*</span>贷款金额：</label> <input
										class="controls yzui-validatebox" notBlank name="loanamount" id="loanamount" type="text"
										size="18" />
								</div>
								<div class="control_group">
									<label class="controls_label"><span>*</span>购车时间(年)：</label> <input
										class="controls yzui-validatebox" notBlank name="carbuydate" id="carbuydate" type="text"
										size="18" maxlength="2" />
								</div>
								<div class="control_group">
									<label class="controls_label"><span>*</span>登记城市：</label> <input
										class="controls yzui-validatebox" notBlank name="carcity" id="carcity" type="text"
										size="18" />
								</div>
								<div class="control_group">
									<label class="controls_label"><span>*</span>购车价格：</label> <input
										class="controls yzui-validatebox" notBlank name="carprice" id="carprice" type="text"
										size="18" />
								</div>
								<div class="control_group">
									<label class="controls_label">备&nbsp;&nbsp;&nbsp;&nbsp;注：</label>
									<textarea rows="3" cols="19"  name="description" id="description" style="margin:0px 2px 0px 15px;width:130px;height:70px;"></textarea>
								</div>
								<div style="text-align: center; margin: 0px 0px 10px 0px">
									<div>
										<a onclick="applyCommit()" href="#"> <img
											src="${contextPath}/imgs/imageFront/submit_btn.png" alt="" /></a>
									</div>
								</div>
							</form>
						</div>
					</div>

					<div class="con2 mt12 " style="border:1px solid #ecebeb; ">
						<div class="div01">
							<a href="carloan.jsp"> <img
								src="${contextPath}/imgs/imageFront/car.jpg" alt=""
								style="cursor: pointer;" width="60px;" height="30px;" /></a>
						</div>
						<div class="div02" style="margin-bottom: 150px;">
							<p>
								[购车贷]为有资金需求的借款人提供相关信用咨询、车辆评估、抵押借款方案、协议管理、回款管理等多方面的服务，借款人以自有车辆为抵押物通过宜车贷服务从出借人处获得出借资金。
								<p>
						</div>
					</div>
				</div>


		<div class="mainLeft">
			<div>
				<img style="width: 780px; height:320px;"
					src="${contextPath}/imgs/imageFront/27111362725306.jpg"></img>
			</div>


					<div>
						<div style="font-size: 20px; font-weight: bold; margin: 20px 0px 20px 0px;">
							轻松便捷，车易贷借款只需<span
								style="color: blue; font-size: 30px; font-style: italic; ">&nbsp;3&nbsp;</span>步
						</div>
						<div style="margin-bottom: 30px; margin-left: 30px;">
							<img src="${contextPath}/imgs/st_step.png" alt="" />
						</div>
						
						<div style="margin: 10px 0px 10px 0px;">
							<img src="${contextPath}/imgs/line1.gif" alt=""/>
							<img src="${contextPath}/imgs/line1.gif" alt=""/>
							<img src="${contextPath}/imgs/line1.gif" alt=""/>
						</div>

						<div style="font-size: 20px; font-weight: bold; margin-top: 20px;">借款所需资料</div>
						<div style="margin: 20px 0px 20px 0px">
							<img src="${contextPath}/imgs/st_means2.jpg" alt="" />
						</div>
						
						<div style="margin: 10px 0px 10px 0px;">
							<img src="${contextPath}/imgs/line1.gif" alt=""/>
							<img src="${contextPath}/imgs/line1.gif" alt=""/>
							<img src="${contextPath}/imgs/line1.gif" alt=""/>
						</div>

						<div
							style="margin: 20px 0px 5px 0px; font: bold; font-size: 20px; font-weight: bolder;">申请条件</div>
						<div style="margin: 5px 0px 5px 15px; font-size: 15px;">
							<p style="margin: 10px 0px 10px 0px;">尊敬的顾客！为了节省您宝贵的时间，请在填写申请表前，请确认您是否拥有以下条件以及所需材料</p>
							<p style="margin: 0px 0px 10px 0px;">● 拥有稳定的职业，月薪不低于4000元人民币。</p>
							<p style="margin: 0px 0px 10px 0px;">● 拥有稳定的职业，月薪不低于4000元人民币。</p>
							<p style="margin: 0px 0px 10px 0px;">● 拥有稳定的职业，月薪不低于4000元人民币。</p>
							<p style="margin: 0px 0px 10px 0px;">● 拥有稳定的职业，月薪不低于4000元人民币。</p>
							<p style="margin: 0px 0px 10px 0px;">● 拥有稳定的职业，月薪不低于4000元人民币。</p>
						</div>
					</div>
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
