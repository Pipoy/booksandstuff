package com.mindteck.booksandstuff.dao.book;

import com.mindteck.booksandstuff.enitities.book.Publisher;

import java.util.List;

/**
 * Created by Philip Lozada on 7/25/2017.
 */
public interface PublisherDAO {
	List<Publisher> getPublishers();
	Publisher getPublisher(Long id);
}
