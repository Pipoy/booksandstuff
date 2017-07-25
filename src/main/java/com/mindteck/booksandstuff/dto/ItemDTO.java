package com.mindteck.booksandstuff.dto;

/**
 * Created by Philip Lozada on 7/25/2017.
 */
public class ItemDTO {

	private Long id;
	private String Category;
	private String name;
	private String price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}
