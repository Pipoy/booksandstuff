package com.mindteck.booksandstuff.dao.impl;

import com.mindteck.booksandstuff.dao.WishDAO;
import com.mindteck.booksandstuff.enitities.user.User;
import com.mindteck.booksandstuff.enitities.user.Wish;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Philip Lozada on 8/15/2017.
 */
@Repository
public class WishDAOImpl implements WishDAO {

	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public void addWish(Wish wish) {
		sessionFactory.getCurrentSession().save(wish);
	}

	@Override
	public void update(Wish wish) {
		sessionFactory.getCurrentSession().merge(wish);
	}

	@Override
	public List<Wish> getUserWishList(Long userId) {
		@SuppressWarnings("unchecked")
		TypedQuery<Wish> query = sessionFactory.getCurrentSession().createQuery("from Wish where user.id=:id");
		query.setParameter("id", userId);
//		User user = query.getSingleResult();
		List<Wish> wishes = query.getResultList();
		return wishes;

	}


//	public List<Wish> getWishList(Long userId) {
//		@SuppressWarnings("unchecked")
//		TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User where id=:id");
//		query.setParameter("id", userId);
//		User user = query.getSingleResult();
//		List<Wish> wishes = user.getUserWishList();
//		return wishes;
//
//	}
}
