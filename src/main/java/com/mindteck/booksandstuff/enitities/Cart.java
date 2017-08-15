package com.mindteck.booksandstuff.enitities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Philip Lozada on 8/14/2017.
 */

@Entity
public class Cart {

	@Id
	@GeneratedValue
	private Long id;

	private Long grandTotal;

	@OneToMany
	private Map<Long, CartItem> cartItems;

	//public Cart(){}

	public Cart() {
		cartItems = new HashMap<>();
		grandTotal=0L;
	}

	public Cart(Long cartId) {
		this();
		this.id = cartId;
	}

	public void addCartItem(CartItem item) {
		Long productId = item.getItem().getId();

		if(cartItems.containsKey(productId)){
			CartItem existingItem = cartItems.get(productId);
		}
	}



	//getters - setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(Long grandTotal) {
		this.grandTotal = grandTotal;
	}

	public Map<Long, CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Map<Long, CartItem> cartItems) {
		this.cartItems = cartItems;
	}
}
