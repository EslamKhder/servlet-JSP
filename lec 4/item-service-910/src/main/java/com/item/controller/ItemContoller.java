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

//http://localhost:8080/item-service-910/ItemController?action=show-item
//http://localhost:8080/item-service-910/ItemController?action=show-items
//http://localhost:8080/item-service-910/ItemController?action=add-item
//http://localhost:8080/item-service-910/ItemController?action=update-items
//http://localhost:8080/item-service-910/ItemController?action=delete-items

//http://localhost:8080/item-service-910/ItemController?action=xyz
//http://localhost:8080/item-service-910/ItemController


// http://localhost:8080/item-service-910/ItemContoller?itemName=www&itemPrice=1&itemTotalNumber=1&action=add-item
@WebServlet("/ItemContoller")
public class ItemContoller extends HttpServlet {

	
	@Resource(name = "jdbc/item")
	private DataSource dataSource;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (Objects.isNull(action)) {
			action = "show-items";
		}
		
		switch (action) {
			case "show-items":
				showItems(request, response);
				break;
		
			case "show-item":
				showItem(request, response);
				break;
				
			case "add-item":
				addItem(request, response);
				break;
			
			case "update-item":
				updateItem(request, response);
				break;

			case "delete-item":
				deleteItem(request, response);
				break;
			default: 
				showItems(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	private void showItem(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("id"));
		ItemService itemService = new ItemServiceImpl(dataSource);
		Item item = itemService.selectItem(id);
		
		if (Objects.nonNull(item)) {
			request.setAttribute("itemSelected", item);
			
			try {
				request.getRequestDispatcher("/update-item.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				System.out.println("Exception " + e.getMessage());
			}
		} else {
			try {
				request.getRequestDispatcher("/item-not-found.html").forward(request, response);
			} catch (ServletException | IOException e) {
				System.out.println("Exception " + e.getMessage());
			}
		}
		
	}


	private void addItem(HttpServletRequest request, HttpServletResponse response) {
		
		String itemName  = request.getParameter("itemName");
		double itemPrice = Double.parseDouble(request.getParameter("itemPrice")); // "50.2"
		int itemTotalNumber = Integer.parseInt(request.getParameter("itemTotalNumber"));
		
		ItemService itemService = new ItemServiceImpl(dataSource);
		
		Item item = new Item(itemName, itemPrice, itemTotalNumber);
		boolean isItemAdded = itemService.addItem(item);
		
		if (isItemAdded) {
			showItems(request, response);
		}
		
	}


	private void updateItem(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("id"));
		String itemName  = request.getParameter("itemName");
		double itemPrice = Double.parseDouble(request.getParameter("itemPrice")); // "50.2"
		int itemTotalNumber = Integer.parseInt(request.getParameter("itemTotalNumber"));
		
		Item item = new Item(id, itemName, itemPrice, itemTotalNumber);
		
		ItemService itemService = new ItemServiceImpl(dataSource);
		
		boolean isItemUpdated = itemService.updateItem(item);
		
		if (isItemUpdated) {
			showItems(request, response);
		}
	}


	private void deleteItem(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("id"));
		ItemService itemService = new ItemServiceImpl(dataSource);
		boolean isItemDeleted = itemService.deleteItem(id);
		
		if (isItemDeleted) {
			showItems(request, response);
		}
	}


	private void showItems(HttpServletRequest request, HttpServletResponse response) {
		
		ItemService itemService = new ItemServiceImpl(dataSource);
		List<Item> items =  itemService.getAllItems();
		request.setAttribute("allItems", items);
		
		try {
			request.getRequestDispatcher("/show-items.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			System.out.println("Exception " + e.getMessage());
		}
	}


}
