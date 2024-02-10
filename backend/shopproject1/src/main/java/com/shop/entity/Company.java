package backend.shopproject1.src.main.java.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int compId;
	private String compTitle;
	private String compDescription;
	
	@OneToMany
	@JoinColumn(name="compId", referencedColumnName = "compId")
	private List<Product> productList;
	
	
	public Company() 
	{
		// TODO Auto-generated constructor stub
	}


	public Company(int compId, String compTitle, String compDescription) {
		super();
		this.compId = compId;
		this.compTitle = compTitle;
		this.compDescription = compDescription;
	}


	public int getCompId() {
		return compId;
	}


	public void setCompId(int compId) {
		this.compId = compId;
	}


	public String getCompTitle() {
		return compTitle;
	}


	public void setCompTitle(String compTitle) {
		this.compTitle = compTitle;
	}




	public String getCompDescription() {
		return compDescription;
	}


	public void setCompDescription(String compDescription) {
		this.compDescription = compDescription;
	}


	public List<Product> getProductList() {
		return productList;
	}


	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}


	@Override
	public String toString() {
		return "Company [compId=" + compId + ", compTitle=" + compTitle + ", compDescription=" + compDescription
				+ ", productList=" + productList + "]";
	}
	
	
	
}
