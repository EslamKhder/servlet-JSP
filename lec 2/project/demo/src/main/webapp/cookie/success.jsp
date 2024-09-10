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
	String language = request.getParameter("favLanguage");
	
	Cookie coo = new Cookie("application.language", language);
	coo.setMaxAge(365*24*60*60);
	
	response.addCookie(coo);
%>

<p>thanks for select your language</p> ${param.favLanguage}
<br>
<br>
<a href="profile.jsp">Profile</a>
</body>
</html>