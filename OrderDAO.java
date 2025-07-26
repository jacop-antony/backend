package com.tap.dao;

import java.util.List;
import com.tap.model.Order;

	public interface OrderDAO {
	void addOrder(Order order);
	Order getOrderById(int orderId);
	List<Order> getAllOrders();
	void updateOrder(Order order);
	void deleteOrder(int orderId);
}
