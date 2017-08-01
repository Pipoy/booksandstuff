package com.mindteck.booksandstuff.dao.cd.impl;

import com.mindteck.booksandstuff.dao.cd.MusicGenreDAO;
import com.mindteck.booksandstuff.enitities.cd.MusicGenre;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Philip Lozada on 8/1/2017.
 */

@Repository
public class MusicGenreDAOImpl implements MusicGenreDAO{

	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public List<MusicGenre> getMusicGenres() {
		@SuppressWarnings("unchecked")
		TypedQuery<MusicGenre> query = sessionFactory.getCurrentSession().createQuery("from MusicGenre");
		return query.getResultList();
	}

	@Override
	public MusicGenre getMusicGenre(Long id) {
		@SuppressWarnings("unchecked")
		TypedQuery<MusicGenre> query = sessionFactory.getCurrentSession().createQuery("from MusicGenre where id=:id");
		query.setParameter("id", id);
		MusicGenre musicGenre = query.getSingleResult();

		return musicGenre;
	}
}
