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
			String query = "SELECT * FROM ITEM";
			
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
		try {
			Connection connection = dataSource.getConnection();
			String query = "SELECT * FROM ITEM where id = " + id;
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query); // empty     item
			
			
			if(resultSet.next()) {
				return new Item(
						resultSet.getInt("ID"),
						resultSet.getString("NAME"),
						resultSet.getDouble("TOTAL_NUMBER"),
						resultSet.getInt("PRICE")
						
				);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}

	@Override
	public boolean addItem(Item item) {
		try {
			Connection connection = dataSource.getConnection();
			String query = "INSERT INTO ITEM (NAME,PRICE,TOTAL_NUMBER) VALUES ('" + item.getName()+ "'," + item.getPrice() + "," + item.getTotalNumber() + ")";
			
			Statement statement = connection.createStatement();
			statement.executeQuery(query); // empty     item
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return false;
	}

	@Override
	public boolean updateItemById(Item item) {
		try {
			Connection connection = dataSource.getConnection();
			String query = "UPDATE ITEM SET NAME = '" 
	                + item.getName() + "', PRICE = " 
	                + item.getPrice() + ", TOTAL_NUMBER = " 
	                + item.getTotalNumber() + " WHERE ID = " + item.getId();
			
			Statement statement = connection.createStatement();
			statement.executeQuery(query); // empty     item
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return false;
	}

	@Override
	public boolean removeItemById(int id) {
		try {
			Connection connection = dataSource.getConnection();
			String query = "delete FROM ITEM where id = " + id;
			
			Statement statement = connection.createStatement();
			statement.executeQuery(query); 
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return false;
	}

}
