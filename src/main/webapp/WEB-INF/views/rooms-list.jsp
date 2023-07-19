<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Rooms List</title>
    <style>
        <%@include file="../styles/main.css"%>
        <%@include file="../styles/table.css"%>
    </style>
</head>
<body>
<%@include file="header.html" %>
<div align="center">
    <h2>Rooms List in ${hotel.name}</h2>
    <form action="/rooms/${hotelId}/create" method="get">
        <div align="center">
            <input type="submit" value="Add New Room">
        </div>
    </form>
    <table class="table" align="center">
        <thead>
        <tr>
            <th scope="col">Description</th>
            <th scope="col">Price per Night</th>
            <th scope="col" colspan="2">Operations</th>
        </tr>
        </thead>
        <c:forEach items="${rooms}" var="room">
            <tr>
                <td>${room.name}</td>
                <td>${room.pricePerNight}</td>
                <td>
                    <a href="/rooms/${hotelId}/update/${room.id}">Edit</a>
                </td>
                <td>
                    <a href="/rooms/${hotelId}/delete/${room.id}">Remove</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>