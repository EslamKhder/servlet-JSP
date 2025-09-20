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

import com.item.impl.ItemServiceImpl;
import com.item.model.Item;
import com.item.service.ItemService;

//http://localhost:8080/item-service-907/ItemController?action=show-items
// http://localhost:8080/item-service-907/ItemController?action=add-item
//http://localhost:8080/item-service-907/ItemController?action=update-item
//http://localhost:8080/item-service-907/ItemController?action=delete-item
//http://localhost:8080/item-service-907/ItemController?action=show-item
//http://localhost:8080/item-service-907/ItemController
//http://localhost:8080/item-service-907/ItemController?action=abc
@WebServlet("/ItemController")
public class ItemController extends HttpServlet {


	@Resource(name = "jdbc/item")
	private DataSource dataSource;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (Objects.isNull(action)) {
			action = "show-items";
		}
		
		switch (action) {
	        case "add-item":
	            addItem(request, response);
	            break;
	
	        case "update-item":
	        	updateItem(request, response);
	            break;
	
	        case "delete-item":
	        	deleteItem(request, response);
	            break;
	
	        case "show-items":
	        	showItems(request, response);
	            break;
	
	        case "show-item":
	        	showItem(request, response);
	        	break;
	        	
            default:
            	showItems(request, response);
		}
	}


	private void showItem(HttpServletRequest request, HttpServletResponse response) {
		ItemService itemService = new ItemServiceImpl(dataSource);
		Item item = itemService.getItemById(null);
	}


	private void showItems(HttpServletRequest request, HttpServletResponse response) {
		ItemService itemService = new ItemServiceImpl(dataSource);
		List<Item> items = itemService.getAllItems();
		
		request.setAttribute("items", items);
		
		try {
			request.getRequestDispatcher("/show-items.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("---> " + e.getMessage());
		} 
	}


	private void deleteItem(HttpServletRequest request, HttpServletResponse response) {
		ItemService itemService = new ItemServiceImpl(dataSource);
		Long id = Long.parseLong(request.getParameter("id"));
		boolean itemDeleted = itemService.deleteItemById(id);
		
		if (itemDeleted) {
			showItems(request, response);
		}
	}


	private void updateItem(HttpServletRequest request, HttpServletResponse response) {
		ItemService itemService = new ItemServiceImpl(dataSource);
		boolean itemupdated = itemService.editItem(null);
		
	}


	private void addItem(HttpServletRequest request, HttpServletResponse response) {
		ItemService itemService = new ItemServiceImpl(dataSource);
		boolean itemAdded = itemService.addItem(null);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
