<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Booking Form</title>
    <style>
        <%@include file="../styles/main.css"%>
        <%@include file="../styles/table.css"%>
    </style>
</head>
<body>
<%@include file="header-user.html" %>
<div align="center">
    <h1>Booking Form</h1>
    <h2>${hotel.name}</h2>
    <form action="/hotels/${hotel.id}/book/${room.id}" method="post">
        <label for="guestName">Guest Name:</label>
        <input type="text" id="guestName" name="guestName" required><br>

        <label for="guestEmail">Guest Email:</label>
        <input type="email" id="guestEmail" name="guestEmail" required><br>

        <label for="checkInDate">Check-in Date:</label>
        <input type="date" id="checkInDate" name="checkInDate" required><br>

        <label for="checkOutDate">Check-out Date:</label>
        <input type="date" id="checkOutDate" name="checkOutDate" required><br>

        <label for="numberOfGuests">Number of Guests:</label>
        <input type="number" id="numberOfGuests" name="numberOfGuests" required><br>

        <input type="submit" value="Submit Booking">
    </form>
</div>
</body>
</html>