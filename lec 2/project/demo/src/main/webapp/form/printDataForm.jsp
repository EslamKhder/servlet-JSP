<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
HI YOUR FIRST NAME : ${param.f_name}

<br>
<br>
HI YOUR LAST NAME : ${param.l_name}
<br>
<br>
HI favorite Programming with radio :  ${param.favProgramming}

<br>
<br>
HI favorite Programming :  ${param.favPr}

<br>
<br>
HI favorite Programming with checkbox :  ${param.favProgrammingWithCheckbox}

<%
	String[] favProgrammingWithCheckbox =  request.getParameterValues("favProgrammingWithCheckbox");

	for (int i=0;i<favProgrammingWithCheckbox.length;i++) {
		out.println("<h1>" + favProgrammingWithCheckbox[i] + "</h1>");
	}
%>

</body>
</html>