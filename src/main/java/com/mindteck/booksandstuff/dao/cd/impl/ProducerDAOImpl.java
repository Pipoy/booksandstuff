package com.mindteck.booksandstuff.dao.cd.impl;

import com.mindteck.booksandstuff.dao.cd.ProducerDAO;
import com.mindteck.booksandstuff.enitities.cd.Producer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;



@Repository
public class ProducerDAOImpl implements ProducerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Producer> getProducets() {
		@SuppressWarnings("unchecked")
		TypedQuery<Producer> query = sessionFactory.getCurrentSession().createQuery("from Producer");
		return query.getResultList();
	}

	@Override
	public Producer getProducer(Long id) {
		@SuppressWarnings("unchecked")
		TypedQuery<Producer> query = sessionFactory.getCurrentSession().createQuery("from Producer where id=:id");
		query.setParameter("id", id);
		Producer producer = query.getSingleResult();

		return producer;
	}
}
