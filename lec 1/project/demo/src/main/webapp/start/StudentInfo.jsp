<%@page import="demo.Student"%>
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
	Student s = new Student();
	s.setId(1);
	s.setAge(20);
	s.setName("ahmed");
	
	out.println("<h1>" + s.getId() + "</h1>");
	out.println("<h2>" + s.getName() + "</h2>");
	out.println("<h3>" + s.getAge() + "</h3>");
%>
</body>
</html>