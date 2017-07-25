package com.mindteck.booksandstuff.enitities.book;

import com.mindteck.booksandstuff.enitities.Item;
import com.mindteck.booksandstuff.enitities.user.Wish;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Philip Lozada on 7/25/2017.
 */

@Entity
public class Book extends Item {

	private String active;
	private String description;
	private String isbn;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Genre")
	private Genre genre;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Author")
	private Author author;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Publisher")
	private Publisher publisher;

	@OneToMany(mappedBy = "book")
	private List<Wish> wishes;

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
}
