package com.item.service;

import java.util.List;

import com.item.model.Item;

public interface ItemService {
	Item getItemById(Long id);
	List<Item> getItems();
	void addItem(Item item);
	void updateItem(Item item);
	void deleteItem(Long id);
}
