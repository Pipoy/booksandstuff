package com.mindteck.booksandstuff.dao.impl;

import com.mindteck.booksandstuff.dao.OrderDAO;
import com.mindteck.booksandstuff.enitities.Order;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Philip Lozada on 8/20/2017.
 */

@Repository
public class OrderDAOImpl implements OrderDAO {


	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addOrder(Order order) {
		sessionFactory.getCurrentSession().save(order);
	}

	@Override
	public void update(Order order) {
		sessionFactory.getCurrentSession().merge(order);
	}

	@Override
	public List<Order> getUsersOrders(Long userId) {
		@SuppressWarnings("unchecked")
		TypedQuery<Order> query = sessionFactory.getCurrentSession().createQuery("from Order where users.id=:id");
		query.setParameter("id", userId);
//		User user = query.getSingleResult();
		List<Order> orders = query.getResultList();
		return orders;
	}

	@Override
	public List<Order> getOrderByOrderId(Long orderId) {
		@SuppressWarnings("unchecked")
		TypedQuery<Order> query = sessionFactory.getCurrentSession().createQuery("from Order where id=:id");
		query.setParameter("id", orderId);
//		User user = query.getSingleResult();
		List<Order> orders = query.getResultList();

		return orders;
	}
}
