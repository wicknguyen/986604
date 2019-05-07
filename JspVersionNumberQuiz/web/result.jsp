<%--
  Created by IntelliJ IDEA.
  User: quynguyen
  Date: 2019-05-06
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>The Number Quiz</title>
    <link href="style.css" type="text/css" rel="stylesheet">
</head>
<body>
    <h1>The Number Quiz</h1>
    ${quiz.correctAnswerOfPrevQuestion}
    <p>Your current score is ${quiz.score} and you have grade <span class="red">${quiz.grade}</span></p>
</body>
</html>
