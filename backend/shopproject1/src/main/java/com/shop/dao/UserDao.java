package backend.shopproject1.src.main.java.com.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.User;

public interface UserDao extends JpaRepository<User,Integer>  {
     	User findByUserId(int id);
     	User findByUserEmail(String email);
     	User findByUserEmailAndUserPassword(String email, String password);
     	User save(User user);
     	List<User> findAll();
     	List<User> findAllByUserRole(String role);

		List<User> findAllByUserRoleNotIn(List<String>list);

}
