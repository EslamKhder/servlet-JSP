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
    
	private ItemUtilService itemUtilService;

    
	@Override
	public void init() throws ServletException {
		itemUtilService = new ItemUtilService(dataSource);
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
				loadItem(request, response);
				break;
			case "DELETE":
				deleteItem(request, response);
				break;
			case "UPDATE":
				updateItem(request, response);
				break;
			default:
				loadItems(request, response);
		}
	}
	
	
	void addItem(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			String name = request.getParameter("nameItem");
			double price = Double.parseDouble(request.getParameter("price"));
			int totalNumber = Integer.parseInt(request.getParameter("totalNumber"));
			
			Item item = new Item(name, price, totalNumber);
			itemUtilService.saveItem(item);
			
			loadItems(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void loadItems(HttpServletRequest request, HttpServletResponse response) {
			
		try {	
			List<Item> items = itemUtilService.getAllItem();
			
			request.setAttribute("allItems", items);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/show-items.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	void loadItem(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			int id = Integer.parseInt(request.getParameter("id"));
		
			Item item = itemUtilService.findItemById(id);
			
			request.setAttribute("existedItem", item);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/update-item.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void deleteItem(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			int id = Integer.parseInt(request.getParameter("id"));
		
			itemUtilService.deleteItem(id);
			
			loadItems(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void updateItem(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("nameItem");
			double price = Double.parseDouble(request.getParameter("price"));
			int totalNumber = Integer.parseInt(request.getParameter("totalNumber"));
			
			Item item = new Item(id, name, price, totalNumber);
			itemUtilService.updateItem(item);
			
			
			loadItems(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
