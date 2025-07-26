package com.tap.daoimp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.MenuDAO;
import com.tap.model.Menu;
import com.tap.util.DBConnection;

public class MenuDAOimp implements MenuDAO {

	private String INSERT = "INSERT INTO `menu` (`menuId`, `restaurantId`, `itemName`, `description`, `price`, `isAvailable`, `ratings`) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private String UPDATE = "UPDATE `menu` SET `itemName` = ?, `description` = ?, `price` = ?, `isAvailable` = ?, `ratings` = ?, `imagePath` = ?, `restaurantId` = ? WHERE `menuId` = ?";
	private String SELECT = "SELECT * FROM `menu` WHERE `menuId` = ?";
	private String SELECT_BY_RESTAURANT = "SELECT * FROM `menu` WHERE `restaurantId` = ?";
	private String DELETE = "DELETE FROM `menu` WHERE `menuId` = ?";

	@Override
	public void addMenu(Menu menu) {
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(INSERT)) {

			stmt.setInt(1, menu.getMenuId());
			stmt.setInt(2, menu.getRestaurantId());
			stmt.setString(3, menu.getItemName());
			stmt.setString(4, menu.getDescription());
			stmt.setInt(5, menu.getPrice());
			stmt.setString(6, menu.getIsAvailable());
			stmt.setDouble(7, menu.getRatings());

			int i = stmt.executeUpdate();
			
			System.out.println(i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private int getMenuId() {
		return 0;
	}

	@Override
	public Menu getMenuById(int menuId) {
		Menu m = null;
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT)) {

			stmt.setInt(1, menuId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				m = new Menu(
					rs.getInt("menuId"),
					rs.getInt("restaurantId"),
					rs.getString("itemName"),
					rs.getString("description"),
					rs.getInt("price"),
					rs.getString("isAvailable"),
					rs.getFloat("ratings"),
					rs.getString("imagePath")
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public List<Menu> getMenusByRestaurant(int restaurantId) {
		List<Menu> list = new ArrayList<>();
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_BY_RESTAURANT)) {

			stmt.setInt(1, restaurantId);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Menu m = new Menu(
					rs.getInt("menuId"),
					rs.getInt("restaurantId"),
					rs.getString("itemName"),
					rs.getString("description"),
					rs.getInt("price"),
					rs.getString("isAvailable"),
					rs.getFloat("ratings"),
					rs.getString("imagePath")
				);
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void updateMenu(Menu m) {
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(UPDATE)) {

			stmt.setString(1, m.getItemName());
			stmt.setString(2, m.getDescription());
			stmt.setInt(3, m.getPrice());
			stmt.setString(4, m.getIsAvailable());
			stmt.setFloat(5, m.getRatings());
			stmt.setString(6, m.getImagePath());
			stmt.setInt(7, m.getRestaurantId());
			stmt.setInt(8, m.getMenuId());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteMenu(int id) {
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(DELETE)) {

			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
