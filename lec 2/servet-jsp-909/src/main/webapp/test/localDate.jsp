<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LocalDate</title>

<style>
    body {
        margin: 0;
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        background: linear-gradient(135deg, #4facfe, #00f2fe);
        font-family: Arial, Helvetica, sans-serif;
    }

    .date-box {
        background-color: #ffffff;
        padding: 30px 40px;
        border-radius: 12px;
        box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
        text-align: center;
    }

    .date-box h1 {
        margin: 0;
        color: #333;
        font-size: 26px;
    }

    .date {
        margin-top: 10px;
        font-size: 18px;
        color: #555;
        font-weight: bold;
    }
</style>

</head>
<body>

<div class="date-box">
    <h1>Hi Student</h1>
    <div class="date">
        <%= new Date() %>
    </div>
</div>

</body>
</html>
