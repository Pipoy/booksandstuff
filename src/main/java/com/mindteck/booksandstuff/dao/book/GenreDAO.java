package com.mindteck.booksandstuff.dao.book;

import com.mindteck.booksandstuff.enitities.book.Genre;

import java.util.List;

/**
 * Created by Philip Lozada on 7/25/2017.
 */
public interface GenreDAO {
	List<Genre> getGenres();

	Genre getGenre(Long Id);
}
