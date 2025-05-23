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

// http://localhost:8080/servlet-jsp-905/ItemController                       action=null
//http://localhost:8080/servlet-jsp-905/ItemController?action=srm              action=srm
//http://localhost:8080/servlet-jsp-905/ItemController?action=add-item        action=add-item
//http://localhost:8080/servlet-jsp-905/ItemController?action=remove-items    action=remove-items
//http://localhost:8080/servlet-jsp-905/ItemController?action=load-item       action=load-item
//http://localhost:8080/servlet-jsp-905/ItemController/?action=load-items      action=load-items
@WebServlet("/ItemController")
public class ItemController extends HttpServlet { 
   
	@Resource(name = "jdbc/item")
	private DataSource dataSource;

	// action = {add-item, update-item, remove-item, load-item, load-items}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (Objects.isNull(action)) {
			action = "load-items";
		}
		
		switch (action) {
			case "add-item":
				addItem(request, response);
				break;
			case "remove-item":
				removeItem(request, response);
				break;
			case "update-item":
				updateItem(request, response);
				break;
			case "load-item":
				loadItem(request, response);
				break;
			case "load-items":
				loadItems(request, response);
				break;
			default:
				loadItems(request, response);
		}
	}
	
	
	private void updateItem(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ItemService itemService = new ItemServiceImpl(dataSource);
		Boolean updatedItem = itemService.updateItem(new Item());
	}


	private void loadItems(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ItemService itemService = new ItemServiceImpl(dataSource);
		List<Item> items =  itemService.loadItems();
		
	}

	private void loadItem(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ItemService itemService = new ItemServiceImpl(dataSource);
		Item item = itemService.loadItem(1);
	}

	private void removeItem(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ItemService itemService = new ItemServiceImpl(dataSource);
		Boolean removedItem = itemService.removeItem(1);
	}
	
	
	private void addItem(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ItemService itemService = new ItemServiceImpl(dataSource);
		Boolean addedItem = itemService.saveItem(new Item());
	}

}
