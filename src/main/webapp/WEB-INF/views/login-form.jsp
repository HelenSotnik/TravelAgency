<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <title>LogIn page</title>
</head>
<body>
<div class="col-md-offset-2">
    <h2>LogIn Page</h2>
</div>
<form class="form-horizontal" action="/login-form" method="POST">
    <div class="form-group">
        <label class="col-sm-2 control-label">Username:</label>
        <div class="col-sm-6">
            <input class="form-control" type="text" name="username"/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">Password:</label>
        <div class="col-sm-6">
            <input class="form-control" type="password" name="password"/>
        </div>
    </div>
    <div class="col-sm-offset-2 col-sm-6">
        <input class="btn btn-info" type="submit" value="LogIn"/> <br>
        <h5>Don`t have an account?</h5>
        <a href="/users/create">Register now!</a>
    </div>
</form>
</body>
</html>