package com.item.controller;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// TODO Auto-generated method stub
		
	}

	private void updateItem(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void addItem(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void showItem(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void showItems(HttpServletRequest request, HttpServletResponse response) {
		// TODO get all items
		ItemService itemService = new ItemServiceImpl();
		List<Item> items = itemService.getItems();
		
		// TODO send items to view
		
	}
}
