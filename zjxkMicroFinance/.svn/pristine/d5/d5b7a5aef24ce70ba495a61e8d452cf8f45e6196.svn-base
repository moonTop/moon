var duplicateFlg = "";

$(document).ready(
		function() {
			var i = 0;
			var displayInfo = "";
			$("[class*='yzui-validatebox']").each(
					function(i) {
						displayInfo = "";
						$(this).wrap("<div id=wrapDiv" + i + " class='wrapDiv' ></div>");
						$(this).attr("idx", i);
						$("#wrapDiv" + i).append("<img src='../imgs/imageFront/error.gif' style='margin-top:0px; margin-left:5px; cursor:pointer;' id=errorIcon" + i + " class='errorIcon' title=''>");
						$(".errorIcon").css("display", "none");
					});

			$("[class*='yzui-validatebox']").focus(function() {
				i = $(this).attr("idx");
				$("#errorIcon" + i).css("display", "none");
			});

			$("[class*='yzui-validatebox']").blur(function() {
				// 非空项目验证
				if (typeof ($(this).attr("notBlank")) != 'undefined') {
					displayInfo = "";
					if (isNull($(this).val())) {
						displayInfo = "必填项！";
						showMessage(i,displayInfo);
						return;
					}
				}
				
				// 项目属性验证
				if(!isNull($(this).val())&&$(this).attr("validType")){
					
					// 数字验证
					if($(this).attr("validType").indexOf("amount")>=0){
						if (!isNumber($(this).val())) {
							displayInfo= "请输入数字！";
							showMessage(i,displayInfo);
							return;
						} else {
							$("#errorIcon" + i).css("display", "none");
						}
					}
					
					// Email地址
					if($(this).attr("validType").indexOf("email")>=0){
						if(!isEmail($(this).val())){
							displayInfo="Email地址不正确！";
							showMessage(i,displayInfo);
							return;
						} else {
							$("#errorIcon" + i).css("display", "none");
						}
					}
					
					// 手机号码
					if($(this).attr("validType").indexOf("mobile")>=0){
						if(!isMobile($(this).val())){
							displayInfo="手机号码不正确！";
							showMessage(i,displayInfo);
							return;s
						} else {
							$("#errorIcon" + i).css("display", "none");
						}
					}
				}
			});

		});

// Form提交时校验
$.fn.validate = function(options) {
	var defaults = {};
	var opts = $.extend(defaults, options);
	var displayInfo = "";
	var errorFlag = "";
	$(this).find("[class*='yzui-validatebox']").each(function() {
		displayInfo = "";
		var i = $(this).attr("idx");
		if (typeof ($(this).attr("notBlank")) != 'undefined') {

			// 必须项目校验
			if (isNull($(this).val())) {
				displayInfo = "必填项！";
				showMessage(i, displayInfo);
				errorFlag = "1";
			}
		}

		// 项目属性验证
		if(!isNull($(this).val())&&$(this).attr("validType")){
			
			// 数字验证
			if($(this).attr("validType").indexOf("amount")>=0){
				if (!isNumber($(this).val())) {
					displayInfo= "请输入数字！";
					showMessage(i,displayInfo);
					errorFlag = "1";
				} else {
					$("#errorIcon" + i).css("display", "none");
				}
			}
			
			// Email地址
			if($(this).attr("validType").indexOf("email")>=0){
				if(!isEmail($(this).val())){
					displayInfo="Email地址不正确！";
					showMessage(i,displayInfo);
					errorFlag = "1";
				} else {
					$("#errorIcon" + i).css("display", "none");
				}
			}
			
			// 手机号码
			if($(this).attr("validType").indexOf("mobile")>=0){
				if(!isMobile($(this).val())){
					displayInfo="手机号码不正确！";
					showMessage(i,displayInfo);
					errorFlag = "1";
				} else {
					$("#errorIcon" + i).css("display", "none");
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

/*
 * 用途：显示信息
 */
function showMessage(i,displayInfo){
	$("#errorIcon" + i).attr("title", displayInfo);
	$("#errorIcon" + i).css("display", "inline");
}

function isNumber(s) {// 判断是否是数字
	var regu = "^[0-9]+$";
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
