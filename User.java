import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.criteria.Fetch;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;         
	private String userName;  
	@Pattern(regexp="^[0-9]{10}$")
	private String userPhone; 
	@Email
	private String userEmail;      
	private String userPassword;  
	private int userStatus;     
	private String userRole;
	
	@OneToMany 
	@JoinColumn(name="userId", referencedColumnName = "userId")
	private List<MyOrder> myorderList;
	
	@OneToMany 
	@JoinColumn(name="userId", referencedColumnName = "userId")
	private List<Address> addressList;
	
	@OneToMany
	@JoinColumn(name="userId", referencedColumnName = "userId")
	private List<Cart> cartList;
	
	@OneToMany
	@JoinColumn(name="userId", referencedColumnName = "userId")
	private List<Payment> paymentList;
	
public User() {
	// TODO Auto-generated constructor stub
}

public User(int userId, String userName, @Pattern(regexp = "^[0-9]{10}$") String userPhone, @Email String userEmail,
		String userPassword, int userStatus, String userRole) {
	super();
	this.userId = userId;
	this.userName = userName;
	this.userPhone = userPhone;
	this.userEmail = userEmail;
	this.userPassword = userPassword;
	this.userStatus = userStatus;
	this.userRole = userRole;
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getUserPhone() {
	return userPhone;
}

public void setUserPhone(String userPhone) {
	this.userPhone = userPhone;
}

public String getUserEmail() {
	return userEmail;
}

public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
}

public String getUserPassword() {
	return userPassword;
}

public void setUserPassword(String userPassword) {
	this.userPassword = userPassword;
}

public int getUserStatus() {
	return userStatus;
}

public void setUserStatus(int userStatus) {
	this.userStatus = userStatus;
}

public String getUserRole() {
	return userRole;
}

public void setUserRole(String userRole) {
	this.userRole = userRole;
}

public List<MyOrder> getMyorderList() {
	return myorderList;
}

public void setMyorderList(List<MyOrder> myorderList) {
	this.myorderList = myorderList;
}

public List<Address> getAddressList() {
	return addressList;
}

public void setAddressList(List<Address> addressList) {
	this.addressList = addressList;
}

public List<Cart> getCartList() {
	return cartList;
}

public void setCartList(List<Cart> cartList) {
	this.cartList = cartList;
}

public List<Payment> getPaymentList() {
	return paymentList;
}

public void setPaymentList(List<Payment> paymentList) {
	this.paymentList = paymentList;
}

@Override
public String toString() {
	return "User [userId=" + userId + ", userName=" + userName + ", userPhone=" + userPhone + ", userEmail=" + userEmail
			+ ", userPassword=" + userPassword + ", userStatus=" + userStatus + ", userRole=" + userRole
			+ "]";
}




 
}
