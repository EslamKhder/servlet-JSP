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

//http://localhost:8080/item-service-908/ItemController
// http://localhost:8080/item-service-908/ItemController?action=getItems
//http://localhost:8080/item-service-908/ItemController?action=getItem
//http://localhost:8080/item-service-908/ItemController?action=addItem
//http://localhost:8080/item-service-908/ItemController?action=editItem
//http://localhost:8080/item-service-908/ItemController?action=deleteItem
//http://localhost:8080/item-service-908/ItemController?action=sdhsjhs

@WebServlet("/ItemController")
public class ItemController extends HttpServlet {

	@Resource(name = "jdbc/item")
	private DataSource dataSource;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// check if user login or not
		
		String action = request.getParameter("action");
		
		if (Objects.isNull(action)) {
			action = "getItems";
		}
		switch(action) {
			case "getItems":
				getItems(request, response);
				break;
			case "getItem":
				getItem(request, response);
				break;
			case "addItem":
				addItem(request, response);
				break;
			case "editItem":
				editItem(request, response);
				break;
			case "deleteItem":
				deleteItem(request, response);
				break;
			default: 
				getItems(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void deleteItem(HttpServletRequest request, HttpServletResponse response) {
		Long id  = Long.parseLong(request.getParameter("id"));
		ItemService itemService = new ItemServiceImpl(dataSource);
		boolean isItemRemoved = itemService.removeItem(id);
		
		getItems(request, response);
		
	}

	private void editItem(HttpServletRequest request, HttpServletResponse response) {
		Long id  = Long.parseLong(request.getParameter("id"));
		String name  = request.getParameter("name");
		Double price  = Double.parseDouble(request.getParameter("price"));
		int totalNumber  = Integer.parseInt(request.getParameter("totalNumber"));
		
		Item item = new Item(id, name, price, totalNumber);
		ItemService itemService = new ItemServiceImpl(dataSource);
		boolean isItemUpdated = itemService.editItem(item);
		getItems(request, response);
	}

	private void addItem(HttpServletRequest request, HttpServletResponse response) {
		String name  = request.getParameter("name");
		Double price  = Double.parseDouble(request.getParameter("price"));
		int totalNumber  = Integer.parseInt(request.getParameter("totalNumber"));
		Item item = new Item(name, price, totalNumber);
		ItemService itemService = new ItemServiceImpl(dataSource);
		boolean isItemSaved  = itemService.addItem(item);
		getItems(request, response);
		
	}

	private void getItem(HttpServletRequest request, HttpServletResponse response) {
		Long id  = Long.parseLong(request.getParameter("id"));
		ItemService itemService = new ItemServiceImpl(dataSource);
		Item item = itemService.loadItem(id);
		
		request.setAttribute("item", item);
		
		try {
			request.getRequestDispatcher("/update-item.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void getItems(HttpServletRequest request, HttpServletResponse response) {
		ItemService itemService = new ItemServiceImpl(dataSource);
		List<Item> items = itemService.loadItems();
		
		request.setAttribute("allItems", items);
		
		try {
			request.getRequestDispatcher("/showItems.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}
