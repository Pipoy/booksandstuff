package com.mindteck.booksandstuff.dao.cd.impl;

import com.mindteck.booksandstuff.dao.cd.CDDAO;
import com.mindteck.booksandstuff.enitities.cd.CD;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Philip Lozada on 8/1/2017.
 */

@Repository
public class CDDAOImpl implements CDDAO {

	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public void add(CD cd) {
		if(cd.getId() != null){
			sessionFactory.getCurrentSession().saveOrUpdate(cd);
		}else {
			sessionFactory.getCurrentSession().merge(cd);
		}
	}

	@Override
	public List<CD> getCDs() {
		@SuppressWarnings("unchecked")
		TypedQuery<CD> query = sessionFactory.getCurrentSession().createQuery("from CD where active=:active");
		query.setParameter("active", "YES");
		return query.getResultList();
	}

	@Override
	public CD getCD(Long id) {
		return null;
	}

}
