package com.mindteck.booksandstuff.dao.cd;

import com.mindteck.booksandstuff.enitities.cd.Artist;
import com.mindteck.booksandstuff.enitities.cd.CD;

import java.util.List;

/**
 * Created by Philip Lozada on 8/1/2017.
 */
public interface ArtistDAO {

	List<Artist> getArtists();

	Artist getArtist(Long id);

	void add(Artist cd);
}
