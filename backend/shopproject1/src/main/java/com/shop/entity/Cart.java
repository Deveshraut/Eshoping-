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
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int cartId;  
	@NotEmpty
	 private int userId; 
	@NotEmpty
	 private int prodId;      
	 private int cartQuantity;
	 
//	 @ManyToOne 
//	 @JoinColumn(name ="userId")
//	 private User user;
	 
	 @ManyToOne 
	 @JoinColumn(name ="prodId", referencedColumnName = "prodId", insertable = false,updatable = false)
	 private Product product;
 
	 

	 public Cart() {
		// TODO Auto-generated constructor stub
	}

public Cart(int cartId, @NotEmpty int userId, @NotEmpty int prodId, int cartQuantity) {
	super();
	this.cartId = cartId;
	this.userId = userId;
	this.prodId = prodId;
	this.cartQuantity = cartQuantity;
}


public Product getProduct() {
	return product;
}

public void setProduct(Product product) {
	this.product = product;
}

public int getCartId() {
	return cartId;
}

public void setCartId(int cartId) {
	this.cartId = cartId;
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public int getProdId() {
	return prodId;
}

public void setProdId(int prodId) {
	this.prodId = prodId;
}

public int getCartQuantity() {
	return cartQuantity;
}

public void setCartQuantity(int cartQuantity) {
	this.cartQuantity = cartQuantity;
}

@Override
public String toString() {
	return "Cart [cartId=" + cartId + ", userId=" + userId + ", prodId=" + prodId + ", cartQuantity=" + cartQuantity
			+ "]";
}
	 
	 

}
