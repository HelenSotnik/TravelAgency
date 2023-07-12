<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>New User registration</title>
    <style>
        <%@include file="../styles/main.css"%>
    </style>
</head>
<body>
<%@include file="header.html" %>
<div align="center">
    <h2>Create New User</h2>
    <%--@elvariable id="user" type="com.softserve.model.User"--%>
    <form:form action="create" method="post" modelAttribute="user">
        <table class="table" align="center">
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