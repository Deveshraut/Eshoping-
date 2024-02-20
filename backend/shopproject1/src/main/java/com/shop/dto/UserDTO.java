package com.shop.dto;

import org.springframework.stereotype.Component;

@Component
public class UserDTO {
	
	private int user_id;
	private String user_name;
	private String user_email;
	private String user_role;
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public UserDTO(int user_id, String user_name, String user_email, String user_role) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_role = user_role;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getUser_email() {
		return user_email;
	}


	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}


	public String getUser_role() {
		return user_role;
	}


	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}


	@Override
	public String toString() {
		return "UserDTO [user_id=" + user_id + ", user_name=" + user_name + ", user_email=" + user_email
				+ ", user_role=" + user_role + "]";
	}
	
	
	
	

}
