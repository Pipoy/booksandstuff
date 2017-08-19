package com.mindteck.booksandstuff.dto;

/**
 * Created by Philip Lozada on 7/25/2017.
 */
public class WishDTO {
	private Long id;
	 private String userId;
	private String itemId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
