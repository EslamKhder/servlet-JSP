package item.service;

import java.util.List;

import item.model.Item;

public interface ItemService {
	List<Item> getAllItem();
	void saveItem(Item item);
	Item findItemById(int id);
	void deleteItem(int id);
	void updateItem(Item item);
	void saveListOfItem(List<Item> items);
	void searchItem(String value);
}
