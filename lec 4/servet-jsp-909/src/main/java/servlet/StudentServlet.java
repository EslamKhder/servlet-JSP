package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
//     javax.sql.DataSource

import model.Item;


@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {

	@Resource(name = "jdbc/connection")
	private DataSource dataSource;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		PrintWriter printWriter =  response.getWriter();
		try {
			
			Connection connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			
			//?id=78&name=test&price=10&totalNumber=12
			int id = Integer.parseInt(request.getParameter("id"));
			/*String name = request.getParameter("name");
			int price = Integer.parseInt(request.getParameter("price"));
			double totalNumber = Double.parseDouble(request.getParameter("totalNumber"));
			*/
			//String query = "INSERT INTO ITEM VALUES (" + id + ", '" + name +"', " + price + ", " + totalNumber+ ")";
			
			//String query = "UPDATE ITEM SET NAME = '" + name+"', price = " + price + ", total_number = " + totalNumber + " where id = " + id;
			
			String query = "delete from ITEM where id = " + id;
			statement.execute(query);
			
			printWriter.append("<h1>deleted success</h1>");
			
			/*String query = "SELECT * from Item";
			ResultSet resultSet = statement.executeQuery(query);
			
			List<Item> items = extractItems(resultSet, printWriter);
			
			
			printWriter.append("<h1>size: " + items.size() + "</h1>");*/
		} catch (SQLException e) {
			printWriter.append("<h1>Exception: " + e.getMessage() + "</h1>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}
	
	
	
	private List<Item> extractItems(ResultSet resultSet, PrintWriter printWriter) {
		List<Item> items = new ArrayList();
		try {
			
			while (resultSet.next()) {
				Item item = new Item();
				
				item.setId(resultSet.getInt("ID"));
				item.setName(resultSet.getString("NAME"));
				item.setPrice(resultSet.getInt("PRICE"));
				item.setTotalNumber(resultSet.getDouble("TOTAL_NUMBER"));
				
				items.add(item);
			}
		} catch (SQLException e) {
			printWriter.append("<h1>Exception: " + e.getMessage() + "</h1>");
		}
		
		return items;
	}
	
	
	void start1(Boolean ex) throws SQLException {
		if (ex) {
			throw new SQLException("aa");
		}
	}
	
	void start2(Boolean ex) throws Exception {
		if (ex) {
			throw new Exception("aa");
		}
	}

}
