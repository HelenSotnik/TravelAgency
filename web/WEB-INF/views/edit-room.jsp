<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Edit Room</title>
    <style>
        <%@include file="../styles/main.css"%>
    </style>
</head>
<body>
<%@include file="header.html" %>
<div align="center">
    <h2>Edit Room</h2>
    <form:form action="/rooms/${hotelId}/update/${room.id}" method="post" modelAttribute="room">
        <table>
            <tr>
                <td>ID: </td>
                <td>${room.id}
                    <form:hidden path="id"/>
                </td>
            </tr>
            <tr>
                <td>Description: </td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>Price per night: </td>
                <td><form:input path="pricePerNight" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Update"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>