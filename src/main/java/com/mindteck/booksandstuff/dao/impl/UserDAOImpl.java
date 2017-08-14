package com.mindteck.booksandstuff.dao.impl;

import com.mindteck.booksandstuff.dao.UserDAO;
import com.mindteck.booksandstuff.enitities.user.Role;
import com.mindteck.booksandstuff.enitities.user.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Philip Lozada on 7/24/2017.
 */
@Repository
public class UserDAOImpl implements UserDAO {


	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public void add(User user) {
		if(user.getId()!=null){
			sessionFactory.getCurrentSession().save(user);}
		else{
			sessionFactory.getCurrentSession().merge(user);}


	}

	@Override
	public List<User> getUsers() {
		@SuppressWarnings("unchecked")
		TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
		return query.getResultList();
	}

	@Override
	public boolean validateUser(String email, String password) {
		@SuppressWarnings("unchecked")
		TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User where email=:email AND password=:password");
		query.setParameter("email", email);
		query.setParameter("password", password);
		List<User> users = query.getResultList();
		if (users.size() > 0)
			return true;
		else
			return false;
	}

	@Override
	public User getUser(Long id) {
		@SuppressWarnings("unchecked")
		TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User where id=:id");
		query.setParameter("id", id);
		User user = query.getSingleResult();

		return user;
	}

	@Override
	public Role getRole(String email, String password) {
		TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User where email=:email and password = :password");
		query.setParameter("email", email);
		query.setParameter("password", password);
		User user = query.getSingleResult();
		return user.getRole();
	}

	@Override
	public Role getRole(String id) {
		User user = sessionFactory.getCurrentSession().get(User.class, Long.parseLong(id));
		return  user.getRole();
	}

	@Override
	public User getUserByEmail(String email) {
		@SuppressWarnings("unchecked")
		TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User where email=:email");
		query.setParameter("email", email);
		User user = query.getSingleResult();

		return user;
	}
}
