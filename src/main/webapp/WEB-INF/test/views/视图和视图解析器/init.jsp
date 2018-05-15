<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/9
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Title</title>
</head>
<body>
<a href="testModelAndView.do">ModelAndView测试</a><br>
<a href="testSessionAttribute.do">SessionAttribute测试</a><br>
<%--
    模拟修改操作 年龄不能被修改
--%>
<form action="testModelAttribute.do" method="post">
    <input type="hidden" name="id"> <br>
    name: <input type="text" name="name" value="张学友"> <br>
    <input type="submit" value="testModelAttribute测试">
</form>
<br>
<a href="testRedirect.do">testRedirect测试</a><br>
<br>
<a href="testForward.do">testForward测试</a><br>
<br>
</body>
</html>
