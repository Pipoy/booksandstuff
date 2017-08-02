package com.mindteck.booksandstuff.service.cd.impl;

import com.mindteck.booksandstuff.dao.cd.MusicGenreDAO;
import com.mindteck.booksandstuff.enitities.cd.MusicGenre;
import com.mindteck.booksandstuff.service.cd.MusicGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Philip Lozada on 8/1/2017.
 */
@Service
public class MusicGenreServiceImpl implements MusicGenreService {

	@Autowired
	private MusicGenreDAO musicGenreDAO;

	@Transactional
	@Override
	public Map<String, String> getMusicGenres() {
		List<MusicGenre> musicGenreList = musicGenreDAO.getMusicGenres();
		Map<String, String> musicGenreMap = new HashMap<>();
		for (MusicGenre mg : musicGenreList) {
			musicGenreMap.put(Long.toString(mg.getId()), mg.getName());

		}

		return musicGenreMap;
	}
}
