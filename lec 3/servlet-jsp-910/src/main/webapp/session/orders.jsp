<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<String> orders = (List<String>)session.getAttribute("myOrders");
	    if(orders == null){
	    	orders = new ArrayList();
	    	session.setAttribute("myOrders", orders);
	    }
		String selectedOrder = request.getParameter("order");
		
		if (selectedOrder != null) {
			orders.add(selectedOrder);
		}
	%>
	
	<% 
		if (orders.isEmpty()) {
			out.print("<h1>no orders found</h1>");
		} else {
	
			out.print("<h1>selected order : </h1>");
			for(String order: orders){
				out.print("<p>" + order + "</p>");
			}
		}
	%>
</body>
</html>