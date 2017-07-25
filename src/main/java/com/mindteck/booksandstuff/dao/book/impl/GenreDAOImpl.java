package com.mindteck.booksandstuff.dao.book.impl;

import com.mindteck.booksandstuff.dao.book.GenreDAO;
import com.mindteck.booksandstuff.enitities.book.Genre;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Philip Lozada on 7/25/2017.
 */
@Repository
public class GenreDAOImpl implements GenreDAO {


	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public List<Genre> getGenres() {
		@SuppressWarnings("unchecked")
		TypedQuery<Genre> query = sessionFactory.getCurrentSession().createQuery("from Genre");
		return query.getResultList();
	}

	@Override
	public Genre getGenre(Long id) {
		@SuppressWarnings("unchecked")
		TypedQuery<Genre> query = sessionFactory.getCurrentSession().createQuery("from Genre where id=:id");
		query.setParameter("id", id);
		Genre genre = query.getSingleResult();

		return genre;
	}
}
