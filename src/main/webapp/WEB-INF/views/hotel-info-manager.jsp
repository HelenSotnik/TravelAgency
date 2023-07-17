<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.softserve.model.Hotel" %>
<html>
<head>
    <title>Hotel INFO</title>
    <style>
        <%@include file="../styles/main.css"%>
        <%@include file="../styles/table.css"%>
    </style>
</head>
<body>
<%@include file="header.html" %>
<div align="center">
    <h2>HOTEL INFO</h2>
    <table class="table">
        <%Hotel hotel = (Hotel) request.getAttribute("hotel");%>
        <tr>
            <td>Name:</td>
            <td style="font-weight: bold"><%=hotel.getName()%>
            </td>
        </tr>
        <tr>
            <td>Location:</td>
            <td style="font-weight: bold"><%=hotel.getLocation()%>
            </td>
        </tr>
        <tr>
            <td>Description:</td>
            <td style="font-weight: bold"><%=hotel.getDescription()%>
            </td>
        </tr>
        <tr>
            <td>Review Score:</td>
            <td style="font-weight: bold"><%=hotel.getReviewScore()%>
            </td>
        </tr>
        <tr>
            <td>Rooms:</td>
            <td style="font-weight: bold">
                <a href="/rooms/${hotel.id}">All Hotel Rooms</a>
            </td>
        </tr>
    </table>
</div>
<div align="center" >
    <h5 style="color: #3e8e41">Please insert the dates to check if rooms in hotel are available.</h5>
    <form:form action="/hotels/${hotel.id}/check-rooms" method="get">
        <table class="table">
            <tr>
                <td>Check-in Date:</td>
                <td><input type="date" id="checkInDate" name="checkInDate" required></td>
            </tr>
            <tr>
                <td>Check-out Date:</td>
                <td><input type="date" id="checkOutDate" name="checkOutDate" required></td>
            </tr>
        </table>
        <div>
            <input type="submit" class="btn btn-info" value="Check Available Rooms"/>
        </div>
    </form:form>
</div>
</body>
</html>
