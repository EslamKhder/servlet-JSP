<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        
        <c:forEach var="item" items="${itemsData}">
	        <tr>
	            <td>${item.id}</td>
	            <td>${item.name}</td>
	            <td>${item.price}</td>
	            <td>${item.totalNumber}</td>
	           <td>
	                <a href="ItemController?action=LOAD_ITEM&id=${item.id}">Update</a>
	                <a href="ItemController?action=DELETE&id=${item.id}">Delete</a>
	            </td>
	            
	        </tr>
        </c:forEach>
        
        </tbody>
    </table>


    <button class="f"><a href="" >Add Item</a></button>


</div>

</body>
</html>
