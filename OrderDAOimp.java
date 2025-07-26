package com.tap.daoimp;

import java.sql.*;
import java.util.*;
import com.tap.dao.OrderDAO;
import com.tap.model.Order;
import com.tap.util.DBConnection;

public class OrderDAOimp implements OrderDAO {

    private static final String INSERT = "INSERT INTO `order` (orderId, restaurantId, userId, orderDate, totalAmount, status, paymentMode) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_BY_ID = "SELECT * FROM `order` WHERE orderId = ?";
    private static final String SELECT_ALL = "SELECT * FROM `order`";
    private static final String UPDATE = "UPDATE `order` SET restaurantId=?, userId=?, orderDate=?, totalAmount=?, status=?, paymentMode=? WHERE orderId = ?";
    private static final String DELETE = "DELETE FROM `order` WHERE orderId = ?";

    @Override
    public void addOrder(Order order) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT)) {
            stmt.setInt(1, order.getOrderId());
            stmt.setInt(2, order.getRestaurantId());
            stmt.setInt(3, order.getUserId());
            stmt.setString(4, order.getOrderDate());
            stmt.setDouble(5, order.getTotalAmount());
            stmt.setString(6, order.getStatus());
            stmt.setString(7, order.getPaymentMode());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Order getOrderById(int orderId) {
        Order order = null;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID)) {
            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                order = new Order(
                    rs.getInt("orderId"),
                    rs.getInt("restaurantId"),
                    rs.getInt("userId"),
                    rs.getString("orderDate"),
                    rs.getDouble("totalAmount"),
                    rs.getString("status"),
                    rs.getString("paymentMode")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                list.add(new Order(
                    rs.getInt("orderId"),
                    rs.getInt("restaurantId"),
                    rs.getInt("userId"),
                    rs.getString("orderDate"),
                    rs.getDouble("totalAmount"),
                    rs.getString("status"),
                    rs.getString("paymentMode")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void updateOrder(Order order) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE)) {
            stmt.setInt(1, order.getRestaurantId());
            stmt.setInt(2, order.getUserId());
            stmt.setString(3, order.getOrderDate());
            stmt.setDouble(4, order.getTotalAmount());
            stmt.setString(5, order.getStatus());
            stmt.setString(6, order.getPaymentMode());
            stmt.setInt(7, order.getOrderId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrder(int orderId) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(DELETE)) {
            stmt.setInt(1, orderId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
