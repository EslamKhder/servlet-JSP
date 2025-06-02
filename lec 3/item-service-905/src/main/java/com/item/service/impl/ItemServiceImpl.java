package com.item.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.sql.DataSource;

import com.item.model.Item;
import com.item.service.ItemService;

public class ItemServiceImpl implements ItemService {

	private DataSource dataSource;
	
	public ItemServiceImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	//preStat
	@Override
	public boolean saveItem(Item item) {
		try {
			Connection connection = dataSource.getConnection();
			
			String query = "INSERT INTO item (NAME,PRICE,TOTAL_NUMBER)"
						+ " VALUES ('" + item.getName() + "', " 
					    + item.getPrice() +", " + item.getTotalNumber() + ")";
			Statement statement = connection.createStatement();
			int res = statement.executeUpdate(query);
			
			System.out.println(res);

			return res == 1;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean removeItem(int id) {
		try {
			Connection connection =  dataSource.getConnection();
			String query = "DELETE FROM item where id = " + id;
			Statement statement = connection.createStatement();
			int res = 0;
			if (Objects.nonNull(loadItem(id))) {// nonNull   null
				res = statement.executeUpdate(query);
			}
			
			if(res == 1) {
				return true;
			}
			
			return false;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean updateItem(Item item) {
	    try {
	        Connection connection = dataSource.getConnection();

	        String query = "UPDATE item SET NAME = '" + item.getName() + "', " +
	                       "PRICE = " + item.getPrice() + ", " +
	                       "TOTAL_NUMBER = " + item.getTotalNumber() +
	                       " WHERE ID = " + item.getId(); 
	        Statement statement = connection.createStatement();
	        int res = statement.executeUpdate(query);
	        
	        return res == 1;

	    } catch (SQLException e) {
	        System.out.println("SQL Error: " + e.getMessage());
	    }

	    return false;
	}


	@Override
	public Item loadItem(int id) {
		try {
			Connection connection =  dataSource.getConnection();
			String query = "SELECT * FROM item where id = " + id;
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			
			if (resultSet.next()) {
				return new Item(
						resultSet.getInt("id"),
						resultSet.getString("Name"),
						resultSet.getDouble("price"),
						resultSet.getInt("total_number")
				);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public List<Item> loadItems() {
		try {
			Connection connection =  dataSource.getConnection();
			String query = "SELECT * FROM item order by id";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			List<Item> items = new ArrayList<Item>();
			
			while (resultSet.next()) {
				Item item = new Item(
						resultSet.getInt("id"),
						resultSet.getString("Name"),
						resultSet.getDouble("price"),
						resultSet.getInt("total_number")
				);
				items.add(item);
			}
			
			return items;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}


}
