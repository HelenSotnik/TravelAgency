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
        <td>Id:</td>
        <td style="font-weight: bold"><%=hotel.getId()%>
        </td>
    </tr>
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
</table>
</div>
</body>
</html>