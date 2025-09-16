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
// connect to dB
List<String> items = (List<String>)session.getAttribute("allItems");
	
	if (items != null) {
		// save to DB
	}
%>
</body>
</html>