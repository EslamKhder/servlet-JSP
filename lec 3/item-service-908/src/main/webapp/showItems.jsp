<%@page import="com.item.model.Item"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Show Items</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f9;
            margin: 0;
            padding: 20px;
        }

        .layer {
            max-width: 900px;
            margin: auto;
            background: #fff;
            padding: 25px;
            border-radius: 12px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.1);
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 25px;
        }

        thead {
            background-color: #007bff;
            color: #fff;
        }

        th, td {
            padding: 12px 15px;
            text-align: center;
            border: 1px solid #ddd;
        }

        tbody tr:nth-child(even) {
            background: #f9f9f9;
        }

        tbody tr:hover {
            background: #f1f1f1;
        }

        a {
            text-decoration: none;
            color: #007bff;
            font-weight: bold;
            margin: 0 8px;
            transition: 0.3s;
        }

        a:hover {
            color: #0056b3;
        }

        .f {
            display: block;
            margin: auto;
            padding: 12px 20px;
            border: none;
            border-radius: 8px;
            background: #28a745;
            cursor: pointer;
            transition: 0.3s;
        }

        .f a {
            color: #fff;
            font-size: 16px;
            font-weight: bold;
        }

        .f:hover {
            background: #218838;
        }
    </style>
</head>
<body>
<div class="layer">
<%
       List<Item> items = (List<Item>)request.getAttribute("allItems");
%>
    <h1>Items</h1>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>PRICE</th>
            <th>TOTAL_NUMBER</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <%for(Item item: items){ %>
        <tr>
            <td><strong><%=item.getId() %></strong></td>
            <td><%=item.getName() %></td>
            <td><%=item.getPrice() %></td>
            <td><%=item.getTotalNumber() %></td>
            <td>
                <a href="/item-service-908/ItemController?action=getItem&id=<%=item.getId() %>">Update</a> 
                <a href="/item-service-908/ItemController?action=deleteItem&id=<%=item.getId() %>">Delete</a>
            </td>
        </tr>
        <%} %>
        </tbody>
    </table>

    <button class="f"><a href="add-item.html">Add Item</a></button>
</div>
</body>
</html>
