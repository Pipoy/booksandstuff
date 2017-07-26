package com.mindteck.booksandstuff.dao.book;

import com.mindteck.booksandstuff.enitities.book.Book;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Philip Lozada on 7/25/2017.
 */
public interface BookDAO {
	void add(Book book);

	List<Book> getBooks();

	Book getBook(Long id);
}

