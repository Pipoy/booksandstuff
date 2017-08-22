package com.mindteck.booksandstuff.enitities;

import javax.persistence.*;

/**
 * Created by Philip Lozada on 7/25/2017.
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//product or stock unit
public class Item {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Category category;

	private String name;
	private Long price;

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

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}
}
