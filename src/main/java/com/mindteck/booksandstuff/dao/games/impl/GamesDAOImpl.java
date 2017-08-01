package com.mindteck.booksandstuff.dao.games.impl;

import com.mindteck.booksandstuff.dao.games.GamesDAO;
import com.mindteck.booksandstuff.enitities.book.Book;
import com.mindteck.booksandstuff.enitities.games.Games;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Philip Lozada on 8/1/2017.
 */

@Repository
public class GamesDAOImpl implements GamesDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Games games) {

		if(games.getId() != null){
			sessionFactory.getCurrentSession().saveOrUpdate(games);
		}else {
			sessionFactory.getCurrentSession().merge(games);
		}
	}

	@Override
	public List<Games> getGames() {
		@SuppressWarnings("unchecked")
		TypedQuery<Games> query = sessionFactory.getCurrentSession().createQuery("from Games where active=:active");
		query.setParameter("active", "YES");
		return query.getResultList();
	}

	@Override
	public Games getGame(Long id) {
		@SuppressWarnings("unchecked")
		TypedQuery<Games> query = sessionFactory.getCurrentSession().createQuery("from Games where id=:id");
		query.setParameter("id", id);
		Games games = query.getSingleResult();
		System.out.println("inside getBookDAO");
		return games;
	}
}
