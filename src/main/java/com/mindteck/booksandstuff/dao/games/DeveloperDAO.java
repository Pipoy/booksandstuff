package com.mindteck.booksandstuff.dao.games;

import com.mindteck.booksandstuff.enitities.games.Developer;

import java.util.List;

/**
 * Created by Philip Lozada on 8/1/2017.
 */
public interface DeveloperDAO {

	List<Developer> getDevelopers();
	Developer  getDeveloper(Long id);

	void addDeveloper(Developer developer);
}
