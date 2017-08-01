package com.mindteck.booksandstuff.enitities.games;

import com.mindteck.booksandstuff.enitities.Item;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Games extends Item {

	private String active;
	private String description;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Platform")
	private Platform platform;


	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Genre")
	private GameGenre gameGenre;


	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Developer")
	private Developer developer;

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	public GameGenre getGameGenre() {
		return gameGenre;
	}

	public void setGameGenre(GameGenre gameGenre) {
		this.gameGenre = gameGenre;
	}

	public Developer getDeveloper() {
		return developer;
	}

	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}
}
