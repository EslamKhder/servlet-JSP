package item.controller;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import item.model.Item;
import item.service.ItemService;
import item.service.impl.ItemServiceImpl;
//http://localhost:8080/item-service-909/ItemController?name=&price=&totalnumber=
// Item Controller     USER --> *

//http://localhost:8080/item-service-909/ItemController
//http://localhost:8080/item-service-909/ItemController?action=abc
//http://localhost:8080/item-service-909/ItemController?action=add-item&name=&price=&totalnumber=
//http://localhost:8080/item-service-909/ItemController?action=remove-item&id=
//http://localhost:8080/item-service-909/ItemController?action=update-item&id=&name=&price=&totalnumber=
//http://localhost:8080/item-service-909/ItemController?action=show-item&id=1
//http://localhost:8080/item-service-909/ItemController?action=show-items

@WebServlet("/ItemController")
public class ItemController extends HttpServlet {
	

	@Resource(name = "jdbc/connection")
	private DataSource dataSource;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (Objects.isNull(action)) {
			action = "show-items";
		}
		
		switch(action) {
			case "add-item":
					addItem(request, response);
				break;
			case "remove-item":
				   removeItem(request, response);
				break;
			case "update-item":
				   updateItem(request, response);
				break;
			case "delete-item":
					removeItem(request, response);
				break;
			case "show-item":
				   showItem(request, response);
				break;
			case "show-items":
				   showItems(request, response);
				break;
			default:
				showItems(request, response);

		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void showItems(HttpServletRequest request, HttpServletResponse response) {
		 try {
			ItemService itemService = new ItemServiceImpl(dataSource);
			List<Item> items = itemService.getItems(); // 
			
			request.setAttribute("allItems", items);
			
			request.getRequestDispatcher("/item/show-items.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("ex => " + e.getMessage());
		}
	}

	private void showItem(HttpServletRequest request, HttpServletResponse response) {
		try {
			ItemService itemService = new ItemServiceImpl(dataSource);
			
			Long id = Long.parseLong(request.getParameter("id"));
			Item item = itemService.getItem(id);
			
			
		} catch (Exception e) {
			System.out.println("ex => " + e.getMessage());
		}
		
	}

	private void updateItem(HttpServletRequest request, HttpServletResponse response) {
		try {
			ItemService itemService = new ItemServiceImpl(dataSource);
			
			Long id = Long.parseLong(request.getParameter("id"));
			String name = request.getParameter("name");
			Double price = Double.parseDouble(request.getParameter("price"));
			Integer totalNumber = Integer.parseInt(request.getParameter("totalNumber"));
			
			Item item = new Item(id, name, price, totalNumber);
			Boolean isItemUpdated = itemService.updateItem(item);
			
			if (isItemUpdated) {
				// 
			}
		} catch (Exception e) {
			System.out.println("ex => " + e.getMessage());
		}
		
	}

	private void removeItem(HttpServletRequest request, HttpServletResponse response) {
		try {
			ItemService itemService = new ItemServiceImpl(dataSource);
			
			Long id = Long.parseLong(request.getParameter("id"));
			
			Boolean isItemDeleted = itemService.removeItem(id);
			
			if (isItemDeleted) {
				showItems(request, response);
			}
		} catch (Exception e) {
			System.out.println("ex => " + e.getMessage());
		}
		
	}

	private void addItem(HttpServletRequest request, HttpServletResponse response) {
		try {
			ItemService itemService = new ItemServiceImpl(dataSource);
			
			String name = request.getParameter("name");
			Double price = Double.parseDouble(request.getParameter("price"));
			Integer totalNumber = Integer.parseInt(request.getParameter("totalNumber"));
			
			// TODO solve if name exist getItemByName
			
			Item item = new Item(name, price, totalNumber);
			Boolean isItemCreated = itemService.createItem(item);
			
			if (isItemCreated) {
				showItems(request, response);
			}
		} catch (Exception e) {
			System.out.println("ex => " + e.getMessage());
		}
		
	}

	

}
