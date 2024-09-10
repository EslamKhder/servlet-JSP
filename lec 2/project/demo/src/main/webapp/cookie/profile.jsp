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
		String favLang = "";
	
		Cookie[] coo = request.getCookies();
		/*
			id: 5      // 0             
			application.language : FR    // 1
			application.player : messi   // 2
			application.programming: java // 3
		*/
		
		if (coo != null) {
			for(int i=0;i<coo.length;i++){
				if (coo[i].getName().equals("application.language")) {
					favLang = coo[i].getValue();
					break;
				}
			}
		}
	%>
	
	<h1>your language <%= favLang %> </h1>
</body>
</html>