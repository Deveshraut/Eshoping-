package backend.shopproject1.src.main.java.com.shop.DTOConvert;

import org.springframework.stereotype.Component;

import com.shop.dto.UserDTO;
import com.shop.entity.User;
@Component
public class UserDTOConverter {
	
//	public UserDTOConverter() {
//		// TODO Auto-generated constructor stub
//	}
	
	public UserDTO toUserDTO(User user)
	{
		UserDTO userDTO = new UserDTO();
		userDTO.setUser_id(user.getUserId());
		userDTO.setUser_name(user.getUserName());
		userDTO.setUser_email(user.getUserEmail());
		userDTO.setUser_role(user.getUserRole());
		
		return userDTO;
	}
	


}
