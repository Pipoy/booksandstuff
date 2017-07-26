package com.mindteck.booksandstuff.service;

import com.mindteck.booksandstuff.enitities.Item;

import java.util.List;

/**
 * Created by Philip Lozada on 7/25/2017.
 */
public interface ItemService {
	List<Item> getAllItems();

	List<Item> getByCategory(Long id);

	Item getProductById(Long id);

}
