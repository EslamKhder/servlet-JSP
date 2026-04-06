<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="selectedItem.jsp">
		your order: <input type="text" name="order">
		<input type="submit" value="take order">
	</form>
	
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