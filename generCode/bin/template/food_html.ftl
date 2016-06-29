<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv=Content-Type content="text/html; charset=utf-8">
<title>[@title]</title>
<meta http-equiv="X-UA-Compatible" content="IE=8">
<script src="../../dths_js/js/commons/jsloader.js" type="text/javascript"></script>
<script src = "../js/common/foods_commonjsloader.jsp"  type="text/javascript"></script>
<script src="../js/${beanNameLower}/${beanNameLower}.js" type="text/javascript"></script>
	<script type="text/javascript">
    $(document).ready( function() {
		pageInit();
    });
  </script>
</head>
<body>
<table align="center" border="0" cellpadding="0" cellspacing="0" width="98%">
    <tr>
        <td>
            <div align="left" class="title" style="margin-left: 5px">${tableRemark}管理</div>
        </td>
    </tr>
    <tr>
        <td colspan="2"><hr color="#0000ff"  size="1"/></td>
    </tr>
    <tr>
        <td width="98%" colspan="2">
            <div>
            	<table cellpadding="0" cellspacing="0" style="width:100%">
							<tr>
								<td style="text-align:right;padding-right:2px">
									 <input id="queryWord" class="easyui-searchbox" data-options="prompt:'请输入查询关键字',searcher:doSearch" style="width:150px">
								</td>
							</tr>
				</table>
                <table id="${beanNameLower}_grid"></table>
            </div>
        </td>
    </tr>
</table>
<div id="addDlg" class="easyui-dialog" style="width:380px;height:330px;padding:10px 20px"
		closed="true" buttons="#dlg-buttons2" iconCls="icon-add" title="">
	<div class="ftitle">${tableRemark}属性</div>
	<form id="fm${beanName}" method="post">
		<input id="ID" name="ID" type="hidden"/>
		<table class="table" style="width: 100%;">
			<#assign  num=0>
			<#list fields as field>
			<#if num=0>
			<tr>
			</#if>
			<#assign  num=num+1>
				<td>
				<div class="fitem">
					<label>${field.remark}:</label>
					<#if field.fieldType=="String" && field.fieldLength !="2" && field.fieldName !="CREATEDATE" && field.fieldName !="CREATEUSER" && field.fieldName !="UPDATEDATE" && field.fieldName !="UPDATEUSER">
						<input id="${field.fieldName}" name="${field.fieldName}" type="text" class="easyui-validatebox" data-options="required:true" missingMessage="${field.remark}为必输项" maxlength="${field.fieldLength}" />
					<#else>
						<input id="${field.fieldName}" name="${field.fieldName}" type="text" class="easyui-validatebox" data-options="required:true" />
					</#if>
				</div>
				</td>
			<#if num==2>
			<#assign  num=0>
			</tr>
			</#if>
			</#list>
			<#if num!=2>
			</tr>
			</#if>
		</table>
	</form>
</div>
<div id="dlg-buttons2">
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onClick="saveOrUpdate${beanName}(fm${beanName})">确认</a>
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onClick="javascript:$('#addDlg').dialog('close')">取消</a>
</div>

<input id="pageId" type="hidden" value="${beanName}"></input>
<input id="currentLoginName" type="hidden" value="<${'#'}userName>"></input>
<input id="currentusername" type="hidden" value="<${'#'}uid>"></input>
</body>
</html>