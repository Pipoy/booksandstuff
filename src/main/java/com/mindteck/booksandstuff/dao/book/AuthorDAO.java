package com.mindteck.booksandstuff.dao.book;

import com.mindteck.booksandstuff.enitities.book.Author;

import java.util.List;

/**
 * Created by Philip Lozada on 7/25/2017.
 */
public interface AuthorDAO {
	List<Author> getAuthors();

	Author getAuthor(Long id);
	void add(Author author);
}
