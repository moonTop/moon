<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv=Content-Type content="text/html; charset=utf-8">
<title>[@title]</title>
<meta http-equiv="X-UA-Compatible" content="IE=8">
<script src="../../commons/jsloader.js" type="text/javascript"></script>
<script src = "../../commons/bpms_commonjsloader_custom.jsp"  type="text/javascript"></script>
<script src="js/${beanNameLower}.js" type="text/javascript"></script>
</head>
<body>
<div align="left" class="title">
	<div class="title1"><img src="../../../../bpms/images/lm0.png" />&nbsp;${tableRemark}管理</div>
</div>
<table align="center" border="0" cellpadding="0" cellspacing="0" width="98%">
    <tr>
        <td width="98%" colspan="2">
            <div>
            	<table cellpadding="0" cellspacing="0" style="width:100%">
							<tr>
								<td style="text-align:right;">
									 <form id="search_fm${beanName}" method="post">
										<div id="search_div" class="easyui-panel" style="margin-bottom:5px;padding:5px" data-options="title:'查询面板',iconCls:'icon-search',collapsible:true,collapsed:false">
								    		<fieldset style="border: 1px solid #ccc;">
								    		<legend style="color:red;">可查询选项(可组合)</legend>
											<table  class="table table-hover table-bordered table-condensed table-striped table-form table-search">
												<colgroup>
													<col width="15%" />
													<col width="35%" />
													<col width="15%" />
													<col width="35%" />
												</colgroup>
												<tbody>
													<#assign  num=0>
													<#list fields as field>
													<#if num=0>
													<tr>
													</#if>
													<#assign  num=num+1>
														<td>
															${field.remark}:
														</td>
														<td>
															<#if field.fieldType=="String" && field.fieldLength !="2" && field.fieldName !="CREATEDATE" && field.fieldName !="CREATEUSER" && field.fieldName !="UPDATEDATE" && field.fieldName !="UPDATEUSER">
																<input id="SEARCH_${field.fieldName}" name="SEARCH_${field.fieldName}" type="text" class="easyui-validatebox" data-options="required:false,validType:'isString'" />
															<#else>
																<input id="SEARCH_${field.fieldName}" name="SEARCH_${field.fieldName}" type="text" class="easyui-validatebox" data-options="required:false" />
															</#if>
														</td>
													<#if num==2>
													<#assign  num=0>
													</tr>
													</#if>
													</#list>
													<#if num!=2 && num !=0>
													</tr>
													</#if>
												</tbody>
												<tfoot>
													<tr>
														<td colspan="4" align="right">
															<div>
																<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="doSearch()">查询</a>
																<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="clearSearch()">重置</a>
															</div>
														</td>
													</tr>
												</tfoot>
											</table>
											</fieldset>
											</div>
										</form>
								</td>
							</tr>
				</table>
                <table id="${beanNameLower}Grid"></table>
            </div>
        </td>
    </tr>
</table>
<div id="addDlg" class="easyui-dialog" style="width:700px;height:330px;padding:10px 20px"
		closed="true" buttons="#dlg-buttons2" iconCls="icon-add" title="">
	<form id="fm${beanName}" method="post">
		<input id="ID" name="ID" type="hidden"/>
		<table class="table table-hover table-bordered table-condensed table-striped table-form">
			<colgroup>
				<col width="15%" />
				<col width="35%" />
				<col width="15%" />
				<col width="35%" />
			</colgroup>
			<tbody>
				<#assign  num=0>
				<#list fields as field>
				<#if num=0>
				<tr>
				</#if>
				<#assign  num=num+1>
					<td>
						${field.remark}:
					</td>
					<td>
						<#if field.fieldType=="String" && field.fieldLength !="2" && field.fieldName !="CREATEDATE" && field.fieldName !="CREATEUSER" && field.fieldName !="UPDATEDATE" && field.fieldName !="UPDATEUSER">
							<input id="${field.fieldName}" name="${field.fieldName}" type="text" class="easyui-validatebox" data-options="required:false,validType:'isString'" missingMessage="${field.remark}为必输项" maxlength="${field.fieldLength}" />
						<#else>
							<input id="${field.fieldName}" name="${field.fieldName}" type="text" class="easyui-validatebox" data-options="required:false" />
						</#if>
					</td>
				<#if num==2>
				<#assign  num=0>
				</tr>
				</#if>
				</#list>
				<#if num!=2 && num !=0>
				</tr>
				</#if>
			</tbody>
		</table>
	</form>
</div>
<div id="dlg-buttons2">
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onClick="saveOrUpdate${beanName}()">确认</a>
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onClick="javascript:$('#addDlg').dialog('close')">取消</a>
</div>

<input id="pageId" type="hidden" value="${beanName}"></input>
</body>
</html>