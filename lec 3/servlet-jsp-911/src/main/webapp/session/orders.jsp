<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Objects"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Orders</title>

<style>

    *{
        margin:0;
        padding:0;
        box-sizing:border-box;
    }

    body{
        font-family: Arial, sans-serif;
        background: linear-gradient(135deg, #0f172a, #1e293b);
        min-height:100vh;
        display:flex;
        justify-content:center;
        align-items:center;
    }

    .container{
        background:white;
        width:450px;
        padding:30px;
        border-radius:15px;
        box-shadow:0 10px 25px rgba(0,0,0,0.3);
    }

    h1{
        text-align:center;
        margin-bottom:20px;
        color:#0f172a;
    }

    .item{
        background:#eff6ff;
        padding:12px;
        margin-bottom:10px;
        border-left:5px solid #2563eb;
        border-radius:8px;
        font-size:18px;
        color:#1e293b;
    }

    .empty{
        text-align:center;
        color:red;
        font-size:22px;
    }

</style>

</head>

<body>

<div class="container">

<%

    List<String> items = (List<String>) session.getAttribute("allItems");

    // Create session list if not exists
    if (Objects.isNull(items)) {
        items = new ArrayList<>();
        session.setAttribute("allItems", items);
    }

    // Get selected item from request
    String selectedItem = request.getParameter("item");

    if (items.contains(selectedItem)) {
    	out.print("<div class='empty'> item already selected before </div");
    	return;
    }
    // Add item if exists
    if (Objects.nonNull(selectedItem) && !selectedItem.trim().isEmpty()) {
        items.add(selectedItem);
    }

%>

<h1>My Ordered Items</h1>

<%

    if (items.isEmpty()) {
%>

        <div class="empty">
            No items found
        </div>

<%
    } else {

        for(String item : items){
%>

            <div class="item">
                <%= item %>
            </div>

<%
        }
    }
%>

</div>

</body>
</html>