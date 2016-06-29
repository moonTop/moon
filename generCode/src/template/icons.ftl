<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript">
	var selectIcon = function($dialog, $input) {
		$input.val($(':radio:checked').val()).attr('class', $(':radio:checked').val());
		$dialog.dialog('destroy');
	};
	$(function() {

		$(':radio').each(function(index) {//初始化小图标
			$(this).after('<img class="iconImg ' + $(this).val() + '"/>');
		});
		$('.iconImg').attr('src', tw.pixel_0);

		$('li').click(function() {//绑定点击td事件，作用是点击td的时候，就可以选中，不一定非得点击radio组件
			$(this).find(':radio').attr('checked', 'checked');
		});

	});
</script>
</head>
<body>
<#list list as item>
<fieldset class="fieldset">
<#list item as ite>
	<#if ite.folderName??>
<legend>${ite.folderName}</legend>
	</#if>
</#list>
<ul class="ul">
	<#list item as ite>
	<li><input name="r" value="ext-icon-${ite.folder}-${ite.fileName}" type="radio" /></li>
	</#list>
</ul>
</fieldset>
</#list>
</body>
</html>