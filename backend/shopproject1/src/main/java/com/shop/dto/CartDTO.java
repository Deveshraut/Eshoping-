package com.shop.dto;

import org.springframework.stereotype.Component;

@Component
public class CartDTO 
{
	private int cart_id;
	private int user_id;
	private int prod_id;
	private int cart_quantity;
	private String prod_title;
	private float prod_price;
	private int prod_qty;
	
	public CartDTO() {
		// TODO Auto-generated constructor stub
	}

	public CartDTO(int cart_id, int user_id, int prod_id, int cart_quantity, String prod_title, float prod_price,
			int prod_qty) {
		super();
		this.cart_id = cart_id;
		this.user_id = user_id;
		this.prod_id = prod_id;
		this.cart_quantity = cart_quantity;
		this.prod_title = prod_title;
		this.prod_price = prod_price;
		this.prod_qty = prod_qty;
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getProd_id() {
		return prod_id;
	}

	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}

	public int getCart_quantity() {
		return cart_quantity;
	}

	public void setCart_quantity(int cart_quantity) {
		this.cart_quantity = cart_quantity;
	}

	public String getProd_title() {
		return prod_title;
	}

	public void setProd_title(String prod_title) {
		this.prod_title = prod_title;
	}

	public float getProd_price() {
		return prod_price;
	}

	public void setProd_price(float prod_price) {
		this.prod_price = prod_price;
	}

	public int getProd_qty() {
		return prod_qty;
	}

	public void setProd_qty(int prod_qty) {
		this.prod_qty = prod_qty;
	}

	@Override
	public String toString() {
		return "CartDTO [cart_id=" + cart_id + ", user_id=" + user_id + ", prod_id=" + prod_id + ", cart_quantity="
				+ cart_quantity + ", prod_title=" + prod_title + ", prod_price=" + prod_price + ", prod_qty=" + prod_qty
				+ "]";
	}
	
	
}
