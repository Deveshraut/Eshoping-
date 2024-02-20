package com.shop.dto;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class ProductSaveDTO 
{
	
	private String prod_title;
	private String prod_description;
	private float prod_price;
	private int cat_id;
	private int comp_id;
	private int prod_qty;
	private int seller_id;
	
	
	public ProductSaveDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductSaveDTO( String prod_title, String prod_description, float prod_price, int cat_id,
			int comp_id, int prod_qty, int seller_id) {
		super();
		
		this.prod_title = prod_title;
		this.prod_description = prod_description;
		this.prod_price = prod_price;
		this.cat_id = cat_id;
		this.comp_id = comp_id;
		this.prod_qty = prod_qty;
		this.seller_id = seller_id;
		
	}

	

	public String getProd_title() {
		return prod_title;
	}

	public void setProd_title(String prod_title) {
		this.prod_title = prod_title;
	}

	public String getProd_description() {
		return prod_description;
	}

	public void setProd_description(String prod_description) {
		this.prod_description = prod_description;
	}

	public float getProd_price() {
		return prod_price;
	}

	public void setProd_price(float prod_price) {
		this.prod_price = prod_price;
	}

	public int getCat_id() {
		return cat_id;
	}

	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}

	public int getComp_id() {
		return comp_id;
	}

	public void setComp_id(int comp_id) {
		this.comp_id = comp_id;
	}

	public int getProd_qty() {
		return prod_qty;
	}

	public void setProd_qty(int prod_qty) {
		this.prod_qty = prod_qty;
	}

	public int getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}

	@Override
	public String toString() {
		return "ProductSaveDTO [prod_title=" + prod_title + ", prod_description=" + prod_description + ", prod_price="
				+ prod_price + ", cat_id=" + cat_id + ", comp_id=" + comp_id + ", prod_qty=" + prod_qty + ", seller_id="
				+ seller_id + "]";
	}



	
	


	
}
