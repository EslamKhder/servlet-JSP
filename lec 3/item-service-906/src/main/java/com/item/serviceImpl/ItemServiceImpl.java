package com.item.serviceImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
    public List<Item> getItems() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            String sql = "SELECT * FROM item ORDER BY id";
            ResultSet resultSet = statement.executeQuery(sql);

            List<Item> items = new ArrayList<>();
            
            while (resultSet.next()) { // 5
                Item item = new Item();

                item.setId(resultSet.getLong("id"));
                item.setName(resultSet.getString("name"));
                item.setPrice(resultSet.getDouble("price"));
                item.setTotalNumber(resultSet.getInt("total_number"));

                items.add(item);
            }

            return items;

        } catch (SQLException e) {
            System.out.println("---> " + e.getMessage());
        } finally {
              try {
            	  if (connection != null) connection.close();
            	  if (statement != null) statement.close();
			} catch (SQLException e) {
				System.out.println("---> " + e.getMessage());
			}
              
        }
        return new ArrayList<>();
    }

    @Override
    public Item getItemById(Long id) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            String sql = "SELECT * FROM item WHERE id = " + id;
            ResultSet resultSet = statement.executeQuery(sql); // 1 row

            Item item = new Item();
            if (resultSet.next()) {
                item.setId(resultSet.getLong("id"));
                item.setName(resultSet.getString("name"));
                item.setPrice(resultSet.getDouble("price"));
                item.setTotalNumber(resultSet.getInt("total_number"));
            }

            return item;

        } catch (SQLException e) {
        	System.out.println("---> " + e.getMessage());
        } finally {
            try {
                if (connection != null) connection.close();
                if (statement != null) statement.close();
            } catch (SQLException e) {
            	System.out.println("---> " + e.getMessage());
            }
        }
        return null;
    }
    @Override
    public void addItem(Item item) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            String sql = "INSERT INTO item (NAME, PRICE, TOTAL_NUMBER) VALUES ('"
                    + item.getName() + "', "
                    + item.getPrice() + ", "
                    + item.getTotalNumber() + ")";

            statement.execute(sql);

        } catch (SQLException e) {
        	System.out.println("---> " + e.getMessage());
        } finally {
            try {
                if (connection != null) connection.close();
                if (statement != null) statement.close();
            } catch (SQLException e) {
            	System.out.println("---> " + e.getMessage());
            }
        }
    }

    @Override
    public void updateItem(Item item) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            String sql = "UPDATE item SET NAME = '" + item.getName() + "', "
                    + "PRICE = " + item.getPrice() + ", "
                    + "TOTAL_NUMBER = " + item.getTotalNumber()
                    + " WHERE id = " + item.getId();

            statement.execute(sql);

        } catch (SQLException e) {
        	System.out.println("---> " + e.getMessage());
        } finally {
            try {
                if (connection != null) connection.close();
                if (statement != null) statement.close();
            } catch (SQLException e) {
            	System.out.println("---> " + e.getMessage());
            }
        }
    }

    @Override
    public void deleteItem(Long id) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            String sql = "DELETE FROM item WHERE id = " + id;

            statement.execute(sql);

        } catch (SQLException e) {
        	System.out.println("---> " + e.getMessage());
        } finally {
            try {
                if (connection != null) connection.close();
                if (statement != null) statement.close();
            } catch (SQLException e) {
            	System.out.println("---> " + e.getMessage());
            }
        }
    }
}
