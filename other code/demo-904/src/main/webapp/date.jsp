<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${param.n}</h1>
	<h1>${param.p}</h1>
	<h1>${param.e}</h1>
	<%
		String name = request.getParameter("n");
		String password = request.getParameter("p");
		String gmail = request.getParameter("e");
		
		out.print("<h1>" + name + "</h1>");
		out.print("<h1>" + password + "</h1>");
		out.print("<h1>" + gmail + "</h1>");
	%>
</body>
</html>