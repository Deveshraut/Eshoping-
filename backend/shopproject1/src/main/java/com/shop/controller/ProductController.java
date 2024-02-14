package backend.shopproject1.src.main.java.com.shop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import com.shop.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shop.entity.Product;
import com.shop.service.ProductServiceImpl;

@CrossOrigin(origins = "*")
@RestController
public class ProductController 
{
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@GetMapping("/product")
	public ResponseEntity<?> findProduct() 
	{
		List<ProductDTO> productDTOList = productServiceImpl.findAllProducts();
		return Response.success(productDTOList);
		
	}
	
	@GetMapping("/productdetails/{id}")
	public ResponseEntity<?> findProductById(@PathVariable("id") int id) 
	{
		List<ProductDTO> list = new ArrayList<>();
		ProductDTO result = productServiceImpl.findProductById(id);
		list.add(result);
		return Response.success(list);
	}
	
	@GetMapping("/productRatingAvg/{id}")
	public ResponseEntity<?> findAvgRating(@PathVariable("id") int id) 
	{
		List<RatingDTOonlyRating> r = new ArrayList<>();
		Float a = productServiceImpl.findAvgRatingProductById(id);
		System.out.println(a.toString());
		r.add(new RatingDTOonlyRating(a.toString()));
		return Response.success(r);
	}

	@GetMapping("/productComment/{id}")
	public ResponseEntity<?> findComment(@PathVariable("id") int id) 
	{
		List<OrderDetailsCommentDTO> commentDTO = productServiceImpl.findCommentsProductById(id);
		return Response.success(commentDTO);
	}
	
	 @PostMapping("/seller/add_product")
	 public ResponseEntity<?> addProductBySeller(@Valid @RequestBody ProductSaveDTO productSaveDTO)
	 {
		 Product product = productServiceImpl.saveProduct(productSaveDTO);
		 return Response.success("ok");
	 }
	 
	@GetMapping("/seller/product")
	public ResponseEntity<?> findAllProductBySeller(@RequestHeader HashMap<String,String>map)
	{

		List<ProductDTO> productDTOList = productServiceImpl.findAllProductBySellerId(Integer.parseInt(map.get("token")));
//		System.out.println(productDTOList);
		return Response.success(productDTOList);
		
	}
	
	@GetMapping("/admin/product")
	public ResponseEntity<?> findAllProductForAdmin() 
	{
		List<ProductDTO> productDTOList = productServiceImpl.findAllProducts();
		return Response.success(productDTOList);
		
	}

	@PostMapping("/search/product")
	public ResponseEntity<?> searchProductBtTitle(@RequestBody ProductDTO productDTO)
	{

		List<ProductDTO> productDTOList = productServiceImpl.searchProductBtTitle(productDTO.getProd_title());
		return Response.success(productDTOList);
	}
//	@PutMapping("/product/{prod_id}")
//	public  ResponseEntity<?>updateProduct(
//			@PathVariable("prod_id") int id,
//			@RequestBody ProductDTO productDTO)
//	{
//		Product product = productServiceImpl.updateProduct(id,productDTO);
//		return Response.success("Product updated");
//	}

	@DeleteMapping("/product/{prod_id}")
	public  ResponseEntity<?> deleteProduct(@PathVariable("prod_id") int id)
	{
		productServiceImpl.deleteProduct(id);
		return Response.success("Product deleted");
	}


//	 @PatchMapping("/product/quantity/{id}")
//	 public ResponseEntity<?> updateQuantity(@PathVariable("id") int id )
//	 {
//		 Product user= productServiceImpl.updateQuantity(id, id);
//		 return Response.success("quantity updated");
//	 }

//	 @PatchMapping("/product/price/{id}")
//	 public ResponseEntity<?> updatePrice(@PathVariable("id") int id )
//	 {
//		 Product user= productServiceImpl.updatePrice(id, id);
//		 return Response.success("price updated");
//	 }


	@PostMapping("/addproduct")
	public ResponseEntity<?> addProduct(@RequestHeader HashMap<String,String>map ,@ModelAttribute AddProductDTO  addProductDTO ) throws IOException {
		Product product = productServiceImpl.AddProduct(Integer.parseInt(map.get("token")),addProductDTO);
		return Response.success("Product Added");
	}

	@GetMapping(value = "/{prod_id}",produces = "image/png")
	public @ResponseBody byte[] getImage(@PathVariable("prod_id") int id)
	{
		Product product = productServiceImpl.findProductByIdforImage(id);
		if(product == null)
			return null;
		return product.getPhoto();
	}



	@PostMapping("/product/update")
	public ResponseEntity<?> updateProduct(@ModelAttribute AddProductDTO addProductDTO ) throws IOException {
		Product product = productServiceImpl.updateProduct(addProductDTO);
		return Response.success("Product Added");
	}






}

