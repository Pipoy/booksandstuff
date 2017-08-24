package com.mindteck.booksandstuff.dto;

import com.mindteck.booksandstuff.enitities.Item;
import com.mindteck.booksandstuff.enitities.user.User;

import java.util.List;

/**
 * Created by Philip Lozada on 8/24/2017.
 */
public class OrderHistoryDTO {

	private Long id;
	private User user;
	private Item orderItems;

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

	public Item getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Item orderItems) {
		this.orderItems = orderItems;
	}
}
