package com.servlet.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo
 */
// http://localhost:8080/servlet-jsp-911/Demo
@WebServlet("/Demo")
public class Demo extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter =  response.getWriter();
		
		printWriter.append("<h1>i am on doGet</h1>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    response.setContentType("text/html");

	    PrintWriter printWriter = response.getWriter();

	    Integer id = Integer.parseInt(request.getParameter("id"));
	    String name = request.getParameter("name");
	    String password = request.getParameter("password");
	    String address = request.getParameter("address");
	    String age = request.getParameter("age");
	    String fav_language = request.getParameter("fav_language");
	    String cars = request.getParameter("cars");
	    String[] vehicles = request.getParameterValues("vehicle");
	    String date = request.getParameter("date");

	    printWriter.println("<html>");
	    printWriter.println("<head>");
	    printWriter.println("<title>User Data</title>");
	    printWriter.println("</head>");
	    printWriter.println("<body>");

	    printWriter.println("<h1>User Information</h1>");

	    printWriter.println("<h3>ID: " + id + "</h3>");
	    printWriter.println("<h3>Name: " + name + "</h3>");
	    printWriter.println("<h3>Password: " + password + "</h3>");
	    printWriter.println("<h3>Address: " + address + "</h3>");
	    printWriter.println("<h3>Age: " + age + "</h3>");
	    printWriter.println("<h3>Favorite Language: " + fav_language + "</h3>");
	    printWriter.println("<h3>Cars: " + cars + "</h3>");
	    printWriter.println("<h3>Date: " + date + "</h3>");

	    printWriter.println("<h3>Vehicles:</h3>");

	    if (vehicles != null) {

	        printWriter.println("<ul>");

	        for (String vehicle : vehicles) {
	            printWriter.println("<li>" + vehicle + "</li>");
	        }

	        printWriter.println("</ul>");

	    } else {

	        printWriter.println("<p>No vehicles selected</p>");
	    }

	    printWriter.println("</body>");
	    printWriter.println("</html>");
	}

}
