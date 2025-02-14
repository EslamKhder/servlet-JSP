<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Student"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Simple Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f4f4f4;
        }
        .form-container {
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        label, br {
            font-weight: bold;
        }
        input[type="text"], input[type="email"], input[type="password"], select {
            width: 100%;
            padding: 10px;
            margin: 5px 0 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        input[type="radio"], input[type="checkbox"] {
            margin-right: 5px;
        }
        button, input[type="submit"] {
            width: 100%;
            padding: 10px;
            background: #28a745;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        button:hover, input[type="submit"]:hover {
            background: #218838;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Register</h2>
        <form action="date.jsp" method="get">
            your name : <input type="text" name="fullName"> <br>
            password : <input type="password" name="password"> <br>
            
            Please select your favorite Web language: <br>
              <input type="radio" name="fav_language" value="H"> html<br>
              <input type="radio" name="fav_language" value="C"> css<br>
              <input type="radio" name="fav_language" value="JS"> javascript
            <br>
            cars:
            <select name="cars">
              <option value="volvo">Volvo</option>
              <option value="saab">Saab</option>
              <option value="mercedes">Mercedes</option>
              <option value="audi">Audi</option>
            </select>
            <br>
            
            <input type="checkbox" name="vehicle" value="Bike">Bike
            <br>
            <input type="checkbox" name="vehicle" value="Car">Car
            <br>
            <input type="checkbox" name="vehicle" value="Boat">Boat
            <br>

<label for="date">Select a date:</label>
    <input type="date" id="date" name="date">
            <input type="submit">
        </form>
    </div>
</body>
</html>
