package backend.shopproject1.src.main.java.com.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.shop.entity.Cart;

public interface CartDAO extends JpaRepository<Cart, Integer>
{
	public List<Cart> findByUserId(int id);
	public Cart save(Cart cart);
	
	@Modifying
	@Query(value = "UPDATE cart SET cart_quantity = ?1 WHERE cart_id = ?2", nativeQuery = true)
	
	int updateCart(int cart_quantity, int cart_id);
	public int deleteAllByUserId(int userId);

	Cart findByCartId(int id);
	
	
}
