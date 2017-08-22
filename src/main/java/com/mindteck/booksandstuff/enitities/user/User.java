package com.mindteck.booksandstuff.enitities.user;

import com.mindteck.booksandstuff.enitities.Item;
import com.mindteck.booksandstuff.enitities.Order;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

/**
 * Created by Philip Lozada on 7/24/2017.
 */
@Entity
public class User {
	@Id
	@GeneratedValue
	@Column(name = "UID")
	private Long id;

	@Column(name = "NAME")
	@Size(max = 20, min = 3, message = "{user.name.invalid}")
	private String name;

	@Column(name = "EMAIL", unique = true)
//	@Email(message = "{user.email.invalid}")
	private String email;

	private String password;



	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="roleId")
	private Role role;

	@OneToMany(mappedBy = "user")
	private List<Order> orders;



	@ManyToMany(fetch = FetchType.EAGER)
	private List<Item> orderHistory;



	@OneToMany(mappedBy = "user")
	private List<Wish> userWishList;




	//getters setters


	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Wish> getUserWishList() {
		return userWishList;
	}

	public void setUserWishList(List<Wish> userWishList) {
		this.userWishList = userWishList;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Item> getOrderHistory() {
		return orderHistory;
	}

	public void setOrderHistory(List<Item> orderHistory) {
		this.orderHistory = orderHistory;
	}

}
