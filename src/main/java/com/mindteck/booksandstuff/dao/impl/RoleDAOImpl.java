package com.mindteck.booksandstuff.dao.impl;

import com.mindteck.booksandstuff.dao.RoleDAO;
import com.mindteck.booksandstuff.enitities.user.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Philip Lozada on 7/24/2017.
 */
@Repository
public class RoleDAOImpl implements RoleDAO {


	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public List<Role> getRoles() {
		@SuppressWarnings("unchecked")
		TypedQuery<Role> query = sessionFactory.getCurrentSession().createQuery("from Role");
		return query.getResultList();
	}

	@Override
	public Role getRole(Long id) {
		@SuppressWarnings("unchecked")
		TypedQuery<Role> query = sessionFactory.getCurrentSession().createQuery("from Role where id=:id");
		query.setParameter("id", id);
		Role role = query.getSingleResult();

		return role;
	}
}
