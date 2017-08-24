package com.mindteck.booksandstuff.controller.loggedIn;

import com.mindteck.booksandstuff.dto.BookDTO;
import com.mindteck.booksandstuff.dto.CD.CDDTO;
import com.mindteck.booksandstuff.dto.Games.GamesDTO;
import com.mindteck.booksandstuff.dto.OrderDTO;
import com.mindteck.booksandstuff.dto.OrderHistoryDTO;
import com.mindteck.booksandstuff.dto.UserDTO;
import com.mindteck.booksandstuff.enitities.Item;
import com.mindteck.booksandstuff.enitities.Order;
import com.mindteck.booksandstuff.enitities.book.Book;
import com.mindteck.booksandstuff.enitities.cd.CD;
import com.mindteck.booksandstuff.enitities.games.Games;
import com.mindteck.booksandstuff.service.ItemService;
import com.mindteck.booksandstuff.service.OrderService;
import com.mindteck.booksandstuff.service.UserService;
import com.mindteck.booksandstuff.service.book.BookService;
import com.mindteck.booksandstuff.service.cd.CDService;
import com.mindteck.booksandstuff.service.games.GameService;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

	@Autowired
	private OrderService orderService;

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
		Long uid = (Long) session.getAttribute("userId2");
		UserDTO user = userService.getUser((String) session.getAttribute("userId"));
//		List<Item> items = user.getOrderHistory();
//		List<OrderDTO> orders = orderService.getOrders(uid);
		List<Order> orders = orderService.getOrders(uid);

		session.setAttribute("oh", orders);

//		List<Order> o1 = user.getOrdersList();
//		for (Order o : o1) {
//			System.out.println(o.getUsers().getName());
//			System.out.println("order# " + o.getId());
//			for (Item i : o.getItem()) {
//
//				System.out.println(i.getName());
//
//			}
//			System.out.println(o.getTotalPrice());
//
//		}

		List<Item> orderItems = new ArrayList<>();

		Map<Long, List<Order>> hashmap = orders
				.stream().collect(Collectors.groupingBy(w -> w.getId()));


		for (Order o : orders) {

			System.out.println("OrderID: " +o.getId());

			for (Item i : o.getItem()) {

				orderItems.add(i);
				System.out.println(i.getName());

			}
			System.out.println(o.getTotalPrice());

		}
		model.addAttribute("orders", orders);

		model.addAttribute("orderItem", orderItems);
//		model.addAttribute("itemsH", items);
		model.addAttribute("user", user);

		return "registeredUser/profile";

	}

	@GetMapping("/auth/userProfile/{orderId}")
	public String viewOrderDetail(@PathVariable String orderId, Model model, HttpSession session) {
		List<Order> orders = orderService.getOrderByOrderId(Long.parseLong(orderId));
		List<Item> orderItems = new ArrayList<>();


		for (Order o : orders) {
			for (Item i : o.getItem()) {
				orderItems.add(i);
			}
		}
		model.addAttribute("orders", orders);
		model.addAttribute("orderItem", orderItems);
//


		return "registeredUser/orderHistory";

	}



}
