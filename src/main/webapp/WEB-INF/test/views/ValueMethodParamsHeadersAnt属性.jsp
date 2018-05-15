<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/8
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="helloWorld.do">RequestMapping请求映射</a>
<br><br>
<a href="get.do">RequestMappingMethodGet属性</a>
<br><br>
<form action="post.do" method="post">
    <input type="submit" value="RequestMappingMethodPost属性">
</form>
<br><br>
<a href="params.do?username=张三&age=110">RequestMappingMethodParams属性</a>
<br><br>
<a href="headers.do">RequestMappingMethodHeaders属性</a>
<br><br>
<a href="ant1/a/aaa.do">RequestMappingAnt ? 匹配任意单字符 属性属性</a>
<br><br>
<a href="ant2/aaafff/aaa.do">RequestMappingAnt * 匹配0或多个任意数量的字符 属性</a>
<br><br>
<a href="ant3/a/a/a/f/f/f/aaa.do">RequestMappingAnt ** 匹配0或者更多目录 属性</a>
<br><br>
<a href="testPathVariable/123.do">RequestMappingPathVariable 属性</a>
</body>
</html>
