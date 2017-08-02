package com.mindteck.booksandstuff.dto.CD;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Philip Lozada on 8/1/2017.
 */
public class CDDTO {

	private Long id;
	private String name;
	private String price;
	private String description;
	private String active;

	private String Artist;
	private String artistName;

	private String Producer;
	private String producerName;

	private String MusicGenre;
	private String musicGenreName;

	private String Category;
	private String categoryName;

	private MultipartFile productImage;

	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

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

	public String getArtist() {
		return Artist;
	}

	public void setArtist(String artist) {
		Artist = artist;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getProducer() {
		return Producer;
	}

	public void setProducer(String producer) {
		Producer = producer;
	}

	public String getProducerName() {
		return producerName;
	}

	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}

	public String getMusicGenre() {
		return MusicGenre;
	}

	public void setMusicGenre(String musicGenre) {
		MusicGenre = musicGenre;
	}

	public String getMusicGenreName() {
		return musicGenreName;
	}

	public void setMusicGenreName(String musicGenreName) {
		this.musicGenreName = musicGenreName;
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
