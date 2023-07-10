<%@ page import="com.softserve.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read User INFO</title>
    <style>
        <%@include file="../styles/main.css"%>
        <%@include file="../styles/table.css"%>
    </style>
</head>
<body>
<div align="center">
<%@include file="header.html" %>
<h2>Read User INFO</h2>
<table class="table">
    <%User user = (User) request.getAttribute("user");%>
    <tr>
        <td>Id:</td>
        <td style="font-weight: bold"><%=user.getId()%>
        </td>
    </tr>
    <tr>
        <td>First Name:</td>
        <td style="font-weight: bold"><%=user.getFirstName()%>
        </td>
    </tr>
    <tr>
        <td>Last Name:</td>
        <td style="font-weight: bold"><%=user.getLastName()%>
        </td>
    </tr>
    <tr>
        <td>Email:</td>
        <td style="font-weight: bold"><%=user.getEmail()%>
        </td>
    </tr>
</table>
</div>
</body>
</html>
