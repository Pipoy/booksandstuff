package com.mindteck.booksandstuff.controller.admin;

import com.mindteck.booksandstuff.dto.Games.GamesDTO;
import com.mindteck.booksandstuff.enitities.games.Games;
import com.mindteck.booksandstuff.service.CategoryService;
import com.mindteck.booksandstuff.service.games.DeveloperService;
import com.mindteck.booksandstuff.service.games.GameGenreService;
import com.mindteck.booksandstuff.service.games.GameService;
import com.mindteck.booksandstuff.service.games.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Philip Lozada on 8/6/2017.
 */

@Controller
@RequestMapping("/admin/gamesManager")
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


	@GetMapping("/")
	public String listGames(Model model, HttpSession session) {


		Long roleId = (Long) session.getAttribute("userRoleId");
		if (roleId==1) {
			List<Games> games = gameService.getGames();
			model.addAttribute("gameList", games);
			return "admin/gamesManager";
		}else {
			return "redirect:/";
		}
	}

	@GetMapping("/gameForm")
	public String showGamesForm(Model model, HttpSession session){
		Long roleId = (Long) session.getAttribute("userRoleId");
		if (roleId==1) {
			Games game = new Games();

			model.addAttribute("game", game);
			model.addAttribute("developer", developerService.getDevelopers());
			model.addAttribute("gameGenre", gameGenreService.getGameGenres());
			model.addAttribute("category", categoryService.getCategories());
			model.addAttribute("platform", platformService.getPlatforms());

			return "admin/formGames";
		}else {
			return "redirect:/";
		}
	}

	@PostMapping("saveGame")
	public String saveGame(@ModelAttribute("game") @Valid GamesDTO gamesDTO,
	                       BindingResult result, Model model,
	                       HttpServletRequest request, HttpSession session) {


		Long roleId = (Long) session.getAttribute("userRoleId");
		if (roleId==1) {
			if (result.hasErrors()) {
				model.addAttribute("developer", developerService.getDevelopers());
				model.addAttribute("gameGenre", gameGenreService.getGameGenres());
				model.addAttribute("category", categoryService.getCategories());
				model.addAttribute("platform", platformService.getPlatforms());

				return "admin/formGames";
			}
			gameService.add(gamesDTO);

			MultipartFile gameImage = gamesDTO.getProductImage();
			String rootDirectory = request.getSession().getServletContext().getRealPath("/");
			Path path = Paths.get(rootDirectory + "\\resources\\images\\" + gamesDTO.getId() + ".png");

			if (gameImage != null && !gameImage.isEmpty()) {
				try {
					gameImage.transferTo(new File(path.toString()));
					//System.out.println(path);
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException("Image saving failed!,", e);
				}
			}
		}else {
			return "redirect:/";
		}


		return "redirect:/admin/gamesManager/";
	}

	@GetMapping("/updateFormGames")
	public String updateFormGames(@RequestParam("gameId") String id, Model model, HttpSession session) {


		Long roleId = (Long) session.getAttribute("userRoleId");
		if (roleId==1) {
			GamesDTO gamesDTO = gameService.getGame(Long.parseLong(id));

			model.addAttribute("game", gamesDTO);
			model.addAttribute("developer", developerService.getDevelopers());
			model.addAttribute("gameGenre", gameGenreService.getGameGenres());
			model.addAttribute("category", categoryService.getCategories());
			model.addAttribute("platform", platformService.getPlatforms());
			return "admin/formGames";
		}else {
			return "redirect:/";
		}

	}
}
