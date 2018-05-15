<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/9
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<br><br>
<a href="requestParam.do?id=123&name=张三">requestParam请求</a>
<br><br>
<a href="requestHeader.do">requestHeader请求</a>
<br><br>
<a href="requestCookieValue.do">requestHeader请求</a>
<br><br>
<form action="requestPOJO.do" method="post">
   id: <input type="text" name="id"><br>
    name:<input type="text" name="name"><br>
    age:<input type="text" name="age"><br>
    学校名称:<input type="text" name="schoolModel.schoolName"><br>
    <input type="submit" value="requestPOJO测试"><br>
</form>
<br><br>
<a href="requestServletApi.do">ServletApi请求</a>
<br><br>
</body>
</html>
