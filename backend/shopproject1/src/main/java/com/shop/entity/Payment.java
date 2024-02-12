package backend.shopproject1.src.main.java.com.shop.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name = "payment")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int payId;  
	@NotEmpty
	private int userId;  
	private float payAmount;
	@NotEmpty
	private int myorderId;
	private String payDate;
	private int payType;
	
//	  @ManyToOne 
//	  @JoinColumn(name ="user_id")
//	  private User user;
//	  
//	  @ManyToOne 
//	  @JoinColumn(name ="myorderId")
//	  private MyOrder myOrder;

	public Payment() {
		// TODO Auto-generated constructor stub
	}

public Payment(int payId, @NotEmpty int userId, float payAmount, @NotEmpty int myorderId, String payDate, int payType) {
	super();
	this.payId = payId;
	this.userId = userId;
	this.payAmount = payAmount;
	this.myorderId = myorderId;
	this.payDate = payDate;
	this.payType = payType;
}

public int getPayId() {
	return payId;
}

public void setPayId(int payId) {
	this.payId = payId;
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public float getPayAmount() {
	return payAmount;
}

public void setPayAmount(float payAmount) {
	this.payAmount = payAmount;
}

public int getMyorderId() {
	return myorderId;
}

public void setMyorderId(int myorderId) {
	this.myorderId = myorderId;
}

public String getPayDate() {
	return payDate;
}

public void setPayDate(String payDate) {
	this.payDate = payDate;
}

public int getPayType() {
	return payType;
}

public void setPayType(int payType) {
	this.payType = payType;
}

@Override
public String toString() {
	return "Payment [payId=" + payId + ", userId=" + userId + ", payAmount=" + payAmount + ", myorderId=" + myorderId
			+ ", payDate=" + payDate + ", payType=" + payType + "]";
}


}
