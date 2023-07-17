<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<html xmlns:th="http://www.thymeleaf.org" lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <title>LogIn Page</title>
</head>
<body>
<div align="center" class="col-md-offset-2">
    <h2>LogIn Page</h2>
<div class="col-md-offset-2" if="${param.error}">Invalid username or password</div>
<div class="col-md-offset-2" if="${param.logout}">You have been logged out</div>
<form class="form-horizontal" action="/login" method="post">
    <div class="form-group">
        <label class="col-sm-2 control-label">Username:</label>
        <div class="col-sm-8">
            <input type="text" class="form-control" name="username"/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">Password:</label>
        <div class="col-sm-8">
            <input type="password" class="form-control" name="password"/>
        </div>
    </div>
    <div class="col-sm-offset-2 col-sm-8">
        <input class="btn btn-info" type="submit" value="LogIn"/>
    </div>
</form>
<br><br>
<div class="col-sm-offset-2 col-sm-8">
    <a href="/users/create">Don't have an account? Register now!</a>
</div>
</div>
</body>
</html>