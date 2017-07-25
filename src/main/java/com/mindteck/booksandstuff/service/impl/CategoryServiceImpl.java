package com.mindteck.booksandstuff.service.impl;

import com.mindteck.booksandstuff.dao.item.CategoryDAO;
import com.mindteck.booksandstuff.enitities.Category;
import com.mindteck.booksandstuff.service.CategoryService;
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
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDAO categoryDAO;

	@Transactional(readOnly = true)
	@Override
	public Map<String, String> getCategories() {
		List<Category> categoryList = categoryDAO.getCategories();
		Map<String, String> categoryMAp = new HashMap<>();
		for(Category category:categoryList){
			categoryMAp.put(Long.toString(category.getId()), category.getName());
			System.out.println(category.getName()+" / "+category.getId());
		};
		return categoryMAp;
	}
}

