package com.shop.dto;

import org.springframework.stereotype.Component;

@Component
public class AddressDTO 
{
	private int add_id;
	private int user_id;
	private String address;
	private String city;
	private String state;
	private String country;
	private String pin;
	
	public AddressDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public AddressDTO(int add_id, int user_id) {
		super();
		this.add_id = add_id;
		this.user_id = user_id;
	}



	public AddressDTO(int add_id, int user_id, String address, String city, String state, String country, String pin) {
		super();
		this.add_id = add_id;
		this.user_id = user_id;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pin = pin;
	}

	public int getAdd_id() {
		return add_id;
	}

	public void setAdd_id(int add_id) {
		this.add_id = add_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
		return "AddressDTO [add_id=" + add_id + ", user_id=" + user_id + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", pin=" + pin + "]";
	}
	
	

}
