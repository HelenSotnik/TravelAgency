<html xmlns:th="http://www.thymeleaf.org" lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <title>Error Page</title>
</head>
<body>
<div th:replace="header"></div>
<br>
<h1 style="margin: 0 auto;color: firebrick; width: max-content" th:text="${code}" />
<h2 style="margin: 0 auto; width: max-content" th:text="${message}" />
</body>
</html>