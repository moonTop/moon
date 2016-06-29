<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<form id="pagerForm" method="post" action="BK1001/application.do">
    <input type="hidden" name="pageNum" value="1" />
    <input type="hidden" name="orderField" value="" />
    <input type="hidden" name="orderDirection" value="asc" />
</form>

<div class="pageHeader">
<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="BK1001/application.do" method="post">
    <input type="hidden" id="numPerPage" name="numPerPage" value="${page.numPerPage}">
    <div class="searchBar">
        <div class="titleBar">
            <div class="navTitle">客户管理/</div><div class="pageTitle">在线申请信息管理</div>
        </div>
        <div class="pageFormContent">
            <label>用户ID：</label><input type="text" name="userid" value="" />
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
            <li><a class="add" href="BK1001/add.do" title="添加用户" target="dialog" width="600" height="400" rel="BK400101"><span>添加</span></a></li>
            <li><a class="edit" href="BK1001/edit/{id}.do" title="修改用户" target="dialog" width="600" height="400" rel="BK400101"><span>修改</span></a></li>
            <li><a class="delete" href="BK1001/remove.do?id={id}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
            <li><a class="edit" href="BK1001/roleallot.do?id={id}" title="角色分配" target="dialog" width="600" height="400" rel="BK400102"><span>角色分配</span></a></li>
            <li><a class="edit" href="BK1001/resetpassword.do?id={id}" target="ajaxTodo" title="确定要重置密码?"><span>重置密码</span></a></li>
        </ul>
    </div>
    <table id="gridTable" class="table" width="100%" layoutH="194">
        <thead>
            <tr>
                <th style="font-weight:bold; text-align: center;"  width="50">序号</th>
				<th style="font-weight:bold; text-align: center;" width="100" style="font-weight:bold;">姓名</th>
				<th style="font-weight:bold; text-align: center;" width="100" style="font-weight:bold;">手机号码</th>
				<th style="font-weight:bold; text-align: center;" width="100" style="font-weight:bold;">Email</th>
				<th style="font-weight:bold; text-align: center;" width="100" style="font-weight:bold;">贷款额度</th>
                <th style="font-weight:bold; text-align: center;" width="100" style="font-weight:bold;">出生年月</th>
                <th style="font-weight:bold; text-align: center;" width="100" style="font-weight:bold;">是否已贷款</th>
                <th style="font-weight:bold; text-align: center;" width="100" style="font-weight:bold;">状态</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="monline" items="${page.resultList}" varStatus="status">
            <tr target="id" rel="${monline.id}">
                <td align="center">${status.index+1}</td>
                <td align="center">${monline.username}</td>
                <td align="center">${monline.mobile}</td>
                <td align="center">${monline.email}</td>
                <td align="center">${monline.loanamount}</td>
                <td align="center">${monline.birthday}</td>
                <td align="center">${monline.isloaned}</td>
                <td align="center">
                	<c:choose>
                		<c:when test="${monline.status == 1}">可用</c:when>
                		<c:otherwise>不可用</c:otherwise>
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