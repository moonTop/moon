<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<title>企业贷</title>
	<meta name="keywords" content="">
	<meta name="description" content="">
	<link rel="stylesheet" href="<c:url value='/css/styleFront.css'/>" type="text/css">
	<script type="text/javascript" src="<c:url value='/js/jquery-1.8.2.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/validateFront.js'/>"></script>
	<script type="text/javascript" src="${contextPath}/js/menu.js"></script>
	<script>
	    //提交申请
        function applyCommit(){
        	if(!$("#applyForm").validate()){
        	    return false;
        	};
        	$.ajax({
        		type: "POST",
                url: "saveApply.do",
                data: $("#applyForm").serialize(),
                dataType: "json",
                success: function (data) {
                    alert(data);
                },
                error: function (data) {
                    alert("申请失败，请重试！");
                }
        	});
        }
	</script>
</head>
<body>
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
	
	<div class="main clearfix">
	<div class= "mainRight">
		<div style= "border: 1px solid #d7d7d7;">
		    <div class ="rightTitle"  ><span style="color:#1059A6;font-size: 20px;font-weight: bold;padding:15px;">企业贷在线申请</span></div>
            <div class="rightContent applyForm" >
		        <form class=""  action="saveApply.do" id="applyForm" name="applyForm" method="post">
		            <input type="hidden" name="loantype" value="企业贷"></input>
		            <div class="control_group">
		               <label class="controls_label"><span>*</span>企业名称：</label>
		               <input class="controls yzui-validatebox" notBlank name="companyname" id="companyname"  type="text" size="18" />
		            </div>
		            <div class="control_group">
                       <label class="controls_label"><span>*</span>企业性质：</label>
                       <select class="controls yzui-validatebox" notBlank name="companyproper" id="companyproper" style="height: 25px ;width: 135px;">
                            <option value="">---请选择---</option>
                            <option value="国有企业">国有企业</option>
                            <option value="集体企业">集体企业</option>
                            <option value="联营企业">联营企业</option>
                            <option value="股份合作制企业">股份合作制企业</option>
                            <option value="私营企业">私营企业</option>
                            <option value="个体户">个体户</option>
                            <option value="合伙企业">合伙企业</option>
                            <option value="有限责任公司">有限责任公司</option>
                            <option value="股份有限公司">股份有限公司</option>
                            <option value="其他">其他</option>
                       </select>
                    </div>
                    <div class="control_group">
                        <label class="controls_label"><span>*</span>联系人：</label>
                        <input class="controls yzui-validatebox" notBlank validType="text" name="name" id="name"  type="text" size="18" />
                    </div>
		            <div class="control_group">
                        <label class="controls_label"><span>*</span>联系方式：</label>
                        <input class="controls yzui-validatebox" notBlank name="phone" id="phone"  type="text" size="18" />
                    </div>
                    <div class="control_group">
		               <label class="controls_label"><span>*</span>单位电话：</label>
		               <input class="controls yzui-validatebox" notBlank name="unittelephone" id="unittelephone"  type="text" size="18" />
		            </div>
                    <div class="control_group">
                        <label class="controls_label"><span>*</span>企业邮箱：</label>
                        <input class="controls yzui-validatebox" notBlank validType="email" name="email" id="email"  type="text" size="18" />
                    </div>
                     <div class="control_group">
                        <label class="controls_label"><span>*</span>贷款金额：</label>
                        <input class="controls yzui-validatebox" notBlank validType="amount" name="loanamount" id="loanamount"  type="text" size="18" />
                    </div>
                    <div class="control_group">
                        <label class="controls_label"><span>*</span>企业所在地：</label>
                        <select class="controls yzui-validatebox" notBlank name="companyaddress" id="companyaddress" style="height: 25px ;width: 135px;">
                            <option value="">---请选择---</option>
                            <option value="和平区">和平区</option>
                            <option value="河东区">河东区</option>
                            <option value="河西区">河西区</option>
                            <option value="南开区">南开区</option>
                            <option value="河北区">河北区</option>
                            <option value="红桥区">红桥区</option>
                            <option value="塘沽区">塘沽区</option>
                            <option value="汉沽区">汉沽区</option>
                            <option value="大港区">大港区</option>
                            <option value="东丽区">东丽区</option>
                            <option value="西青区">西青区</option>
                            <option value="津南区">津南区</option>
                            <option value="北辰区">北辰区</option>
                            <option value="武清区">武清区</option>
                            <option value="宝坻区">宝坻区</option>
                            <option value="蓟县">蓟&nbsp;&nbsp;县</option>
                            <option value="静海县">静海县</option>
                            <option value="宁河县">宁河县</option>
                        </select>
                    </div>
                    <div class="control_group">
                        <label class="controls_label">备&nbsp;&nbsp;&nbsp;&nbsp;注：</label>
                        <textarea rows="3" cols="19"  name="description" id="description" style="margin:0px 2px 0px 15px;width:130px;height:70px;"></textarea>
                    </div>
                    <div style= "text-align: center; margin: 0px 0px 10px 0px ">
                       <div><a onclick="applyCommit()" href="#"><img src="${contextPath}/imgs/imageFront/submit_btn.png" alt=""/></a></div>
                    </div>
		        </form>
		    </div>
		</div>
		<div style= "border: 1px solid #d7d7d7; margin-top: 15px">
             <div style="margin: 15px;"><img style="" src="${contextPath}/imgs/imageFront/business.jpg"></img></div>
             <div style="margin: 15px;">
                  <p style=" font-size: 14px; text-indent: 2em; line-height: 25px ">解一时之需，赢无限商机，[企业贷]为各类中小企业量身定制最快捷的贷款服务，无需任何抵押担保，快捷审核放款，祝您的企业抢占市场先机。只要您是企业法人，现金即时到手。</p>
             </div>
        </div>
	</div>
	<div class= "mainLeft">
	    <div>
            <div><img style="width: 780px; height:320px;" src="../imgs/imageFront/010.jpg"></img></div>
        </div>
        <div style= " border: 1px solid #d7d7d7; margin-top: 20px">
           <div style="margin:20px 0px 20px 20px; font: bold;  font-size:25px;">申请步骤</div>
           <div style="margin:5px 0px 20px 20px;">
               <img alt="" src="${contextPath}/imgs/imageFront/st_step.png"></img>
           </div>
           
           <div style="border : 1px dashed #d7d7d7; margin:0px 100px 0px 20px;"></div>
           
           <div style="margin:20px 0px 20px 20px; font: bold;  font-size:25px; ">申请所需材料</div>
           <div style="margin:5px 0px 20px 20px;">
               <img alt="" src="${contextPath}/imgs/imageFront/st_means.jpg"></img>
           </div>
           
           <div style="border : 1px dashed #d7d7d7; margin:0px 100px 0px 20px;"></div>
           
           <div style="margin:20px 0px 5px 20px; font: bold;  font-size:25px;">申请条件</div>
           <div style="margin:5px 0px 5px 20px; font-size:14px;">
              <p style="margin:0px 0px 10px 0px; color: #7e7e7e; font-weight: bold;">尊敬的顾客！为了节省您宝贵的时间，请在填写申请表前，请确认您是否拥有以下条件以及所需材料</p>
              <p style="margin:0px 0px 10px 10px; color: #7e7e7e;">● 拥有稳定的职业，月薪不低于4000元人民币。</p>
              <p style="margin:0px 0px 10px 10px; color: #7e7e7e;">● 拥有稳定的职业，月薪不低于4000元人民币。</p>
              <p style="margin:0px 0px 10px 10px; color: #7e7e7e;">● 拥有稳定的职业，月薪不低于4000元人民币。</p>
              <p style="margin:0px 0px 10px 10px; color: #7e7e7e;">● 拥有稳定的职业，月薪不低于4000元人民币。</p>
              <p style="margin:0px 0px 30px 10px; color: #7e7e7e;">● 拥有稳定的职业，月薪不低于4000元人民币。</p>
           </div>
        </div>
	</div>
	</div>
	<div class="footer footer2" style="text-align:center;">
		<div class="footer_inner auto">
			<p class="pt15">
				<a href="#" target="_blank" title="" class="pr10">官方微博</a>|<a
					href="contact.jsp" target="_blank" title="联系我们" class="pl10 pr10">联系我们</a>|<a
					href="about.jsp" target="_blank" title="关于我们" class="pr10 pl10">关于我们</a>|<span
					class="pl10">全国免费咨询电话：022-2370-8858</span>
			</p>
		</div>
	</div>
</body>
</html>