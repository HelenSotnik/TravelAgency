<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Manager page</title>
    <style>
        <%@include file="../styles/main.css"%>
        <%@include file="../styles/table.css"%>
    </style>
</head>
<body>
<%@include file="header.html" %>
<div align="center">
    <h2>Travel Agency Manager Page</h2>
    <form method="get" action="agency-manager/search">
        <input type="text" name="keyword"/>
        <input type="submit" value="Search"/>
    </form>
    <h3>List of Users</h3>
    <form action="/users/create" method="get">
        <div align="center">
            <input type="submit" value="Add New User">
        </div>
    </form>
    <table class="table" align="center">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Full name</th>
            <th scope="col">E-mail</th>
            <th scope="col" colspan="3">Operations</th>
        </tr>
        </thead>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>
                  <a href="/bookings/${user.id}">${user.firstName} ${user.lastName}</a>
                </td>
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
</div>
</body>
</html>