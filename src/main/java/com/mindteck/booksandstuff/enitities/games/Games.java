package com.mindteck.booksandstuff.enitities.games;

import com.mindteck.booksandstuff.enitities.Item;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;


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

	@Transient
	private MultipartFile productImage;

	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

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
