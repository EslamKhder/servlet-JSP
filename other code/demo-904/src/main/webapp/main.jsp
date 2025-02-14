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
		String favLan = "no language";
		Cookie[] cookie = request.getCookies();//5
		
		if(cookie != null){
			for(int i=0;i<cookie.length; i++){
				if(cookie[i].getName().equals("application.language")){
					favLan= cookie[i].getValue();
					break;
				}
			}
		}
		out.print("<h1> your language is : " + favLan +"</h1>");
	%>
</body>
</html>