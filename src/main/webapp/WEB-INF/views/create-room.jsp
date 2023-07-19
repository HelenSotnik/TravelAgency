<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Room</title>
    <style>
        <%@include file="../styles/main.css"%>
    </style>
</head>
<body>
<%@include file="header.html" %>
<div align="center">
    <h2>Add New Room</h2>
    <form:form action="/rooms/${hotelId}/create" method="post" modelAttribute="room">
        <table class="table" align="center">
            <tr>
                <td>Room Description:</td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td>Price per night:</td>
                <td><form:input path="pricePerNight"/></td>
            </tr>
        </table>
        <div>
            <input type="submit" class="btn btn-info" value="Add"/>
            <input type="reset" class="btn btn" value="Clear"/>
        </div>
    </form:form>
</div>
</body>
</html>