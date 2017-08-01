package com.mindteck.booksandstuff.dao.games;

import com.mindteck.booksandstuff.enitities.games.GameGenre;

import java.util.List;

/**
 * Created by Philip Lozada on 8/1/2017.
 */
public interface GameGenreDAO {

	List<GameGenre> getGameGenres();
	GameGenre getGameGenre(Long id);
}
