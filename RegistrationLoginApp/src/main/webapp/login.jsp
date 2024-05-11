<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
	<%@include file="displayerrors.jsp"%>
<head>
<meta charset="ISO-8859-1">
<title>LoginForm</title>
</head>
<body>
	<h1>Login-Form</h1>
	<form action="loginServlet" method="POST">
		<%
		Object obj = session.getAttribute("errors");
		String errorMesg = " ";
		if (obj != null) {
			errorMesg = (String) obj;
		%>
		<font color=red>
			<%
			out.println(errorMesg);
			%>
		</font>
		<%
		session.setAttribute("errors", " ");
		}
		%>
		<br> <br> UserName:<input type="text" name="userName" /><br>
		<br> password:<input type="password" name="password" /><br>
		<br> <input type="submit" value="submit">
	</form>
</body>
</html>