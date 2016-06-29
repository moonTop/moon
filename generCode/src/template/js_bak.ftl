function pageInit(){
	//datagrid
	initDatagrid();
}

//高度计算
function getHeight(){
	return $(window).height()*0.77;
};

function initDatagrid(){
    $('#${beanName}').datagrid({
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
			 {title : '${field.remark}',field : '${field.fieldName}',sortable : true,width : 100,align : 'center'}<#if field_has_next>,</#if>
		    </#if>
			</#list>
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
		enableHeaderClickMenu: true
	});
    loadDatagrid();
}
function loadDatagrid(otherParams){
	var params={};
	if(otherParams != undefined){
		extend(params,otherParams);
	}
	var url = purl+'co${beanName}Manager.dh?key=query${beanName}s&username='+$('#currentusername').val();
	MyUtility.bindService2DataGrid("${beanName}", url, params);
	MyUtility.refreshDataGrid("${beanName}", null, true);
}
var ${beanName}OprUrl;

function openAdd${beanName}() {
	 $('#addDlg').dialog({
			title: '新增',
			modal:true
		});
	   $('#addDlg').dialog('open');
	   $("#fm${beanName}")[0].reset();
       ${beanName}OprUrl = purl+'co${beanName}Manager.dh?key=add${beanName}&username='+$("#currentusername").val();
}
function openEdit${beanName}() {
    var rows = $("#${beanName}").datagrid("getSelections");
    if (null !=rows && rows.length>0) {
    	if(rows.length>1){
    		$.messager.alert("提示信息","请选择其中一条数据进行操作");
    		return;
    	}
    	var row = rows[0];
    	$('#addDlg').dialog({
			title: '修改',
			modal:true
		});
    	$('#addDlg').dialog('open');
        $("#fm${beanName}")[0].reset();
        $("#fm${beanName}").form("load", row);
        ${beanName}OprUrl = purl+'co${beanName}Manager.dh?key=edit${beanName}&username='+$("#currentusername").val();
    }
    else
    {
    	$.messager.alert("提示信息","请先选择要操作的对象");
    }
}
function saveOrUpdate${beanName}(form) {
        if( $("#fm${beanName}").form("validate")){
		  $("#fm${beanName}").form("submit", {
	            url: ${beanName}OprUrl,
	            success: function (data) {
	            	if(data&&JSON.parse(data)&&JSON.parse(data).result=="exists"){
	            		$.messager.alert("提示信息", "该条信息已经存在,请修改关键字");
	            	}
	            	else if (data&&JSON.parse(data)&&JSON.parse(data).result >0) {
	                    $.messager.alert("提示信息", "操作成功");
	                    $("#addDlg").dialog("close");
	                   
	                    loadDatagrid();
	                }
	                else {
	                    $.messager.alert("提示信息", "操作失败");
	                    
	                }
	            }
	        });
	}
}	
function delete${beanName}() {
   var rows = $('#${beanName}').datagrid('getSelections');
    if (null != rows && rows.length>0) {
        $.messager.confirm('警告', '确认删除所选信息内容?', function (r) {
            if (r) {
            	var resultCount=0;
            	for (var i = 0; i < rows.length; i++) {
					var row = rows[i];
					MyUtility.requestService(purl+'co${beanName}Manager.dh?key=delete${beanName}&username='+$("#currentusername").val(), {ID: row.ID}, function(data){
						if(data.result>0){
							resultCount = resultCount+1;
						}
					}, null, false);
				}
            	$.messager.alert("提示信息", "总共"+rows.length+"条，成功"+resultCount+"条");
            	loadDatagrid();
            }
        });
    } else {
    	$.messager.alert("请先选择要操作的对象");
    }
}  
function doSearch(value,names){
	loadDatagrid({queryWord : value});
}
//上传照片
function add(id){
	$('#uploadDiv').dialog('open');
	$('#iframepage').attr('src','../upload/uploadFile.jsp?input='+id+'');
}
