<%--
  Created by IntelliJ IDEA.
  User: wujian
  Date: 2018-05-08
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="filterGet/1">get</a>
<br><br>
<form action="filterPost" method="post">
    <input type="submit" value="post">
    <input type="hidden" name="_method" value="post"/>
</form>
<br><br>
<form action="filterPut/2.do" method="post">
    <input type="hidden" name="_method" value="put">
    <input type="submit" value="测试put">
</form>
<br><br>
<form action="filterDelete/233.do" method="post">
    <input type="hidden" name="_method" value="DELETE"/>
    <input type="submit" value="delete">
    <br>
</form>
<br><br>
</body>
</html>
