package backend.shopproject1.src.main.java.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Payment;
import org.springframework.data.jpa.repository.Query;

public interface PaymentDAO extends JpaRepository<Payment,Integer> {
    Payment save(Payment payment);
    @Query(value="Select sum(pay_amount) from payment;",nativeQuery = true)
    double totalPayment();
}
