	var duplicateFlg = "";
	
$(document).ready(function() {
	var i = 0;
	var displayInfo="";
	$("input[class*='yzui-validatebox']").each(
			function(i) {
				displayInfo="";
				$(this).wrap("<span id=wrapDiv"+i+" class='wrapDiv' ></span>");
				$("#wrapDiv"+i).css("width",$(this).width()+2);
				$("#wrapDiv"+i).css("height",$(this).height()+2);
				var wrapWidth= parseInt($("#wrapDiv"+i).css("width"));
				var wrapHeight= parseInt($("#wrapDiv"+i).css("height"));
				var inputWidth= parseInt($(this).css("width"));
				var inputHeight= parseInt($(this).css("height"));

				infoLeft=parseInt($("#wrapDiv"+i).width())+8;
				$(this).attr("idx",i);
				$("#wrapDiv"+i).append("<img src='../../imageFront/validatebox_warning.png' style='height:16px;width:18px;' id=validateRstIcon"+i+" class='validateRstIcon'><div id=validateDisplayDiv"+i+" class='validateDisplayDiv'><div id=validateDisplayInfoIcon"+i+" class='validateDisplayInfoIcon'></div><div id=validateDisplayInfoMsg"+i+" class='validateDisplayInfoMsg'></div></div>");
				$("#validateRstIcon"+i).css("right",1);
				$("#validateDisplayInfoIcon"+i).css("left",$("#wrapDiv"+i).width());
				$("#validateDisplayInfoMsg"+i).css("left",infoLeft);
				$("#validateDisplayInfoMsg"+i).text("");
				
				// 鼠标划过事件
				$(this).hover(function(){
					// 非空项目验证
					if(typeof($(this).attr("notBlank"))!='undefined'){
							displayInfo="";
							if (isNull($(this).val())) {
								displayInfo="必填项！"	;	
								$("#validateDisplayInfoMsg"+i).html(displayInfo);
								$("#validateDisplayDiv"+i).css("display", "inline");
								return;
							}
					}
					
					// 项目属性验证
					if(!isNull($(this).val())&&$(this).attr("validType")){
						if($(this).attr("validType").indexOf("numberOrLetter")>=0){
							displayInfo="";
							if(!isNumberOrLetter($(this).val())){
								displayInfo="请输入数字或字符！";
								showMessage(i,displayInfo);
								return;
							}else{
								hideMessage(i);
							}
						}
						//输入数字 
						if($(this).attr("validType").indexOf("amount")>=0){
							displayInfo="";
							if(!isNumber($(this).val())){
								displayInfo="请输入数字！";
								showMessage(i,displayInfo);
								return;
							}else{
								hideMessage(i);
							}
						}
						//输入字母
						if($(this).attr("validType").indexOf("EnglishLetter")>=0){
							displayInfo="";
							if(!Letter($(this).val())){
								displayInfo="请输入字符！";
								showMessage(i,displayInfo);
								return;
							}else{
								hideMessage(i);
							}
						}
						// 不可输入汉字验证
						if($(this).attr("validType").indexOf("noContainsChinese")>=0){
							displayInfo="";
							if(containsChinese($(this).val())){
								displayInfo="不可输入汉字！";
								showMessage(i,displayInfo);
								return;
							}else{
								hideMessage(i);
							}
						}
						
						// 邮件地址验证
						if($(this).attr("validType").indexOf("email")>=0){
							displayInfo="";
							if(!isEmail($(this).val())){
								displayInfo="Email地址不正确！";
								showMessage(i,displayInfo);
								return;
							}else{
								hideMessage(i);
							}
						}	
						
						// 手机号验证
						if($(this).attr("validType").indexOf("mobile")>=0){
							displayInfo="";
							if(!isMobile($(this).val())){
								displayInfo="手机号码不正确！";
								showMessage(i,displayInfo);
								return;
							}else{
								hideMessage(i);
							}
						}
						
						// 长度验证
						if($(this).attr("validType").indexOf("length")>=0){
							if(checkLength($(this)) != "" ){
								return;
							}
						}
						
						// 用户名数据库中存在性验证
						if($(this).attr("validType").indexOf("duplicate")>=0){
							if (duplicateFlg  != "") {
								displayInfo= "您输入的用户名已存在！";
								showMessage(i,displayInfo);
							} else {
								hideMessage(i)
							}
						}
					}
				});	
				
				// 数据库重复内容验证
				if($(this).attr("validType")&& $(this).attr("validType").indexOf("duplicate")>=0){
					$(this).blur(function(){
						if($(this).attr("validType").indexOf("length")>=0){
							if(checkLength($(this)) != "" ){
								return;
							}else{
								duplicateCheck($(this));
							}
					}else{
						duplicateCheck($(this));
						}
					})
				};

				$(this).keyup(function(){
					if(isNull($(this).val())){
						$(".validateDisplayDiv",$(this).parent()).css("display", "none");
						$(".validateRstIcon",$(this).parent()).css("display", "none");
						return;
					}
					if(!isNull($(this).val())&&$(this).attr("validType")){
						if($(this).attr("validType").indexOf("numberOrLetter")>=0){
								displayInfo="";
								if(!isNumberOrLetter($(this).val())){
									displayInfo="请输入数字或字符！";
									showMessage(i,displayInfo);
									return;
								}else{
									hideMessage(i);
								}
						}
						if($(this).attr("validType").indexOf("amount")>=0){
							displayInfo="";
							if(!isNumber($(this).val())){
								displayInfo="请输入数字！";
								showMessage(i,displayInfo);
								return;
							}else{
								hideMessage(i);
							}
					}
						if($(this).attr("validType").indexOf("EnglishLetter")>=0){
							displayInfo="";
							if(!Letter($(this).val())){
								displayInfo="请输入字符！";
								showMessage(i,displayInfo);
								return;
							}else{
								hideMessage(i);
							}
					}
						if($(this).attr("validType").indexOf("noContainsChinese")>=0){
							displayInfo="";
							if(containsChinese($(this).val())){
								displayInfo="不可输入汉字！";
								showMessage(i,displayInfo);
								return;
							}else{
								hideMessage(i);
							}
						}
						if($(this).attr("validType").indexOf("length")>=0){
							checkLength($(this));
						}
					}
				});
			});
	$("input[class*='yzui-validatebox']").mouseout(function() {
		$(".validateDisplayDiv").css("display", "none");
	});
	$("input[class*='yzui-validatebox']").focus(function() {
		$(".validateDisplayDiv").css("display", "none");
	});
	
	// Form提交时校验
	$.fn.validate = function(options) {
		var defaults = {};
		var opts = $.extend(defaults, options);
		var displayInfo = "";
		var errorFlag = "";
		$(this).find("input[class*='yzui-validatebox']").each(function() {
				displayInfo="";
				var i =$(this).attr("idx");
				if(typeof($(this).attr("notBlank"))!='undefined'){
					
					// 必须项目校验
					if (isNull($(this).val())) {
						displayInfo= "必填项！";
						showMessage(i,displayInfo);
						errorFlag = "1";
					}
				}
				
				// 项目属性校验
				if(!isNull($(this).val())&&$(this).attr("validType")){
					
					// 数字或字母校验
					if($(this).attr("validType").indexOf("numberOrLetter")>=0){
						if (!isNumberOrLetter($(this).val())) {
							displayInfo= "请输入数字或字母！";
							showMessage(i,displayInfo);
							errorFlag = "1";
						} else {
							hideMessage(i)
						}
					}
					//数字验证
					if($(this).attr("validType").indexOf("amount")>=0){
						if (!isNumber($(this).val())) {
							displayInfo= "请输入数字！";
							showMessage(i,displayInfo);
							errorFlag = "1";
						} else {
							hideMessage(i)
						}
					}
					// 字母校验
					if($(this).attr("validType").indexOf("EnglishLetter")>=0){
						if (!Letter($(this).val())) {
							displayInfo= "请输入字母！";
							showMessage(i,displayInfo);
							errorFlag = "1";
						} else {
							hideMessage(i)
						}
					}
					// 不包含汉字校验
					if($(this).attr("validType").indexOf("noContainsChinese")>=0){
						if (containsChinese($(this).val())) {
							displayInfo= "不可输入汉字！";
							showMessage(i,displayInfo);
							errorFlag = "1";
						} else {
							hideMessage(i)
						}
					}
					
					// Email地址
					if($(this).attr("validType").indexOf("email")>=0){
						if(!isEmail($(this).val())){
							displayInfo="Email地址不正确！";
							showMessage(i,displayInfo);
							errorFlag = "1";
							return;
						}else{
							hideMessage(i)
						}
					}
					
					// 手机号码
					if($(this).attr("validType").indexOf("mobile")>=0){
						if(!isMobile($(this).val())){
							displayInfo="手机号码不正确！";
							showMessage(i,displayInfo);
							errorFlag = "1";
							return;
						}else{
							hideMessage(i)
						}
					}
					
					// 长度验证
					if($(this).attr("validType").indexOf("length")>=0){
						errorFlag = checkLength($(this));
					}
					
					// 前台用户名数据库中存在性验证
					if($(this).attr("validType").indexOf("duplicate")>=0){
						if (duplicateFlg  != "") {
							displayInfo= "您输入的用户名已存在！";
							showMessage(i,displayInfo);
							errorFlag = "1";
						} else {
							hideMessage(i)
						}
					}
				}
		});
		
		// 有错误的情况，返回
		if (errorFlag != "") {
			return false;
		}
		return true;
	};	
	
	$.fn.clear = function(options) {
		var defaults = {};
		var opts = $.extend(defaults, options);
		var displayInfo = "";
		var errorFlag = "";
		$(this).find("input").each(function() {
			$(this).val("");
			$(".validateDisplayDiv", $(this).parent()).css("display", "none");
			$(".validateRstIcon", $(this).parent()).css("display", "none");	
		});
	};	
	
});

/*
 * 用途：校验重复内容
 */
function duplicateCheck(obj){
	var arr = obj.attr("validType").split(";");
	var i =obj.attr("idx");
	
	for(var k=0;k<arr.length;k++){
		var str = arr[k];
		var tbName="";
		if(str.indexOf("duplicate")>=0){
			tbName=str.replace("duplicate[","").replace("]","");
		}
	}
	var error=""
    $.ajax({
        type : "POST",
        url : "duplicate.do",
        anysc:false,
        data : {condition:obj.attr("name"),value:obj.val(),model:tbName},
        success : function(data) {
            if (data == '1') {
            	obj.attr("error","1");
            	showMessage(i,"您输入的用户名已存在！");
            	duplicateFlg = "1";
            }else{
            	hideMessage(i);
            	duplicateFlg = "";
            }
        }
    });
	return error;
}

/*
 * 用途：校验控件的Length属性
 */
function checkLength(obj){
	var arr = obj.attr("validType").split(";");
	var objLen=obj.val().length;

	for(var k=0;k<arr.length;k++){
		var str = arr[k];
		if(str.indexOf("length")>=0){
			var arry=str.replace("length[","").replace("]","").split(",");
		}
	}
	var error ="";
	var minLength =arry[0];
	var maxLength =arry[1];		
	var i=obj.attr("idx");
	displayInfo="";
	if(objLen<minLength){
		displayInfo="长度不能小于" + minLength+"!";
		showMessage(i,displayInfo);
		error= "1";
	}else if(objLen>maxLength){
		displayInfo="长度不能大于" + maxLength+"!";
		showMessage(i,displayInfo);
		error= "1";
	}else{
		hideMessage(i);
	}
	return error;
}

/*
 * 用途：显示信息
 */
function showMessage(i,displayInfo){
	$("#validateDisplayInfoMsg"+i).html(displayInfo);
	$("#validateDisplayDiv"+i).css("display", "inline");
	$("#validateRstIcon"+i).css("display", "inline");
}

/*
 * 用途：检查输入字符串是否只由英文字母和数字组成 输入： s：字符串 返回： 如果通过验证返回true,否则返回false
 */
function isNumberOrLetter(s) {// 判断是否是数字或字母
	var regu = "^[0-9a-zA-Z]+$";
	var re = new RegExp(regu);
	if (re.test(s)) {
		return true;
	} else {
		return false;
	}
};
function isNumber(s) {// 判断是否是数字
	var regu = "^[0-9]+$";
	var re = new RegExp(regu);
	if (re.test(s)) {
		return true;
	} else {
		return false;
	}
};
function Letter(s) {// 判断是否是字母
	var regu = "^[a-zA-Z]+$";
	var re = new RegExp(regu);
	if (re.test(s)) {
		return true;
	} else {
		return false;
	}
};
/*
 * 用途：检查输入字符串是否为空或者全部都是空格 输入： str 返回： 如果全是空返回true,否则返回false
 */
function isNull(str) {
	if (str == "")
		return true;
	var regu = "^[ ]+$";
	var re = new RegExp(regu);
	return re.test(str);
};
/*
 * 用途：判断输入的值是否含有汉字
 */
function containsChinese(str) {
	if (escape(str).indexOf("%u") != -1){
		return true;
	}
	return false;
}

/*
 * 用途：判断是否Email
 */
function isEmail(str) {
	var reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	if (reg.test(str)) {
		return true
	} else {
		return false
	}
}
/*
 * 用途：判断是否Mobile
 */
function isMobile(str) {
	var re;
	re = /^[1]+[3-8]+[0-9]+$/
	if (re.test(str) && str.length == 11) {
		return true;
	} else {
		return false;
	}
}

