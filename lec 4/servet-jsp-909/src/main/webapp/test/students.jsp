<%@page import="model.Student"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Students</title>

<style>
    body {
        margin: 0;
        min-height: 100vh;
        font-family: Arial, Helvetica, sans-serif;
        background: linear-gradient(135deg, #43cea2, #185a9d);
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .container {
        background-color: #ffffff;
        padding: 30px 40px;
        border-radius: 12px;
        box-shadow: 0 12px 30px rgba(0, 0, 0, 0.2);
        width: 420px;
    }

    h1 {
        text-align: center;
        margin-bottom: 20px;
        color: #333;
    }

    ul {
        list-style: none;
        padding: 0;
        margin: 0;
    }

    li {
        display: flex;
        justify-content: space-between;
        align-items: center;
        background-color: #f5f7fb;
        padding: 12px 15px;
        margin-bottom: 12px;
        border-radius: 8px;
        font-size: 15px;
        color: #444;
        transition: 0.3s ease;
    }

    li:hover {
        background-color: #43cea2;
        color: #ffffff;
        transform: scale(1.02);
    }

    li span {
        font-weight: bold;
    }
</style>

</head>
<body>

<div class="container">
    <h1>Students</h1>
    <ul>
    <%!
	    String convertToUpper(String value){
	        return value.toUpperCase();
	    }
    %>
        <%
            List<Student> students = Arrays.asList(
                new Student(1L, "Ahmed", "01012345678"),
                new Student(2L, "Osama", "01123456789"),
                new Student(3L, "Islam", "01234567890"),
                new Student(4L, "Ali", "01598765432"),
                new Student(5L, "Mona", "01099887766")
            );

            for (Student student : students) {
        %>
            <li>
                <span>#<%= student.getId() %></span>
                <span><%=convertToUpper(student.getName())%></span>
                <span><%= student.getPhone() %></span>
            </li>
        <%
            }
        %>
    </ul>
</div>

</body>
</html>
