package com.mindteck.booksandstuff.service.games;

import com.mindteck.booksandstuff.dto.Games.GamesDTO;
import com.mindteck.booksandstuff.enitities.games.Games;

import java.util.List;

/**
 * Created by Philip Lozada on 8/6/2017.
 */
public interface GameService {
	void add(GamesDTO gamesDTO);
	List<Games> getGames();

	GamesDTO getGame(Long id);
}
