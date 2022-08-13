<%--
  Created by IntelliJ IDEA.
  User: meife
  Date: 2022/7/23
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/fileUpLoad" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" value="选择文件" name="upload"><br>
    <input type="submit" value="上传">
</form>
</body>
</html>
