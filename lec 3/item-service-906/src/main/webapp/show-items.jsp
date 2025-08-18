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
</head>
<body>
<div class="layer">

	<%
		List<Item> items = (List<Item>) request.getAttribute("allItems");
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
        	for(Item item: items){
        		out.print("<tr><td><strong>" + item.getId() + "</strong></td>");
        		out.print("<td>" + item.getName() + "</td>");
        		out.print("<td>" + item.getPrice() + "</td>");
        		out.print("<td>" + item.getTotalNumber() + "</td>");
        		out.print("<td><a>Update</a><a>Delete</a></td></tr>");
        	}
        %>
        </tbody>
    </table>


    <button class="f"><a href="" >Add Item</a></button>


</div>

</body>
</html>
