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

	<form action="orderV2.jsp" method="get">
		write order : <input type="text" name="order" />
		<br>
		<br>
		<input type="submit" value="Add Order">
	</form>
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
			out.println("<h1>" + items.get(i) + "</h1>");
		}
	%>
</body>
</html>