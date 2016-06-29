<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<form id="pagerForm" method="post" action="BK1004/carloanList.do">
    <input type="hidden" name="pageNum" value="1" />
    <input type="hidden" name="orderField" value="" />
    <input type="hidden" name="orderDirection" value="asc" />
</form>

<div class="pageHeader">
<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="BK1004/carloanList.do" method="post">
    <input type="hidden" id="numPerPage" name="numPerPage" value="${page.numPerPage}">
    <div class="searchBar">
        <div class="titleBar">
            <div class="navTitle">客户管理/</div><div class="pageTitle">车宜贷客户信息</div>
        </div>
        <div class="pageFormContent">
            <label>申请人姓名：</label><input type="text" name="name" value="${model.name}" />
        </div>
        <div class="subBar">
            <ul>
                <li><div class="buttonActive"><div class="buttonContent"><button type="submit">查&nbsp;&nbsp;询</button></div></div></li>
            </ul>
        </div>
    </div>
    </form>
</div>
<div class="pageContent">
    <div class="panelBar">
        <ul class="toolBar">
            <li><a class="edit" href="BK1004/edit/{id}.do" title="修改用户" target="dialog" width="600" height="400" rel="BK100401"><span>修改</span></a></li>
        </ul>
    </div>
    <table id="gridTable" class="table" width="100%" layoutH="194">
        <thead>
            <tr>
                <th style="font-weight:bold; text-align: center;"  width="50">序号</th>
				<th style="font-weight:bold; text-align: center;" width="100" style="font-weight:bold;">申请人姓名</th>
				<th style="font-weight:bold; text-align: center;" width="100" style="font-weight:bold;">手机号码</th>
                <th style="font-weight:bold; text-align: center;" width="100" style="font-weight:bold;">贷款金额</th>
                <th style="font-weight:bold; text-align: center;" width="100" style="font-weight:bold;">车辆购置价格</th>
                <th style="font-weight:bold; text-align: center;" width="100" style="font-weight:bold;">申请日期</th>
                <th style="font-weight:bold; text-align: center;" width="100" style="font-weight:bold;">状态</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="carloan" items="${page.resultList}" varStatus="status">
            <tr target="id" rel="${carloan.id}">
                <td align="center">${status.index+1}</td>
                <td align="center">${carloan.name}</td>
                <td align="center">${carloan.phone}</td>
                <td align="center">${carloan.loanamount}</td>
                <td align="center">${carloan.carprice}</td>
                <td align="center"><fmt:formatDate value='${carloan.applydate}' pattern='yyyy-MM-dd' /></td>
                <td align="center">
                	<c:choose>
                		<c:when test="${carloan.status == 0}">未处理</c:when>
                		<c:otherwise>已处理</c:otherwise>
                	</c:choose>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="panelBar">
        <div class="pages">
            <span>显示</span>
            <select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
                <option value="20">20</option>
                <option value="30">30</option>
                <option value="100">100</option>
                <option value="200">200</option>
            </select>
            <span>条，共${page.totalCount}条</span>
        </div>
        
        <div class="pagination" targetType="navTab" totalCount="${page.totalCount}" numPerPage="${page.numPerPage}" pageNumShown="10" currentPage="${page.pageNum}"></div>
    </div>
</div>
<script type="text/javascript">
    navTab.getCurrentPanel().find("select[name='numPerPage'] option[value='${page.numPerPage}']").attr("selected",true);
</script>