package com.mindteck.booksandstuff.controller;

import com.mindteck.booksandstuff.enitities.games.Games;
import com.mindteck.booksandstuff.service.CategoryService;
import com.mindteck.booksandstuff.service.games.DeveloperService;
import com.mindteck.booksandstuff.service.games.GameGenreService;
import com.mindteck.booksandstuff.service.games.GameService;
import com.mindteck.booksandstuff.service.games.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by Philip Lozada on 8/6/2017.
 */

@Controller
public class GamesController {

	@Autowired
	private GameService gameService;

	@Autowired
	private DeveloperService developerService;

	@Autowired
	private GameGenreService gameGenreService;

	@Autowired
	private CategoryService categoryService;



	@Autowired
	private PlatformService platformService;


	@GetMapping("gamesManager")
	public String listGames(Model model) {
		List<Games> games = gameService.getGames();
		model.addAttribute("gameList", games);
		return "gamesManager";
	}

	@GetMapping("bookForm")
	public String showBookForm(Model model){
		Games game = new Games();

		model.addAttribute("game", game);
		model.addAttribute("developer", developerService.getDevelopers());
		model.addAttribute("gameGenre", gameGenreService.getGameGenres());
		model.addAttribute("category", categoryService.getCategories());
		model.addAttribute("platform", platformService.getPlatforms());

		return "bookForm";
	}
}
