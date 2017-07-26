package com.mindteck.booksandstuff.controller;

import com.mindteck.booksandstuff.dto.BookDTO;
import com.mindteck.booksandstuff.enitities.Item;
import com.mindteck.booksandstuff.service.ItemService;
import com.mindteck.booksandstuff.service.book.AuthorService;
import com.mindteck.booksandstuff.service.book.BookService;
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
	private AuthorService authorService;






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

		}


		return "viewProduct";
	}

}
