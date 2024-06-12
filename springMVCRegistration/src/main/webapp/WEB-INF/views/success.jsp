<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success</title>
</head>
<body>
	<h1>Success page</h1>
	<jsp:useBean id="user" class="com.apex.beans.User" scope="request" />
	<%="Congratulations! You have successfully registered " + request.getParameter("firstName")%>
	<br>
</body>
</html>