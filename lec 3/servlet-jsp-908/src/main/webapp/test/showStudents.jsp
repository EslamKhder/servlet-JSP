<%@page import="java.util.ArrayList"%>
<%@page import="model.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student List</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: #f5f6fa;
        margin: 0;
        padding: 20px;
        display: flex;
        justify-content: center;
    }
    table {
        width: 70%;
        border-collapse: collapse;
        background: #fff;
        box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        border-radius: 8px;
        overflow: hidden;
    }
    th, td {
        padding: 12px 15px;
        text-align: left;
    }
    th {
        background: #4CAF50;
        color: #fff;
        font-size: 1.1rem;
    }
    tr:nth-child(even) {
        background: #f2f2f2;
    }
    tr:hover {
        background: #eafaf1;
    }
</style>
</head>
<body>
    <table>
        <tr>
            <th>ID</th>
            <th>User Name</th>
            <th>Password</th>
        </tr>
        <%
            List<Student> students = new ArrayList<>();

            // Add students using the constructor
            students.add(new Student(1L, "ahmed", "pass123"));
            students.add(new Student(2L, "mona", "secret456"));
            students.add(new Student(3L, "omar", "mypassword"));
            students.add(new Student(4L, "sara", "12345"));
            students.add(new Student(5L, "osama", "78946"));

            for(Student student: students){
        %>
        <tr>
            <td><%= student.getId() %></td>
            <td><%= student.getUserName() %></td>
            <td><%= student.getPassword() %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
