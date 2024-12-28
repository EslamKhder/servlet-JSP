package itemservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import item.model.Item;

public class ItemUtilService {
	
	private DataSource dataSource;
	
	public ItemUtilService(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	public List<Item> getAllItem() throws SQLException{
		Connection connection = null;
		Statement statement = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			
			String sql = "select * from item order by id";
			ResultSet resultSet = statement.executeQuery(sql);
			
			List<Item> items = new ArrayList();
			while (resultSet.next()) {
					Item item = new Item();
				
					item.setId(resultSet.getInt("id"));
					item.setName(resultSet.getString("name"));
					item.setPrice(resultSet.getDouble("price"));
					item.setTotalNumber(resultSet.getInt("total_number"));
					
					items.add(item);
			}
			
			return items;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.close();
			statement.close();
		}
		return new ArrayList();
	}
	
	public List<ShowItemDetails> getAllItemDetails() throws SQLException{
		Connection connection = null;
		Statement statement = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			
			String sql = "SELECT * FROM ITEM i INNER JOIN item_details it ON (i.ID = it.ITEM_ID)";
			ResultSet resultSet = statement.executeQuery(sql);
			
			List<ShowItemDetails> items = new ArrayList();
			while (resultSet.next()) {
				ShowItemDetails itemDetails = new ShowItemDetails();
				
				itemDetails.setId(resultSet.getInt("id"));
				itemDetails.setName(resultSet.getString("name"));
				itemDetails.setPrice(resultSet.getDouble("price"));
				itemDetails.setTotalNumber(resultSet.getInt("total_number"));
				itemDetails.setDescription(resultSet.getString("DESCRIPTION"));
				itemDetails.setModel(resultSet.getString("MODEL"));
				itemDetails.setType(resultSet.getString("TYPE_MODEL"));
				items.add(itemDetails);
			}
			
			return items;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.close();
			statement.close();
		}
		return new ArrayList();
	}
	 
	public void saveItem(Item item) throws SQLException{
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = dataSource.getConnection();
			
			String sql = "INSERT INTO item (NAME,PRICE,TOTAL_NUMBER)"
						+ " VALUES (?, ?, ?)";
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, item.getName());
			statement.setDouble(2, item.getPrice());
			statement.setInt(3, item.getTotalNumber());
			
			statement.execute();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.close();
			statement.close();
		}
	}
	
	
	public void saveItemDetails(ItemDetails itemDetails) throws SQLException{
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = dataSource.getConnection();
			
			String sql = "INSERT INTO item_details (model, type_model, description, item_id) VALUES "
					+ "(?, ?, ?, ?)";
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, itemDetails.getModel());
			statement.setString(2, itemDetails.getType());
			statement.setString(3, itemDetails.getDescription());
			statement.setInt(4, itemDetails.getItemId());
			
			statement.execute();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.close();
			statement.close();
		}
	}
	
	
	public Item findItemById(int id) throws SQLException{
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = dataSource.getConnection();
			
			String sql = "select * from item where id = ?";
			
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			
			ResultSet resultSet = statement.executeQuery();
			
			Item item = new Item();
			if (resultSet.next()) {
					item.setId(resultSet.getInt("id"));
					item.setName(resultSet.getString("name"));
					item.setPrice(resultSet.getDouble("price"));
					item.setTotalNumber(resultSet.getInt("total_number"));
			}
			
			return item;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.close();
			statement.close();
		}
		return null;
	}
	
	public void deleteItem(int id) throws SQLException{
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = dataSource.getConnection();
			
			String sql = "DELETE from Item where id = ?";
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1, id);
			
			statement.execute();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.close();
			statement.close();
		}
	}

	public void updateItem(Item item) throws SQLException{
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = dataSource.getConnection();
			
			String sql = "UPDATE ITEM SET NAME =?, PRICE=?, TOTAL_NUMBER=? WHERE id = ?";
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, item.getName());
			statement.setDouble(2, item.getPrice());
			statement.setInt(3, item.getTotalNumber());
			statement.setInt(4, item.getId());
			statement.execute();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.close();
			statement.close();
		}
	}
}
