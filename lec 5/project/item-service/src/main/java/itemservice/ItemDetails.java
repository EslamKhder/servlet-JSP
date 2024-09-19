package itemservice;

public class ItemDetails {
	
	private int itemDetailsId;
	private String type;
	private String model;
	private String description;
	private int itemId;
	
	
	public ItemDetails() {
		
	}
	public ItemDetails(String type, String model, String description, int itemId) {
		this.type = type;
		this.model = model;
		this.description = description;
		this.itemId = itemId;
	}
	public int getItemDetailsId() {
		return itemDetailsId;
	}
	public void setItemDetailsId(int itemDetailsId) {
		this.itemDetailsId = itemDetailsId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
	
}
