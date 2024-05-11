
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.training.entity.OrderDetails"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>

<html>
<head>
<body>
</head>
<h2>
	<%="Welcome " + session.getAttribute("firstName")%>
	<%List<OrderDetails>list=(List)request.getAttribute("list");%>

</h2>
<table style="width: 40%" border="1">
	<caption>
		<h2>Order Details</h2>
	</caption>
	<tr>
		<th>orderId</th>
		<th>productName</th>
		<th>productPrice($)</th>
		<th>orderQuantity</th>
		<th>orderDate</th>
	</tr>
	<c:forEach items="${list}" var="list" varStatus="status">
		<tr>
			<td>${list.orderId}</td>
			<td>${list.productName}</td>
			<td>${list.productPrice}</td>
			<td>${list.orderQuantity}</td>
			<td>${list.orderDate}</td>
		</tr>
	</c:forEach>
</table>
</body>

</html>