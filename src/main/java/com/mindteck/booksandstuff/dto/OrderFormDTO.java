package com.mindteck.booksandstuff.dto;

/**
 * Created by Philip Lozada on 8/20/2017.
 */
public class OrderFormDTO {

	private String City;
	private String Street;
	private String State;

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}
}
