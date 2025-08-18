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
import com.item.serviceImpl.ItemServiceImpl;

/**
 * Servlet implementation class ItemController
 */
@WebServlet("/ItemController")
//http://localhost:8080/item-service-906/ItemController
//http://localhost:8080/item-service-906/ItemController?action=hjjhgj
//http://localhost:8080/item-service-906/ItemController?action=showItem
//http://localhost:8080/item-service-906/ItemController?action=showItems
//http://localhost:8080/item-service-906/ItemController?action=addItem
//http://localhost:8080/item-service-906/ItemController?action=updateItem
//http://localhost:8080/item-service-906/ItemController?action=deleteItem&id=1
public class ItemController extends HttpServlet {

	
	@Resource(name = "jdbc/itemConnection")
	private DataSource dataSource;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if (Objects.isNull(action)) {
			action = "showItems";
		}
		switch(action) {
			case "showItem":
				showItem(request, response);
				break;
			case "showItems":
				showItems(request, response);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void deleteItem(HttpServletRequest request, HttpServletResponse response) {
		Long id =  Long.parseLong(request.getParameter("id"));
		ItemService itemService = new ItemServiceImpl(dataSource);
		itemService.deleteItem(id);
	}

	private void updateItem(HttpServletRequest request, HttpServletResponse response) {
		Long id =  Long.parseLong(request.getParameter("id"));
		String name = request.getParameter("name");
		double price = Double.parseDouble(request.getParameter("price"));
		int totalNumber = Integer.parseInt(request.getParameter("totalNumber"));

		Item item = new Item(id, name, price, totalNumber);
		ItemService itemService = new ItemServiceImpl(dataSource);
		itemService.updateItem(item);
	}

	private void addItem(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		double price = Double.parseDouble(request.getParameter("price"));
		int totalNumber = Integer.parseInt(request.getParameter("totalNumber"));

		Item item = new Item(name, price, totalNumber);
		ItemService itemService = new ItemServiceImpl(dataSource);
		itemService.addItem(item);
		
	}

	private void showItems(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ItemService itemService = new ItemServiceImpl(dataSource);
		List<Item> items =  itemService.getItems();
		
		request.setAttribute("allItems", items);
		
		System.err.println("--> res " + items.size());
		try {
			request.getRequestDispatcher("/show-items.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("--> " + e.getMessage());
		}
		
	}

	private void showItem(HttpServletRequest request, HttpServletResponse response) {
		Long id =  Long.parseLong(request.getParameter("id"));
		ItemService itemService = new ItemServiceImpl(dataSource);
		Item item = itemService.getItemById(id);
		
	}


}
