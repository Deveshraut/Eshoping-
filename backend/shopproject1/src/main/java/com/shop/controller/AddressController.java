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

import com.shop.dto.AddressDTO;
import com.shop.dto.CartDTO;
import com.shop.dto.ProductDTO;
import com.shop.dto.Response;
import com.shop.entity.Address;
import com.shop.entity.Product;
import com.shop.service.AddressServiceImpl;

@CrossOrigin(origins = "*")
@RestController
public class AddressController 
{
	@Autowired
	private AddressServiceImpl addressServiceImpl;
	
	
	@PostMapping("/address")
	public ResponseEntity<?> saveUser(@RequestHeader HashMap<String,String>map, @RequestBody AddressDTO addressDTO)
	{
		int id = Integer.parseInt(map.get("token"));
		Address address = addressServiceImpl.saveAddress(id,addressDTO);
		return Response.success("ok");
	}
	
	@GetMapping("/address/{add_id}")
	public ResponseEntity<?> findAddressByAddId(@PathVariable("add_id") int id) 
	{
		List<AddressDTO> addressDTO = addressServiceImpl.findAllAddressByAddId(id);
		return Response.success(addressDTO);
	}
	
	@PutMapping("/address/{user_id}")
	public  ResponseEntity<?>updateProduct(
			@PathVariable("user_id") int id,
			@RequestBody AddressDTO addressDTO)
	{
		Address address = addressServiceImpl.updateAddress(id,addressDTO);
		return Response.success("address updated");
	}
	
	
	@DeleteMapping("/address/{user_id}")
	public  ResponseEntity<?> deleteAddress(@PathVariable("user_id") int id)
	{
		addressServiceImpl.deleteAddress(id);
		return Response.success("Address deleted");
	}
	
	

	@GetMapping("/address")
	public ResponseEntity<?> findAddressById(@RequestHeader Map<String, String> mapValue) 
	{
		List<AddressDTO> addressDTO = addressServiceImpl.findAllAddressById(Integer.parseInt(mapValue.get("token")));
		return Response.success(addressDTO);
	}
	
	
	
}
