<%--
  Created by IntelliJ IDEA.
  User: 曹超
  Date: 2018/8/23
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/header.jsp"%>
<div class="page-title">
    <h3>欢迎你：${sessionScope.devUserSession.devName}  | 角色：开发者用户</h3>
</div>
<%@include file="common/footer.jsp"%>