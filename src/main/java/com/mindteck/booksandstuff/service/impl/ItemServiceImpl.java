package com.mindteck.booksandstuff.service.impl;

import com.mindteck.booksandstuff.dao.item.ItemDAO;
import com.mindteck.booksandstuff.enitities.Item;
import com.mindteck.booksandstuff.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Philip Lozada on 7/25/2017.
 */

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemDAO itemDAO;

	@Transactional(readOnly = true)
	@Override
	public List<Item> getAllItems() {
		return itemDAO.getItems();
	}

	@Transactional
	@Override
	public List<Item> getByCategory(Long id) {
		List<Item> items = itemDAO.getItemsByCategory(id);

		return items;
	}

	@Transactional
	@Override
	public Item getProductById(Long id) {
		return itemDAO.getItem(id);
	}
}
