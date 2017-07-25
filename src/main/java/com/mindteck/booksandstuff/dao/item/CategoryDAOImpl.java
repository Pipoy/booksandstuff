package com.mindteck.booksandstuff.dao.item;

import com.mindteck.booksandstuff.enitities.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Philip Lozada on 7/25/2017.
 */
@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public List<Category> getCategories() {
		@SuppressWarnings("unchecked")
		TypedQuery<Category> query = sessionFactory.getCurrentSession().createQuery("from Category ");
		return query.getResultList();
	}

	@Override
	public Category getCategory(Long id) {
		@SuppressWarnings("unchecked")
		TypedQuery<Category> query = sessionFactory.getCurrentSession().createQuery("from Category where id=:cid ");
		query.setParameter("cid", id);
		Category category = query.getSingleResult();
		return category;
	}
}
