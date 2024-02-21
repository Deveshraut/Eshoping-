package backend.shopproject1.src.main.java.com.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Company;
import com.shop.entity.Product;

public interface CompanyDAO extends JpaRepository<Company,Integer> {

	List<Company> findAll();
	Company save (Company company);
	void deleteByCompId(int id);
	Company findByCompId(int id);
}
