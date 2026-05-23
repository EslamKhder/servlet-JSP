<%@page import="java.util.Objects"%>
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
	String arabicValue = "مرحبا";
	String englishValue = "Welcome";

	String currentLan = null;
	Cookie[] cookies = request.getCookies();
	
	for(Cookie cookie: cookies){
		if (cookie.getName().equals("fav_language")) {
			currentLan = cookie.getValue();
			break;
		}
	}
	
	if (Objects.isNull(currentLan)) {
		out.print("<h1>no language found can't show this page</h1>");
		return;
	}
	
	if (currentLan.equals("arabic")) {
		out.print("<h1>" + arabicValue + "</h1>");
	}
	
	if (currentLan.equals("english")) {
		out.print("<h1>" + englishValue + "</h1>");
	}
	
	
%>

</body>
</html>