package itemservice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import item.model.Item;

/**
 * Servlet implementation class TestItem
 */
@WebServlet("/TestItem")
public class TestItem extends HttpServlet {
       
	@Resource(name = "jdbc/web_item")
	private DataSource dataSource;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		
		ItemUtilService itemUtilService = new ItemUtilService(dataSource);
		
		Item item = new Item();
		item.setName("item10");
		item.setPrice(85);
		item.setTotalNumber(150);
		printWriter.print("<h1>done</h1>");
		try {
			itemUtilService.saveItem(item);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*try {
			List<Item> items = itemUtilService.getAllItem();
			for(Item i: items) {
				printWriter.print("<h1>" + i.getId() + "</h1>");
				printWriter.print("<h1>" + i.getName() + "</h1>");
				printWriter.print("<h1>" + i.getPrice() + "</h1>");
				printWriter.print("<h1>" + i.getTotalNumber() + "</h1>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*try {
			Connection connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			
			String sql = "select * from item";
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				printWriter.print("<h1>" + resultSet.getString("id") + "</h1>");
				printWriter.print("<h1>" + resultSet.getString("name") + "</h1>");
				printWriter.print("<h1>" + resultSet.getString("price") + "</h1>");
				printWriter.print("<h1>" + resultSet.getString("total_number") + "</h1>");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("----> " + e.getMessage());
		}*/
		
		
	}



}
