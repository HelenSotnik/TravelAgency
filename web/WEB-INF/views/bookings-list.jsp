<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Bookings List</title>
    <style>
        <%@include file="../styles/main.css"%>
        <%@include file="../styles/table.css"%>
    </style>
</head>
<body>
<%@include file="header-user.html" %>
<div align="center">
    <h2>${user.firstName} ${user.lastName}'s Bookings List</h2>
    <table class="table" align="center">
        <thead>
        <tr>
            <th scope="col" width="150px">Guest Full Name</th>
            <th scope="col">Guest Email</th>
            <th scope="col">Hotel Name</th>
            <th scope="col">Room Description</th>
            <th scope="col">CheckInDate</th>
            <th scope="col">CheckInDate</th>
            <th scope="col" colspan="1">Operations</th>
        </tr>
        </thead>
        <c:forEach items="${bookings}" var="booking">
            <tr>
                <td>${booking.guestFullName}</td>
                <td>${booking.guestEmail}</td>
                <td>${booking.hotel.name}</td>
                <td>${booking.room.name}</td>
                <td>${booking.checkInDate}</td>
                <td>${booking.checkOutDate}</td>
                <td>
                    <a href="/bookings/${booking.id}/delete">Cancel Booking</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
