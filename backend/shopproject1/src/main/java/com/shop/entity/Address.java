package backend.shopproject1.src.main.java.com.shop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Comparator;

@Entity
@Table(name = "address" )
public class Address
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addId;
	private int userId;
	private String address;
	private String city;
	private String state;
	private String country;
	private String pin;
	
	@ManyToOne
	 @JoinColumn(name ="userId",referencedColumnName = "userId", insertable = false, updatable = false)
	 private User user;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(int addId, int userId, String address, String city, String state, String country, String pin) {
		super();
		this.addId = addId;
		this.userId = userId;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pin = pin;
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getAddId() {
		return addId;
	}

	public void setAddId(int addId) {
		this.addId = addId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "Address [addId=" + addId + ", userId=" + userId + ", address=" + address + ", city=" + city + ", state="
				+ state + ", country=" + country + ", pin=" + pin + "]";
	}
	
	
	
}
