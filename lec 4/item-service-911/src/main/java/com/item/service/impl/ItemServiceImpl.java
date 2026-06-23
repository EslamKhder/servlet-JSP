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
	
	@Override
	public boolean addItem(Item item) {
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = dataSource.getConnection();  // connection open
			statement = connection.createStatement(); // statement open
			
			String query = "INSERT INTO HR.ITEM (NAME, PRICE, TOTAL_NUMBER) VALUES('" + 
								item.getName() + "', " + item.getPrice() +", " + item.getTotalNumber() + ")";
			
			statement.execute(query);
			
			return true;
		} catch (Exception exception) {
			System.out.println("ex => " + exception.getMessage());
		} finally {
			try {
				if(Objects.nonNull(connection)) {
					connection.close();
				}
				
				if(Objects.nonNull(statement)) {
					statement.close();
				}
			} catch (SQLException exception) {
				System.out.println("ex => " + exception.getMessage());
			}
		}
		
		return false;
	}

	@Override
	public boolean updateItem(Item item) {
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = dataSource.getConnection();  // connection open
			statement = connection.createStatement(); // statement open
			
			String query = "UPDATE HR.ITEM SET NAME='" + item.getName() + "', PRICE=" + item.getPrice() + ", TOTAL_NUMBER = " + item.getTotalNumber() + " WHERE ID=" + item.getId();
			
			statement.execute(query);
			
			return true;
		} catch (Exception exception) {
			System.out.println("ex => " + exception.getMessage());
		} finally {
			try {
				if(Objects.nonNull(connection)) {
					connection.close();
				}
				
				if(Objects.nonNull(statement)) {
					statement.close();
				}
			} catch (SQLException exception) {
				System.out.println("ex => " + exception.getMessage());
			}
		}
		
		return false;
	}

	@Override
	public Item getItemById(Long id) {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = dataSource.getConnection();
		    statement = connection.createStatement();
			String query = "select * from item where id = " + id;
			ResultSet resultSet = statement.executeQuery(query);
			
			if (resultSet.next()) {
				Long itemId = resultSet.getLong("ID");
				String name = resultSet.getString("NAME");
				Double price = resultSet.getDouble("PRICE");
				int totalNumber = resultSet.getInt("TOTAL_NUMBER");
				Item item = new Item(id,name, price, totalNumber);
				return item;
			}
		} catch (SQLException e) {
			System.out.println("Excetion " + e.getMessage());
		} finally {
			try {
				if (Objects.nonNull(connection)) {
					connection.close();
				}
				if (Objects.nonNull(statement)) {
					statement.close();
				}
			} catch (SQLException e) {
				System.out.println("Excetion " + e.getMessage());
			}
			
		}
		return null;
	}

	@Override
	public List<Item> getItems() {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = dataSource.getConnection();
		    statement = connection.createStatement();
			String query = "select * from item";
			ResultSet resultSet = statement.executeQuery(query);
			List<Item> items = new ArrayList();
			while (resultSet.next()) {
				Long id = resultSet.getLong("ID");
				String name = resultSet.getString("NAME");
				Double price = resultSet.getDouble("PRICE");
				int totalNumber = resultSet.getInt("TOTAL_NUMBER");
				Item item = new Item(id,name, price, totalNumber);
				items.add(item);
			}
			return items;
		} catch (SQLException e) {
			System.out.println("Excetion " + e.getMessage());
		} finally {
			try {
				if (Objects.nonNull(connection)) {
					connection.close();
				}
				if (Objects.nonNull(statement)) {
					statement.close();
				}
			} catch (SQLException e) {
				System.out.println("Excetion " + e.getMessage());
			}
			
		}
		return null;
	}

	@Override
	public boolean removeItemById(Long id) {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = dataSource.getConnection();
		    statement = connection.createStatement();
			String query = "delete from item where id = " + id;
			statement.execute(query);
			return true;
			
		} catch (SQLException e) {
			System.out.println("Excetion " + e.getMessage());
		} finally {
			try {
				if (Objects.nonNull(connection)) {
					connection.close();
				}
				if (Objects.nonNull(statement)) {
					statement.close();
				}
			} catch (SQLException e) {
				System.out.println("Excetion " + e.getMessage());
			}
			
		}
		return false;
	}

}
