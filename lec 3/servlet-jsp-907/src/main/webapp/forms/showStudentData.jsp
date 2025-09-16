<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Info</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: #f4f6f9;
        margin: 0;
        padding: 20px;
    }

    h1 {
        color: #333;
        font-size: 22px;
        margin: 10px 0;
    }

    .container {
        max-width: 700px;
        margin: auto;
        background: white;
        padding: 25px;
        border-radius: 10px;
        box-shadow: 0 4px 10px rgba(0,0,0,0.1);
    }

    .title {
        text-align: center;
        font-size: 28px;
        color: #007bff;
        margin-bottom: 20px;
    }

    ul {
        padding-left: 20px;
    }

    ul li {
        font-size: 18px;
        color: #444;
    }

    hr {
        margin: 20px 0;
        border: 0;
        border-top: 2px solid #eee;
    }
</style>
</head>
<body>

<div class="container">
    <div class="title">Hello Student</div>
    
    <h1>ID : ${param.id}</h1>
    <h1>Name : ${param.name}</h1>
    <h1>Password : ${param.password}</h1>
    <h1>Address : ${param.address}</h1>
    <h1>Age : ${param.age}</h1>
    <h1>Favorite Web Language : ${param.fav_language}</h1>
    <h1>Selected Car : ${param.cars}</h1>
    <h1>Selected Vehicles :</h1>
    <h1>${paramValues.vehicle}</h1>
    <h1>Date Selected : ${param.date}</h1>

    <hr>

    <%
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String age = request.getParameter("age");
        String favLanguage = request.getParameter("fav_language");
        String car = request.getParameter("cars");
        String date = request.getParameter("date");

        out.print("<h1>ID: " + id + "</h1>");
        out.print("<h1>Name: " + name + "</h1>");
        out.print("<h1>Password: " + password + "</h1>");
        out.print("<h1>Address: " + address + "</h1>");
        out.print("<h1>Age: " + age + "</h1>");
        out.print("<h1>Favorite Web Language: " + favLanguage + "</h1>");
        out.print("<h1>Selected Car: " + car + "</h1>");

        String[] vehicles = request.getParameterValues("vehicle");
        out.print("<h1>Selected Vehicles:</h1>");
        if (vehicles != null) {
            out.print("<ul>");
            for (String v : vehicles) {
                out.print("<li>" + v + "</li>");
            }
            out.print("</ul>");
        } else {
            out.print("<h2>No vehicle selected</h2>");
        }

        out.print("<h1>Date Selected: " + date + "</h1>");
    %>
</div>
</body>
</html>
