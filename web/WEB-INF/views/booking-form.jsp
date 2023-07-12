<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Booking Form</title>
    <style>
        <%@include file="../styles/main.css"%>
    </style>
</head>
<body>
<%@include file="header-user.html" %>
<div align="center">
    <h1>Booking Form</h1>
    <h2>${hotel.name}</h2>
    <form:form action="/bookings/${hotelId}/book/${roomId}" method="post" modelAttribute="booking">
        <table class="table" align="center">
        <tr>
            <td>Guest Full Name:</td>
            <td><form:input path="guestFullName"/></td>
        </tr>
        <tr>
            <td>Guest Email:</td>
            <td><form:input path="guestEmail"/></td>
        </tr>
        <tr>
            <td>Check-in Date:</td>
            <td><form:input type="date" path="checkInDate"/></td>
        </tr>
        <tr>
            <td>Check-out Date:</td>
            <td><form:input type="date" path="checkOutDate"/></td>
        </tr>
        </table>
        <div>
            <input type="submit" value="Submit Booking">
        </div>
    </form:form>
</div>
</body>
</html>