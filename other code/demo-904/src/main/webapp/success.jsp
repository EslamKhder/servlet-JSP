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
			String favLanguage = request.getParameter("fav_language");
			Cookie coo = new Cookie("application.language", favLanguage);
			coo.setMaxAge(10); // 
			
			response.addCookie(coo);
		%>
		
		<h1>success selected language</h1>
		<a href="main.jsp" >go to main Profile</a>
</body>
</html>