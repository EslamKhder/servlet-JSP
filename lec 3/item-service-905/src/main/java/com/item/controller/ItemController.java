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

//http://localhost:8080/item-service-905/ItemController?itemName=item55&itemPrice=54&itemTotalNumber=15&action=add-item

// http://localhost:8080/item-service-905/ItemController                        action=null
//http://localhost:8080/item-service-905/ItemController?action=srm              action=srm
//http://localhost:8080/item-service-905/ItemController?action=load-items      action=load-items
//http://localhost:8080/item-service-905/ItemController?action=add-item         action=add-item
//http://localhost:8080/item-service-905/ItemController?action=remove-items     action=remove-items
//http://localhost:8080/item-service-905/ItemController?action=load-item        action=load-item

@WebServlet("/ItemController")
public class ItemController extends HttpServlet { 
   
	@Resource(name = "jdbc/item")
	private DataSource dataSource;

	private ItemService itemService;

	// public    private  protected  default
	public ItemController(){
		
	}
	
	@Override
	public void init() throws ServletException {
		itemService = new ItemServiceImpl(dataSource);
	}

	
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
		Item item = extraxtItem(request);
		Boolean updatedItem = itemService.updateItem(item);
		
		if(updatedItem) {
			loadItems(request, response);
		}
	}


	private void loadItems(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		List<Item> items =  itemService.loadItems();
		
		request.setAttribute("itemsData", items);
		try {
			request.getRequestDispatcher("/load-items.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void loadItem(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		Item item = itemService.loadItem(id);
		request.setAttribute("itemData", item);
		try {
			request.getRequestDispatcher("/update-item.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void removeItem(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("==> " + id);
		Boolean removedItem = itemService.removeItem(id);
		if (removedItem) {
			loadItems(request, response);
		}
	}
	
	private void addItem(HttpServletRequest request, HttpServletResponse response) {
		Item item = extraxtItem(request);
		Boolean addedItem = itemService.saveItem(item);
		System.out.println("====> " + addedItem);
		if (addedItem) {
			loadItems(request, response);
		}
	}

	private Item extraxtItem(HttpServletRequest request){
		String itemName = request.getParameter("itemName");
		double itemPrice = Double.parseDouble(request.getParameter("itemPrice"));
		int itemTotalNumber = Integer.parseInt(request.getParameter("itemTotalNumber"));
		
		Item item = new Item(itemName, itemPrice, itemTotalNumber);
		
		String idParam = request.getParameter("itemId");
		if (Objects.nonNull(idParam)) {
			item.setId(Integer.parseInt(idParam));
		}
		
		return item;
	}
}
