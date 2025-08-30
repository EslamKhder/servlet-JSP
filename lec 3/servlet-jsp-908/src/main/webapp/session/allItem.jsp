<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Objects"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="allItem.jsp">
		your order: <input type="text" name="order">
		<input type="submit" value="take order">
	</form>
	
	<%
	
	List<String> orders =  (List<String>)session.getAttribute("myOrders");

	if(Objects.isNull(orders)){
		orders = new ArrayList();
		session.setAttribute("myOrders", orders);
	}
	
	
	String order = request.getParameter("order"); // book1
	if(Objects.nonNull(order)){
		orders.add(order);
	}
	

%>


<h1><%
		if(orders.isEmpty()){
			out.print("no data found");
			return;
		}
		for(String or: orders){
			out.print("<p>" + or + "</p>");
		}
		
	%></h1>
</body>
</html>

<!-- book1  -->
<!-- book2  -->
<!-- book3  -->