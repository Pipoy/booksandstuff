package com.mindteck.booksandstuff.service.cd.impl;

import com.mindteck.booksandstuff.dao.cd.ProducerDAO;
import com.mindteck.booksandstuff.enitities.cd.Producer;
import com.mindteck.booksandstuff.service.cd.ProducerService;
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
public class ProducerServiceImpl implements ProducerService {

	@Autowired
	private ProducerDAO producerDAO;

	@Transactional
	@Override
	public Map<String, String> getProducers() {
		List<Producer> producers = producerDAO.getProducets();
		Map<String, String> producerMap = new HashMap<>();
		for (Producer p : producers) {
			producerMap.put(Long.toString(p.getId()), p.getName());
		}

		return producerMap;
	}
}
