package com.mindteck.booksandstuff.dao.games.impl;

import com.mindteck.booksandstuff.dao.games.DeveloperDAO;
import com.mindteck.booksandstuff.enitities.games.Developer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Philip Lozada on 8/1/2017.
 */


@Repository
public class DeveloperDAOImpl implements DeveloperDAO {


	@Autowired
	private SessionFactory sessionFactory;



	@Override
	public List<Developer> getDevelopers() {
		@SuppressWarnings("unchecked")
		TypedQuery<Developer> query = sessionFactory.getCurrentSession().createQuery("from Developer");
		return query.getResultList();
	}

	@Override
	public Developer getDeveloper(Long id) {
		@SuppressWarnings("unchecked")
		TypedQuery<Developer> query = sessionFactory.getCurrentSession().createQuery("from Developer where id=:id");
		query.setParameter("id", id);
		Developer developer = query.getSingleResult();

		return developer;
	}

	@Override
	public void addDeveloper(Developer developer) {
		if(developer.getId() != null){
			sessionFactory.getCurrentSession().saveOrUpdate(developer);
		}else {
			sessionFactory.getCurrentSession().merge(developer);
		}
	}
}
