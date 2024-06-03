<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String error = (String) session.getAttribute("errors");
	%>

	<%
	if (error != null && !error.equals("")) {
	%>
	<h3>
		<font color="maroon" face="Arial, Helvetica, sans-serif" size="3">Please
			correct the following errors and try again:</font>
	</h3>
	<ul>
		<font size="3" color="black" face="Arial, Helvetica, sans-serif">
			<%=session.getAttribute("errors")%></font>
	</ul>
	<%
	session.removeAttribute("errors");
	%>
	<%
	}
	%>

</body>
</html>