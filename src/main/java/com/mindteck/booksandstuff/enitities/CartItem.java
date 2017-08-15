package com.mindteck.booksandstuff.enitities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Philip Lozada on 8/14/2017.
 */

@Entity
public class CartItem{

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	private Item item;

	private int quantity;
	private Long totalPrice;

	public CartItem(){}

	public CartItem(Item item, int quantity, Long totalPrice){

		this.item = item;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}

	public void updateTotalPrice(){
		totalPrice = this.item.getPrice() * this.quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}
}
