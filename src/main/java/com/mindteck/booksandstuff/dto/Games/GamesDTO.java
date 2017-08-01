package com.mindteck.booksandstuff.dto.Games;

/**
 * Created by Philip Lozada on 8/1/2017.
 */
public class GamesDTO {

	private Long id;
	private String name;
	private String price;

	private String description;
	private String active;

	private String Platform;
	private String platformName;

	private String GameGenre;
	private String gameGenreName;

	private String Category;
	private String categoryName;

	private String Developer;
	private String developerName;



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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getPlatform() {
		return Platform;
	}

	public void setPlatform(String platform) {
		Platform = platform;
	}

	public String getPlatformName() {
		return platformName;
	}

	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}

	public String getGameGenre() {
		return GameGenre;
	}

	public void setGameGenre(String gameGenre) {
		GameGenre = gameGenre;
	}

	public String getGameGenreName() {
		return gameGenreName;
	}

	public void setGameGenreName(String gameGenreName) {
		this.gameGenreName = gameGenreName;
	}

	public String getDeveloper() {
		return Developer;
	}

	public void setDeveloper(String developer) {
		Developer = developer;
	}

	public String getDeveloperName() {
		return developerName;
	}

	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
