package com.servlet.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/ItemServlet")
public class ItemServlet extends HttpServlet {
	
	@Resource(name = "jdbc/itemConnection")
	private DataSource dataSource;
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter printWriter = response.getWriter();
		try {
			
			/*String id = request.getParameter("id");
			if(Objects.isNull(id)) {
				printWriter.print("<h1>no id found.</h1>");
				return;
			}*/
			
			Connection connection = dataSource.getConnection();
			String query = "delete from item where id = 40";
			Statement statement = connection.createStatement();
			
			statement.execute(query);
			
			printWriter.print("<h1>delete success</h1>");
			/*Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(query);
			
			if(resultSet.next()) {
				printWriter.print("<h1>" +resultSet.getInt("ID") + "</h1>");
				printWriter.print("<h1>" +resultSet.getString("NAME") + "</h1>");
				printWriter.print("<h1>" +resultSet.getDouble("PRICE") + "</h1>");
				printWriter.print("<h1>" +resultSet.getDouble("TOTAL_NUMBER") + "</h1>");
				
				printWriter.print("<h1>--------------------</h1>");
			} else {
				printWriter.print("<h1>no data found.</h1>");
				return;
			}
			
			/*resultSet.next(); // on 1 row
			
			printWriter.print("<h1>" +resultSet.getInt("ID") + "</h1>");
			printWriter.print("<h1>" +resultSet.getString("NAME") + "</h1>");
			printWriter.print("<h1>" +resultSet.getDouble("PRICE") + "</h1>");
			printWriter.print("<h1>" +resultSet.getDouble("TOTAL_NUMBER") + "</h1>");
			
			printWriter.print("<h1>--------------------</h1>");
			resultSet.next(); // on 2 row
			
			printWriter.print("<h1>" +resultSet.getInt("ID") + "</h1>");
			printWriter.print("<h1>" +resultSet.getString("NAME") + "</h1>");
			printWriter.print("<h1>" +resultSet.getDouble("PRICE") + "</h1>");
			printWriter.print("<h1>" +resultSet.getDouble("TOTAL_NUMBER") + "</h1>");
			printWriter.print("<h1>--------------------</h1>");
			
			resultSet.next(); // on 3 row
			
			printWriter.print("<h1>" +resultSet.getInt("ID") + "</h1>");
			printWriter.print("<h1>" +resultSet.getString("NAME") + "</h1>");
			printWriter.print("<h1>" +resultSet.getDouble("PRICE") + "</h1>");
			printWriter.print("<h1>" +resultSet.getDouble("TOTAL_NUMBER") + "</h1>");
			printWriter.print("<h1>--------------------</h1>");
			
			resultSet.next(); // on 4 row
			
			printWriter.print("<h1>" +resultSet.getInt("ID") + "</h1>");
			printWriter.print("<h1>" +resultSet.getString("NAME") + "</h1>");
			printWriter.print("<h1>" +resultSet.getDouble("PRICE") + "</h1>");
			printWriter.print("<h1>" +resultSet.getDouble("TOTAL_NUMBER") + "</h1>");
			*/
			
		} catch (SQLException e) {
			printWriter.print("<p>" + e.getMessage() + "</p>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
}



