package itemservice;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ItemController
 */
@WebServlet("/ItemController")
public class ItemController extends HttpServlet {
	
	@Resource(name = "jdbc/web_item")
	private DataSource dataSource;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemController() {
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String finalAction = request.getParameter("action");
		
		if (finalAction == null) {
			finalAction = "LOAD_ITEMS";
		}
		
		switch(finalAction) {
			case "ADD":
				addItem(request, response);
				break;
			case "LOAD_ITEMS":
				loadItems(request, response);
				break;
			case "LOAD_ITEM":
				
				break;
			case "DELETE":
				
				break;
			case "UPDATE":
				
				break;
			default:
				
		}
	}
	
	
	void addItem(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			ItemUtilService itemUtilService = new ItemUtilService(dataSource);
			String name = (String) request.getAttribute("name");
			double price = (double) request.getAttribute("price");
			int totalNumber = (int) request.getAttribute("totalNumber");
			
			Item item = new Item(name, price, totalNumber);
			itemUtilService.saveItem(item);
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/show-items.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void loadItems(HttpServletRequest request, HttpServletResponse response) {
			
		try {
			ItemUtilService itemUtilService = new ItemUtilService(dataSource);
	
			List<Item> items = itemUtilService.getAllItem();
			
			/*RequestDispatcher dispatcher = request.getRequestDispatcher("/show-items.jsp");
			dispatcher.forward(request, response);*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	void loadItem(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			ItemUtilService itemUtilService = new ItemUtilService(dataSource);
			int id = (int) request.getAttribute("id");
		
			Item item = itemUtilService.findItemById(id);
			
			
			/*RequestDispatcher dispatcher = request.getRequestDispatcher("/show-items.jsp");
			dispatcher.forward(request, response);*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
