$(document).ready( function() {
	$("#search_fm${beanName}").bind('keyup',function(event){
	    event=document.all?window.event:event;
	    if((event.keyCode || event.which)==13){
	    	doSearch();
	    }
    });
	initDatagrid();
});

function initDatagrid(){
    $('#${beanNameLower}Grid').datagrid({
	    height:getHeight(),
		nowrap: true,
		striped: true,
		pagination:true,
		rownumbers:true,
//		fitColumns: true,
		singleSelect:false,
		pageSize:15,
		pageList:[10,15,20,30],
		frozenColumns:[[
		                {field:'ck',checkbox:true}
		                ]],
		columns:[[
            {field:'ID',hidden:true},	
			<#list fields as field>
			<#if field.isPK?index_of("true")==-1>
			 {title : '${field.remark}',field : '${field.fieldName}',sortable : false,width : 100,align : 'center'},
		    </#if>
			</#list>
			 {title : '创建日期',field : 'CREATEDATE',sortable : false,width : 150,align : 'center',
					formatter : function(value,row,index){
						return Date.getDateStr(value);
					}
			 },
			 {title : '创建人',field : 'CREATEUSER',sortable : false,width : 100,align : 'center'},
			 {title : '最后操作时间',field : 'UPDATEDATE',sortable : false,width : 150,align : 'center',
					formatter : function(value,row,index){
						return Date.getDateStr(value);
					}
			 },
			 {title : '最后操作人',field : 'UPDATEUSER',sortable : false,width : 100,align : 'center'}
		]],
		toolbar:[{
   			text : '新增',
			iconCls : 'icon-add',
			plain:true,
			handler : function() {
				openAdd${beanName}();
			}
		},'-',{
			text : '编辑',
			iconCls : 'icon-edit',
			plain:true,
			handler : function() {
				openEdit${beanName}();
			}
		},'-',{
			text : '删除',
			iconCls : 'icon-remove',
			plain:true,
			handler : function() {
				delete${beanName}();
			}
		}],
		enableHeaderClickMenu: false
	});
    loadDatagrid();
}
/**
 * 加载列表信息
 * @param otherParams
 */
function loadDatagrid(otherParams){
	var params={};
	if(otherParams != undefined){
		$.extend(params,otherParams);
	}
	var url = purl+'${beanNameLower}Manager.dh?key=query${beanName}';
	bpms.bindService2DataGrid("${beanNameLower}Grid", url, params);
	bpms.refreshDataGrid("${beanNameLower}Grid", null, true);
}
/**
 * 打开添加窗口
 */
function openAdd${beanName}() {
	 $('#addDlg').dialog({
			title: '新增',
			modal:true
		});
	   $('#addDlg').dialog('open');
	   $("#fm${beanName}").form("clear");
}
/**
 * 打开编辑窗口
 */
function openEdit${beanName}() {
    var rows = $("#${beanNameLower}Grid").datagrid("getSelections");
    if (null !=rows && rows.length>0) {
    	if(rows.length>1){
    		$.messager.alert("提示信息","请选择其中一条数据进行操作","warning");
    		return;
    	}
    	var row = rows[0];
    	$('#addDlg').dialog({
			title: '修改',
			modal:true
		});
    	$('#addDlg').dialog('open');
        $("#fm${beanName}").form("clear");
        $("#fm${beanName}").form("load", row);
    }
    else
    {
    	$.messager.alert("提示信息","请先选择要操作的对象","warning");
    }
}
/**
 * 提交数据
 * @param form
 */
function saveOrUpdate${beanName}() {
    if( $("#fm${beanName}").form("validate")){
    	var url = "";
    	var params = bpms.serializeObject($("#fm${beanName}"));
    	var id = params.ID;
    	if(bpms.isEmpty(id)){
    		url = purl+'${beanNameLower}Manager.dh?key=add${beanName}';
    	}else{
    		url = purl+'${beanNameLower}Manager.dh?key=update${beanName}';
    	}
    	bpms.requestService(url,params,function(data){
			if (data.result == "exists") {
//				$.messager.alert("提示信息", "该条信息已经存在,请修改关键字");
				$.messager.alert("提示信息", "编码重复，不允许提交！","warning");
			} else if (data.result > 0) {
				$.messager.alert("提示信息", "操作成功","info");
				$("#addDlg").dialog("close");
				loadDatagrid();
			} else {
				$.messager.alert("提示信息", "操作失败","error");
			}
		});
	}
}	
/**
 * 删除数据
 */
function delete${beanName}() {
   var rows = $('#${beanNameLower}Grid').datagrid('getSelections');
    if (null != rows && rows.length>0) {
        $.messager.confirm('警告', '确认删除所选信息内容?', function (r) {
            if (r) {
            	var ids =[];
            	for (var i = 0; i < rows.length; i++) {
            		ids.push(rows[i].ID);
            	}
				bpms.requestService(purl+'${beanNameLower}Manager.dh?key=delete${beanName}', {IDS: ids.join(",")}, function(data){
					if(data.result>0){
						$.messager.alert("提示信息", "总共"+rows.length+"条，成功"+data.result+"条","info");
					}
				}, null, false);
			}
        	loadDatagrid();
        });
    } else {
    	$.messager.alert("提示信息","请先选择要操作的对象","warning");
    }
}  
/**
 * 查询数据
 * @param value
 * @param names
 */
function doSearch(){
	if ($('#search_fm${beanName}').form('validate')) {
		loadDatagrid(bpms.serializeObject($("#search_fm${beanName}")));
	}
}
/**
 * 清空查询内容
 */
function clearSearch(){
	$('#search_fm${beanName}').form('clear');
	loadDatagrid();
}
