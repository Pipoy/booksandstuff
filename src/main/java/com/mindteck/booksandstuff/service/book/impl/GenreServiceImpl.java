package com.mindteck.booksandstuff.service.book.impl;

import com.mindteck.booksandstuff.dao.book.GenreDAO;
import com.mindteck.booksandstuff.enitities.book.Genre;
import com.mindteck.booksandstuff.service.book.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Philip Lozada on 7/25/2017.
 */
@Service
public class GenreServiceImpl implements GenreService {
	@Autowired
	private GenreDAO genreDAO;

	@Transactional
	@Override
	public Map<String, String> getGenres() {
		List<Genre> genres = genreDAO.getGenres();
		Map<String, String> genreMap = new HashMap<>();
		for(Genre g : genres) {
			genreMap.put(Long.toString(g.getId()), g.getName());
		}
		return genreMap;
	}
}
