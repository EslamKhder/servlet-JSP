<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Current Date</title>

<style>
    body{
        margin: 0;
        padding: 0;
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        background: linear-gradient(to right, #1e3c72, #2a5298);
        font-family: Arial, sans-serif;
    }

    .card{
        background-color: white;
        padding: 30px 50px;
        border-radius: 15px;
        box-shadow: 0 4px 15px rgba(0,0,0,0.3);
        text-align: center;
    }

    h1{
        color: #1e3c72;
        font-size: 28px;
        margin: 0;
    }

    .date{
        margin-top: 15px;
        font-size: 22px;
        color: #444;
    }
</style>

</head>
<body>

<div class="card">
    <h1>Local Date & Time</h1>
    <div class="date">
        <%= new Date() %>
    </div>
</div>

</body>
</html>