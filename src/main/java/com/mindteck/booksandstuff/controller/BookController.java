package com.mindteck.booksandstuff.controller;

import com.mindteck.booksandstuff.enitities.book.Book;
import com.mindteck.booksandstuff.service.book.AuthorService;

import com.mindteck.booksandstuff.service.book.BookService;
import com.mindteck.booksandstuff.service.book.GenreService;
import com.mindteck.booksandstuff.service.book.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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


	@GetMapping("list")
	public String listBooks(Model model) {
		List<Book> books = bookService.getBooks();
		model.addAttribute("booksList", books);

		return "listBooks";

	}



}
