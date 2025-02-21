<%@page import="java.util.List"%>
<%@page import="model.Item"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Show Items</title>
    <link rel="stylesheet" href="css/show-items.css">
</head>
<body>
<div class="layer">
	<% 
		List<Item> items = (List<Item>)request.getAttribute("itemData");
	%>
    <table>
        <h1>Items</h1>
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
        	for(int i=0;i<items.size();i++){
        		out.print("<tr><td>" + items.get(i).getId() +"</td>");
        		out.print("<td>" + items.get(i).getName() +"</td>");
        		out.print("<td>" + items.get(i).getPrice() +"</td>");
        		out.print("<td>" + items.get(i).getTotalNumber() +"</td>");
        		out.print("<td><a>Update</a><a>Delete</a></td></tr>");
        	}
        %>
        
        </tbody>
    </table>


    <button class="f"><a href="add-item.html" >Add Item</a></button>


</div>

</body>
</html>
