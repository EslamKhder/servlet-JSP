<%@page import="com.servlet.model.Item"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Items Table</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: #f4f6f9;
        margin: 0;
        padding: 40px;
    }

    h1 {
        text-align: center;
        color: #333;
    }

    table {
        width: 70%;
        margin: 30px auto;
        border-collapse: collapse;
        background: white;
        box-shadow: 0 5px 15px rgba(0,0,0,0.1);
        border-radius: 10px;
        overflow: hidden;
    }

    th, td {
        padding: 12px 15px;
        text-align: center;
    }

    th {
        background: #667eea;
        color: white;
        font-size: 16px;
    }

    tr:nth-child(even) {
        background: #f2f2f2;
    }

    tr:hover {
        background: #e6e9ff;
        transition: 0.3s;
    }
</style>

</head>
<body>

<h1>Items List</h1>

<table>
    <tr>
        <th>#</th>
        <th>ID</th>
        <th>Name</th>
        <th>Grade</th>
    </tr>

<%!
	public String toUpperCase(String value){
		return value.toUpperCase();
	}
	List<Item> items2 = Item.getItems();
%>
<%
    for(int i = 0; i < items2.size(); i++){
%>
    <tr>
        <td><%= (i + 1) %></td>
        <td><%= items2.get(i).getId() %></td>
        <td><%= toUpperCase(items2.get(i).getName()) %></td>
        <td><%= items2.get(i).getPrice() %></td>
    </tr>
<%
    }
%>

</table>

</body>
</html>