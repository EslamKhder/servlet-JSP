<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Current Date</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: linear-gradient(135deg, #667eea, #764ba2);
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        margin: 0;
    }

    .container {
        background: white;
        padding: 40px 60px;
        border-radius: 15px;
        box-shadow: 0 10px 25px rgba(0,0,0,0.2);
        text-align: center;
    }

    h1 {
        color: #333;
        font-size: 24px;
    }

    .date {
        margin-top: 15px;
        font-size: 20px;
        color: #764ba2;
        font-weight: bold;
    }
</style>

</head>
<body>

	<%
		Date date1 = new Date();
	%>
    <div class="container">
        <h1>Local Date Now</h1>
        <div class="date"><%= date1 %></div>
    </div>
    ///////////////////////////////
	<%
		Date date2 = new Date();
	    out.print("<div class='container'>");
	    out.print("<h1>Local Date Now</h1>");
	    out.print("<div class='date'>" + date2);
	    out.print("</div>");
	    out.print("</div>");
	%>
</body>
</html>