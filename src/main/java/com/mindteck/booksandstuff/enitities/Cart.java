package com.mindteck.booksandstuff.enitities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Philip Lozada on 8/14/2017.
 */

@Entity
public class Cart {

	@Id
	@GeneratedValue
	private String id;

	private Long grandTotal;

	@OneToMany
	private List<CartItem> cartItems;

	//public Cart(){}

	public Cart() {
		cartItems = new ArrayList<>();
		grandTotal=0L;
	}

	public Cart(String cartId) {
		this();
		this.id = cartId;
	}

	public void addCartItem(CartItem item) {
		Long productId = item.getItem().getId();

//		if(cartItems.containsKey(productId)){
//			CartItem existingItem = cartItems.get(productId);
//		}

		for (CartItem ci : cartItems) {
			if (ci.getItem().getId().equals(productId)) {
				ci.setQuantity(ci.getQuantity() + 1);
				ci.setTotalPrice(ci.getTotalPrice() * ci.getQuantity());
			}else{
				cartItems.add(item);
			}
		}

		updateGrandTotal();
	}

	public void updateGrandTotal() {
		grandTotal =0L;
		for (CartItem ci : cartItems) {
			grandTotal += ci.getTotalPrice();
		}
	}

	public void removeCartItem(CartItem item) {
		Long productId = item.getItem().getId();

		for (CartItem ci : cartItems) {
			if(ci.getItem().getId().equals(item.getItem().getId())){
				cartItems.remove(ci);
			}
		}
		updateGrandTotal();
	}


	public int cartItemSize() {
		return cartItems.size();
	}

	//getters - setters


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

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
}
