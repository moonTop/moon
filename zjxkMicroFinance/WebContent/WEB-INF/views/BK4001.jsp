<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<form id="pagerForm" method="post" action="BK4001/list.do">
    <input type="hidden" name="pageNum" value="1" />
    <input type="hidden" name="orderField" value="" />
    <input type="hidden" name="orderDirection" value="asc" />
</form>

<div class="pageHeader">
<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="BK4001/list.do" method="post">
    <input type="hidden" id="numPerPage" name="numPerPage" value="${page.numPerPage}">
    <div class="searchBar">
        <div class="titleBar">
            <div class="navTitle">用户管理/</div><div class="pageTitle">后台用户列表</div>
        </div>
        <div class="pageFormContent">
            <label>用户ID：</label><input type="text" name="userid" value="${model.userid}" />
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
            <li><a class="add" href="BK4001/add.do" title="添加用户" target="dialog" width="600" height="400" rel="BK400101"><span>添加</span></a></li>
            <li><a class="edit" href="BK4001/edit/{id}.do" title="修改用户" target="dialog" width="600" height="400" rel="BK400101"><span>修改</span></a></li>
            <li><a class="edit" href="BK4001/deleteUserInfo.do?id={id}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
            <li><a class="edit" href="BK4001/userRoleDetail.do?id={id}" title="角色分配" target="dialog" width="600" height="400" rel="BK400102"><span>角色分配</span></a></li>
            <li><a class="edit" href="BK4001/resetUserPassword.do?id={id}" target="ajaxTodo" title="确定要重置密码?"><span>重置密码</span></a></li>
        </ul>
    </div>
    <table id="gridTable" class="table" width="100%" layoutH="194">
        <thead>
            <tr>
                <th style="font-weight:bold; text-align: center;"  width="50">序号</th>
				<th style="font-weight:bold; text-align: center;" width="100" style="font-weight:bold;">用户ID</th>
				<th style="font-weight:bold; text-align: center;" width="100" style="font-weight:bold;">用户名</th>
				<th style="font-weight:bold; text-align: center;" width="100" style="font-weight:bold;">用户角色</th>
				<th style="font-weight:bold; text-align: center;" width="100" style="font-weight:bold;">所属部门</th>
                <th style="font-weight:bold; text-align: center;" width="100" style="font-weight:bold;">职位描述</th>
                <th style="font-weight:bold; text-align: center;" width="100" style="font-weight:bold;">联系方式</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${page.resultList}" varStatus="status">
            <tr target="id" rel="${user.id}">
                <td align="center">${status.index+1}</td>
                <td align="center">${user.userid}</td>
                <td align="center">${user.username}</td>
                <td align="center">${user.rolename}</td>
                <td align="center">${user.orgname}</td>
                <td align="center">${user.detail}</td>
                <td align="center">${user.mobile}</td>
                
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