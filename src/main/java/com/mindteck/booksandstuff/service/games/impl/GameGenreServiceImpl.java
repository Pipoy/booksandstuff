package com.mindteck.booksandstuff.service.games.impl;

import com.mindteck.booksandstuff.dao.games.GameGenreDAO;
import com.mindteck.booksandstuff.enitities.games.GameGenre;
import com.mindteck.booksandstuff.service.games.GameGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Philip Lozada on 8/6/2017.
 */
@Service
public class GameGenreServiceImpl implements GameGenreService{

	@Autowired
	private GameGenreDAO gameGenreDAO;


	@Transactional
	@Override
	public Map<String, String> getGameGenres() {
		List<GameGenre> gameGenres = gameGenreDAO.getGameGenres();
		Map<String, String> gameGenreMap = new HashMap<>();
		for (GameGenre gg : gameGenres) {
			gameGenreMap.put(Long.toString(gg.getId()), gg.getName());
		}

		return gameGenreMap;
	}
}
