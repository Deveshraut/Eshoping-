package backend.shopproject1.src.main.java.com.shop.controller;

import java.util.List;

import javax.validation.Valid;

import com.shop.dto.CategoryDTO;
import com.shop.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shop.dto.CompanyDTO;
import com.shop.dto.Response;
import com.shop.entity.Company;
import com.shop.service.CompanyServiceImpl;

@CrossOrigin(origins = "*")
@RestController
public class CompanyController {
	
	@Autowired
	private CompanyServiceImpl companyServiceImpl;
	
	
	@GetMapping("/company")
	public ResponseEntity<?> findAllCompany() 
	{
		List<CompanyDTO> CompanyDTOList = companyServiceImpl.getAllCompany();
		return Response.success(CompanyDTOList);
		
	}
	
	 @PostMapping("/company")
	 public ResponseEntity<?> addCompany(@Valid @RequestBody CompanyDTO companyDTO)
	 {
		 Company company = companyServiceImpl.saveCompany(companyDTO);
		 return Response.success("ok");
	 }

	@PostMapping("/company/update")
	public ResponseEntity<?> updateCompany(@Valid @RequestBody CompanyDTO companyDTO)
	{
		Company company = companyServiceImpl.updateCompany(companyDTO);
		return Response.success("Company Updated");
	}

	@DeleteMapping("/company/{comp_id}")
	public ResponseEntity<?> deleteCompany(@PathVariable("comp_id") int compId)
	{
	companyServiceImpl.deleteCompany(compId);
		return Response.success("Company Deleted");
	}
	

}
