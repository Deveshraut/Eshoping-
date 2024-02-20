package backend.shopproject1.src.main.java.com.shop.DTOConvert;

import org.springframework.stereotype.Component;

import com.shop.dto.CompanyDTO;
import com.shop.entity.Company;

@Component
public class CompanyDTOConverter {
	
	public CompanyDTO toCompanyDTO(Company company)
	{
		CompanyDTO companyDTO = new CompanyDTO();
		companyDTO.setComp_id(company.getCompId());
		companyDTO.setComp_title(company.getCompTitle());
		companyDTO.setComp_description(company.getCompDescription());
		return companyDTO;
	}
	
	public Company toEntityCompanyDTO(CompanyDTO companyDTO)
	{
		Company company = new Company();
		company.setCompTitle(companyDTO.getComp_title());
		company.setCompDescription(companyDTO.getComp_description());
		return company;
	}

}
