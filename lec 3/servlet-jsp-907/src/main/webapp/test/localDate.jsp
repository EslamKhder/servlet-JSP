<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Show Local Date</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #f0f4f8, #d9e4ec);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        h1 {
            background-color: #ffffff;
            padding: 20px 40px;
            border-radius: 12px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.15);
            color: #2c3e50;
        }
        .date {
            font-size: 22px;
            font-weight: bold;
            color: #16a085;
        }
    </style>
</head>
<body>
    <h1>
        Local date is: <span class="date"><%= new Date() %></span>
    </h1>
</body>
</html>
