package com.mindteck.booksandstuff.dao.book.impl;

import com.mindteck.booksandstuff.dao.book.AuthorDAO;
import com.mindteck.booksandstuff.enitities.book.Author;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Philip Lozada on 7/25/2017.
 */

@Repository
public class AuthorDAOImpl implements AuthorDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Author> getAuthors() {
		@SuppressWarnings("unchecked")
		TypedQuery<Author> query = sessionFactory.getCurrentSession().createQuery("from Author");
		return query.getResultList();
	}

	@Override
	public Author getAuthor(Long id) {
		@SuppressWarnings("unchecked")
		TypedQuery<Author> query = sessionFactory.getCurrentSession().createQuery("from Author where id=:id");
		query.setParameter("id", id);
		Author author = query.getSingleResult();

		return author;
	}

	@Override
	public void addAuthor(Author author) {
		if(author.getId() != null){
			sessionFactory.getCurrentSession().saveOrUpdate(author);
		}else {
			sessionFactory.getCurrentSession().merge(author);
		}

	}
}
