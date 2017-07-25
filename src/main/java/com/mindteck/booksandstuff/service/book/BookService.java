package com.mindteck.booksandstuff.service.book;

import com.mindteck.booksandstuff.dto.BookDTO;
import com.mindteck.booksandstuff.enitities.book.Book;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Philip Lozada on 7/25/2017.
 */

public interface BookService {
	void add(BookDTO bookDTO) ;
	List<Book> getBooks();
	BookDTO getBook(Long id);

}
