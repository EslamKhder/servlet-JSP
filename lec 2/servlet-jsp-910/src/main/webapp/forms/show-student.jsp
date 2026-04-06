<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Details</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: linear-gradient(to right, #4facfe, #00f2fe);
        margin: 0;
        padding: 0;
    }

    .container {
        width: 60%;
        margin: 50px auto;
        background: #fff;
        padding: 30px;
        border-radius: 15px;
        box-shadow: 0 10px 25px rgba(0,0,0,0.2);
    }

    h1 {
        font-size: 20px;
        color: #333;
        border-bottom: 1px solid #eee;
        padding-bottom: 8px;
        margin-bottom: 15px;
    }

    h1 span {
        color: #007BFF;
        font-weight: bold;
    }

    .title {
        text-align: center;
        font-size: 28px;
        margin-bottom: 25px;
        color: #007BFF;
    }
    .row {
    font-size: 18px;
    color: #444;
    padding: 10px 0;
    border-bottom: 1px solid #eee;
}

.row span {
    color: #007BFF;
    font-weight: bold;
    margin-left: 10px;
}

/* Vehicles style */
.badge {
    display: inline-block;
    background: #007BFF;
    color: white;
    padding: 5px 10px;
    border-radius: 10px;
    margin: 3px;
    font-size: 14px;
}
</style>

</head>
<body>

<div class="container">
    <div class="title">User Information</div>

    <h1>ID: <span>${param.id}</span></h1>
    <h1>Name: <span>${param.name}</span></h1>
    <h1>Password: <span>${param.password}</span></h1>
    <h1>Address: <span>${param.address}</span></h1>
    <h1>Age: <span>${param.age}</span></h1>
    <h1>Favorite Language: <span>${param.fav_language}</span></h1>
    <h1>Cars: <span>${param.cars}</span></h1>
    <h1>Vehicle: <span>${param.vehicle}</span></h1>
    <h1>Date: <span>${param.date}</span></h1>
</div>

	<%
	    Integer id = Integer.parseInt(request.getParameter("id"));
	    String name = request.getParameter("name");
	    String password = request.getParameter("password");
	    String address = request.getParameter("address");
	    float age = Float.parseFloat(request.getParameter("age"));
	    String favLanguage = request.getParameter("fav_language");
	    String cars = request.getParameter("cars");
	    String[] vehicles = request.getParameterValues("vehicle");
	    String date = request.getParameter("date");
	%>

<div class="container">
    <div class="title">User Information (Scriptlet)</div>

    <div class="row">ID: <span><%= id %></span></div>
    <div class="row">Name: <span><%= name.toUpperCase() %></span></div>
    <div class="row">Password: <span><%= password %></span></div>
    <div class="row">Address: <span><%= address %></span></div>
    <div class="row">Age: <span><%= age %></span></div>
    <div class="row">Favorite Language: <span><%= favLanguage %></span></div>
    <div class="row">Cars: <span><%= cars %></span></div>

    <div class="row">
        Vehicles:
        <span>
            <%
                if (vehicles != null) {
                    for (String vehicle : vehicles) {
                        out.print("<div class='badge'>" + vehicle + "</div>");
                    }
                }
            %>
        </span>
    </div>

    <div class="row">Date: <span><%= date %></span></div>
</div>
</body>
</html>