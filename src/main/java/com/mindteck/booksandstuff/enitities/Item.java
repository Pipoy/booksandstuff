package com.mindteck.booksandstuff.enitities;

import javax.persistence.*;

/**
 * Created by Philip Lozada on 7/25/2017.
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Item {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	private Category category;
	private String name;
	private double price;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
