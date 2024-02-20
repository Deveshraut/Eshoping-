package backend.shopproject1.src.main.java.com.shop.DTOConvert;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.shop.dto.UserSignInDTO;
import com.shop.dto.UserSignUpDTO;
import com.shop.entity.User;



@Component
public class UserSignUpDTOConverter {
	@Autowired
	 private PasswordEncoder passwordEncoder;
	public User toEntityUserSignUpDTO(UserSignUpDTO userSignUpDTO)
	{
		User user = new User();
		user.setUserEmail(userSignUpDTO.getEmail());
		user.setUserName(userSignUpDTO.getName());
		user.setUserPassword(passwordEncoder.encode(userSignUpDTO.getPassword()));
		user.setUserPhone(userSignUpDTO.getPhone());
		user.setUserRole("CUSTOMER");
		user.setUserStatus(1);
		return user;
	}

}
