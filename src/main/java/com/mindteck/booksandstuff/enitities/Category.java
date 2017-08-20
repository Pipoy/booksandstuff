package com.mindteck.booksandstuff.enitities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Philip Lozada on 7/25/2017.
 */

@Entity
public class Category {

	@Id
	@GeneratedValue
	private Long id;
	private String name;

	@OneToMany(mappedBy = "category")
	private List<Item> item;



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

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}
}
