package com.mindteck.booksandstuff.enitities;

import com.mindteck.booksandstuff.enitities.user.User;

import javax.persistence.*;

/**
 * Created by Philip Lozada on 8/20/2017.
 */

@Entity
public class Order {

	@Id
	@GeneratedValue
	@Column(name = "OID")
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	private User user;

	@ManyToOne(cascade = CascadeType.ALL)
	private Item item;


	private String someData;

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
