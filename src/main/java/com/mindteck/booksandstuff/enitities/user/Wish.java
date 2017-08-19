package com.mindteck.booksandstuff.enitities.user;

import com.mindteck.booksandstuff.enitities.Item;
import com.mindteck.booksandstuff.enitities.book.Book;
import com.mindteck.booksandstuff.enitities.cd.CD;
import com.mindteck.booksandstuff.enitities.games.Games;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Philip Lozada on 7/24/2017.
 */

@Entity
public class Wish {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="userId")
	private User user;

//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="bookId")
//	private Book book;
//
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="cdId")
//	private CD cd;
//
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="gameId")
//	private Games games;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="itemId")
	private Item item;




	private Date wishAdded;
	private String status;
	private Date wishRemoved;



	@ManyToOne(cascade = CascadeType.ALL)
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

//		public Games getGames() {
//		return games;
//	}
//
//	public void setGames(Games games) {
//		this.games = games;
//	}
//
//	public CD getCd() {
//		return cd;
//	}
//
//	public void setCd(CD cd) {
//		this.cd = cd;
//	}
//
//	public Book getBook() {
//		return book;
//	}
//
//	public void setBook(Book book) {
//		this.book = book;
//	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public Date getWishAdded() {
		return wishAdded;
	}

	public void setWishAdded(Date wishAdded) {
		this.wishAdded = wishAdded;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getWishRemoved() {
		return wishRemoved;
	}

	public void setWishRemoved(Date wishRemoved) {
		this.wishRemoved = wishRemoved;
	}
}
