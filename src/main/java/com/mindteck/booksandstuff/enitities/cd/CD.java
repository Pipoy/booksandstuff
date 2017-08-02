package com.mindteck.booksandstuff.enitities.cd;

import com.mindteck.booksandstuff.enitities.Item;
import com.mindteck.booksandstuff.enitities.user.Wish;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Philip Lozada on 7/25/2017.
 */

@Entity
public class CD extends Item {

	private String active;
	private String description;


	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Genre")
	private MusicGenre musicGenre;


	@ManyToOne
	@JoinColumn(name = "Artist")
	private Artist artist;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Producer")
	private Producer producer;


	@Transient
	private MultipartFile productImage;

	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

	@OneToMany(mappedBy = "cd")
	private List<Wish> wish;

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



	public MusicGenre getMusicGenre() {
		return musicGenre;
	}

	public void setMusicGenre(MusicGenre musicGenre) {
		this.musicGenre = musicGenre;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	public List<Wish> getWish() {
		return wish;
	}

	public void setWish(List<Wish> wish) {
		this.wish = wish;
	}
}
