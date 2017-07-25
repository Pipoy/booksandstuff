package com.mindteck.booksandstuff.service.book.impl;

import com.mindteck.booksandstuff.dao.book.PublisherDAO;
import com.mindteck.booksandstuff.enitities.book.Publisher;
import com.mindteck.booksandstuff.service.book.PublisherService;
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
public class PublisherServiceImpl implements PublisherService {

	@Autowired
	private PublisherDAO publisherDAO;


	@Transactional
	@Override
	public Map<String, String> getPublishers() {
		List<Publisher> publishers = publisherDAO.getPublishers();
		Map<String, String> publisherMap = new HashMap<>();
		for(Publisher p : publishers) {
			publisherMap.put(Long.toString(p.getId()), p.getName());
		}
		return publisherMap;
	}
}
