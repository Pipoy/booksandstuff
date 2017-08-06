package com.mindteck.booksandstuff.dto.Games;

/**
 * Created by Philip Lozada on 8/6/2017.
 */
public class DeveloperDTO {
	private Long id;
	private String name;

	public String getName(){
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {

		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
