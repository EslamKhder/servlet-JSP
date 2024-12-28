package item.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import item.model.Item;
import item.service.ItemService;
import item.serviceimpl.ItemServiceImpl;

/**
 * Servlet implementation class ItemController
 */
@WebServlet("/ItemController")
public class ItemController extends HttpServlet {
	
	@Resource(name = "jdbc/web_item")
	private DataSource dataSource;
	
	private ItemService itemService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemController() {
        
    }

    
	@Override
	public void init() throws ServletException {
		itemService = new ItemServiceImpl(dataSource);
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (action == null) {
			action = "LOAD_ITEMS";
		}
		
		switch (action) {
			case "LOAD_ITEMS":
				loadItems(request, response);
			case "ADD":
				addItems(request, response);
			case "DELETE":
				deleteItems(request, response);
			case "UPDATE":
				updateItems(request, response);
			case "LOAD_ITEM":
				loadItem(request, response);
			default:
				loadItems(request, response);
		}
	}

	private void loadItem(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void updateItems(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void deleteItems(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void addItems(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void loadItems(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<Item> items = itemService.getAllItem();
		
		request.setAttribute("itemsData", items);
		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/loadItems.jsp");
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
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
