package com.mindteck.booksandstuff.dao.games.impl;

import com.mindteck.booksandstuff.dao.games.PlatformDAO;
import com.mindteck.booksandstuff.enitities.book.Publisher;
import com.mindteck.booksandstuff.enitities.games.Platform;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Philip Lozada on 8/1/2017.
 */
@Repository
public class PlatformDAOImpl implements PlatformDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Platform> getPlatforms() {
		@SuppressWarnings("unchecked")
		TypedQuery<Platform> query = sessionFactory.getCurrentSession().createQuery("from Platform");
		return query.getResultList();
	}

	@Override
	public Platform getPlatform(Long id) {
		@SuppressWarnings("unchecked")
		TypedQuery<Platform> query = sessionFactory.getCurrentSession().createQuery("from Platform where id=:id");
		query.setParameter("id", id);
		Platform platform = query.getSingleResult();

		return platform;

	}
}
