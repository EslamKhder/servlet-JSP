<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Date Page</title>

<style>
    body {
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
        background: linear-gradient(to right, #4facfe, #00f2fe);
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .container {
        background-color: white;
        padding: 30px 50px;
        border-radius: 15px;
        box-shadow: 0 10px 25px rgba(0,0,0,0.2);
        text-align: center;
    }

    h1 {
        color: #333;
        font-size: 28px;
    }

    .date {
        margin-top: 15px;
        font-size: 20px;
        color: #555;
    }
</style>

</head>
<body>

<div class="container">
    <h1>Current Date</h1>
    <div class="date">
        <%= new Date() %>
    </div>
</div>

</body>
</html>