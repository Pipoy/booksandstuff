package com.mindteck.booksandstuff.service.cd.impl;

import com.mindteck.booksandstuff.dao.cd.ArtistDAO;
import com.mindteck.booksandstuff.dto.CD.ArtistDTO;
import com.mindteck.booksandstuff.enitities.cd.Artist;
import com.mindteck.booksandstuff.service.cd.ArtistService;
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
public class ArtistServiceImpl implements ArtistService{

	@Autowired
	private ArtistDAO artistDAO;

	@Transactional
	@Override
	public void add(ArtistDTO artistDTO) {
		Artist artist = new Artist();

		artist.setId(artistDTO.getId());
		artist.setName(artistDTO.getName());

		artistDAO.add(artist);

	}

	@Transactional
	@Override
	public ArtistDTO getArtist(String id) {
		Artist artist = artistDAO.getArtist(Long.parseLong(id));
		ArtistDTO artistDTO = new ArtistDTO();

		artistDTO.setId(artist.getId());
		artistDTO.setName(artist.getName());

		return artistDTO;
	}

	@Transactional(readOnly = true)
	@Override
	public Map<String, String> getArtists() {
		List<Artist> artists = artistDAO.getArtists();
		Map<String, String> artistMap = new HashMap<>();
		for (Artist artist : artists) {
			artistMap.put(Long.toString(artist.getId()), artist.getName());
		}
		return artistMap;
	}
}
