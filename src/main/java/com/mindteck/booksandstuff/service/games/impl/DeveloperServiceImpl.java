package com.mindteck.booksandstuff.service.games.impl;

import com.mindteck.booksandstuff.dao.games.DeveloperDAO;
import com.mindteck.booksandstuff.dto.Games.DeveloperDTO;
import com.mindteck.booksandstuff.enitities.games.Developer;
import com.mindteck.booksandstuff.service.games.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Philip Lozada on 8/6/2017.
 */

@Service
public class DeveloperServiceImpl implements DeveloperService{

	@Autowired
	private DeveloperDAO developerDAO;

	@Override
	public void add(DeveloperDTO developerDTO) {
		Developer developer = new Developer();
		developer.setId(developerDTO.getId());
		developer.setName(developerDTO.getName());

		developerDAO.addDeveloper(developer);

	}

	@Transactional
	@Override
	public DeveloperDTO getDeveloper(String id) {
		Developer developer = developerDAO.getDeveloper(Long.parseLong(id));
		DeveloperDTO developerDTO = new DeveloperDTO();

		developerDTO.setId(developer.getId());
		developerDTO.setName(developer.getName());

		return developerDTO;
	}

	@Transactional(readOnly = true)
	@Override
	public Map<String, String> getDevelopers() {
		List<Developer> developers = developerDAO.getDevelopers();
		Map<String, String> developerMap = new HashMap<>();
		for (Developer developer : developers) {
			developerMap.put(Long.toString(developer.getId()), developer.getName());
		}

		return developerMap;
	}
}
