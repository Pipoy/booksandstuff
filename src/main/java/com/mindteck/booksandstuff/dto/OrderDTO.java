package com.mindteck.booksandstuff.dto;

import com.mindteck.booksandstuff.enitities.Item;
import com.mindteck.booksandstuff.enitities.user.User;

/**
 * Created by Philip Lozada on 8/20/2017.
 */
public class OrderDTO {
	private Long id;
	private User user;
	private Item item;

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

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
}
