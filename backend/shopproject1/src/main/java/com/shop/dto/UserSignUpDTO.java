package com.shop.dto;

import org.springframework.stereotype.Component;

@Component
public class UserSignUpDTO 
{
	private String email;
	private String name;
	private String password;
	private String phone;
	
	public UserSignUpDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserSignUpDTO(String email, String name, String password, String phone) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.phone = phone;
	}

	 
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "UserSignUpDTO [email=" + email + ", name=" + name + ", password=" + password + ", phone=" + phone + "]";
	}
	
	
	
}
