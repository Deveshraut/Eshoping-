package backend.shopproject1.src.main.java.com.shop.DTOConvert;

import org.springframework.stereotype.Component;

import com.shop.dto.AddressDTO;
import com.shop.entity.Address;

@Component
public class AddressDTOConverter 
{


	public AddressDTO toAddressDTO(Address address)
	{
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setAdd_id(address.getAddId());
		addressDTO.setUser_id(address.getUserId());
		addressDTO.setAddress(address.getAddress());
		addressDTO.setCity(address.getCity());
		addressDTO.setState(address.getState());
		addressDTO.setCountry(address.getCountry());
		addressDTO.setPin(address.getPin());
		return addressDTO;
	}
	
	public Address toAddressEntity(int id, AddressDTO addressDTO)
	{
		Address address = new Address();
		address.setUserId( id );
		address.setAddress(addressDTO.getAddress());
		address.setCity(addressDTO.getCity());
		address.setState(addressDTO.getState());
		address.setCountry(addressDTO.getCountry());
		address.setPin(addressDTO.getPin());
		return address;
	}
}
