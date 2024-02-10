package backend.shopproject1.src.main.java.com.shop.entity;

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

@Entity
@Table(name = "category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int catId;
	private String catTitle;
	private String catDescription;
	
	@OneToMany
	@JoinColumn(name="catId", referencedColumnName = "catId")
	private List<Product> productList;
	
	
	
	public Category() {
		// TODO Auto-generated constructor stub
	}



	public Category(int catId, String catTitle, String catDescription) {
		super();
		this.catId = catId;
		this.catTitle = catTitle;
		this.catDescription = catDescription;
	}



	public int getCatId() {
		return catId;
	}



	public void setCatId(int catId) {
		this.catId = catId;
	}



	public String getCatTitle() {
		return catTitle;
	}



	public void setCatTitle(String catTitle) {
		this.catTitle = catTitle;
	}



	public String getCatDescription() {
		return catDescription;
	}



	public void setCatDescription(String catDescription) {
		this.catDescription = catDescription;
	}



	public List<Product> getProductList() {
		return productList;
	}



	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}



	@Override
	public String toString() {
		return "Category [catId=" + catId + ", catTitle=" + catTitle + ", catDescription=" + catDescription
				+ ", productList=" + productList + "]";
	}


	

	 
}
