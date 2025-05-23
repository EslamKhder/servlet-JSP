package com.item.service.impl;

import java.util.List;

import javax.sql.DataSource;

import com.item.model.Item;
import com.item.service.ItemService;

public class ItemServiceImpl implements ItemService {

	private DataSource dataSource;
	
	public ItemServiceImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public boolean saveItem(Item item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeItem(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateItem(Item item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Item loadItem(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> loadItems() {
		// TODO Auto-generated method stub
		return null;
	}

}
