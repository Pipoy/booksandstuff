package com.mindteck.booksandstuff.service.games.impl;

import com.mindteck.booksandstuff.dao.games.PlatformDAO;
import com.mindteck.booksandstuff.enitities.games.Platform;
import com.mindteck.booksandstuff.service.games.PlatformService;
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
public class PlatformServiceImpl implements PlatformService {

	@Autowired
	private PlatformDAO platformDAO;

	@Transactional(readOnly = true)
	@Override
	public Map<String, String> getPlatforms() {
		List<Platform> platforms = platformDAO.getPlatforms();
		Map<String, String> platformMap = new HashMap<>();
		for (Platform p : platforms) {
			platformMap.put(Long.toString(p.getId()), p.getName());
		}

		return platformMap;
	}
}
