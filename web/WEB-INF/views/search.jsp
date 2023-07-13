<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Search Result</title>
    <style>
        <%@include file="../styles/main.css"%>
        <%@include file="../styles/table.css"%>
    </style>
</head>
<body>
<%@include file="header.html" %>
<h2 align="center">Search result</h2>
<table class="table" align="center">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">First name</th>
        <th scope="col">Last name</th>
        <th scope="col">E-mail</th>
        <th scope="col" colspan="3">Operations</th>
    </tr>
    </thead>
    <c:forEach items="${result}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>
                <a href="/users/${user.id}/read">Read</a>
            </td>
            <td>
                <a href="/users/${user.id}/update">Edit</a>
            </td>
            <td>
                <a href="/users/${user.id}/delete">Remove</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
