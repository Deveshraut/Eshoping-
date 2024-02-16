package backend.shopproject1.src.main.java.com.shop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.shop.dto.CartDTO;
import com.shop.dto.Response;
import com.shop.service.CartServiceImpl;

@CrossOrigin(origins = "*")
@RestController
public class CartController 
{
	@Autowired
	private CartServiceImpl cartServiceImpl;
	
	@GetMapping("/cart/{id}")
	public ResponseEntity<?> findCartById(@PathVariable("id") int id) 
	{
		List<CartDTO> cartDTO = cartServiceImpl.findCartItemsByUserId(id);
		return Response.success(cartDTO);
	}
	
	@GetMapping("/cart")
	public ResponseEntity<?> findCart(@RequestHeader Map<String, String> mapValue) 
	{
		List<CartDTO> cartDTO = cartServiceImpl.findCartItemsByUserId(Integer.parseInt(mapValue.get("token")));
		return Response.success(cartDTO);
	}
	
	@PostMapping("/addtocart")
	public ResponseEntity<?> addToCart(@RequestHeader HashMap<String,String>map, @RequestBody CartDTO cartDto)
	{
		int userId = Integer.parseInt(map.get("token"));
		 cartServiceImpl.addToCart(userId,cartDto);
		return Response.success("Added to cart");
		
	}
	
	@PutMapping("/cart")
	public ResponseEntity<?> updateCart(@RequestHeader HashMap<String,String>map ,@RequestBody CartDTO cartDto)
	{
		int userId = Integer.parseInt(map.get("token"));
		return Response.success(cartServiceImpl.updateCart(userId,cartDto));
	}
	 
	@DeleteMapping("/cart/{cart_id}")
	public ResponseEntity<?> deleteCart(@PathVariable("cart_id") int cart_id) 
	{
		cartServiceImpl.deleteCart(cart_id);
		return Response.success("Ok");
	}
}
