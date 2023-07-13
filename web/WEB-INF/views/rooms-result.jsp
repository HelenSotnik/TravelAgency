<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Available Rooms Search</title>
    <style>
        <%@include file="../styles/main.css"%>
        <%@include file="../styles/table.css"%>
    </style>
</head>
<body>
<%@include file="header-user.html" %>
<div align="center">
    <h2>Available Rooms List in ${hotel.name}</h2>
    <br>
    <table class="table" align="center">
        <thead>
        <tr>
            <th scope="col">Description</th>
            <th scope="col">Price per Night</th>
            <th scope="col" colspan="1">Operations</th>
        </tr>
        </thead>
        <c:forEach items="${result}" var="room">
            <tr>
                <td>${room.name}</td>
                <td>${room.pricePerNight}</td>
                <td>
                    <a href="/bookings/${hotel.id}/book/${room.id}">Book</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>