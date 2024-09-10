<!DOCTYPE html>
<%@page import="java.util.Date"%>
<html>
<head>
<title>start</title>
</head>
<body>
<%!
	String getNameInUpperCase(String name){
	    return name.toUpperCase();
	}

	int numberofVis = 5;
%>
HI : <% out.println("<h1> " + getNameInUpperCase("eslam") + "</h1>"); %>


HI local time : <%=new Date() %>
<br>
counts of people : <%= numberofVis %>
<%
	for (int i=1;i<=5;i++) {
		out.println("<h2> hi Student " + i + "</h2>");
	}

	
%>
</body>
</html>