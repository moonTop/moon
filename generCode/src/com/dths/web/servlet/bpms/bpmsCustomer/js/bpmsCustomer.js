$(document).ready( function() {
	$("#search_fmBpmsCustomer").bind('keyup',function(event){
	    event=document.all?window.event:event;
	    if((event.keyCode || event.which)==13){
	    	doSearch();
	    }
    });
	initDatagrid();
});

function initDatagrid(){
    $('#bpmsCustomerGrid').datagrid({
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
			 {title : '客户专员',field : 'KHZY',sortable : false,width : 100,align : 'center'},
			 {title : '客户专员ID',field : 'KHZYID',sortable : false,width : 100,align : 'center'},
			 {title : '公司简称',field : 'GSJC',sortable : false,width : 100,align : 'center'},
			 {title : '公司全称',field : 'GSQC',sortable : false,width : 100,align : 'center'},
			 {title : '常用联系人',field : 'CYLXR',sortable : false,width : 100,align : 'center'},
			 {title : '公司法人',field : 'GSFR',sortable : false,width : 100,align : 'center'},
			 {title : '公司地址',field : 'GSDZ',sortable : false,width : 100,align : 'center'},
			 {title : '公司注册地址',field : 'GSZCDZ',sortable : false,width : 100,align : 'center'},
			 {title : '营业执照',field : 'YYZZ',sortable : false,width : 100,align : 'center'},
			 {title : '营业执照号',field : 'YYZZH',sortable : false,width : 100,align : 'center'},
			 {title : '税务登记证',field : 'SWDJZ',sortable : false,width : 100,align : 'center'},
			 {title : '客户开户银行',field : 'KHKHYH',sortable : false,width : 100,align : 'center'},
			 {title : '客户银行账号',field : 'KHYHZH',sortable : false,width : 100,align : 'center'},
			 {title : '手机号码',field : 'SJHM',sortable : false,width : 100,align : 'center'},
			 {title : '公司法人地址',field : 'GSFRDZ',sortable : false,width : 100,align : 'center'},
			 {title : '经营范围',field : 'JYFW',sortable : false,width : 100,align : 'center'},
			 {title : '电话座机',field : 'GSZJ',sortable : false,width : 100,align : 'center'},
			 {title : '传真',field : 'CZHM',sortable : false,width : 100,align : 'center'},
			 {title : '税务登记号',field : 'SWDJH',sortable : false,width : 100,align : 'center'},
			 {title : '公司全称简拼',field : 'GSQCJP',sortable : false,width : 100,align : 'center'},
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
				openAddBpmsCustomer();
			}
		},'-',{
			text : '编辑',
			iconCls : 'icon-edit',
			plain:true,
			handler : function() {
				openEditBpmsCustomer();
			}
		},'-',{
			text : '删除',
			iconCls : 'icon-remove',
			plain:true,
			handler : function() {
				deleteBpmsCustomer();
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
	var url = purl+'bpmsCustomerManager.dh?key=queryBpmsCustomer';
	bpms.bindService2DataGrid("bpmsCustomerGrid", url, params);
	bpms.refreshDataGrid("bpmsCustomerGrid", null, true);
}
/**
 * 打开添加窗口
 */
function openAddBpmsCustomer() {
	 $('#addDlg').dialog({
			title: '新增',
			modal:true
		});
	   $('#addDlg').dialog('open');
	   $("#fmBpmsCustomer").form("clear");
}
/**
 * 打开编辑窗口
 */
function openEditBpmsCustomer() {
    var rows = $("#bpmsCustomerGrid").datagrid("getSelections");
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
        $("#fmBpmsCustomer").form("clear");
        $("#fmBpmsCustomer").form("load", row);
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
function saveOrUpdateBpmsCustomer() {
    if( $("#fmBpmsCustomer").form("validate")){
    	var url = "";
    	var params = bpms.serializeObject($("#fmBpmsCustomer"));
    	var id = params.ID;
    	if(bpms.isEmpty(id)){
    		url = purl+'bpmsCustomerManager.dh?key=addBpmsCustomer';
    	}else{
    		url = purl+'bpmsCustomerManager.dh?key=updateBpmsCustomer';
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
function deleteBpmsCustomer() {
   var rows = $('#bpmsCustomerGrid').datagrid('getSelections');
    if (null != rows && rows.length>0) {
        $.messager.confirm('警告', '确认删除所选信息内容?', function (r) {
            if (r) {
            	var ids =[];
            	for (var i = 0; i < rows.length; i++) {
            		ids.push(rows[i].ID);
            	}
				bpms.requestService(purl+'bpmsCustomerManager.dh?key=deleteBpmsCustomer', {IDS: ids.join(",")}, function(data){
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
	if ($('#search_fmBpmsCustomer').form('validate')) {
		loadDatagrid(bpms.serializeObject($("#search_fmBpmsCustomer")));
	}
}
/**
 * 清空查询内容
 */
function clearSearch(){
	$('#search_fmBpmsCustomer').form('clear');
	loadDatagrid();
}
