package com.servlet.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet {

	
	@Resource(name = "jdbc/demo")
	private DataSource dataSource;
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		try {
			Connection connection = dataSource.getConnection();
			printWriter.append("<h1>Connection success </h1>");
			
			int id = 44;
			String name = "test2";
			int p = 2;
			int tn = 2;
	        //String query = "INSERT INTO ITEM (ID, NAME, PRICE, TOTAL_NUMBER) VALUES(" + id + ", '" + name + "', " + p + ", " +tn + ")";
			//String query = "update ITEM set NAME = '" + name + "', PRICE = " + p + ", TOTAL_NUMBER = " + tn + " where id = " + id; 
	        String query = "delete from item where id = " + id;
			Statement statement = connection.createStatement();
			
			statement.execute(query);
			printWriter.append("<h1>success delete </h1>");
			/*ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				long id = resultSet.getLong("id");
				String name = resultSet.getString("NAME");
				double price = resultSet.getDouble("Price");
				int totalNumber = resultSet.getInt("TOTAL_NUMBER");
				printWriter.append("<h1>" + id + " - " + name + " - " + price + " - " + totalNumber + "</h1>");
			}*/
			
			
		} catch (SQLException e) {
			printWriter.append("<h1>Connection failed: " + e.getMessage() + " </h1>");
		} 
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
