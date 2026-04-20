package com.item.service;

import java.util.List;

import com.item.model.Item;

public interface ItemService {

	List<Item> getAllItems();
	
	Item selectItem(Long id);
	
	boolean addItem(Item item);
	
	boolean updateItem(Item item);
	
	boolean deleteItem(Long id);
}
