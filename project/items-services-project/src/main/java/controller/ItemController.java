package controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.Item;
import service.ItemService;
import service.impl.ItemServiceImpl;

/**
 * Servlet implementation class ItemController
 */
//http://localhost:8080/items-services-project/ItemController
//http://localhost:8080/items-services-project/ItemController?action=load-items
// http://localhost:8080/items-services-project/ItemController?action=sasaas
@WebServlet("/ItemController")
public class ItemController extends HttpServlet {

	@Resource(name = "jdbc/item")
	private DataSource dataSource;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userAction = request.getParameter("action");
		
		if (userAction == null) {
			userAction = "load-items";
		}
		
		switch(userAction) {
			case "load-items":
				loadItems(request, response);
				break;
			case "add-item":
				addItem(request, response);
				break;
			case "remove-item":
				removeItem(request, response);
				break;
			case "update-item":
			    updateItem(request, response);
				break;
			default:
				loadItems(request, response);
		}
		
	}

	
	private void updateItem(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	private void removeItem(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	private void addItem(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ItemService itemService = new ItemServiceImpl(dataSource); 
		
		String itemName = request.getParameter("itemName");
		String itemPrice = request.getParameter("itemPrice");
		String itemtotalNumber = request.getParameter("itemtotalNumber");
		Item item = new Item(
				itemName,
				Double.parseDouble(itemPrice),
				Integer.parseInt(itemtotalNumber)
		);
		
		boolean itemSaved = itemService.addItem(item);
		
		if (itemSaved) {
			loadItems(request, response);
		}
	}


	private void loadItems(HttpServletRequest request, HttpServletResponse response) {
		ItemService itemService = new ItemServiceImpl(dataSource); 
		
		List<Item> items = itemService.getAllItem();
		
		request.setAttribute("itemData", items);
		try {
			request.getRequestDispatcher("/load-items.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
