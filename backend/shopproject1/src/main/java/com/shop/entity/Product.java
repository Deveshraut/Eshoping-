package com.shop.entity;

import java.util.Arrays;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
@Entity
@Table(name= "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int prodId;
	  private String prodTitle;
	  private String prodDescription;
	  private float prodPrice;
	  @NotEmpty
	  private Integer catId;

	  private Integer compId;
	  private int prodQty;
	  private int sellerId;
	  @Lob
	  @Column(name = "photo", columnDefinition="BLOB")
	  private byte[] photo;
	  

	  	@OneToMany
		@JoinColumn(name="productId", referencedColumnName = "prodId")
		private List<OrderDetail> orderDetailList;

	  	@OneToMany
		@JoinColumn(name="prodId", referencedColumnName = "prodId")
		private List<Cart> cartList;

	  
	  public Product() {
		  
	  }

	public Product(int prodId, String prodTitle, String prodDescription, float prodPrice, @NotEmpty int catId,
			@NotEmpty int compId, int prodQty, int sellerId, byte[] photo) {
		super();
		this.prodId = prodId;
		this.prodTitle = prodTitle;
		this.prodDescription = prodDescription;
		this.prodPrice = prodPrice;
		this.catId = catId;
		this.compId = compId;
		this.prodQty = prodQty;
		this.sellerId = sellerId;
		this.photo = photo;
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public String getProdTitle() {
		return prodTitle;
	}

	public void setProdTitle(String prodTitle) {
		this.prodTitle = prodTitle;
	}

	public String getProdDescription() {
		return prodDescription;
	}

	public void setProdDescription(String prodDescription) {
		this.prodDescription = prodDescription;
	}

	public float getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(float prodPrice) {
		this.prodPrice = prodPrice;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(int compId) {
		this.compId = compId;
	}

	public int getProdQty() {
		return prodQty;
	}

	public void setProdQty(int prodQty) {
		this.prodQty = prodQty;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public List<OrderDetail> getOrderDetailList() {
		return orderDetailList;
	}

	public void setOrderDetailList(List<OrderDetail> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}

	public List<Cart> getCartList() {
		return cartList;
	}

	public void setCartList(List<Cart> cartList) {
		this.cartList = cartList;
	}

	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodTitle=" + prodTitle + ", prodDescription=" + prodDescription
				+ ", prodPrice=" + prodPrice + ", catId=" + catId + ", compId=" + compId + ", prodQty=" + prodQty
				+ ", sellerId=" + sellerId + ", photo=" + Arrays.toString(photo) + ", orderDetailList="
				+ orderDetailList + ", cartList=" + cartList + "]";
	}
	  

}