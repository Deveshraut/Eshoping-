package com.shop.dto;

import org.springframework.stereotype.Component;

@Component
public class UserEditDTO 
{
	private int id;
	private String name;
	private String phone;
	private String password;
	
	public UserEditDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public UserEditDTO(int id, String name, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserEditDTO [id=" + id + ", name=" + name + ", phone=" + phone + ", password=" + password + "]";
	}
	

}
