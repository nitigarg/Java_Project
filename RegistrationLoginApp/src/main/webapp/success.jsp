<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Success page</h1>
	<jsp:useBean id="user" class="com.training.entity.User" scope="request" />
	<%="Congratulations! You have successfully registered " + request.getParameter("firstName")%>
	<br>
    <a href="login.jsp">Login</a>
</body>
</html>