package com.tap.model;

public class Menu {
	
	private int menuId;
    private int restaurantId;
    private String itemName;
    private String description;
    private int price;
    private String isAvailable;
    private float ratings;
    private String imagePath;
    
    
    public Menu()
    {
    	
    }


	public Menu(int menuId, int restaurantId, String itemName, String description, int price, String isAvailable,
			float ratings, String imagePath) {
		super();
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
		this.ratings = ratings;
		this.imagePath = imagePath;
	}


	public Menu(int menuId, int restaurantId, String itemName, String description, int price, String isAvailable,
			float ratings) {
		super();
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
		this.ratings = ratings;
	}


	public int getMenuId() {
		return menuId;
	}


	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}


	public int getRestaurantId() {
		return restaurantId;
	}


	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getIsAvailable() {
		return isAvailable;
	}


	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}


	public float getRatings() {
		return ratings;
	}


	public void setRatings(float ratings) {
		this.ratings = ratings;
	}


	public String getImagePath() {
		return imagePath;
	}


	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}


	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", restaurantId=" + restaurantId + ", itemName=" + itemName + ", description="
				+ description + ", price=" + price + ", isAvailable=" + isAvailable + ", ratings=" + ratings
				+ ", imagePath=" + imagePath + "]";
	}
    
    
	
	
    

    
}