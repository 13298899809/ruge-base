<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/4
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
jfreechart 柱状图 <br>
<br>
<c:if test="${not empty chartURL}">
    <img src="${chartURL}" width=1100 height=680 border=0
         color=gray>
</c:if>
</body>
</html>
