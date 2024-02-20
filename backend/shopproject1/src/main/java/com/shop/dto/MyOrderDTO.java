package com.shop.dto;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class MyOrderDTO {
	
	
	private String prod_title;
	//private byte[] photo;
	private int  rating;
	private String comment;
	private float prod_price;
	private int user_id;
	private float total_price;
	private String  orderDate;
	private int orderdetails_id;
	private int myorder_id;
	private int product_id;
	private int quantity;
	private int  seller_id;
	private String status;
	private int add_id;

	public void setAdd_id(int add_id) {
		this.add_id = add_id;
	}

	public MyOrderDTO() {
		// TODO Auto-generated constructor stub
	}

//	public MyOrderDTO(String prod_title, byte[] photo, int rating, String comment, float prod_price, int user_id,
//			float total_price, String order_date, int orderdetails_id, int myorder_id, int product_id, int quantity,
//			int seller_id, String status) {
//		super();
//		this.prod_title = prod_title;
//
//		this.rating = rating;
//		this.comment = comment;
//		this.prod_price = prod_price;
//		this.user_id = user_id;
//		this.total_price = total_price;
//		this.orderDate = order_date;
//		this.orderdetails_id = orderdetails_id;
//		this.myorder_id = myorder_id;
//		this.product_id = product_id;
//		this.quantity = quantity;
//		this.seller_id = seller_id;
//		this.status = status;
//	}

	public int getAdd_id() {
		return add_id;
	}

	public String getProd_title() {
		return prod_title;
	}

	public void setProd_title(String prod_title) {
		this.prod_title = prod_title;
	}





	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public float getProd_price() {
		return prod_price;
	}

	public void setProd_price(float prod_price) {
		this.prod_price = prod_price;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public float getTotal_price() {
		return total_price;
	}

	public void setTotal_price(float total_price) {
		this.total_price = total_price;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderdetails_id() {
		return orderdetails_id;
	}

	public void setOrderdetails_id(int orderdetails_id) {
		this.orderdetails_id = orderdetails_id;
	}

	public int getMyorder_id() {
		return myorder_id;
	}

	public void setMyorder_id(int myorder_id) {
		this.myorder_id = myorder_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "MyOrderDTO{" +
				"prod_title='" + prod_title + '\'' +
				", rating=" + rating +
				", comment='" + comment + '\'' +
				", prod_price=" + prod_price +
				", user_id=" + user_id +
				", total_price=" + total_price +
				", orderDate='" + orderDate + '\'' +
				", orderdetails_id=" + orderdetails_id +
				", myorder_id=" + myorder_id +
				", product_id=" + product_id +
				", quantity=" + quantity +
				", seller_id=" + seller_id +
				", status='" + status + '\'' +
				", add_id=" + add_id +
				'}';
	}
}
