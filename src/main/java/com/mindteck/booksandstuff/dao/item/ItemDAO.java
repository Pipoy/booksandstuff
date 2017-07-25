package com.mindteck.booksandstuff.dao.item;

import com.mindteck.booksandstuff.enitities.Item;

import java.util.List;

/**
 * Created by Philip Lozada on 7/25/2017.
 */


public interface ItemDAO {
	List<Item> getItems();
	Item getItem(Long itemId);
}
