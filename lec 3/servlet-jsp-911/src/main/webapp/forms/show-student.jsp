<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Details</title>

<style>

    body{
        font-family: Arial, sans-serif;
        background: linear-gradient(to right, #4facfe, #00f2fe);
        margin: 0;
        padding: 40px;
    }

    .container{
        width: 600px;
        margin: auto;
        background-color: white;
        padding: 30px;
        border-radius: 15px;
        box-shadow: 0 4px 12px rgba(0,0,0,0.2);
    }

    h1{
        text-align: center;
        color: #0077cc;
        margin-bottom: 30px;
    }

    .info{
        font-size: 18px;
        margin: 12px 0;
        padding: 10px;
        border-bottom: 1px solid #ddd;
    }

    .label{
        font-weight: bold;
        color: #0077cc;
    }

    hr{
        margin: 25px 0;
    }

</style>

</head>
<body>

<div class="container">

<h1>Student Information</h1>

<div class="info"><span class="label">ID:</span> ${param.id}</div>
<div class="info"><span class="label">Name:</span> ${param.name}</div>
<div class="info"><span class="label">Password:</span> ${param.password}</div>
<div class="info"><span class="label">Address:</span> ${param.address}</div>
<div class="info"><span class="label">Age:</span> ${param.age}</div>
<div class="info"><span class="label">Favorite Language:</span> ${param.fav_language}</div>
<div class="info"><span class="label">Car:</span> ${param.cars}</div>
<div class="info"><span class="label">Vehicle:</span> ${param.vehicle}</div>
<div class="info"><span class="label">Date:</span> ${param.date}</div>

<hr>

<%
    Integer id = Integer.parseInt(request.getParameter("id"));
    String name = request.getParameter("name");
    String password = request.getParameter("password");
    String address = request.getParameter("address");
    String age = request.getParameter("age");
    String fav_language = request.getParameter("fav_language");
    String cars = request.getParameter("cars");
    String[] vehicles = request.getParameterValues("vehicle");
    String date = request.getParameter("date");

    // TODO GO TO DB to INSERT Student
%>

<div class="info"><span class="label">ID:</span> <%= id %></div>
<div class="info"><span class="label">Name:</span> <%= name.toUpperCase() %></div>
<div class="info"><span class="label">Password:</span> <%= password %></div>
<div class="info"><span class="label">Address:</span> <%= address %></div>
<div class="info"><span class="label">Age:</span> <%= age %></div>
<div class="info"><span class="label">Favorite Language:</span> <%= fav_language %></div>
<div class="info"><span class="label">Car:</span> <%= cars %></div>

<div class="info">
    <span class="label">Vehicles:</span>
    <%
        if(vehicles != null){
            for(String vehicle : vehicles){
                out.print(vehicle + " ");
            }
        }
    %>
</div>

<div class="info"><span class="label">Date:</span> <%= date %></div>

</div>

</body>
</html>