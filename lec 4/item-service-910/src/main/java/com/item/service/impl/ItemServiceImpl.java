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
		if (Objects.isNull(dataSource)) {
			throw new IllegalArgumentException("DataSource must not be null");
		}
		this.dataSource = dataSource;
	}
	
	@Override
	public List<Item> getAllItems() {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = dataSource.getConnection();
		    statement = connection.createStatement();
			String query = "select * from item";
			ResultSet resultSet = statement.executeQuery(query);
			
			List<Item> items = new ArrayList();
			while (resultSet.next()) {
				Item item = new Item(
						resultSet.getLong("ID"),
						resultSet.getString("NAME"),
						resultSet.getDouble("PRICE"),
						resultSet.getInt("TOTAL_NUMBER")
				);
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
	public Item selectItem(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addItem(Item item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateItem(Item item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteItem(Long id) {
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
