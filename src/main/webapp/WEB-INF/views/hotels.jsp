<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Hotels</title>
    <style>
        <%@include file="../styles/main.css"%>
        <%@include file="../styles/table.css"%>
    </style>
</head>
<body>
<%@include file="header.html" %>
<div align="center">
    <br>
    <form method="get" action="hotels/search-hotel">
        <input type="text" name="keyword"/>
        <input type="submit" value="Search Hotel"/>
    </form>
    <h2>Hotels List</h2>
    <form action="/hotels/create" method="get">
        <div align="center">
            <input type="submit" value="Add New Hotel">
        </div>
    </form>
    <table class="table" align="center">
        <thead>
        <tr>
            <th scope="col" width="150px">Name</th>
            <th scope="col">Location</th>
            <th scope="col">Description</th>
            <th scope="col" width="100px">Review Score</th>
            <th scope="col" colspan="2">Operations</th>
        </tr>
        </thead>
        <c:forEach items="${hotels}" var="hotel">
            <tr>
                <td>
                    <a href="/agency-manager/hotels/${hotel.id}/read">${hotel.name}</a>
                </td>
                <td>${hotel.location}</td>
                <td>${hotel.description}</td>
                <td>${hotel.reviewScore}</td>
                <td>
                    <a href="/hotels/${hotel.id}/update">Edit</a>
                </td>
                <td>
                    <a href="/hotels/${hotel.id}/delete">Remove</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>