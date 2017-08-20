package com.mindteck.booksandstuff.dao;

import com.mindteck.booksandstuff.enitities.Order;

import java.util.List;

/**
 * Created by Philip Lozada on 8/20/2017.
 */
public interface OrderDAO {
	void addOrder(Order order);

	void update(Order order);

	List<Order> getUsersOrders(Long userId);
}
