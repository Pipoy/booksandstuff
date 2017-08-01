package com.mindteck.booksandstuff.dao.book.impl;

import com.mindteck.booksandstuff.dao.book.BookDAO;
import com.mindteck.booksandstuff.enitities.book.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Philip Lozada on 7/25/2017.
 */
@Repository
public class BookDAOImpl implements BookDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Book book) {
		if(book.getId() != null){
			sessionFactory.getCurrentSession().saveOrUpdate(book);
		}else {
			sessionFactory.getCurrentSession().merge(book);
		}
	}

	@Override
	public List<Book> getBooks() {
		@SuppressWarnings("unchecked")
		TypedQuery<Book> query = sessionFactory.getCurrentSession().createQuery("from Book where active=:active");
		query.setParameter("active", "YES");
		return query.getResultList();
	}

	@Override
	public Book getBook(Long id) {
		@SuppressWarnings("unchecked")
		TypedQuery<Book> query = sessionFactory.getCurrentSession().createQuery("from Book where id=:id");
		query.setParameter("id", id);
		Book book = query.getSingleResult();
		System.out.println("inside getBookDAO");
		return book;
	}
}
