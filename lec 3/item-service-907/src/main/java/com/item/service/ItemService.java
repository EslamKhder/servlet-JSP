package com.item.service;

import java.util.List;

import com.item.model.Item;

public interface ItemService {

	boolean addItem(Item item);
	boolean editItem(Item item);
	Item getItemById(Long id);
	List<Item> getAllItems();
	boolean deleteItemById(Long id);
}
