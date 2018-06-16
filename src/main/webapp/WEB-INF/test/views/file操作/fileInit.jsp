<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/11
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="fileUpload.do" method="post" enctype="multipart/form-data">
    <input type="text" name="name"><br>
    <input type="file" name="image" onchange="showImg(this)"><br>
    <input type="submit" value="上传">
</form>

<br>
<form action="fileUploads.do" method="post" enctype="multipart/form-data">
    <input type="text" name="name"><br>
    <input type="file" name="image"><br>
    <input type="submit" value="多个上传">
</form>
<div id="img"></div>
<script>
    function showImg(file) {
        var prevDiv = document.getElementById('img');
        if (file.files && file.files[0]) {
            var reader = new FileReader();
            reader.onload = function (evt) {
                prevDiv.innerHTML = '<img src="' + evt.target.result + '" />';
            }
            reader.readAsDataURL(file.files[0]);
        }
    }
</script>
</body>
</html>
