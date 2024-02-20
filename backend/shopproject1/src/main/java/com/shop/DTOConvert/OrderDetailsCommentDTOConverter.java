package backend.shopproject1.src.main.java.com.shop.DTOConvert;

import org.springframework.stereotype.Component;

import com.shop.dto.OrderDetailsCommentDTO;
import com.shop.entity.OrderDetail;

@Component
public class OrderDetailsCommentDTOConverter 
{
	public OrderDetailsCommentDTO toOrderDetailsCommentDTO(OrderDetail orderDetail)
    {
        OrderDetailsCommentDTO orderDetailsCommentDTO = new OrderDetailsCommentDTO();
        orderDetailsCommentDTO .setUser_name(orderDetail.getMyOrder().getUser().getUserName());
        orderDetailsCommentDTO.setRating(orderDetail.getRating());
        orderDetailsCommentDTO.setComment(orderDetail.getComment());
        orderDetailsCommentDTO.setProduct_id(orderDetail.getProductId());
        orderDetailsCommentDTO.setOrderDate(orderDetail.getMyOrder().getOrderDate());

        return orderDetailsCommentDTO;
    }
}
