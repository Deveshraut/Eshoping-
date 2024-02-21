package backend.shopproject1.src.main.java.com.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.shop.dto.OrderDetailsCommentDTO;
import com.shop.entity.OrderDetail;
import com.shop.entity.Product;

public interface OrderDetailsDao extends JpaRepository<OrderDetail,Integer>
{
		
		List<OrderDetail> findByProductId(int id);
}
