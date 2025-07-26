package com.tap.daoimp;

import java.sql.*;
import java.util.*;
import com.tap.dao.OrderItemDAO;
import com.tap.model.OrderItem;
import com.tap.util.DBConnection;

public class OrderItemDAOimp implements OrderItemDAO {

    private static final String INSERT = "INSERT INTO orderitem (orderItemId, orderId, menuId, quantity, totalAmount) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_BY_ORDER = "SELECT * FROM orderitem WHERE orderId = ?";
    private static final String DELETE = "DELETE FROM orderitem WHERE orderItemId = ?";

    @Override
    public void addOrderItem(OrderItem item) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT)) {
            stmt.setInt(1, item.getOrderItemId());
            stmt.setInt(2, item.getOrderId());
            stmt.setInt(3, item.getMenuId());
            stmt.setInt(4, item.getQuantity());
            stmt.setDouble(5, item.getTotalAmount());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OrderItem> getItemsByOrderId(int orderId) {
        List<OrderItem> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ORDER)) {
            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new OrderItem(
                    rs.getInt("orderItemId"),
                    rs.getInt("orderId"),
                    rs.getInt("menuId"),
                    rs.getInt("quantity"),
                    rs.getDouble("totalAmount")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void deleteItemById(int orderItemId) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(DELETE)) {
            stmt.setInt(1, orderItemId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
