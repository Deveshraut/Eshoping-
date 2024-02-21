package backend.shopproject1.src.main.java.com.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Address;
import com.shop.entity.Cart;

public interface AddressDAO extends JpaRepository<Address, Integer> 
{
	List<Address> findAllByUserId(int id);
	Address save(Address address);
	List<Address> findAllByAddId(int id);
	
	Address findByUserId(int id);
}
