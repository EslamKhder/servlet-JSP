<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Objects"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    body {
        font-family: Arial, Helvetica, sans-serif;
        background-color: #f4f6f9;
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        margin: 0;
    }

    .result-box {
        background: #ffffff;
        padding: 30px 40px;
        border-radius: 12px;
        box-shadow: 0 6px 15px rgba(0, 0, 0, 0.15);
        text-align: center;
        min-width: 320px;
    }

    .result-box h2 {
        margin: 0 0 15px;
        color: #333;
        font-size: 22px;
    }

    .order-value {
        font-size: 20px;
        font-weight: bold;
        color: #4CAF50;
        background: #f1f8f4;
        padding: 10px 15px;
        border-radius: 8px;
        display: inline-block;
        margin-top: 10px;
    }
</style>
</head>
<body>

	<!--  
		book1   *****                      allOrders [book1]
		book2                              allOrders [book1, book2]
		book3                              allOrders [book1, book2, book3]
	 -->
	<%
		List<String> allOrdersSelected =  (List<String>)session.getAttribute("allOrders");
	
		if(Objects.isNull(allOrdersSelected)){
			allOrdersSelected = new ArrayList();
			session.setAttribute("allOrders", allOrdersSelected);
		}
		
		String selectedOrder = request.getParameter("order");
		if(Objects.nonNull(selectedOrder)){
			allOrdersSelected.add(selectedOrder);
		}
		
	%>
	
 	<div class="result-box">
        <h2>Selected Order is:</h2>
        <%
       		if(!allOrdersSelected.isEmpty()) {
       			for(String or: allOrdersSelected){
    	    		out.print("<div class='order-value'>" + or + "</div>");
    	    	}
       		} else {
       			out.print("<div class='order-value'>no order selected</div>");
       		}
        %>
    </div>
</body>
</html>