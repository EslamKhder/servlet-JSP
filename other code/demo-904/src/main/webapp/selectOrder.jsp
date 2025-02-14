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
		<form action="selectOrder.jsp" method="get">
			your order : <input type="text" name="order" > <br>
			<input type="submit" value="select item">
		</form>
		
	<% 
	// book1 book2
	
	List<String> orders = (List<String>)session.getAttribute("myOrders");
	
	if (orders == null) {
		System.out.print("is null");
		orders = new ArrayList();
		session.setAttribute("myOrders", orders);
	}
	
	String selectedOrder = request.getParameter("order");
	
	if (selectedOrder != null) {
		orders.add(selectedOrder);
	}
	
	for(String order: orders){
		out.print("<h1>" + order + "</h2>");
	}
	
	%>
		
</body>
</html>