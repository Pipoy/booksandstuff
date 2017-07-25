package com.mindteck.booksandstuff.enitities.book;

import com.mindteck.booksandstuff.enitities.Item;

import javax.persistence.Entity;

/**
 * Created by Philip Lozada on 7/25/2017.
 */

@Entity
public class Book extends Item {

	private String active;
	private String description;
	private String isbn;
}
