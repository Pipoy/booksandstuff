package com.mindteck.booksandstuff.enitities.games;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Philip Lozada on 8/1/2017.
 */
@Entity
public class GameGenre {

	@Id
	@GeneratedValue
	@Column(name = "GameGenre_ID")
	private Long id;
	private String name;

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
}
