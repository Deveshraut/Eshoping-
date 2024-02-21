package backend.shopproject1.src.main.java.com.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Category;

public interface CategoryDAO extends JpaRepository<Category, Integer>{
	
	List<Category> findAll();
	Category findByCatId(int id);
	void deleteByCatId(int id);

	
	
}
