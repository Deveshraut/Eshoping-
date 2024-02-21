package backend.shopproject1.src.main.java.com.shop.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.shop.entity.Product;
import com.shop.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProductDao extends JpaRepository<Product,Integer> 
{
	
	List <Product>findAll();
	Product findByProdId(int id);
	Product save (Product product);
	List<Product> findAllBySellerId(int id);
	List<Product> findAllByProdTitleContainingIgnoreCase(String title);
	@Query(value = "SELECT AVG(rating) as rating FROM orderdetails WHERE product_id = ?1",nativeQuery = true)
	float findAvgRating(int id);
	void deleteAllByCompId(int id);
}
