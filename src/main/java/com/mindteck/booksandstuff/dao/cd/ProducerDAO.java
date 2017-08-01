package com.mindteck.booksandstuff.dao.cd;

import com.mindteck.booksandstuff.enitities.cd.Producer;

import java.util.List;

/**
 * Created by Philip Lozada on 8/1/2017.
 */
public interface ProducerDAO {
	List<Producer> getProducets();

	Producer getProducer(Long id);
}
