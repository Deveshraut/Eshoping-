package backend.shopproject1.src.main.java.com.shop.DTOConvert;

import com.shop.dto.PaymentDto;
import com.shop.entity.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentDTOConverter {

    public PaymentDto toPaymentDTO(Payment payment){

        PaymentDto paymentDto=new PaymentDto();
        paymentDto.setPay_id(payment.getPayId());
        paymentDto.setUser_id(payment.getUserId());
        paymentDto.setMyorder_id(payment.getMyorderId());
        paymentDto.setPay_date(payment.getPayDate());
        paymentDto.setPay_amount(payment.getPayAmount());
        paymentDto.setPay_type(payment.getPayType());
        return paymentDto;
    }
}