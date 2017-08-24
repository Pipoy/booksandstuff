package com.mindteck.booksandstuff.service.impl;

import com.mindteck.booksandstuff.dao.OrderDAO;
import com.mindteck.booksandstuff.dao.UserDAO;
import com.mindteck.booksandstuff.dao.item.ItemDAO;
import com.mindteck.booksandstuff.dto.OrderDTO;
import com.mindteck.booksandstuff.enitities.Item;
import com.mindteck.booksandstuff.enitities.Order;
import com.mindteck.booksandstuff.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Philip Lozada on 8/20/2017.
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private ItemDAO itemDAO;

	@Autowired
	private OrderDAO orderDAO;

	@Transactional
	@Override
	public void addOrder(OrderDTO orderDTO) {
		Order order = new Order();
//		order.setId(orderDTO.getId());
		//order.setItem(itemDAO.getItem((orderDTO.getItem().getId())));
		for (Item i : orderDTO.getOrderItems()) {
			order.getItem().add(i);
		}
//		order.setUser(userDAO.getUser((orderDTO.getUser().getId())));

		orderDAO.addOrder(order);

	}

	@Transactional
	@Override
	public void addOrder(Order order) {
		orderDAO.addOrder(order);
	}

	@Transactional
	@Override
	public List<Order> getOrders(Long userId) {
		List<Order> orders = orderDAO.getUsersOrders(userId);


		return orders;
	}

	@Transactional
	@Override
	public List<Order> getOrderByOrderId(Long orderID) {
		List<Order> orders = orderDAO.getOrderByOrderId(orderID);
		return orders;
	}

//	@Transactional
//	@Override
//	public List<OrderDTO> getOrders(Long userId) {
//		List<Order> orders = orderDAO.getUsersOrders(userId);
//
//		List<OrderDTO> orderDTOS = new ArrayList<>();
//		for (Order o : orders) {
//			OrderDTO odto = new OrderDTO();
//
//			for (Item i : o.getItem()) {
//				odto.getOrderItems().add(i);
//			}
//			odto.setId(o.getId());
//			odto.setUser(o.getUsers());
//			orderDTOS.add(odto);
//
//		}
//
//		return orderDTOS;
//	}
}
