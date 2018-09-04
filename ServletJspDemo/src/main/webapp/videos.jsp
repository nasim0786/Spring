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
	response.setHeader("Cache-Control", "no-cahce, no-store, must-revalidate"); // Http 1.1
	
	response.setHeader("Pragma", "no-cache"); // Http 1.0
	
	response.setHeader("Expires", "0"); //Proxies
	
		if(session.getAttribute("username") == null) {
			response.sendRedirect("login.jsp");
		}
	%>
	
	<form action="logout">
		<input type="submit" value="logout">
	</form>
	<iframe width="560" height="315" src="https://www.youtube.com/embed/TRa9IMvccjg" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
</body>
</html>