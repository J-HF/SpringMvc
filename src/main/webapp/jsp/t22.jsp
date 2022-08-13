<%--
  Created by IntelliJ IDEA.
  User: meife
  Date: 2022/7/22
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="container">
    <div class="title">进货信息</div>
    <input type="button" value="新增" class="btn2" onclick="onAdd()" />
    <table class="dataGrid">
        <tr>
            <th>编号</th>
            <th>商品名称</th>
            <th>数量</th>
            <th>单价</th>
            <th>进货时间</th>
            <th>供应商</th>
            <th>采购员</th>
            <th>订单号</th>
            <th>操作</th>
        </tr>
        <tr>
        </tr>
        <c:forEach var="item" items="${pageInfo.list}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${item.goods.goodsName}</td>
                <td>${item.amount}</td>
                <td>${item.price}元</td>
                <td><fmt:formatDate value="${item.purchase_time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>${item.supplier.supplierName}</td>
                <td>${item.sysUser.name}</td>
                <td>${item.serial_id}</td>
                <td>
                    <input type="button" value="修改" class="btn2" onclick="onEdit(${item.id})" />
                    <input type="button" value="删除" class="btn2" onclick="onDelete(${item.id})" />
                    <input type="button" value="查看" class="btn2" onclick="onDetail(${item.id})" />
                </td>
            </tr>
        </c:forEach>
    </table>
    <span>第${pageInfo.pageNum}页 / 共${pageInfo.pages}页   共${pageInfo.total}条</span>
    <a href="?pageNum=1" >首页</a>
    <c:if test="${pageInfo.hasPreviousPage}">
    <a href="list?pageNum=${pageInfo.pageNum-1}" >上一页</a>
    </c:if>
    <c:if test="${pageInfo.hasNextPage}">
    <a href="list?pageNum=${pageInfo.pageNum+1}" >下一页</a>
    </c:if>
    <a href="list?pageNum=${pageInfo.pages}" >尾页</a>

</body>
</html>
