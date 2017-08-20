package com.mindteck.booksandstuff.controller.loggedIn;

import com.mindteck.booksandstuff.dto.BookDTO;
import com.mindteck.booksandstuff.dto.CD.CDDTO;
import com.mindteck.booksandstuff.dto.Games.GamesDTO;
import com.mindteck.booksandstuff.dto.UserDTO;
import com.mindteck.booksandstuff.enitities.Category;
import com.mindteck.booksandstuff.enitities.Item;
import com.mindteck.booksandstuff.enitities.Order;
import com.mindteck.booksandstuff.enitities.book.Book;
import com.mindteck.booksandstuff.enitities.cd.CD;
import com.mindteck.booksandstuff.enitities.games.Games;
import com.mindteck.booksandstuff.enitities.user.User;
import com.mindteck.booksandstuff.service.ItemService;
import com.mindteck.booksandstuff.service.UserService;
import com.mindteck.booksandstuff.service.book.BookService;
import com.mindteck.booksandstuff.service.cd.CDService;
import com.mindteck.booksandstuff.service.games.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Philip Lozada on 8/14/2017.
 */
@Controller
public class HomeRegisteredController {
	@Autowired
	private UserService userService;



	@Autowired
	private ItemService itemService;

	@Autowired
	private BookService bookService;

	@Autowired
	private GameService gameService;

	@Autowired
	private CDService cdService;

	@GetMapping("/index")
	public String home() {
		return "registeredUser/home";
	}

	@GetMapping("/auth/items")
	public String listItems(Model model) {
		List<Item> items = itemService.getAllItems();
		model.addAttribute("itemList", items);

		return "registeredUser/items";
	}
	@GetMapping("/auth/items/viewProduct/{productId}")
	public String viewProduct(@PathVariable String productId, Model model){
		Item item = itemService.getProductById(Long.parseLong(productId));
		Long categoryId = item.getCategory().getId();
//		List<Category> c = item.getCategories();

//		for(int i =0; i <c.size(); i++) {
//			if(c.get(i).getId() == 1){
//				BookDTO book = bookService.getBook(Long.parseLong(productId));
//				String author = book.getAuthorName();
//				String publisher = book.getPublisherName();
//				String genre = book.getGenreName();
//				String category = book.getCategoryName();
//				model.addAttribute("product", book);
//				model.addAttribute("author", author);
//				model.addAttribute("publisher", publisher);
//				model.addAttribute("genre", genre);
//				model.addAttribute("category", category);
//				return "registeredUser/viewBookDetail";
//			}
//			if (c.get(i).getId() == 2) {
//				CDDTO cddto = cdService.getCD(Long.parseLong(productId));
//				model.addAttribute("cd", cddto);
//				return "registeredUser/viewCDDetail";
//			}
//			if(c.get(i).getId() == 3){
//				GamesDTO gamesDTO = gameService.getGame(Long.parseLong(productId));
//				model.addAttribute("games", gamesDTO);
//				return "registeredUser/viewGameDetail";
//			}
//		}




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
			return "registeredUser/viewBookDetail";
		}

		if (categoryId == 2) {
			CDDTO cddto = cdService.getCD(Long.parseLong(productId));
			model.addAttribute("cd", cddto);
			return "registeredUser/viewCDDetail";
		}

		if (categoryId == 3) {
			GamesDTO gamesDTO = gameService.getGame(Long.parseLong(productId));
			model.addAttribute("games", gamesDTO);
			return "registeredUser/viewGameDetail";
		}

		return "registeredUser/items";

	}

	@GetMapping("/auth/items/cds")
	public String viewCDs(Model model) {

		List<CD> cds = cdService.getCDs();
		model.addAttribute("cdList", cds);

		return "registeredUser/itemsCD";
	}

	@GetMapping("/auth/items/books")
	public String viewBooks(Model model) {

		List<Book> books = bookService.getBooks();
		model.addAttribute("bookList", books);

		return "registeredUser/itemsBook";
	}

	@GetMapping("/auth/items/games")
	public String viewGames(Model model) {

		List<Games> games = gameService.getGames();
		model.addAttribute("gameList", games);

		return "registeredUser/itemsGames";
	}

	@GetMapping("/auth/logout")
	public String logout(Model model, HttpServletRequest request) {
		System.out.println("logout()");
		HttpSession httpSession = request.getSession();
		httpSession.invalidate();
		return "redirect:/home";

	}

	@GetMapping("/auth/userProfile")
	public String viewUserProfile(Model model, HttpSession session) {
		//model.addAttribute("user", userService.getUser((String) session.getAttribute("userId")));
		//String uid = (String) session.getAttribute("userId");
//		System.out.println(session.getAttribute("userId"));
//		String uid = (String) session.getAttribute("userId");
		UserDTO user = userService.getUser((String) session.getAttribute("userId"));
//		User usr = (User) session.getAttribute("currentUser");
		List<Item> items = user.getOrderHistory();


		List<Order> orders = user.getOrdersList();
//		for (Order i : orders) {
//			System.out.println(i.getItem().getName());
//
//		}




		model.addAttribute("itemsH", items);
		model.addAttribute("itemsX", orders);
		model.addAttribute("user", user);



		return "registeredUser/profile";

	}


}
