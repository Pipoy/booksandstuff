package com.mindteck.booksandstuff.service.games.impl;

import com.mindteck.booksandstuff.dao.games.DeveloperDAO;
import com.mindteck.booksandstuff.dao.games.GameGenreDAO;
import com.mindteck.booksandstuff.dao.games.GamesDAO;
import com.mindteck.booksandstuff.dao.games.PlatformDAO;
import com.mindteck.booksandstuff.dao.item.CategoryDAO;
import com.mindteck.booksandstuff.dto.Games.GamesDTO;
import com.mindteck.booksandstuff.enitities.games.Games;
import com.mindteck.booksandstuff.service.games.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Philip Lozada on 8/6/2017.
 */
@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private DeveloperDAO developerDAO;

	@Autowired
	private GameGenreDAO gameGenreDAO;

	@Autowired
	private PlatformDAO platformDAO;

	@Autowired
	private GamesDAO gamesDAO;



	@Transactional
	@Override
	public void add(GamesDTO gamesDTO) {
		Games game = new Games();

		game.setId(gamesDTO.getId());
		game.setName(gamesDTO.getName());
		game.setPrice(Long.parseLong(gamesDTO.getPrice()));
		game.setCategory(categoryDAO.getCategory(Long.parseLong(gamesDTO.getCategory())));

		game.setActive(gamesDTO.getActive());
		game.setDescription(gamesDTO.getDescription());

		game.setDeveloper(developerDAO.getDeveloper(Long.parseLong(gamesDTO.getDeveloper())));
		game.setGameGenre(gameGenreDAO.getGameGenre(Long.parseLong(gamesDTO.getGameGenre())));
		game.setPlatform(platformDAO.getPlatform(Long.parseLong(gamesDTO.getPlatform())));

		gamesDAO.add(game);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Games> getGames() {

		return gamesDAO.getGames();
	}

	@Transactional(readOnly = true)
	@Override
	public GamesDTO getGame(Long id) {
		Games games = gamesDAO.getGame(id);

		GamesDTO gamesDTO = new GamesDTO();

		gamesDTO.setId(games.getId());
		gamesDTO.setName(games.getName());
		gamesDTO.setPrice(games.getPrice().toString());

		gamesDTO.setActive(games.getActive());
		gamesDTO.setDescription(games.getDescription());

		gamesDTO.setCategory(Long.toString(games.getCategory().getId()));
		gamesDTO.setCategoryName(games.getCategory().getName());

		gamesDTO.setDeveloper(Long.toString(games.getDeveloper().getId()));
		gamesDTO.setDeveloperName(games.getDeveloper().getName());

		gamesDTO.setPlatform(Long.toString(games.getPlatform().getId()));
		gamesDTO.setPlatformName(games.getPlatform().getName());

		gamesDTO.setGameGenre(Long.toString(games.getGameGenre().getId()));
		gamesDTO.setGameGenreName(games.getGameGenre().getName());

		gamesDTO.setProductImage(games.getProductImage());


		return gamesDTO;
	}
}
