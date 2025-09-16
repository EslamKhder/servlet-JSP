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
<!-- book1  -->
<!-- book2  -->
<!-- book3  -->

	<%
	List<String> items = (List<String>)session.getAttribute("allItems");
	
	if (items == null) {
		items = new ArrayList();
		session.setAttribute("allItems", items); // 
	}
	
	String order = request.getParameter("order"); // book2
	if (order != null){
		items.add(order);
	}
	
	
	if (items != null && items.size() != 0){
		for(String o: items){
			out.print("<h1> " + o + "</h1>");
		}
	} else {
		out.print("<h1> no items here.</h1>");
	}
	
	%>
	
	
	
<% 
	//List<String> orders = (List<String>)session.getAttribute("allOrders");
	// no
	/*if (orders == null) {
		orders = new ArrayList();
		session.setAttribute("allOrders", orders); // allOrders [book1, book2]
	}

	String order = request.getParameter("order"); // book2
	orders.add(order);
	
	for(String o: orders){
		out.print("<h1> " + o + "</h1>");
	}*/
%>
</body>
</html>