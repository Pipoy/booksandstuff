package com.mindteck.booksandstuff.dao.cart.impl;

import com.mindteck.booksandstuff.dao.cart.CartDAO;
import com.mindteck.booksandstuff.enitities.Cart;
import com.mindteck.booksandstuff.enitities.book.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Philip Lozada on 8/18/2017.
 */
@Repository
public class CartDAOImpl implements CartDAO {

	private List<Cart> cartList;

	@Autowired
	private SessionFactory sessionFactory;



	@Override
	public Cart createCart(Cart cart) {
		if (cart.getId() != null) {
			sessionFactory.getCurrentSession().saveOrUpdate(cart);
		}else{
			sessionFactory.getCurrentSession().merge(cart);
		}
		return null;
	}

	@Override
	public Cart getCart(String cartId) {
		@SuppressWarnings("unchecked")
		TypedQuery<Cart> query = sessionFactory.getCurrentSession().createQuery("from Cart where id=:id");
		query.setParameter("id", cartId);
		return query.getSingleResult();

	}

	@Override
	public void update(Long cartId) {

	}

	@Override
	public void delete(Long cartId) {

	}
}
