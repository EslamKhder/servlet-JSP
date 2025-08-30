package com.item.service;

import java.util.List;

import com.item.model.Item;

public interface ItemService {
	boolean addItem(Item item);
	boolean removeItem(Long id);
	boolean editItem(Item item);
	Item loadItem(Long id);
	List<Item> loadItems();
}
