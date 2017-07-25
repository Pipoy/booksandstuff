package com.mindteck.booksandstuff.service.book;

import com.mindteck.booksandstuff.dto.AuthorDTO;

import java.util.Map;

/**
 * Created by Philip Lozada on 7/25/2017.
 */
public interface AuthorService {
	void add(AuthorDTO authorDTO);

	AuthorDTO getAuthor(String id);

	Map<String, String> getAuthors();
}
