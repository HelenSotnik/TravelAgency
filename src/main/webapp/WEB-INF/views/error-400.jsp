<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<html xmlns:th="http://www.thymeleaf.org" lang="en">
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <title>Bad Request Error page 400 HTTP status code</title>
</head>
<body>
<div th:replace="header"></div>
<div class="col-md-offset-2">
  <h1 style="width: max-content; font-weight:bold; alignment: center; color: firebrick">400 BAD_REQUEST</h1>
</div>
<div class="col-md-offset-2">
  <h2 style="max-width: 800px; width: max-content; alignment: center"
      th:text=" ${message}"/>
</div>
</body>
</html>
