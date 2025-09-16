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
	String language = "no language";
	Cookie cookies [] = request.getCookies(); // 1000    2
	
	for(Cookie cookie: cookies){
		if (cookie.getName().equals("fav_language")){
			language = cookie.getValue();
			break;
		}
	}
%>

<%= language %>
</body>
</html>