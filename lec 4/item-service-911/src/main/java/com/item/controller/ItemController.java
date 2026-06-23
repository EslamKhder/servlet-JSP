package com.item.controller;

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

import com.item.model.Item;
import com.item.service.ItemService;
import com.item.service.impl.ItemServiceImpl;

//http://localhost:8080/item-service-911/ItemController?action=showItems
//http://localhost:8080/item-service-911/ItemController?action=showItem
//http://localhost:8080/item-service-911/ItemController?action=addItem
//http://localhost:8080/item-service-911/ItemController?action=updateItem
//http://localhost:8080/item-service-911/ItemController?action=deleteItem
//http://localhost:8080/item-service-911/ItemController
//http://localhost:8080/item-service-911/ItemController?action=xyz
@WebServlet("/ItemController")
public class ItemController extends HttpServlet {

	@Resource(name = "jdbc/item")
	private DataSource dataSource;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getParameter("action");
		
		if (Objects.isNull(action)) {
			action = "showItems";
		}
		
		switch(action) {
			case "showItems":
				showItems(request, response);
				break;
			case "showItem":
				showItem(request, response);
				break;
			case "addItem":
				addItem(request, response);
				break;
			case "updateItem":
				updateItem(request, response);
				break;
			case "deleteItem":
				deleteItem(request, response);
				break;
			default:
				showItems(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void deleteItem(HttpServletRequest request, HttpServletResponse response) {
		// TODO get all items DONE
		ItemService itemService = new ItemServiceImpl(dataSource);
		Long id = Long.parseLong(request.getParameter("id"));
		
		boolean isItemDeleted = itemService.removeItemById(id);
		
		if (isItemDeleted) {
			showItems(request, response);
		}
		
	}

	private void updateItem(HttpServletRequest request, HttpServletResponse response) {
		// TODO get all items DONE
		ItemService itemService = new ItemServiceImpl(dataSource);
		
		Long id = Long.parseLong(request.getParameter("id"));
		String name = request.getParameter("name");
		Double price = Double.parseDouble(request.getParameter("price"));
		int totalNumber = Integer.parseInt(request.getParameter("totalNumber"));
		Item item = new Item(id, name, price, totalNumber);
		
		boolean isItemUpdated = itemService.updateItem(item);
		
		if (isItemUpdated) {
			showItems(request, response);
		}
	}

	private void addItem(HttpServletRequest request, HttpServletResponse response) {
		// TODO get all items DONE
		ItemService itemService = new ItemServiceImpl(dataSource);
		
		String name = request.getParameter("name");
		Double price = Double.parseDouble(request.getParameter("price"));
		int totalNumber = Integer.parseInt(request.getParameter("totalNumber"));
		Item item = new Item(name, price, totalNumber);
		
		boolean isItemAdded = itemService.addItem(item);
		
		if (isItemAdded) {
			showItems(request, response);
		}
	}

	private void showItem(HttpServletRequest request, HttpServletResponse response) {
		ItemService itemService = new ItemServiceImpl(dataSource);
		Long id = Long.parseLong(request.getParameter("id"));
		
		Item item = itemService.getItemById(id);
		if (Objects.nonNull(item)) {
			request.setAttribute("itemData", item);
			try {
				request.getRequestDispatcher("update-item.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				System.out.println("Exc: " + e.getMessage());
			}
		}
		
		
	}

	private void showItems(HttpServletRequest request, HttpServletResponse response) {
		// TODO get all items DONE
		ItemService itemService = new ItemServiceImpl(dataSource);
		List<Item> items = itemService.getItems();
		
		// TODO send items to view
		request.setAttribute("itemsData", items);
		
		try {
			request.getRequestDispatcher("showItems.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			System.out.println("Exc: " + e.getMessage());
		}
	}
}
