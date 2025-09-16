<%@page import="java.util.ArrayList"%>
<%@page import="com.servlet.model.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Students List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f7f9fc;
            padding: 30px;
        }
        h1 {
            text-align: center;
            color: #2c3e50;
        }
        table {
            width: 70%;
            margin: 20px auto;
            border-collapse: collapse;
            background: #fff;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        }
        th, td {
            padding: 12px 18px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background: #3498db;
            color: white;
            text-transform: uppercase;
            letter-spacing: 1px;
        }
        tr:hover {
            background: #f1f1f1;
        }
    </style>
</head>
<body>
    <h1>Students List</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Address</th>
        </tr>
        <%!
	        String toUpperCase(String name){
	    		return name.toUpperCase();
	    	}
        %>
        
        <%
        
            List<Student> students = new ArrayList<>();
            students.add(new Student(1, "Ahmed", "Cairo", 20));
            students.add(new Student(2, "Mona", "Giza", 22));
            students.add(new Student(3, "Omar", "Alexandria", 19));
            students.add(new Student(4, "Sara", "Mansoura", 21));
            students.add(new Student(5, "Hassan", "Aswan", 23));

            for(Student student : students){
        %>
        <tr>
            <td><%= student.getId() %></td>
            <td><%= toUpperCase(student.getName()) %></td>
            <td><%= student.getAge() %></td>
            <td><%= student.getAddress() %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
