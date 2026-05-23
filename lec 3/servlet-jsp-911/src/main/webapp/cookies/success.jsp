<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Language Saved</title>

<style>

    *{
        margin:0;
        padding:0;
        box-sizing:border-box;
    }

    body{
        font-family: Arial, sans-serif;
        background: linear-gradient(135deg, #0f172a, #1e293b);
        height:100vh;
        display:flex;
        justify-content:center;
        align-items:center;
    }

    .container{
        background:white;
        width:420px;
        padding:40px;
        border-radius:16px;
        text-align:center;
        box-shadow:0 10px 25px rgba(0,0,0,0.3);
    }

    h1{
        color:#16a34a;
        margin-bottom:20px;
        font-size:30px;
    }

    p{
        color:#475569;
        margin-bottom:30px;
        font-size:18px;
    }

    a{
        display:inline-block;
        text-decoration:none;
        background:#2563eb;
        color:white;
        padding:12px 24px;
        border-radius:10px;
        transition:0.3s;
        font-size:16px;
    }

    a:hover{
        background:#1d4ed8;
    }

</style>

</head>

<body>

<div class="container">

<%

    String language = request.getParameter("language");

    if(language != null && !language.trim().isEmpty()){

        Cookie cookie = new Cookie("fav_language", language);

        // Save cookie for 1 year
        cookie.setMaxAge(60 * 60 * 24 * 365);

        response.addCookie(cookie);

%>

        <h1>Language Saved Successfully</h1>

        <p>
            Your favorite language is:
            <strong><%= language %></strong>
        </p>

<%
    } else {
%>

        <h1 style="color:red;">No Language Selected</h1>

<%
    }
%>

    <a href="main-page.jsp">
        Back To Main Page
    </a>

</div>

</body>
</html>