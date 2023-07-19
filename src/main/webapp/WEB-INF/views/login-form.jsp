<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>LogIn page</title>
    <style>
        <%@include file="../styles/main.css"%>
    </style>
</head>
<body>
<div align="center">
    <h2>LogIn Page</h2>
    <form action="/login-form" method="POST">
        <div>
            <label>Username: </label><input type="text" name="username"/>
        </div>
        <br>
        <div>
            <label>Password: </label><input type="password" name="password"/>
        </div>
        <br>
        <div align="center">
            <input type="submit" value="LogIn"/>
            <h5>Don`t have an account?</h5><a href="/users/create">Register now!</a>
        </div>
    </form>
</div>
</body>
</html>