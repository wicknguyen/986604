<%@ page import="mum.model.Quiz" %><%--
  Created by IntelliJ IDEA.
  User: quynguyen
  Date: 2019-05-06
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>JSP Version Number Quiz</title>
    <link href="style.css" type="text/css" rel="stylesheet">
  </head>
  <body>
    <form action="validateAge" method="post">
      <h1>The Number Quiz</h1>
      <%
        String errorMsg = (String) request.getAttribute("errorMsg");
        if (errorMsg != null) {
          out.print("<p class='red'>" + errorMsg + "</p>");
        }
      %>
      <label>Your age: </label>
      <input type="text" name="age" size="10"/>
      <input type="submit" value="Submit"/>
    </form>
  </body>
</html>
