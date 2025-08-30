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
        background: #f5f6fa;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    .card {
        background: #fff;
        padding: 25px 40px;
        border-radius: 12px;
        box-shadow: 0 4px 12px rgba(0,0,0,0.2);
        width: 400px;
    }
    h2 {
        margin-bottom: 20px;
        color: #4CAF50;
    }
    p {
        font-size: 16px;
        margin: 8px 0;
    }
    span {
        font-weight: bold;
        color: #333;
    }
</style>
</head>
<body>
<%!

	String toUpperCase(String value){
		return value.toUpperCase();
	}
%>
    <div class="card">
        <h2>Submitted Student Data</h2>
        <p>ID: <span>${param.id}</span></p>
        <p>Name: <span>toUpperCase(${param.name})</span></p>
        <p>Password: <span>${param.password}</span></p>
        <p>Address: <span>${param.address}</span></p>
        <p>Age: <span>${param.age}</span></p>
        <p>Favorite Language: <span>${param.fav_language}</span></p>
        <p>Vehicles: <span>${param.vehicle}</span></p>
        <p>Car: <span>${param.cars}</span></p>
        <p>Date: <span>${param.date}</span></p>
    </div>
    
    
    <div class="card">
    	<%
    	 Long id = Long.parseLong(request.getParameter("id"));
	        String name = toUpperCase(request.getParameter("name"));
	        String password = request.getParameter("password");
	        String address = request.getParameter("address");
	        String age = request.getParameter("age");
	        String favLang = request.getParameter("fav_language");
	        String[] vehicles = request.getParameterValues("vehicle");
	        String car = request.getParameter("cars");
	        String date = request.getParameter("date");
    	%>
		    <h2>Submitted Student Data</h2>
		    <p>ID: <span><%= id %></span></p>
		    <p>Name: <span><%= name %></span></p>
		    <p>Password: <span><%= password %></span></p>
		    <p>Address: <span><%= address %></span></p>
		    <p>Age: <span><%= age %></span></p>
		    <p>Favorite Language: <span><%= favLang %></span></p>
		    <p>Vehicles: 
		        <span>
		            <%
		                if (vehicles != null) {
		                    for (String v : vehicles) {
		                        out.print(v + " ");
		                    }
		                }
		            %>
		        </span>
		    </p>
		    <p>Car: <span><%= car %></span></p>
		    <p>Date: <span><%= date %></span></p>
		</div>
</body>
</html>
<!-- <p>Vehicles: <span>${paramValues.vehicle[0]} ${paramValues.vehicle[1]} ${paramValues.vehicle[2]}</span></p>
  -->
