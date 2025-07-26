package com.tap.dao;

import java.util.List;
import com.tap.model.Restaurant;

public interface RestaurantDAO {

	List<Restaurant> getAllRestaurants();

	Restaurant getRestaurant(int restaurantId);
	
    public void addRestaurant(Restaurant restaurant);
    
    public void updateRestaurant(Restaurant restaurant);

    public void deleteRestaurant(int restaurantId);
    
    public String getRestaurantNameById(int restaurantId);

}
