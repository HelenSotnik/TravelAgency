<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html xmlns:th="http://www.thymeleaf.org" lang="en">
<head>
    <title>Home page</title>
    <style>
        <%@include file="../styles/main.css"%>
        <%@include file="../styles/table.css"%>
    </style>
</head>
<body align="center">
<%@include file="header.html" %>
<h2>List of Users</h2>
<h4><a href="/users/create">Create new User</a></h4>
<br>
<table class="table" align="center">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">First name</th>
        <th scope="col">Last name</th>
        <th scope="col">E-mail</th>
        <th scope="col" colspan="2">Operations</th>
    </tr>
    </thead>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>
                <a href="/users/${user.id}/update">Edit</a>
            </td>
            <td>
                <a href="/users/${user.id}/delete">Remove</a>
            </td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>