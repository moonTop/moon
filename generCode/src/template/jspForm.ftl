<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<%
	String id = request.getParameter("id");
	if (id == null) {
		id = "";
	}
%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<jsp:include page="../../inc.jsp"></jsp:include>
<script type="text/javascript">
	var submitForm = function($dialog, $grid, $pjq) {
		if ($('#form').form('validate')) {
			var url;
			if ($(':input[name="id"]').val().length > 0) {
				url = tw.contextPath + '/${beanNameLower}/update.htm';
			} else {
				url = tw.contextPath + '/${beanNameLower}/save.htm';
			}
			$.post(url, tw.serializeObject($('#form')), function(result) {
				if (result.success) {
					$grid.treegrid('reload');
					$dialog.dialog('destroy');
				} else {
					$pjq.messager.alert('提示', result.msg, 'error');
				}
			}, 'json');
		}
	};
	var showIcons = function() {
		var dialog = parent.tw.modalDialog({
			title : '浏览小图标',
			url : tw.contextPath + '/style/icons.jsp',
			buttons : [ {
				text : '确定',
				handler : function() {
					dialog.find('iframe').get(0).contentWindow.selectIcon(dialog, $('#iconCls'));
				}
			} ]
		});
	};
	$(function() {
		if ($(':input[name="id"]').val().length > 0) {
			parent.$.messager.progress({
				text : '数据加载中....'
			});
			$.post(tw.contextPath + '/${beanNameLower}/getById.htm', {
				id : $(':input[name="id"]').val()
			}, function(result) {
				if (result.id != undefined) {
					$('#form').form('load', {
						<#list fields as field>
						'${field.fieldName}' : result.${field.fieldName},
						</#list>
					});
					$('#iconCls').attr('class', result.iconCls);//设置背景图标
				}
				parent.$.messager.progress('close');
			}, 'json');
		}
	});
</script>
</head>
<body>
	<form method="post" class="form" id="form">
		<fieldset>
			<legend>${tableRemark}</legend>
			<table class="table" style="width: 100%;">
				<#assign  num=0>
				<#list fields as field>
				<#if num=0>
				<tr>
				</#if>
				<#assign  num=num+1>
					<#if field.fieldType=="Date">
					<th>${field.remark}</th>
					<td><input name="${field.fieldName}" class="Wdate" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" /></td>
					<#else>
					<th>${field.remark}</th>
					<td><input name="${field.fieldName}" class="easyui-validatebox" data-options="required:true" /></td>
					</#if>
				<#if num==2>
				<#assign  num=0>
				</tr>
				</#if>
				</#list>
				<#if num!=2>
				</tr>
				</#if>
			</table>
		</fieldset>
	</form>
</body>
</html>