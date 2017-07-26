package com.mindteck.booksandstuff.controller;

import com.mindteck.booksandstuff.dao.book.BookDAO;
import com.mindteck.booksandstuff.dto.BookDTO;
import com.mindteck.booksandstuff.enitities.book.Book;
import com.mindteck.booksandstuff.service.CategoryService;
import com.mindteck.booksandstuff.service.book.AuthorService;

import com.mindteck.booksandstuff.service.book.BookService;
import com.mindteck.booksandstuff.service.book.GenreService;
import com.mindteck.booksandstuff.service.book.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Philip Lozada on 7/25/2017.
 */
@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private AuthorService authorService;

	@Autowired
	private GenreService genreService;

	@Autowired
	private PublisherService publisherService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	BookDAO bookDAO;

	private Path path;


	@GetMapping("list")
	public String listBooks(Model model) {
		List<Book> books = bookService.getBooks();
		model.addAttribute("booksList", books);

		return "listBooks";

	}

	@GetMapping("bookForm")
	public String showBookForm(Model model) {
		Book book1 = new Book();

		model.addAttribute("bookShow", book1);

		model.addAttribute("authorsShow",  authorService.getAuthors());
		model.addAttribute("genresShow", genreService.getGenres());
		model.addAttribute("publishersShow", publisherService.getPublishers());
		model.addAttribute("categoriesShow", categoryService.getCategories());



		return "formBook";


	}

	@PostMapping("saveBook")
	public String saveBook(@ModelAttribute("bookShow") @Valid BookDTO book, BindingResult result, Model model, HttpServletRequest request) {

		if (result.hasErrors()) {
			model.addAttribute("authorsShow", authorService.getAuthors());
			model.addAttribute("genresShow", genreService.getGenres());
			model.addAttribute("publishersShow", publisherService.getPublishers());
			model.addAttribute("categoriesShow", categoryService.getCategories());

			return "formBook";
		}

		System.out.println("id:" + book.getId() +
				"name: " + book.getName() +
				"author: " + book.getAuthor() +
				"publisher: " + book.getPublisher() +
				"isbn" + book.getIsbn());
		bookService.add(book);



		return "redirect:list";
	}


	@GetMapping("updateForm")
	public String updateForm(@RequestParam("bookId") String theId, Model model) {

		BookDTO book = bookService.getBook(Long.parseLong(theId));

		model.addAttribute("authorsShow",  authorService.getAuthors());
		model.addAttribute("genresShow", genreService.getGenres());
		model.addAttribute("publishersShow", publisherService.getPublishers());
		model.addAttribute("categoriesShow", categoryService.getCategories());
		model.addAttribute("bookShow", book);


		return "formBook";
	}

}








