<%--
  Created by IntelliJ IDEA.
  User: Eugene
  Date: 26-Mar-17
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
  <title>Sum</title>
</head>
<body>
<h2>Sum two elements</h2>
<hr>
<form method="get" action="http://localhost:8080/form">
  p1<input type="text" size="50" name="p1"><br>
  p2<input type="text" size="50" name="p2"><br>

  _
  <br><input type="submit" value="Send get">
</form>

<form method="post" action="http://localhost:8080/form">
  p3<input type="text" size="50" name="p3"><br>
  p4<input type="text" size="50" name="p4"><br>

  _
  <br><input type="submit" value="Send post">
</form>
</body></html>
