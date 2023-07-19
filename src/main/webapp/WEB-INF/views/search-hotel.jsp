<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Hotel Search Result</title>
    <style>
        <%@include file="../styles/main.css"%>
        <%@include file="../styles/table.css"%>
    </style>
</head>
<body>
<%@include file="header.html" %>
<div align="center">
    <h2>Hotel Search Result</h2>
    <br>
    <table class="table" align="center">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Location</th>
            <th scope="col">Description</th>
        </tr>
        </thead>
        <c:forEach items="${result}" var="hotel">
            <tr>
                <td>
                    <a href="/hotels/${hotel.id}/read">${hotel.name}</a>
                </td>
                <td>${hotel.location}</td>
                <td>${hotel.description}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>