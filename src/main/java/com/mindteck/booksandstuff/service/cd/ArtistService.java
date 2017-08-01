package com.mindteck.booksandstuff.service.cd;

import com.mindteck.booksandstuff.dto.CD.ArtistDTO;

import java.util.Map;

/**
 * Created by Philip Lozada on 8/1/2017.
 */
public interface ArtistService {
	void add(ArtistDTO artistDTO);

	ArtistDTO getArtist(String id);
	Map<String, String> getArtists();
}
