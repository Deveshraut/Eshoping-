package backend.shopproject1.src.main.java.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
@Entity
@Table(name = "myorder")
public class MyOrder {
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Id
	 private int myorderId; 
	 @NotEmpty
	 private int userId; 
	 private String orderDate;    
	 private int status;     
	 private float totalPrice;
	 private int addId;
	
	
	 @ManyToOne
	 @JoinColumn(name ="userId",referencedColumnName = "userId", insertable = false,updatable = false)
	 private User user;
	 
	 @OneToMany
	 @JoinColumn(name="userId", referencedColumnName = "myorderId")
	 private List<Payment> paymentList;
	 
	
	 @OneToMany
	 @JoinColumn(name="myorderId", referencedColumnName = "myorderId")
	private List<OrderDetail> orderDetailList;
	
	
	 
	 public MyOrder() {
		// TODO Auto-generated constructor stub
	}



	public MyOrder(int myorderId, @NotEmpty int userId, String orderDate, int status, float totalPrice) {
		super();
		this.myorderId = myorderId;
		this.userId = userId;
		this.orderDate = orderDate;
		this.status = status;
		this.totalPrice = totalPrice;
	}

	

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}



	public int getMyorderId() {
		return myorderId;
	}



	public void setMyorderId(int myorderId) {
		this.myorderId = myorderId;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getOrderDate() {
		return orderDate;
	}



	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}



	public float getTotalPrice() {
		return totalPrice;
	}



	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}



	public List<Payment> getPaymentList() {
		return paymentList;
	}



	public void setPaymentList(List<Payment> paymentList) {
		this.paymentList = paymentList;
	}



	public List<OrderDetail> getOrderDetailList() {
		return orderDetailList;
	}



	public void setOrderDetailList(List<OrderDetail> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}



	public int getAddId() {
		return addId;
	}



	public void setAddId(int addId) {
		this.addId = addId;
	}



	@Override
	public String toString() {
		return "MyOrder [myorderId=" + myorderId + ", userId=" + userId + ", orderDate=" + orderDate + ", status="
				+ status + ", totalPrice=" + totalPrice + ", paymentList=" + paymentList + ", orderDetailList="
				+ orderDetailList + "]";
	}



}
