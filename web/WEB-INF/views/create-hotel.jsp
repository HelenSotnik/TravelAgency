<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add hotel</title>
    <style>
        <%@include file="../styles/main.css"%>
    </style>
</head>
<body>
<%@include file="header.html" %>
<div align="center">
    <h2>Add New Hotel</h2>
    <%--@elvariable id="user" type="com.softserve.model.Hotel"--%>
    <form:form action="create" method="post" modelAttribute="hotel">
        <table class="table" align="center">
            <tr>
                <td>Hotel Name:</td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td>Description:</td>
                <td><form:input path="description"/></td>
            </tr>
            <tr>
                <td>Location:</td>
                <td><form:input path="location"/></td>
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