<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<form id="pagerForm" method="post" action="BK4005/logList.do">
    <input type="hidden" name="pageNum" value="1" />
    <input type="hidden" name="orderField" value="" />
    <input type="hidden" name="orderDirection" value="asc" />
</form>

<div class="pageHeader">
<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="BK4005/logList.do" method="post">
    <input type="hidden" id="numPerPage" name="numPerPage" value="${page.numPerPage}">
    <div class="searchBar">
        <div class="titleBar">
            <div class="navTitle">系统日志/</div><div class="pageTitle">日志列表</div>
        </div>
        <div class="pageFormContent">
            <tr>
                <label>模块名称：</label><input type="text" name="modulename" value="${model.modulename}" />
                <label>操作类型：</label><input type="text" name="opstyle" value="${model.opstyle}" />
                <label>操作内容：</label><input type="text" name="opcontent" value="${model.opcontent}" />
            </tr>
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
            <li class="line">line</li>
        </ul>
    </div>
    <table id="gridTable" class="table" width="100%" layoutH="194">
        <thead>
            <tr>
                <th width="50" style="font-weight:bold;">序号</th>
                <th style="font-weight:bold; text-align: center;"  width="100" >模块名称</th>
				<th style="font-weight:bold; text-align: center;" width="100" style="font-weight:bold;">操作类型</th>
                <th style="font-weight:bold; text-align: center;" width="200" style="font-weight:bold;">操作内容</th>
                <th style="font-weight:bold; text-align: center;" width="100" style="font-weight:bold;">操作员</th>
                <th style="font-weight:bold; text-align: center;" width="100" style="font-weight:bold;">操作时间</th>
                <th style="font-weight:bold; text-align: center;" width="100" style="font-weight:bold;">IP地址</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="mlog" items="${page.resultList}" varStatus="status">
            <tr target="id" rel="${mlog.id}">
                <td align="center">${status.index+1}</td>
                <td align="center">${mlog.modulename}</td>
                <td align="center">${mlog.opstyle}</td>
                <td align="center">${mlog.opcontent}</td>
                <td align="center">${mlog.opperson}</td>
                <td align="center">${mlog.formattedOptime}</td>
                <td align="center">${mlog.ip}</td>
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