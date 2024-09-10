<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Orders</title>
</head>
<body>

	<%
		List<String> items = (List<String>) session.getAttribute("orderItems");
	
		if (items == null) {
			items = new ArrayList();
			session.setAttribute("orderItems", items);
		}
		
		String selectedOrder = request.getParameter("order");
		
		if (selectedOrder != null) {
			items.add(selectedOrder);
		}
		
		
		for(int i=0;i<items.size();i++){
			out.println("<h1>" + items.get(0) + "</h1>");
		}
	%>
	
	
	
</body>
</html>