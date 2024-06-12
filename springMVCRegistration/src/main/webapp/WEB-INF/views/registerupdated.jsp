<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
	<%@include file="displayerrors.jsp"%>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
</head>
<body>
	<h1>Registration Form</h1>
	<form:errors path="user.*"></form:errors>

	<form action="registerUpdated" method="POST">
		<br>
		<br> FirstName:<input type="text" name="firstName" /><br>
		<br> LastName:<input type="text" name="lastName" /><br>
		<br> UserName:<input type="text" name="userName" /><br>
		<br> password:<input type="password" name="password" /><br>
		<br> <input type="submit" value="submit">
	</form>
</body>
</html>