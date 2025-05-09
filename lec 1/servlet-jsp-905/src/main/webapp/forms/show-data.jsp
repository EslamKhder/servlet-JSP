<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Data</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            padding: 20px;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        .student-data {
            background-color: #fff;
            border-radius: 8px;
            padding: 25px;
            max-width: 500px;
            margin: auto;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        .student-data p {
            font-size: 16px;
            margin: 10px 0;
            color: #555;
        }

        .student-data p span {
            font-weight: bold;
            color: #222;
        }
    </style>
</head>
<body>

<div class="student-data">
    <h1>Hi Student, Your Data with jsp $param</h1>

    <p><span>Your ID:</span> ${param.id}</p>
    <p><span>Your Name:</span> ${param.name}</p>
    <p><span>Your Password:</span> ${param.password}</p>
    <p><span>Your Address:</span> ${param.address}</p>
    <p><span>Your Age:</span> ${param.age}</p>
    <p><span>Your Phone:</span> ${param.phone}</p>
    <p><span>fav_language:</span> ${param.fav_language}</p>
    <p><span>cars:</span> ${param.cars}</p>
    <p><span>vehicles:</span> ${param.vehicle}</p>
    <p><span>date:</span> ${param.date}</p>
    
    <h1>Hi Student, Your Data with jsp java param</h1>
    <%
    	int id = Integer.parseInt(request.getParameter("id"));
    	String name = request.getParameter("name");
    	String password = request.getParameter("password");
    	String address = request.getParameter("address");
    	int age = Integer.parseInt(request.getParameter("age"));
    	String phone = request.getParameter("phone");
    	String favLanguage = request.getParameter("fav_language");
    	String cars = request.getParameter("cars");
    	String[] vehicles = request.getParameterValues("vehicle");
    	String date = request.getParameter("date");
    	String allVechiles = String.join(", ", vehicles);
    %>
    
    
	<p><span>Your ID:</span> <%= id %></p>
	<p><span>Your Name:</span> <%= name %></p>
	<p><span>Your Password:</span> <%= password %></p>
	<p><span>Your Address:</span> <%= address %></p>
	<p><span>Your Age:</span> <%= age %></p>
	<p><span>Your Phone:</span> <%= phone %></p>
	<p><span>Your Favorite Language:</span> <%= favLanguage %></p>
	<p><span>Your Selected Car:</span> <%= cars %></p>
	<p><span>Your Selected Vehicle:</span> <%= allVechiles %></p>
	<p><span>Your Selected Date:</span> <%= date %></p>
</div>

</body>
</html>
