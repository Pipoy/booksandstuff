package com.mindteck.booksandstuff.dao.cd;

import com.mindteck.booksandstuff.enitities.cd.MusicGenre;

import java.util.List;

/**
 * Created by Philip Lozada on 8/1/2017.
 */
public interface MusicGenreDAO {
	List<MusicGenre> getMusicGenres();

	MusicGenre getMusicGenre(Long id);
}
