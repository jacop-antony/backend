package com.tap.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.RestaurantDAO;
import com.tap.model.Restaurant;
import com.tap.util.DBConnection;

public class RestaurantDAOimp implements RestaurantDAO {

	public static final String UPDATE = "UPDATE restaurant SET name = ?, address = ?, phoneNumber = ?, cuisineType = ?, deliveryTime = ?, adminUserId = ?, rating = ?, isActive = ?, imagePath = ? WHERE restaurantId = ?";
	public static final String INSERT = "INSERT INTO restaurant (restaurantId, name, address, phoneNumber, cuisineType, deliveryTime, adminUserId, rating, isActive, imagePath) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String SELECT = "SELECT * FROM restaurant WHERE restaurantId = ?";
	public static final String DELETE = "DELETE FROM restaurant WHERE restaurantId = ?";
	public static final String SELECT_ALL = "SELECT * FROM restaurant";
	public static final String GETRESTAURANTNAME = "SELECT NAME FROM restaurant WHERE restaurantId = ?";
	

	@Override
	public List<Restaurant> getAllRestaurants() {
		List<Restaurant> list = new ArrayList<>();
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);)
		{
			ResultSet res = stmt.executeQuery();

			while (res.next()) {

				int id =res.getInt(1);
				String name=res.getString(2);
				String address = res.getString(3); 
				String phoneNumber = res.getString(4); 
				String cuisineType = res.getString(5); 
				int deliveryTime = res.getInt(6); 
				int adminUserId = res.getInt(7); 
				double rating = res.getDouble(8);
				int isActive = res.getInt(9);
				String imagePath = res.getString(10);

				Restaurant r = new Restaurant(id,name,address,phoneNumber,cuisineType,deliveryTime,adminUserId,rating,isActive,imagePath);

				list.add(r);

			}

		} catch (SQLException  e) {
			e.printStackTrace();
		}
		return list;
	}
	
	

	@Override
	public void addRestaurant(Restaurant restaurant) {
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(INSERT)) {

			stmt.setInt(1, restaurant.getRestaurantId());
			stmt.setString(2, restaurant.getName());
			stmt.setString(3, restaurant.getAddress());
			stmt.setString(4, restaurant.getPhoneNumber());
			stmt.setString(5, restaurant.getCuisineType());
			stmt.setInt(6, restaurant.getDeliveryTime());
			stmt.setInt(7, restaurant.getAdminUserId());
			stmt.setDouble(8, restaurant.getRating());
			stmt.setInt(9, restaurant.isActive());
			stmt.setString(10, restaurant.getImagePath());

			stmt.executeUpdate();

		} catch (SQLException  e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateRestaurant(Restaurant restaurant) {
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(UPDATE)) {

			stmt.setString(1, restaurant.getName());
			stmt.setString(2, restaurant.getAddress());
			stmt.setString(3, restaurant.getPhoneNumber());
			stmt.setString(4, restaurant.getCuisineType());
			stmt.setInt(5, restaurant.getDeliveryTime());
			stmt.setInt(6, restaurant.getAdminUserId());
			stmt.setDouble(7, restaurant.getRating());
			stmt.setInt(8, restaurant.isActive());
			stmt.setString(9, restaurant.getImagePath());
			stmt.setInt(10, restaurant.getRestaurantId());

			int i = stmt.executeUpdate();

			System.out.println(i);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Restaurant getRestaurant(int restaurantId) {
		Restaurant r = null;

		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT)) 
		{

			stmt.setInt(1, restaurantId);
			ResultSet res = stmt.executeQuery();

			while(res.next())
			{
				int id =res.getInt(1);
				String name=res.getString(2);
				String address = res.getString(3); 
				String phoneNumber = res.getString(4); 
				String cuisineType = res.getString(5); 
				int deliveryTime = res.getInt(6); 
				int adminUserId = res.getInt(7); 
				double rating = res.getDouble(8);
				int isActive = res.getInt(9);
				String imagePath = res.getString(10);

				r = new Restaurant(id,name,address,phoneNumber,cuisineType,deliveryTime,adminUserId,rating,isActive,imagePath);
			}

		} catch (SQLException  e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public void deleteRestaurant(int restaurantId) {
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(DELETE)) {

			stmt.setInt(1, restaurantId);
			int i = stmt.executeUpdate();
			System.out.println(i);

		} catch (SQLException  e) {
			e.printStackTrace();
		}
	}
	
	

	@Override
	public String getRestaurantNameById(int restaurantId) {
	    String restaurantName = null;

	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(GETRESTAURANTNAME)) {

	        pstmt.setInt(1, restaurantId);

	        ResultSet rs = pstmt.executeQuery();
	        if (rs.next()) {
	            restaurantName = rs.getString("name");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return restaurantName;
	}

}

