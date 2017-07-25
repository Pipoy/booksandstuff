package com.mindteck.booksandstuff.dao.item;

import com.mindteck.booksandstuff.enitities.Item;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Philip Lozada on 7/25/2017.
 */
@Repository
public class ItemDAOImpl implements ItemDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Item> getItems() {
		@SuppressWarnings("unchecked")
		TypedQuery<Item> query = sessionFactory.getCurrentSession().createQuery("from Item");
		return query.getResultList();
	}

	@Override
	public Item getItem(Long itemId) {
		@SuppressWarnings("unchecked")
		TypedQuery<Item> query = sessionFactory.getCurrentSession().createQuery("from Item where id=:iid");
		query.setParameter("iid", itemId);
		Item item = query.getSingleResult();
		return item;
	}

	@Override
	public List<Item> getItemsByCategory(Long categoryId) {
		@SuppressWarnings("unchecked")
		TypedQuery<Item> query = sessionFactory.getCurrentSession().createQuery("from Item where Category.id=:cid");
		query.setParameter("cid", categoryId);
		return query.getResultList();
	}
}
