package service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.Item;
import service.ItemService;

public class ItemServiceImpl implements  ItemService {

	private DataSource dataSource;
	
	public ItemServiceImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public List<Item> getAllItem() {
		List<Item> categories = new ArrayList();
		try {
			Connection connection = dataSource.getConnection();
			String query = "SELECT * FROM CATEGORY";
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			
			while(resultSet.next()) {
				categories.add(new Item(
						resultSet.getInt("ID"),
						resultSet.getString("NAME"),
						resultSet.getDouble("TOTAL_NUMBER"),
						resultSet.getInt("PRICE")
						
				));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return categories;
	}

	@Override
	public Item getItemById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addItem(Item item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateItemById(Item item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeItemById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
