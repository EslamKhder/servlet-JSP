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
	String language = request.getParameter("language");
	Cookie cookie = new Cookie("fav_language", language);
	cookie.setMaxAge(60 * 60 * 24 * 365); // 4/8/2025 10:37 ------>    4/8/2026 10:37 
	// 365
	// 60 * 60 * 24 * 365
	
	response.addCookie(cookie);
%>

<h1>language saved</h1>
<a href="main-page.jsp">main page</a>
</body>
</html>