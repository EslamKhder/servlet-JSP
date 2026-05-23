package com.servlet.demo;

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


@WebServlet("/DBConnection")
public class DBConnection extends HttpServlet {

	
	@Resource(name = "jdbc/test")
	private DataSource dataSource;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter printWriter = response.getWriter();
		try {
			Connection connection = dataSource.getConnection();
			//String query = "SELECT * FROM item where id = 41";
			String query = "INSERT INTO HR.ITEM (ID, NAME, PRICE, TOTAL_NUMBER) VALUES(700, 'i1', 745, 125)";
			// String query = "UPDATE HR.ITEM SET NAME='updated_tes', PRICE=0, TOTAL_NUMBER=0 WHERE ID=45";
			String query = "DELETE FROM ITEM WHERE ID = 45";
			Statement statement = connection.createStatement();
			statement.execute(query);
			printWriter.append("<h1> DELETE success</h1>");
			//ResultSet resultSet = statement.executeQuery(query);
			
			
			
			/*
			// r
			// 1 2 3
			if(resultSet.next()) {
				int id = resultSet.getInt("ID");
				String name = resultSet.getString("NAME");
				Double price = resultSet.getDouble("PRICE");
				Double totalNumber = resultSet.getDouble("TOTAL_NUMBER");
				printWriter.append(
					    "<h1> ID: " + id +
					    ", Name: " + name +
					    ", Price: " + price +
					    ", Total Number: " + totalNumber +
					    "</h1>"
					);
			}
			
			*/
						
			// insert
			// update
			// select
			// delete
			
			
			//printWriter.append("<h1> connection success " + connection + " </h1>");
		} catch (SQLException e) {
			printWriter.append("<h1> ex: " + e.getMessage() + " </h1>");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
