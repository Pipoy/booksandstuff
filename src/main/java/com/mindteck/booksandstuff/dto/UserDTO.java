package com.mindteck.booksandstuff.dto;

import com.mindteck.booksandstuff.enitities.Item;
import com.mindteck.booksandstuff.enitities.Order;
import com.mindteck.booksandstuff.enitities.user.Wish;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by Philip Lozada on 7/24/2017.
 */
public class UserDTO {
	private Long id;


	@Size(max = 20, min = 3, message = "{user.name.invalid}")
	private String name;


	@Email(message = "{user.email.invalid}")
	private String email;

	@Size(max = 12, min = 1, message = "{password.invalid}")
	private String password;

	private String Role;

	private List<Order> ordersList;

	private List<Item> orderHistory;


	private List<Wish> wishes;

	 ///////////////////////

	public List<Order> getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(List<Order> ordersList) {
		this.ordersList = ordersList;
	}

	public List<Wish> getWishes() {
		return wishes;
	}

	public void setWishes(List<Wish> wishes) {
		this.wishes = wishes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public List<Item> getOrderHistory() {
		return orderHistory;
	}

	public void setOrderHistory(List<Item> orderHistory) {
		this.orderHistory = orderHistory;
	}

	public void addItemToOH(Item item) {
		this.getOrderHistory().add(item);
	}

}


