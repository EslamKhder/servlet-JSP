<%@page import="java.util.ArrayList"%>
<%@page import="com.servlet.model.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Students Table</title>

<style>

    body{
        font-family: Arial, sans-serif;
        background: linear-gradient(to right, #4facfe, #00f2fe);
        margin: 0;
        padding: 30px;
    }

    h1{
        text-align: center;
        color: white;
        margin-bottom: 30px;
    }

    table{
        width: 80%;
        margin: auto;
        border-collapse: collapse;
        background-color: white;
        border-radius: 10px;
        overflow: hidden;
        box-shadow: 0 4px 10px rgba(0,0,0,0.2);
    }

    th{
        background-color: #0077cc;
        color: white;
        padding: 15px;
        font-size: 18px;
    }

    td{
        padding: 12px;
        text-align: center;
        border-bottom: 1px solid #ddd;
        font-size: 16px;
    }

    tr:hover{
        background-color: #f2f2f2;
    }

</style>

</head>
<body>

<h1>Students Information</h1>

<%!
	List<Student> students = new ArrayList<>();
	
	String toUpper(String value){
		return value.toUpperCase();
	}
%>
<%
    students.add(new Student(1, "Ahmed", 22, "ahmed@gmail.com"));
    students.add(new Student(2, "Sara", 21, "sara@gmail.com"));
    students.add(new Student(3, "Ali", 23, "ali@gmail.com"));
    students.add(new Student(4, "Mona", 20, "mona@gmail.com"));
%>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Email</th>
    </tr>

<%
    for(Student student : students){
%>

    <tr>
        <td><%= student.getId() %></td>
        <td><%= toUpper(student.getName()) %></td>
        <td><%= student.getAge() %></td>
        <td><%= student.getEmail() %></td>
    </tr>

<%
    }
%>

</table>

</body>
</html>