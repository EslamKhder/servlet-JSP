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
  <link rel="stylesheet" href="css/show-items.css">
  <style>
    /* General reset */
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
      font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
    }

    body {
      background: linear-gradient(135deg, #74ebd5, #9face6);
      min-height: 100vh;
      display: flex;
      justify-content: center;
      align-items: center;
      padding: 30px;
    }

    .layer {
      background: #fff;
      padding: 30px;
      border-radius: 16px;
      box-shadow: 0 8px 24px rgba(0,0,0,0.1);
      width: 100%;
      max-width: 900px;
      animation: fadeIn 0.6s ease-in-out;
    }

    h1 {
      text-align: center;
      margin-bottom: 20px;
      color: #333;
      font-size: 28px;
    }

    table {
      width: 100%;
      border-collapse: collapse;
      margin-bottom: 20px;
    }

    thead {
      background: #4e73df;
      color: #fff;
    }

    thead th {
      padding: 12px;
      font-size: 16px;
      letter-spacing: 0.5px;
      text-transform: uppercase;
    }

    tbody tr {
      background: #f9f9f9;
      transition: background 0.3s;
    }

    tbody tr:nth-child(even) {
      background: #f1f5fb;
    }

    tbody td {
      padding: 12px;
      text-align: center;
      color: #444;
    }

    tbody tr:hover {
      background: #e8f0fe;
    }

    a {
      display: inline-block;
      margin: 0 5px;
      padding: 6px 12px;
      border-radius: 6px;
      text-decoration: none;
      font-size: 14px;
      transition: 0.3s;
    }

    a:hover {
      opacity: 0.85;
    }

    a:first-child {
      background: #1cc88a;
      color: #fff;
    }

    a:last-child {
      background: #e74a3b;
      color: #fff;
    }

    .f {
      display: block;
      margin: 0 auto;
      padding: 12px 24px;
      background: #4e73df;
      color: #fff;
      border: none;
      border-radius: 8px;
      font-size: 16px;
      font-weight: bold;
      cursor: pointer;
      transition: 0.3s;
    }

    .f:hover {
      background: #2e59d9;
    }

    .f a {
      color: #fff;
      text-decoration: none;
    }

    @keyframes fadeIn {
      from { opacity: 0; transform: translateY(10px); }
      to { opacity: 1; transform: translateY(0); }
    }
  </style>
</head>
<body>
<div class="layer">
<%
	List<Item> items = (List<Item>) request.getAttribute("items");
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
    <%
    	for(Item item: items){
    		
    %>
      <tr>
        <td><strong><%=item.getId() %></strong></td>
        <td><%=item.getName() %></td>
        <td>$<%=item.getPrice() %></td>
        <td><%=item.getTotalNumber() %></td>
        <td>
          <a href="#">Update</a>
          <a href="/item-service-907/ItemController?action=delete-item&id=<%=item.getId() %>">Delete</a>
        </td>
      </tr>
    <%
      	}
    %>
    </tbody>
  </table>

  <button class="f"><a href="#">➕ Add Item</a></button>
</div>
</body>
</html>
