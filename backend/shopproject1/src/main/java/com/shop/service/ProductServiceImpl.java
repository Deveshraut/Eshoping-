package backend.shopproject1.src.main.java.com.shop.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.shop.DTOConvert.ProductUpdateDTOConverter;
import com.shop.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.DTOConvert.OrderDetailsCommentDTOConverter;
import com.shop.DTOConvert.ProductDTOConverter;
import com.shop.dao.OrderDetailsDao;
import com.shop.dao.ProductDao;
import com.shop.entity.OrderDetail;
import com.shop.entity.Product;
@Transactional
@Service
public class ProductServiceImpl 
{
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private OrderDetailsDao orderDetailsDao;
	
	@Autowired
	private ProductDTOConverter productDTOConverter;
	
	@Autowired
	private OrderDetailsCommentDTOConverter orderDetailsCommentDTOConverter;

	@Autowired
	private ProductImageComverter productImageComverter;
	@Autowired
	ProductUpdateDTOConverter productUpdateDTOConverter;


	
	
	
	public List <ProductDTO> 	findAllProducts()
	{
		return productDao.findAll()
				.stream()
				.filter(f-> f.getCompId() !=null)
				.map(p-> productDTOConverter.toProductDTO(p))
				.collect(Collectors.toList());
	}
	
	public ProductDTO findProductById(int id)
	{
		return productDTOConverter.toProductDTO(productDao.findByProdId(id)) ;
	}

public float findAvgRatingProductById(int id)
{
	 float a= productDao.findAvgRating(id);

	 return a;
}
	
	public List<OrderDetailsCommentDTO> findCommentsProductById(int id) {
		
		List<OrderDetail> orderDetailList = orderDetailsDao.findByProductId(id);
		return orderDetailList.stream()
		.map(p-> orderDetailsCommentDTOConverter.toOrderDetailsCommentDTO(p))
		.collect(Collectors.toList());
	}
	
	
	
	public Product saveProduct(ProductSaveDTO productSaveDTO)
	{
		Product product = productDTOConverter.toEntityProduct(productSaveDTO);
		return productDao.save(product);
	}
	
	
	
	public List<ProductDTO> findAllProductBySellerId(int id)
	{


		//List<Product> productList = productDao.findAllBySellerId(id);
		List<Product> productList = productDao.findAll();

		return  productList.stream().filter(k-> k.getSellerId()==id && k.getCompId()!= null) .map(p->productDTOConverter.toProductDTO(p))
				.collect(Collectors.toList());
	}


    public List<ProductDTO> searchProductBtTitle(String title) {
		List <Product> product= productDao
				.findAllByProdTitleContainingIgnoreCase(title);
		if(product != null)
		{
			return  	product.stream()
				.filter(f-> f.getCompId() != null)
				.map(p->productDTOConverter.toProductDTO(p))
				.collect(Collectors.toList());
		}

		return new ArrayList<ProductDTO>();
    }


	public void deleteProduct(int id)
	{
	 productDao.deleteById(id);
	}
	
	public Product updateQuantity(int id,int quantity)
	{
	 Product product= productDao.findByProdId(id);
	 product.setProdQty(quantity);
	 return productDao.save(product);
	}
	
	
	public Product updatePrice(int id,float price)
	{
	 Product product= productDao.findByProdId(id);
	 product.setProdPrice(price);
	 return productDao.save(product);
	}
	
	public Product AddProduct(int token, AddProductDTO addProductDTO) {
		Product product = productImageComverter.toProductEntity(token,addProductDTO);
		return productDao.save(product);
		}

		public Product findProductByIdforImage(int id) {
			return productDao.findByProdId(id);
		}





	public Product updateProduct(AddProductDTO addProductDTO) throws IOException {
		 Product product =productDao.findByProdId(addProductDTO.getProd_id());
		product.setProdTitle(addProductDTO.getProd_title());
		product.setProdPrice(addProductDTO.getProd_price());
		product.setProdQty(addProductDTO.getProd_qty());

		return  productDao.save(product);

	}

}
