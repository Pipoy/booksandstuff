package com.mindteck.booksandstuff.dao.cd.impl;

import com.mindteck.booksandstuff.dao.cd.ArtistDAO;
import com.mindteck.booksandstuff.enitities.cd.Artist;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Philip Lozada on 8/1/2017.
 */

@Repository
public class ArtistDAOImpl implements ArtistDAO{


	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public List<Artist> getArtists() {
		@SuppressWarnings("unchecked")
		TypedQuery<Artist> query = sessionFactory.getCurrentSession().createQuery("from Artist");
		return query.getResultList();
	}

	@Override
	public Artist getCD(Long id) {
		@SuppressWarnings("unchecked")
		TypedQuery<Artist> query = sessionFactory.getCurrentSession().createQuery("from Artist where id=:id");
		query.setParameter("id", id);
		Artist artist = query.getSingleResult();

		return artist;
	}

	@Override
	public void addCD(Artist artist) {
		if(artist.getId() != null){
			sessionFactory.getCurrentSession().saveOrUpdate(artist);
		}else {
			sessionFactory.getCurrentSession().merge(artist);
		}

	}
}
