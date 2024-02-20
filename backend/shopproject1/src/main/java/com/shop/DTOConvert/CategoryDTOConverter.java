package backend.shopproject1.src.main.java.com.shop.DTOConvert;

import org.springframework.stereotype.Component;

import com.shop.dto.CategoryDTO;
import com.shop.entity.Category;

@Component
public class CategoryDTOConverter {
	
	public CategoryDTO toCategoryDTO( Category category)
	{
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setCat_id(category.getCatId());
		categoryDTO.setCat_title(category.getCatTitle());
		categoryDTO.setCat_description(category.getCatDescription());
	
		return categoryDTO;
		
	}
	public Category toEntityCategoryDTO(CategoryDTO categoryDTO)
	{
		Category category = new Category();
		category.setCatTitle(categoryDTO.getCat_title());
		category.setCatDescription(categoryDTO.getCat_description());
		return category;

	}
	
	

}
