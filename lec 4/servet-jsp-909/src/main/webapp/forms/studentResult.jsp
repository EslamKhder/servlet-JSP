<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    body {
        font-family: Arial, Helvetica, sans-serif;
        background-color: #f4f6f9;
        margin: 0;
        padding: 20px;
    }

    h1 {
        font-size: 18px;
        color: #333;
        background: #ffffff;
        padding: 10px 15px;
        margin: 8px 0;
        border-left: 5px solid #4CAF50;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }

    h1:first-of-type {
        font-size: 26px;
        text-align: center;
        background: #4CAF50;
        color: #fff;
        border-left: none;
    }

    h1:nth-of-type(11) {
        background: #2196F3;
        color: #fff;
        border-left: none;
        text-align: center;
    }
</style>

</head>
<body>
	<h1>studentResult</h1>
	<h1>id: ${param.id}</h1>
	<h1>name: ${param.name}</h1>
	<h1>password: ${param.password}</h1>
	<h1>address: ${param.address}</h1>
	<h1>age: ${param.age}</h1>
	<h1>fav_language: ${param.fav_language}</h1>
	<h1>cars: ${param.cars}</h1>
	<h1>vehicle: ${param.vehicle}</h1>
	<h1>date: ${param.date}</h1>
	
	<h1>--------->after using java</h1>
	<!-- java -->
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
		
		// conn DB
		// insert 
		// exc
		// commit 
		// su insert
		
	%>
	
	<h1>id: <%= id %></h1>
	<h1>name: <%= name %></h1>
	<h1>password: <%= password %></h1>
	<h1>address: <%= address %></h1>
	<h1>age: <%= age %></h1>
	<h1>fav_language: <%= fav_language %></h1>
	<h1>cars: <%= cars %></h1>
	<%
		for(String ve: vehicles){
			out.print("<h1>" + ve + "</h1>");
		}
	%>
	<h1>date: <%= date %></h1>
	
	
</body>
</html>