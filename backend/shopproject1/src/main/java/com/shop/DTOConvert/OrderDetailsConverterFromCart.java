package backend.shopproject1.src.main.java.com.shop.DTOConvert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shop.dao.ProductDao;
import com.shop.entity.Cart;
import com.shop.entity.OrderDetail;

@Component
public class OrderDetailsConverterFromCart {
	
	@Autowired
    private ProductDao productDao;
    public OrderDetail toOrderDetailFromCart(Cart cart, int myOrderId)
    {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setMyorderId(myOrderId);
        orderDetail.setProductId(cart.getProdId());
        orderDetail.setPrice(productDao.findByProdId(cart.getProdId()).getProdPrice());
        orderDetail.setQuantity(cart.getCartQuantity());
        return  orderDetail;
    }

}
