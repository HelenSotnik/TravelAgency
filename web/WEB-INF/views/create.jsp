<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>New User registration</title>
    <style>
        <%@include file="../styles/main.css"%>
    </style>
</head>
<body align="center">
<%@include file="header.html" %>
<div>
    <h2>Create New User</h2>
</div>
<%--@elvariable id="user" type="com.softserve.model.User"--%>
<form:form action="create" method="post" modelAttribute="user">
    <table align="center">
        <tr>
            <td>First name:</td>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td>Last name:</td>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><form:input path="password"/></td>
        </tr>
    </table>
    <div>
        <input type="submit" class="btn btn-info" value="Register"/>
        <input type="reset" class="btn btn" value="Clear"/>
    </div>
</form:form>
</div>
</body>
</html>