package com.mindteck.booksandstuff.enitities;

import com.mindteck.booksandstuff.enitities.user.User;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Philip Lozada on 8/20/2017.
 */

@Entity
@Table(name = "Orders")
public class Order {

	@Id
	@GeneratedValue
	@Column(name = "OrderID")
	private Long id;

	@ManyToOne
	private User users;


	@ManyToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<Item> item;

	private Long totalPrice;

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}
	//getters - setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}
}
