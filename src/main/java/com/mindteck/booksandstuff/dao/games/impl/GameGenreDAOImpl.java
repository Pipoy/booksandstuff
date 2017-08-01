package com.mindteck.booksandstuff.dao.games.impl;

import com.mindteck.booksandstuff.dao.games.GameGenreDAO;
import com.mindteck.booksandstuff.enitities.book.Genre;
import com.mindteck.booksandstuff.enitities.games.GameGenre;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Philip Lozada on 8/1/2017.
 */
@Repository
public class GameGenreDAOImpl implements GameGenreDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<GameGenre> getGameGenres() {
		@SuppressWarnings("unchecked")
		TypedQuery<GameGenre> query = sessionFactory.getCurrentSession().createQuery("from GameGenre");
		return query.getResultList();
	}

	@Override
	public GameGenre getGameGenre(Long id) {
		@SuppressWarnings("unchecked")
		TypedQuery<GameGenre> query = sessionFactory.getCurrentSession().createQuery("from GameGenre where id=:id");
		query.setParameter("id", id);
		GameGenre gameGenre = query.getSingleResult();

		return gameGenre;
	}
}
