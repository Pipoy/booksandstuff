package com.mindteck.booksandstuff.service;

import com.mindteck.booksandstuff.dto.OrderDTO;
import com.mindteck.booksandstuff.enitities.Order;

import java.util.List;

/**
 * Created by Philip Lozada on 8/20/2017.
 */
public interface OrderService {
	void addOrder(OrderDTO orderDTO);
	void addOrder(Order order);

//	List<OrderDTO> getOrders(Long userId);
	List<Order> getOrders(Long userId);

	List<Order> getOrderByOrderId(Long orderID);
}
