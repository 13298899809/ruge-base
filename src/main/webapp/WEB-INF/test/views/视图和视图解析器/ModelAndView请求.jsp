<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/9
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <%--jsp版本过低  EL是默认关闭的。。。必须手动打开 --%>
    <%--<%@ page isELIgnored="false" %>--%>
    <title>Title</title>
</head>
<body>
${time}<br>
el表达式:${list}<br>
jstl遍历list集合:
<%--
items:被遍历的集合对象
var : 用于存放现在的指定成员
--%>
<c:if test="${list!=null && fn:length(list) > 0}">
    <c:forEach items="${list}" var="list">
        <c:out value="${list}"></c:out>
    </c:forEach>
</c:if>
<br>
jstl遍历list对象:
<c:if test="${modelList!=null && fn:length(modelList) > 0}">
    <c:forEach items="${modelList}" var="model">
        <c:out value="${model.id}"></c:out>
        <c:out value="${model.name}"></c:out>
        <c:out value="${model.age}"></c:out>
    </c:forEach>
</c:if>
<br>
jstl遍历map:
<c:forEach items="${map}" var="map">
    <c:if test="${map.key=='now'}">
        遍历常量: <c:out value="${map.value}"/>
    </c:if>
    </br>
    <c:if test="${map.key=='list'}">
        <c:if test="${map.value!=null && fn:length(map.value) > 0}">
            遍历常量list集合: <c:out value="${map.value}"/>
        </c:if>
    </c:if>

    </br>
    <c:if test="${map.key=='modelList'}">
        <c:if test="${map.value!=null && fn:length(map.value) > 0}">
            <c:forEach items="${map.value}" var="model">
                遍历对象list集合 <c:out value="${model.id}"></c:out>
                <c:out value="${model.name}"></c:out>
                <c:out value="${model.age}"></c:out>
            </c:forEach>
        </c:if>
    </c:if>
    <br>
</c:forEach>
<br>
requestScope.user:&nbsp&nbsp&nbsp&nbsp${requestScope.user} <br>
sessionScope.user:&nbsp&nbsp&nbsp&nbsp${sessionScope.user} <br>
</body>
</html>