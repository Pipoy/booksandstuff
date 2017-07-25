package com.mindteck.booksandstuff.dao.item;

import com.mindteck.booksandstuff.enitities.Category;

import java.util.List;

/**
 * Created by Philip Lozada on 7/25/2017.
 */
public interface CategoryDAO {
	List<Category> getCategories();
	Category getCategory(Long id);
}
