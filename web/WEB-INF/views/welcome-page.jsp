<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome page</title>
    <style>
        <%@include file="../styles/main.css"%>
        <%@include file="../styles/table.css"%>
    </style>
</head>
<body>
<div align="center">
    <%@include file="header-user.html" %>
    <h1 align="center">Welcome to Paradise Travel Agency</h1>
    <h3>Here you may find a wide range of hotels all over the world</h3>
    <br>
    <form method="get" action="/hotels/search-hotel">
        <input type="text" name="keyword"/>
        <input type="submit" value="Search Hotel"/>
    </form>
    <h3>Full List of Hotels</h3>
    <table class="table" align="center">
        <thead>
        <tr>
        <tr>
            <th scope="col" width="150px">Name</th>
            <th scope="col">Location</th>
            <th scope="col">Description</th>
            <th scope="col" width="100px">Review Score</th>
        </tr>
        </tr>
        </thead>
        <c:forEach items="${hotels}" var="hotel">
            <tr>
                <td>
                    <a href="/hotels/${hotel.id}/read">${hotel.name}</a>
                </td>
                <td>${hotel.location}</td>
                <td>${hotel.description}</td>
                <td>${hotel.reviewScore}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>