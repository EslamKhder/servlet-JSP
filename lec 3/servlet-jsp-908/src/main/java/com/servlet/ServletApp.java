package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ServletApp
 */
@WebServlet("/ServletApp")
public class ServletApp extends HttpServlet {

	@Resource(name = "jdbc/item")
	private DataSource dataSource;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		
		try {
			
			Connection connection = dataSource.getConnection();
			String query = "SELECT * FROM item";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				int id =  resultSet.getInt("id");
				String name = resultSet.getString("name");
				double price = resultSet.getDouble("price");
				double totalNumber = resultSet.getInt("total_number");
				
				printWriter.append("<h1>" + id + "</h1>");
				printWriter.append("<h1>" + name + "</h1>");
				printWriter.append("<h1>" + price + "</h1>");
				printWriter.append("<h1>" + totalNumber + "</h1>");
				printWriter.append("<h1>------------------------------</h1>");
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			printWriter.append("<h1>" + e.getMessage() + "</h1>");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
	}

}
