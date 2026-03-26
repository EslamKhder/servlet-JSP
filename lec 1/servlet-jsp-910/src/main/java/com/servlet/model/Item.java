package com.servlet.model;

import java.util.ArrayList;
import java.util.List;

public class Item {

	private int id;
	private String name;
	private float price;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	

	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public static List<Item> getItems() {
        List<Item> items = new ArrayList();

        Item item1 = new Item();
        item1.setId(1);
        item1.setName("item1");
        item1.setPrice(95.5f);

        Item item2 = new Item();
        item2.setId(2);
        item2.setName("item2");
        item2.setPrice(88.0f);

        Item item3 = new Item();
        item3.setId(3);
        item3.setName("item3");
        item3.setPrice(91.2f);
        
        Item item4 = new Item();
        item4.setId(4);
        item4.setName("item4");
        item4.setPrice(955.2f);

        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        return items;
    }
}
