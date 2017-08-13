package com.mindteck.booksandstuff.controller;

import com.mindteck.booksandstuff.dto.BookDTO;
import com.mindteck.booksandstuff.dto.CD.CDDTO;
import com.mindteck.booksandstuff.dto.Games.GamesDTO;
import com.mindteck.booksandstuff.enitities.Item;
import com.mindteck.booksandstuff.enitities.book.Book;
import com.mindteck.booksandstuff.enitities.cd.CD;
import com.mindteck.booksandstuff.enitities.games.Games;
import com.mindteck.booksandstuff.service.ItemService;
import com.mindteck.booksandstuff.service.book.AuthorService;
import com.mindteck.booksandstuff.service.book.BookService;
import com.mindteck.booksandstuff.service.cd.CDService;
import com.mindteck.booksandstuff.service.games.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by Philip Lozada on 7/25/2017.
 */

@Controller
public class HomeController {


	@Autowired
	private ItemService itemService;

	@Autowired
	private BookService bookService;

	@Autowired
	private GameService gameService;

	@Autowired
	private CDService cdService;



	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("items")
	public String listItems(Model model) {
		List<Item> items = itemService.getAllItems();
		model.addAttribute("itemList", items);

		return "items";
	}

	@GetMapping("/items/viewProduct/{productId}")
	public String viewProduct(@PathVariable String productId, Model model){
		Item item = itemService.getProductById(Long.parseLong(productId));
		Long categoryId = item.getCategory().getId();

		if (categoryId == 1) {
			BookDTO book = bookService.getBook(Long.parseLong(productId));
			String author = book.getAuthorName();
			String publisher = book.getPublisherName();
			String genre = book.getGenreName();
			String category = book.getCategoryName();
			model.addAttribute("product", book);
			model.addAttribute("author", author);
			model.addAttribute("publisher", publisher);
			model.addAttribute("genre", genre);
			model.addAttribute("category", category);
			return "viewBookDetail";
		}

		if (categoryId == 2) {
			CDDTO cddto = cdService.getCD(Long.parseLong(productId));
			model.addAttribute("cd", cddto);
			return "viewCDDetail";
		}

		if (categoryId == 3) {
			GamesDTO gamesDTO = gameService.getGame(Long.parseLong(productId));
			model.addAttribute("games", gamesDTO);
			return "viewGameDetail";
		}

		return "items";

	}

	@GetMapping("/items/cds")
	public String viewCDs(Model model) {

		List<CD> cds = cdService.getCDs();
		model.addAttribute("cdList", cds);

		return "itemsCD";
	}

	@GetMapping("/items/books")
	public String viewBooks(Model model) {

		List<Book> books = bookService.getBooks();
		model.addAttribute("bookList", books);

		return "itemsBook";
	}

	@GetMapping("/items/games")
	public String viewGames(Model model) {

		List<Games> games = gameService.getGames();
		model.addAttribute("gameList", games);

		return "itemsGames";
	}



}
