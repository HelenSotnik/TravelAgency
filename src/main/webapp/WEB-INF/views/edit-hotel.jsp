<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Edit Hotel</title>
    <style>
        <%@include file="../styles/main.css"%>
    </style>
</head>
<body>
<%@include file="header.html" %>
<div align="center">
    <h2>Edit Hotel</h2>
    <form:form action="/hotels/create" method="post" modelAttribute="hotel">
        <table>
            <tr>
                <td>ID: </td>
                <td>${hotel.id}
                    <form:hidden path="id"/>
                </td>
            </tr>
            <tr>
                <td>Name: </td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>Location: </td>
                <td><form:input path="location" /></td>
            </tr>
            <tr>
                <td>Description: </td>
                <td><form:input path="description" /></td>
            </tr>
            <tr>
                <td>Review Score:</td>
                <td><form:input path="reviewScore"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Update"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>