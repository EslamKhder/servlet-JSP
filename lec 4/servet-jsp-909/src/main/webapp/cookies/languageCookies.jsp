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
	cookie.setMaxAge(10);
	response.addCookie(cookie);
%>

<a href="main-page.jsp">main page</a>
</body>
</html>