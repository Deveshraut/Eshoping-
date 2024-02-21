package backend.shopproject1.src.main.java.com.shop.dao;

import com.shop.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.MyOrder;

import java.util.List;

public interface MyOrderDAO extends JpaRepository<MyOrder, Integer>{

	MyOrder save(MyOrder myOrder);

    List<MyOrder> findByUserId(int id);

   // List<OrderDetail> findByMyorderId(int myorderId);
   MyOrder findByMyorderId(int myorderId);



    //List<OrderDetail> findByMyOrderId(int myorderId);
}
