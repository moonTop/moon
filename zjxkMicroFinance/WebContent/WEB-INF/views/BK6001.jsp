<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<form id="pagerForm" method="post" action="BK6001/todoList.do">
    <input type="hidden" name="pageNum" value="1" />
</form>

<div class="pageHeader">
<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="BK6001/todoList.do" method="post">
    <input type="hidden" id="numPerPage" name="numPerPage" value="${page.numPerPage}">
    <div class="searchBar">
        <div class="titleBar">
            <div class="navTitle">任务管理/</div><div class="pageTitle">待办列表</div>
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
            <li><a class="edit" href="BK6001/approval/{taskId}.do" title="任务处理" target="navTab" rel="BK6001"><span>任务处理</span></a></li>
            <li><a class="edit" href="BK6001/viewflow/{taskId}.do" title="流程图" target="dialog" rel="BK6001" width="800" height="600"><span>查看流程图</span></a></li>
        </ul>
    </div>
    <table id="gridTable" class="table" width="100%" layoutH="153">
        <thead>
            <tr>
                <th width="50" style="font-weight:bold;">序号</th>
                <th width="200" style="font-weight:bold;">流程名称</th>
				<th width="200" style="font-weight:bold;">任务名称</th>
				<th width="200" style="font-weight:bold;">创建时间</th>
				<th width="200" style="font-weight:bold;">任务状态</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="taskBean" items="${tasks}" varStatus="status">
            <tr target="taskId" rel="${taskBean.taskId}">
                <td align="center">${status.index+1}</td>
                <td>${taskBean.processName}[${taskBean.processInstanceId}]</td>
                <td>${taskBean.taskName}</td>
                <td>${taskBean.createTime}</td>
                <td>${taskBean.taskStatus}</td>
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