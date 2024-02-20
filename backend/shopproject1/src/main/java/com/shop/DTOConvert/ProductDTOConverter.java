package backend.shopproject1.src.main.java.com.shop.DTOConvert;

import org.springframework.stereotype.Component;

import com.shop.dto.ProductDTO;
import com.shop.dto.ProductSaveDTO;
import com.shop.entity.Product;

@Component
public class ProductDTOConverter 
{
	
	public ProductDTOConverter() {
		// TODO Auto-generated constructor stub
	}
	
	public  ProductDTO toProductDTO(Product entity)
	{
		ProductDTO dto = new ProductDTO();
		dto.setProd_id(entity.getProdId());
		dto.setProd_title(entity.getProdTitle());
		dto.setProd_description(entity.getProdDescription());
		dto.setProd_price(entity.getProdPrice());
		dto.setCat_id(entity.getCatId());
		dto.setComp_id(entity.getCompId());
		dto.setProd_qty(entity.getProdQty());
		dto.setSeller_id(entity.getSellerId());

		
		return dto;
	}
	
	public Product toEntityProduct(ProductSaveDTO productSaveDto)
	{
		Product product = new Product();
		product.setProdTitle(productSaveDto.getProd_title());
		product.setProdDescription(productSaveDto.getProd_description());
		product.setProdPrice(productSaveDto.getProd_price());
		product.setCatId(productSaveDto.getCat_id());
		product.setCompId(productSaveDto.getComp_id());
		product.setProdQty(productSaveDto.getProd_qty());
		product.setSellerId(productSaveDto.getSeller_id());
		
		return product;
		
	}
}
