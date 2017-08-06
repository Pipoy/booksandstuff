package com.mindteck.booksandstuff.service.games;

import com.mindteck.booksandstuff.dto.CD.ArtistDTO;
import com.mindteck.booksandstuff.dto.Games.DeveloperDTO;

import java.util.Map;

/**
 * Created by Philip Lozada on 8/6/2017.
 */
public interface DeveloperService {
	void add(DeveloperDTO developerDTO);

	DeveloperDTO getArtist(String id);
	Map<String, String> getArtists();
}
