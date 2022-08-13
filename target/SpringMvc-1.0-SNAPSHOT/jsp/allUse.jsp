<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="frm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>生日</td>
        <td>性别</td>
        <td>地址</td>
    </tr>
    <c:forEach items="${uses}" var="use" varStatus="vs">
        <tr bgcolor="${vs.index%2==0?'azure':''}">
            <td>${use.id}</td>
            <td>${use.username}</td>
            <td>
                <frm:formatDate value="${use.birthday}" pattern="yyyy-MM-dd"></frm:formatDate>
            </td>
            <td>${use.sex}</td>
            <td>${use.address}</td>
        </tr>
    </c:forEach>
</table>
<span>第${pageInfo.pageNum}页 / 共${pageInfo.pages}页   共${pageInfo.total}条</span>
<a href="?pageNum=1">首页</a>
<c:if test="${pageInfo.hasPreviousPage}">
    <a href="list?pageNum=${pageInfo.pageNum-1}">上一页</a>
</c:if>
<c:if test="${pageInfo.hasNextPage}">
    <a href="list?pageNum=${pageInfo.pageNum+1}">下一页</a>
</c:if>
<a href="list?pageNum=${pageInfo.pages}">尾页</a>
</body>
<script>

</script>
</html>