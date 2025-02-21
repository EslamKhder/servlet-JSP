package service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.Item;
import service.ItemService;

public class ItemServiceImpl implements ItemService {

	private DataSource dataSource;
	
	public ItemServiceImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	@Override
	public List<Item> getAllItem() {
		Connection connection;
		List<Item> items = new ArrayList();
		try {
			connection = dataSource.getConnection();
			String query = "select * from Item";
			Statement statement =  connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				Item item = new Item(
						resultSet.getInt("ID"),
						resultSet.getString("NAME") ,
						resultSet.getDouble("PRICE"),
						resultSet.getInt("TOTAL_NUMBER")
				);
				items.add(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return items;
	}

	@Override
	public Item getItemById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addItem(Item item) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement statement = null;
		try {
			connection = dataSource.getConnection();
			String sql = "INSERT INTO item (NAME,PRICE,TOTAL_NUMBER)"
					+ " VALUES ('" + item.getName() + "', " + item.getPrice() +", " + item.getTotalNumber() + ")";
			statement =  connection.createStatement();
			statement.executeQuery(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
