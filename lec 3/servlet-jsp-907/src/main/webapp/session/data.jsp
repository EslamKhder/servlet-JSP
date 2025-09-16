<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	List<String> orders = (List<String>)session.getAttribute("allOrders");
	
	for(String o: orders){
		out.print("<h1> " + o + "</h1>");
	}
%>
</body>
</html>