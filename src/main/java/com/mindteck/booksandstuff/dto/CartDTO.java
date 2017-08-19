package com.mindteck.booksandstuff.dto;

import com.mindteck.booksandstuff.enitities.CartItem;

import java.util.List;

/**
 * Created by Philip Lozada on 8/18/2017.
 */
public class CartDTO {

	private String id;
	private Long grandTotal;
	private List<CartItem> cartItemList;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(Long grandTotal) {
		this.grandTotal = grandTotal;
	}

	public List<CartItem> getCartItemList() {
		return cartItemList;
	}

	public void setCartItemList(List<CartItem> cartItemList) {
		this.cartItemList = cartItemList;
	}
}
