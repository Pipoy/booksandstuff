package com.mindteck.booksandstuff.service.book.impl;

import com.mindteck.booksandstuff.dao.book.AuthorDAO;
import com.mindteck.booksandstuff.dao.book.BookDAO;
import com.mindteck.booksandstuff.dao.book.GenreDAO;
import com.mindteck.booksandstuff.dao.book.PublisherDAO;
import com.mindteck.booksandstuff.dao.item.CategoryDAO;
import com.mindteck.booksandstuff.dto.BookDTO;
import com.mindteck.booksandstuff.enitities.book.Book;
import com.mindteck.booksandstuff.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Philip Lozada on 7/25/2017.
 */
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDAO bookDAO;

	@Autowired
	private AuthorDAO authorDAO;

	@Autowired
	private PublisherDAO publisherDAO;

	@Autowired
	private GenreDAO genreDAO;

	@Autowired
	private CategoryDAO categoryDAO;

	@Transactional
	@Override
	public void add(BookDTO bookDTO) {
		Book book = new Book();

		book.setId(bookDTO.getId());
		book.setName(bookDTO.getName());
		book.setPrice(Long.parseLong(bookDTO.getPrice()));
		book.setCategory(categoryDAO.getCategory(Long.parseLong(bookDTO.getCategory())));

		book.setActive(bookDTO.getActive());
		book.setDescription(bookDTO.getDescription());
		book.setIsbn(bookDTO.getIsbn());

		book.setAuthor(authorDAO.getAuthor(Long.parseLong(bookDTO.getAuthor())));
		book.setPublisher(publisherDAO.getPublisher(Long.parseLong(bookDTO.getPublisher())));
		book.setGenre(genreDAO.getGenre(Long.parseLong(bookDTO.getGenre())));




		System.out.println("inside bookserviceimpl" + book.getName() + book.getId());

		bookDAO.add(book);

	}

	@Transactional(readOnly = true)
	@Override
	public List<Book> getBooks() {
		return bookDAO.getBooks();
	}

	@Transactional
	@Override
	public BookDTO getBook(Long id) {
		Book book = bookDAO.getBook(id);

		BookDTO bookDTO = new BookDTO();


		bookDTO.setId(book.getId());
		book.setCategory(book.getCategory());
		bookDTO.setName(book.getName());
		bookDTO.setPrice(book.getPrice().toString());

		bookDTO.setActive(book.getActive());
		bookDTO.setIsbn(book.getIsbn());
		bookDTO.setDescription(book.getDescription());


		bookDTO.setGenre(Long.toString(book.getGenre().getId()));
		bookDTO.setAuthor(Long.toString(book.getAuthor().getId()));
		bookDTO.setPublisher(Long.toString(book.getPublisher().getId()));

		System.out.println("publisher: " + book.getPublisher());
		System.out.println("Author: " + book.getAuthor());

		return bookDTO;

	}
}
