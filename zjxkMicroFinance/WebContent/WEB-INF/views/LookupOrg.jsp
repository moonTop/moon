<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<form id="pagerForm" action="Lookup/org.do">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="orderField" value="" />
	<input type="hidden" name="orderDirection" value="asc" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="Lookup/org.do" onsubmit="return dwzSearch(this, 'dialog');">
        <input type="hidden" id="numPerPage" name="numPerPage" value="${page.numPerPage}">
	</form>
</div>
<div class="pageContent">
	<table class="table" layoutH="60" targetType="dialog" width="100%">
		<thead>
			<tr>
			    <th style="font-weight:bold; text-align: center;"  width="50">序号</th>
				<th style="font-weight:bold; text-align: center;" width="100">部门编码</th>
				<th style="font-weight:bold; text-align: center;" width="100">部门名称</th>
				<th style="font-weight:bold; text-align: center;" width="50">选择</th>
			</tr>
		</thead>
		<tbody>
            <c:forEach var="org" items="${page.resultList}" varStatus="status">
            <tr>
                <td align="center">${status.index+1}</td>
                <td align="center">${org.orgno}</td>
                <td align="center">${org.orgname}</td>
                <td>
                    <a class="btnSelect" href="javascript:$.bringBack({id:'${org.id}', orgno:'${org.orgno}', orgname:'${org.orgname}'})" title="查找带回">选择</a>
                </td>
            </tr>
            </c:forEach>
		</tbody>
	</table>

    <div class="panelBar">
        <div class="pages">
            <span>显示</span>
            <select class="combox" name="numPerPage" onchange="dwzPageBreak({targetType:'dialog', data:{numPerPage:this.value}})">
                <option value="10">10</option>
                <option value="20">20</option>
                <option value="100">100</option>
                <option value="200">200</option>
            </select>
            <span>条，共${page.totalCount}条</span>
        </div>
        <div class="pagination" targetType="dialog" totalCount="${page.totalCount}" numPerPage="${page.numPerPage}" pageNumShown="10" currentPage="${page.pageNum}"></div>
    </div>
</div>
<script type="text/javascript">
    $.pdialog.getCurrent().find("select[name='numPerPage'] option[value='${page.numPerPage}']").attr("selected",true);
</script>