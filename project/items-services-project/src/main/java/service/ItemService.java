package service;

import java.util.List;

import model.Item;

public interface ItemService {
	List<Item> getAllItem();
	Item getItemById(int id);
	boolean addItem(Item item);
	boolean updateItemById(Item item);
	boolean removeItemById(int id);
}
