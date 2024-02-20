package com.shop.dto;

import org.springframework.stereotype.Component;

@Component
public class OrderDetailsCommentDTO 
{
	private String user_name;
	private double rating;
	private String comment;
	private int product_id;
	private String orderDate;
	
	public OrderDetailsCommentDTO() {
		// TODO Auto-generated constructor stub
	}

	
	public OrderDetailsCommentDTO(String user_name, double rating, String comment, int product_id, String orderDate) {
		super();
		this.user_name = user_name;
		this.rating = rating;
		this.comment = comment;
		this.product_id = product_id;
		this.orderDate = orderDate;
	}


	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "OrderDetailsCommentDTO [user_name=" + user_name + ", rating=" + rating + ", comment=" + comment
				+ ", product_id=" + product_id + ", orderDate=" + orderDate + "]";
	}
	
	
	
}
