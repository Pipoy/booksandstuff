package com.mindteck.booksandstuff.enitities;

import com.mindteck.booksandstuff.enitities.user.User;

import javax.persistence.*;
import java.util.List;

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

	@ManyToOne(cascade = CascadeType.ALL)
	private Category category;

	private String name;
	private Long price;


//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	private List<Category> categories;
//
//	public List<Category> getCategories() {
//		return categories;
//	}
//
//	public void setCategories(List<Category> categories) {
//		this.categories = categories;
//	}

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
