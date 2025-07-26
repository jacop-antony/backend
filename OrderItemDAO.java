package com.tap.dao;

import java.util.List;
import com.tap.model.OrderItem;

public interface OrderItemDAO {
	
    void addOrderItem(OrderItem item);
    
    List<OrderItem> getItemsByOrderId(int orderId);
    
    void deleteItemById(int orderItemId);
}
