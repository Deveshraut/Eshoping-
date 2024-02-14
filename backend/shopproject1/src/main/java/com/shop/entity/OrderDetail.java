package backend.shopproject1.src.main.java.com.shop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "orderdetails")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderdetailsId;
	@NotEmpty
	private int myorderId;
	@NotEmpty
	private int productId;
	private float price;
	private int quantity;
	private int rating;
	private String comment;
	
	 
	 @ManyToOne
	 @JoinColumn(name ="myorderId",referencedColumnName = "myorderId", insertable = false, updatable = false)
	 private MyOrder myOrder;
	 
	 @ManyToOne
	 @JoinColumn(name ="productId",referencedColumnName = "prodId", insertable = false, updatable = false)
	 private Product product;
	
	
	
	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}


public OrderDetail(int orderdetailsId, @NotEmpty int myorderId, @NotEmpty int productId, float price, int quantity,
		int rating, String comment) {
	super();
	this.orderdetailsId = orderdetailsId;
	this.myorderId = myorderId;
	this.productId = productId;
	this.price = price;
	this.quantity = quantity;
	this.rating = rating;
	this.comment = comment;
}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public MyOrder getMyOrder() {
	return myOrder;
}


public void setMyOrder(MyOrder myOrder) {
	this.myOrder = myOrder;
}


public int getOrderdetailsId() {
	return orderdetailsId;
}


public void setOrderdetailsId(int orderdetailsId) {
	this.orderdetailsId = orderdetailsId;
}


public int getMyorderId() {
	return myorderId;
}


public void setMyorderId(int myorderId) {
	this.myorderId = myorderId;
}


public int getProductId() {
	return productId;
}


public void setProductId(int productId) {
	this.productId = productId;
}


public float getPrice() {
	return price;
}


public void setPrice(float price) {
	this.price = price;
}


public int getQuantity() {
	return quantity;
}


public void setQuantity(int quantity) {
	this.quantity = quantity;
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


@Override
public String toString() {
	return "OrderDetail [orderdetailsId=" + orderdetailsId + ", myorderId=" + myorderId + ", productId=" + productId
			+ ", price=" + price + ", quantity=" + quantity + ", rating=" + rating + ", comment=" + comment + "]";
}

	
	
	
}
