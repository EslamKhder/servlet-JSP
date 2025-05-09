<%@page import="jee.servlet.jsp.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<%
	List<Student> students = List.of(
		new Student(1,"ahmed", "cairo", 20),
		new Student(2,"mohamed", "alex", 30),
		new Student(3,"ali", "cairo", 15),
		new Student(4,"osama", "alex", 10)
	);
%>
<h2 style="text-align: center;">Student Table</h2>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Address</th>
        <th>Age</th>
    </tr>
    <%
    	for(Student student: students){
    		out.print("<tr>");
    		out.print("<td>" + student.getId() + "</td>");
    		out.print("<td>" + student.getName() + "</td>");
    		out.print("<td>" + student.getAddress() + "</td>");
    		out.print("<td>" + student.getAge() + "</td>");
    		out.print("</tr>");
    	}
    %>
    
</table>

</body>
</html>