package backend.shopproject1.src.main.java.com.shop.controller;

import com.shop.dao.PaymentDAO;
import com.shop.dto.PaymentDto;
import com.shop.dto.Response;
import com.shop.service.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentServiceImpl paymentService;

    @GetMapping("")
    public ResponseEntity<?> findAllPayment(){
    List<PaymentDto> list=paymentService.findAllPayment();
    return Response.success(list);
    }

    @GetMapping("/total")
    public ResponseEntity<?> totalPayment(){
        Double totalPayment=paymentService.totalPayment();
        return Response.success(totalPayment);
    }
}
