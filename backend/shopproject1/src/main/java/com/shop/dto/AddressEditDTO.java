package com.shop.dto;

import org.springframework.stereotype.Component;

@Component
public class AddressEditDTO 
{
	private String address;
	private String city;
	private String state;
	private String country;
	private String pin;
	
	public AddressEditDTO() {
		// TODO Auto-generated constructor stub
	}

	public AddressEditDTO(String address, String city, String state, String country, String pin) {
		super();
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pin = pin;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "AddressEditDTO [address=" + address + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", pin=" + pin + "]";
	}
	
	
}
