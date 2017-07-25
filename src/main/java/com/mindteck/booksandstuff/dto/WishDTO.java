package com.mindteck.booksandstuff.dto;

/**
 * Created by Philip Lozada on 7/25/2017.
 */
public class WishDTO {
	String userId;
	String bookId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
}
