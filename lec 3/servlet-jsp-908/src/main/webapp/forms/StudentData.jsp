<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form Example</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: linear-gradient(to right, #74ebd5, #ACB6E5);
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    form {
        background: #fff;
        padding: 25px 40px;
        border-radius: 12px;
        box-shadow: 0 4px 12px rgba(0,0,0,0.2);
        width: 400px;
    }
    label {
        font-weight: bold;
        display: block;
        margin: 10px 0 5px;
    }
    input[type="text"],
    input[type="number"],
    input[type="password"],
    input[type="date"],
    select {
        width: 100%;
        padding: 8px;
        border: 1px solid #ccc;
        border-radius: 6px;
        margin-bottom: 15px;
        font-size: 14px;
    }
    input[type="radio"],
    input[type="checkbox"] {
        margin-right: 8px;
    }
    p {
        margin: 15px 0 8px;
        font-weight: bold;
    }
    input[type="submit"] {
        background: #4CAF50;
        color: white;
        padding: 12px;
        border: none;
        border-radius: 6px;
        cursor: pointer;
        font-size: 16px;
        width: 100%;
    }
    input[type="submit"]:hover {
        background: #45a049;
    }
</style>
</head>
<body>
<form action="/servlet-jsp-908/ServletApp" method="post">
    <label>ID:</label>
    <input type="number" name="id" required>

    <label>Name:</label>
    <input type="text" name="name" required>

    <label>Password:</label>
    <input type="password" name="password" required>

    <label>Address:</label>
    <input type="text" name="address" required>

    <label>Age:</label>
    <input type="number" name="age" required>

    <p>Please select your favorite Web language:</p>
    <input type="radio" name="fav_language" value="H"> HTML<br>
    <input type="radio" name="fav_language" value="C"> CSS<br>
    <input type="radio" name="fav_language" value="JS"> JavaScript<br>

    <label>Cars:</label>
    <select name="cars">
        <option value="volvo">Volvo</option>
        <option value="saab">Saab</option>
        <option value="mercedes">Mercedes</option>
        <option value="audi">Audi</option>
    </select>

    <label>Vehicles:</label>
    <input type="checkbox" name="vehicle" value="Bike"> Bike
    <input type="checkbox" name="vehicle" value="Car"> Car
    <input type="checkbox" name="vehicle" value="Boat"> Boat

    <label for="date">Select a date:</label>
    <input type="date" id="date" name="date">

    <input type="submit" value="Submit">
</form>
</body>
</html>
