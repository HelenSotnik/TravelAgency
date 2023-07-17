<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <title>Error page</title>
</head>
<body>
<div th:replace="header"></div>
<br>
<h1 style="margin: 0 auto; width: max-content">403/Forbidden</h1>
<h2 style="margin: 0 auto; width: max-content" th:text="${error}"></h2>
</body>
</html>