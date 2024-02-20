package backend.shopproject1.src.main.java.com.shop.DTOConvert;


import com.shop.dao.MyOrderDAO;
import com.shop.dao.OrderDetailsDao;
import com.shop.dao.ProductDao;
import com.shop.entity.OrderDetail;
import com.shop.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shop.dto.MyOrderDTO;
import com.shop.entity.MyOrder;

import java.util.List;

@Component
public class MyOrderDTOConverter {
	@Autowired
	MyOrderDAO myOrderDAO;

	@Autowired
	ProductDao productDao;

	public MyOrderDTO toMyOrderDTO(MyOrder myorder)
	{
		MyOrderDTO myOrderDTO =new MyOrderDTO();

		//List<OrderDetail> list = myOrderDAO.findByMyorderId(myorder.getMyorderId());
		List<OrderDetail> list = myorder.getOrderDetailList();
		for(OrderDetail orderDetail :list)
		{
			Product p = productDao.findByProdId(orderDetail.getProductId());
			//myOrderDTO.setPhoto(p.getPhoto());
			myOrderDTO.setProd_title(p.getProdTitle());
			myOrderDTO.setRating(orderDetail.getRating());
			myOrderDTO.setComment(orderDetail.getComment());
			myOrderDTO.setProd_price(orderDetail.getPrice());
			myOrderDTO.setUser_id(myorder.getUserId());
			myOrderDTO.setTotal_price(myorder.getTotalPrice());
			myOrderDTO.setOrderDate(myorder.getOrderDate());
			myOrderDTO.setOrderdetails_id(orderDetail.getOrderdetailsId());
			myOrderDTO.setMyorder_id(orderDetail.getMyorderId());
			myOrderDTO.setProduct_id(orderDetail.getProductId());
			myOrderDTO.setQuantity(orderDetail.getQuantity());
			myOrderDTO.setSeller_id(p.getSellerId());

			if(myorder.getStatus() == 0)
				myOrderDTO.setStatus("not delivered");
			else
				myOrderDTO.setStatus("delivered");
		}
		return myOrderDTO;
	}
}
