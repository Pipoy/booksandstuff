package com.mindteck.booksandstuff.dao.games;

import com.mindteck.booksandstuff.enitities.games.Platform;

import java.util.List;

/**
 * Created by Philip Lozada on 8/1/2017.
 */
public interface PlatformDAO {

	List<Platform> getPlatforms();
	Platform getPlatform(Long id);
}
