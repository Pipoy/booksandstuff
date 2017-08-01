package com.mindteck.booksandstuff.dao.games;

import com.mindteck.booksandstuff.enitities.games.Games;

import java.util.List;

/**
 * Created by Philip Lozada on 8/1/2017.
 */
public interface GamesDAO {

	void add(Games games);
	List<Games> getGames();
	Games getGame(Long id);
}
