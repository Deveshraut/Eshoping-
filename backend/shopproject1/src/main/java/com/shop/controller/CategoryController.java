package backend.shopproject1.src.main.java.com.shop.controller;

import java.util.List;

import com.shop.dto.CompanyDTO;
import com.shop.entity.Category;
import com.shop.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shop.dto.CategoryDTO;
import com.shop.dto.Response;
import com.shop.service.CategoryServiceImpl;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
public class CategoryController {
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	
	
	@GetMapping("/category")
	public ResponseEntity<?> findAllCategories() 
	{
		List<CategoryDTO> categoryDTOList = categoryServiceImpl.getAllCategoryList();
		return Response.success(categoryDTOList);
		
	}

	@PostMapping("/category")
	public ResponseEntity<?> addCategory(@Valid @RequestBody CategoryDTO categoryDTO)
	{
		Category category = categoryServiceImpl.saveCategory(categoryDTO);
		return Response.success("ok");
	}

	@PutMapping("/category")
	public ResponseEntity<?> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO)
	{
		Category category = categoryServiceImpl.updateCategory(categoryDTO);
		return Response.success("Category Updated");
	}

	@DeleteMapping("/category/{cat_id}")
	public ResponseEntity<?> deleteCategory(@PathVariable("cat_id") int catId)
	{
		  categoryServiceImpl.deleteCategory(catId);
		return Response.success("Category Deleted");
	}

	
	

}
