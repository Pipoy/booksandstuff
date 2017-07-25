package com.mindteck.booksandstuff.dao.book.impl;

import com.mindteck.booksandstuff.dao.book.PublisherDAO;
import com.mindteck.booksandstuff.enitities.book.Publisher;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Philip Lozada on 7/25/2017.
 */
@Repository
public class PublisherDAOImpl implements PublisherDAO{

	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public List<Publisher> getPublishers() {
		@SuppressWarnings("unchecked")
		TypedQuery<Publisher> query = sessionFactory.getCurrentSession().createQuery("from Publisher");
		return query.getResultList();

	}

	@Override
	public Publisher getPublisher(Long id) {
		@SuppressWarnings("unchecked")
		TypedQuery<Publisher> query = sessionFactory.getCurrentSession().createQuery("from Publisher where id=:id");
		query.setParameter("id", id);
		Publisher publisher = query.getSingleResult();

		return publisher;

	}
}
