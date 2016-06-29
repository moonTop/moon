<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tw.sys.util.SecurityUtil"%>
<%
	String contextPath = request.getContextPath();
	SecurityUtil securityUtil = new SecurityUtil(session);
%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<jsp:include page="../../inc.jsp"></jsp:include>
<script type="text/javascript">
	var grid;
	var addFun = function() {
		var dialog = parent.tw.modalDialog({
			title : '添加信息',
			url : tw.contextPath + '/${jspRootPath}${beanName}Form.jsp',
			buttons : [ {
				text : '添加',
				handler : function() {
					dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
				}
			} ]
		});
	};
	var showFun = function(id) {
		if(id == "" || id == undefined){
			var node = grid.datagrid('getSelected');
			id = node.id;
		}
		var dialog = parent.tw.modalDialog({
			title : '查看信息',
			url : tw.contextPath + '/${jspRootPath}${beanName}Form.jsp?id=' + id
		});
	};
	var editFun = function(id) {
		if(id == "" || id == undefined){
			var node = grid.datagrid('getSelected');
			id = node.id;
		}
		var dialog = parent.tw.modalDialog({
			title : '编辑信息',
			url : tw.contextPath + '/${jspRootPath}${beanName}Form.jsp?id=' + id,
			buttons : [ {
				text : '编辑',
				handler : function() {
					dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
				}
			} ]
		});
	};
	var removeFun = function(id) {
		if(id == "" || id == undefined){
			var node = grid.datagrid('getSelected');
			id = node.id;
		}
		parent.$.messager.confirm('询问', '您确定要删除此记录？', function(r) {
			if (r) {
				$.post(tw.contextPath + '/${beanNameLower}/delete.htm', {
					id : id
				}, function() {
					grid.datagrid('reload');
				}, 'json');
			}
		});
	};
	$(function() {
		grid = $('#grid').datagrid({
			title : '',
			url : tw.contextPath + '/${beanNameLower}/grid.htm',
			striped : true,
			rownumbers : true,
			pagination : true,
			singleSelect : true,
			idField : 'id',
			sortName : 'createdatetime',
			sortOrder : 'desc',
			pageSize : 50,
			pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
			frozenColumns : [ [ 
			<#list fields as field>
			<#if field.isPK?index_of("true")!=-1>
			  {
				width : '100',
				title : '${field.remark}',
				field : '${field.fieldName}',
				sortable : true
			  }
		    </#if>
			</#list>
			 ] ],
			columns : [ [ 
			<#list fields as field>
			<#if field.isPK?index_of("true")==-1>
			  {
				width : '150',
				title : '${field.remark}',
				field : '${field.fieldName}',
				sortable : true
			  },
		    </#if>
			</#list>
			  {
				title : '操作',
				field : 'action',
				width : '90',
				formatter : function(value, row) {
					var str = '';
					<%if (securityUtil.havePermission("/${beanNameLower}/getById")) {%>
						str += tw.formatString('<img class="iconImg ext-icon-notes-note" title="查看" onclick="showFun(\'{0}\');"/>', row.id);
					<%}%>
					<%if (securityUtil.havePermission("/${beanNameLower}/update")) {%>
						str += tw.formatString('<img class="iconImg ext-icon-notes-note_edit" title="编辑" onclick="editFun(\'{0}\');"/>', row.id);
					<%}%>
					<%if (securityUtil.havePermission("/${beanNameLower}/delete")) {%>
						str += tw.formatString('<img class="iconImg ext-icon-notes-note_delete" title="删除" onclick="removeFun(\'{0}\');"/>', row.id);
					<%}%>
					return str;
				}
			} ] ],
			toolbar : '#toolbar',
			onBeforeLoad : function(param) {
				parent.$.messager.progress({
					text : '数据加载中....'
				});
			},
			onLoadSuccess : function(data) {
				$('.iconImg').attr('src', tw.pixel_0);
				parent.$.messager.progress('close');
				createMenuDiv(this);
			},
			onRowContextMenu:initGridContextMenu
		});
	});
</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<div id="toolbar" style="display: none;">
		<table>
			<tr>
				<td>
					<form id="searchForm">
						<table>
							<tr>
								<#list fields as field>
								<#if field.fieldType=="Date">
								<td>${field.remark}</td>
								<td><input name="${field.fieldName}" class="Wdate" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" style="width: 120px;" /></td>
								<#else>
								<td>${field.remark}</td>
								<td><input name="${field.fieldName}" style="width: 80px;" /></td>
								</#if>
								</#list>
								<td>
									<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'ext-icon-zoom-zoom',plain:true" onclick="grid.datagrid('load',tw.serializeObject($('#searchForm')));">过滤</a>
									<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'ext-icon-zoom-zoom_out',plain:true" onclick="$('#searchForm input').val('');grid.datagrid('load',{});">重置过滤</a>
								</td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
			<tr>
				<td>
					<table>
						<tr>
							<%if (securityUtil.havePermission("/${beanNameLower}/save")) {%>
							<td><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'ext-icon-notes-note_add',plain:true" onclick="addFun();">添加</a></td>
							<%}%>
							<td><div class="datagrid-btn-separator"></div></td>
							<td><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'ext-icon-table-table_add',plain:true" onclick="">导入</a></td>
							<td><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'ext-icon-table-table_go',plain:true" onclick="">导出</a></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	<div data-options="region:'center',fit:true,border:false">
		<table id="grid" data-options="fit:true,border:false"></table>
	</div>
</body>
</html>