<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<style>
.clearfix {
	*zoom: 1;
}

.clearfix:after {
	content: "\200B";
	display: block;
	height: 0;
	clear: both;
	overflow: hidden;
	visibility: hidden;
}
</style>
<div class="pageContent" >
	<form id="BK400301Form" method="post" action="BK4003/saveAssignment.do"	class="pageForm required-validate"	onsubmit="return validateCallback(this, dialogAjaxDone);">
        <input type="hidden" id="navTabId" name="navTabId" value="" />
        <input type="hidden" id="id" name="id" value="${id}" />
		<div class="pageFormContent" layoutH="56" style="background-color:#F0F0F0">
			<div class="clearfix" style="padding:0em 0em 0em 2em;">
				<div id="leftDiv" style="width: 35%; height: 20em; border: #828790 solid 1px; float: left; overflow-y:auto;background-color:white;">
					<div style="">
						<table cellspacing="0" cellpadding="0" class="searchRstTB">
							<thead>
								<tr>
								    <td class="theadTd" style="width:1%;height:20%">&nbsp;</td>
									<td class="theadTd" style="width:20%;height:20%"></td>
								</tr>
							</thead>
							<tbody id="srcTbody">
								<c:forEach var="fmodule"  items="${model}" varStatus="status">
									<tr  style="cursor: pointer;" class="srcTr" id="${fmodule.modname}" onclick="addClk(this)">
									    <td class="tbodyTd" style="width:1%;height:20px"><span style="display:none;" ><input id="${fmodule.id}" name="chkSel"  type="checkbox" value="${fmodule.id}"></span></td>
										<td class="tbodyTd" style="width:1%;height:20px"><span style="height:2%" class="srcText">${fmodule.modname}</span></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>				
				</div>
				<div style="width: 25%; height: 20em; float: left; line-height: 20em; text-align: center;">
					<div style="margin-top:2em"><img alt="" src="${contextPath}/imgs/add.jpg" onclick="addModule()"></div>
					<div style="margin-top:1em" ><img alt="" src="${contextPath}/imgs/addAll.jpg" onclick="addAllModule()"></div>
					<div style="margin-top:3em"><img alt="" src="${contextPath}/imgs/remove.jpg" onclick="removeModule()"></div>
					<div style="margin-top:1em" ><img alt="" src="${contextPath}/imgs/removeAll.jpg" onclick="removeAllModule()"></div>
				</div>
				<div id="rightDiv" 
					style="width: 35%; height: 20em; border: #828790 solid 1px; float: left;overflow-y:auto;background-color:white;">
					<div style="">
						<table cellspacing="0" cellpadding="0" class="searchRstTB">
							<thead>
								<tr>
								    <td class="theadTd" style="width:1%;height:20%">&nbsp;</td>
									<td class="theadTd" style="width:20%;height:20%"></td>
								</tr>
							</thead>
							<tbody id="tarTbody">
								<c:forEach var="existfmodule"  items="${existLst}" varStatus="status">
									<tr  style="cursor: pointer;" class="tarTr" id="${existfmodule.modname}" onclick="addClk(this)">
									    <td class="tbodyTd" style="width:1%;height:20px"><span style="display:none;" ><input id="${existfmodule.id}" name="chkSelId"  type="checkbox" value="${existfmodule.id}"></span></td>
										<td class="tbodyTd" style="width:1%;height:20px"><span style="height:2%">${existfmodule.modname}</span></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>	
				</div>

			</div>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="button" onclick="submitForm()">保存</button>
						</div>
					</div></li>
				<li>
					<div class="button">
						<div class="buttonContent">
							<button type="button" class="close">取消</button>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</form>
</div>
<script type="text/javascript">
$("#navTabId")
.val(navTab._getTabs().eq(navTab._currentIndex).attr("tabid"));
    function submitForm(){
		$('.tarTr').find(":checkbox").attr("checked", true);
		$('.srcTr').find(":checkbox").attr("checked", false);
		$("#BK400301Form").submit();
    }
	function addClk(objSrc) {
		var obj = $(objSrc).find(":checkbox");
		var chk = obj.is(':checked');
		if (chk == false) {
			obj.attr("checked", true);
			$(objSrc).css("background-color","#DFE8F6");
		} else {
			obj.attr("checked", false);
			$(objSrc).css("background-color","white");
		}
	};
	function removeClk(objTar) {
		var obj = $(objTar).find(":checkbox");
		var chk = obj.is(':checked');
		if (chk == false) {
			obj.attr("checked", true);
			$(objTar).css("background-color","#DFE8F6");
		} else {
			obj.attr("checked", false);
			$(objTar).css("background-color","white");
	    }
	};
	function addModule(){
		$('.srcTr').each(function(){
			var modName = $(this).attr('id');
			var obj = $(this).find(":checkbox");
			var chk = obj.is(':checked');
			if (chk == true) {
				$(this).remove();
				var $tr = $("<tr style='cursor: pointer;' class='tarTr' id="+ modName+" onclick='removeClk(this)' >");
				var $td = $("<td class='tbodyTd' style='width:1%;height:20px'>");
				var $spanTd1 = $("<span style='display:none;' >");
				var $spanTd1Chk = $("<input id="+obj.attr('id')+" name='chkSelId' type='checkbox' value="+obj.attr('id')+" />");
				$("#tarTbody").append($tr);
				$tr.append($td);
				$td.append($spanTd1);
				$spanTd1.append($spanTd1Chk);
				var $td1 = $("<td class='tbodyTd' style='width:1%;height:20px'>");
				$tr.append($td1);
				var $spanTd2 = $("<span style='height:2%'>");
				$td1.append($spanTd2);
				$spanTd2.append(modName);
			}
		})
	};
	
	function addAllModule(){
		$('.tarTr').find(":checkbox").attr("checked", true);
		removeModule();
		$('.srcTr').find(":checkbox").attr("checked", true);
		addModule();
	}
	function removeModule(){
		$('.tarTr').each(function(){
			var modName = $(this).attr('id');
			var obj = $(this).find(":checkbox");
			var chk = obj.is(':checked');
			if (chk == true) {
				$(this).remove();
				var $tr = $("<tr style='cursor: pointer;' class='srcTr' id="+ modName+" onclick='addClk(this)' >");
				var $td = $("<td class='tbodyTd' style='width:1%;height:20px'>");
				var $spanTd1 = $("<span style='display:none' >");
				var $spanTd1Chk = $("<input id="+obj.attr('id')+" name='chkSel' type='checkbox' value="+obj.attr('id')+" />");
				$("#srcTbody").append($tr);
				$tr.append($td);
				$td.append($spanTd1);
				$spanTd1.append($spanTd1Chk);
				var $td1 = $("<td class='tbodyTd' style='width:1%;height:20px'>");
				$tr.append($td1);
				var $spanTd2 = $("<span style='height:2%'>");
				$td1.append($spanTd2);
				$spanTd2.append(modName);
			}
		})
	};	
	function removeAllModule(){
		$('.srcTr').find(":checkbox").attr("checked", true);
		addModule();
		$('.tarTr').find(":checkbox").attr("checked", true);
		removeModule();
	}

</script>