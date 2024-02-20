package backend.shopproject1.src.main.java.com.shop.DTOConvert;

import org.springframework.stereotype.Component;
import com.shop.dto.CartDTO;
import com.shop.entity.Cart;


@Component
public class CartDTOConverter 
{
	
	public CartDTOConverter() {
		// TODO Auto-generated constructor stub
	}
	
	public CartDTO toCartDTO(Cart cart)
    {
        
		CartDTO cartDTO = new CartDTO();
		cartDTO.setCart_id(cart.getCartId());
		cartDTO.setUser_id(cart.getUserId());
		cartDTO.setProd_id(cart.getProdId());
		cartDTO.setCart_quantity(cart.getCartQuantity());
		cartDTO.setProd_title(cart.getProduct().getProdTitle());
		cartDTO.setProd_price(cart.getProduct().getProdPrice());
		cartDTO.setProd_qty(cart.getProduct().getProdQty());
        return cartDTO ;
    }
	
	public Cart toEntityCartUpdate(int userId, CartDTO cartDTO)
	{
		Cart cart = new Cart();
		cart.setUserId(userId);
		cart.setCartId(cartDTO.getCart_id());
		cart.setCartQuantity(cartDTO.getCart_quantity());
		return cart;
	}
	
	public Cart toEntityCart(int userId, CartDTO cartDTO)
	{
		Cart cart = new Cart();
		cart.setUserId(userId);
		cart.setProdId(cartDTO.getProd_id());
		cart.setCartQuantity(cartDTO.getCart_quantity());
		return cart;
	}
}
