<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.ArrayList"%>
<%@page import="demo.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
table, th, td {
  border:1px solid black;
}
</style>
<body>

<%
	List<Student> students = new ArrayList();
	students.add(new Student(1, "ahmed" , true));
	students.add(new Student(2, "moahmed" , false));
	students.add(new Student(3, "mona" , true));
	students.add(new Student(4, "Mai" , true));
	students.add(new Student(5, "osama" , false));
	
	pageContext.setAttribute("allStudents", students);
%>
<h2>Student Data</h2>

<table style="width:100%">
  <tr>
    <th>id</th>
    <th>name</th>
    <th>active</th>
  </tr>
  <c:forEach var="stu" items="${allStudents}">
	  <tr>
	    <td>${stu.id}</td>
	    <td>${stu.name}</td>
	    <td>
			<c:choose>
		    	<c:when test="${stu.active}">
		    		Active Student NICE
		    	</c:when>
		    	<c:otherwise>
		    		IN Active Student BAD
		    	</c:otherwise>
		    </c:choose>
		</td>
	  </tr>
  </c:forEach>
  
</table>


</body>
</html>