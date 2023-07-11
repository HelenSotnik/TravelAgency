<%@ page import="com.softserve.model.User" %>
<%@ page import="com.softserve.model.Hotel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hotel INFO</title>
    <style>
        <%@include file="../styles/main.css"%>
        <%@include file="../styles/table.css"%>
    </style>
</head>
<body>
<%@include file="header-user.html" %>
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
    </table>
</div>
<div align="center" >
    <h5 style="color: #3e8e41">Please insert the dates to check if rooms in hotel are available.</h5>
    <form action="/hotels/${hotel.id}/check-rooms" method="get">
        <label for="checkInDate">Check-in Date:  </label>
        <input type="date" id="checkInDate" name="checkInDate" required>
        <br>
        <label for="checkOutDate">Check-out Date:</label>
        <input type="date" id="checkOutDate" name="checkOutDate" required><br>
        <br>
        <input type="submit" value="Check Available Rooms">
    </form>

</div>
</body>
</html>