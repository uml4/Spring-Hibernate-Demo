<%-- 
    Document   : header
    Created on : Apr 10, 2015, 9:50:53 AM
    Author     : Administrator
--%>
<%@ include file="./include.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello Spring</title>
          <link href="<c:url value="/resources/styles/styles.css" />" rel="stylesheet" type="text/css" />
          <script type='text/javascript' src="<c:url value="/resources/js/jquery-1.11.1.js" />" > </script>
    </head>
    <body>
                 <h1>PNV DEV 15 Hello Spring</h1>
    <ul class="menu"> 
        <li><a href="<%=request.getContextPath()%>/">Index</a></li>
        <li><a href="<%=request.getContextPath()%>/department">Manage Departments</a></li>
        <li><a href="<%=request.getContextPath()%>/title">Manage Titles</a></li>
        <li><a href="<%=request.getContextPath()%>/employee">Manage Employees</a></li>
    </ul>