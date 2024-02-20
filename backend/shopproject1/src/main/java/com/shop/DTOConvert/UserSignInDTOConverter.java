package backend.shopproject1.src.main.java.com.shop.DTOConvert;

import org.springframework.stereotype.Component;

import com.shop.dto.UserSignInDTO;
import com.shop.entity.User;

@Component
public class UserSignInDTOConverter {
	
	public UserSignInDTO toUserSignInDTO(User user)
	{
		UserSignInDTO userSignInDTO = new UserSignInDTO();
		userSignInDTO.setName(user.getUserName());
		userSignInDTO.setEmail(user.getUserEmail());
		userSignInDTO.setPhone(user.getUserPhone());
		userSignInDTO.setRole(user.getUserRole());
		userSignInDTO.setId(user.getUserId());
		return userSignInDTO;
	}
	
//	public User toEntityUserEditProfile(UserSignInDTO userSignInDTO)
//	{
//		User user = new User();
//		user.setUserName();
//		user.setUserPhone();
//		user.setUserId();
//		return user;
//	}

}
