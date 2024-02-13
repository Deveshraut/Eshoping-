package backend.shopproject1.src.main.java.com.shop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.web.servlet.AuthorizeRequestsDsl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dto.AddressDTO;
import com.shop.dto.AuthRequest;
import com.shop.dto.Credentials;
import com.shop.dto.Response;
import com.shop.dto.UserDTO;
import com.shop.dto.UserEditDTO;
import com.shop.dto.UserSignInDTO;
import com.shop.dto.UserSignUpDTO;
import com.shop.entity.User;
import com.shop.service.JwtHelper;
import com.shop.service.JwtResponse;
import com.shop.service.UserServiceImpl;
@CrossOrigin(origins ="*")
@RestController

public class UserController {
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private UserDetailsService userDetailsService;
	 
	@Autowired
	private JwtHelper jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	
//	 @PostMapping("/user/signin")
//	 public ResponseEntity<?> signIn(@Valid @RequestBody Credentials cred)
//	 {
//		 UserSignInDTO user = userServiceImpl.findUserByEmailAndPassword(cred);
//		 if(user == null)
//			 return Response.error("user not found");
//		 return Response.success(user);
//	 }
	    @PostMapping("/user/signin")
	    public String authenticateAndGetToken(@RequestBody Credentials authRequest) {
	        Authentication authentication = authenticationManager
	        		.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
	        if (authentication.isAuthenticated()) {
	            return jwtService.generateToken(authRequest.getEmail());
	        } else {
	            throw new UsernameNotFoundException("invalid user request !");
	        }
	    }
	
	
	 
	 @PostMapping("/user/signup")
	 public ResponseEntity<?> signUp(@Valid @RequestBody UserSignUpDTO userSignUpDTO)
	 {
		 User user = userServiceImpl.saveUser(userSignUpDTO);
		 return Response.success(user);
	 }
	 
	 @PostMapping("/user/edit")
	 public ResponseEntity<?> edit(@RequestHeader HashMap<String,String>map, @RequestBody UserEditDTO userEditDTO)
	 {
		 User user = userServiceImpl.editUser(Integer.parseInt(map.get("token")),userEditDTO);
		 return Response.success(user);
	 }
	 
	
	 
	 @PatchMapping("/seller/apply")
	 public ResponseEntity<?> updateRoleAsCUSTSELL(@RequestHeader Map<String, String> mapValue )
	 {
		 User user = userServiceImpl.updateRole(Integer.parseInt(mapValue.get("token")));
		 System.out.println(mapValue.get("token"));
		
		 return Response.success("successfully applied for seller");
	 }
	 

	 
	 @PostMapping("user/checkout")
		public  ResponseEntity<?>placeOrede(@RequestHeader HashMap<String,String> map,@RequestBody AddressDTO addressDTO)
		 {
			 int userId = Integer.parseInt(map.get("token"));
			 System.out.println(addressDTO);
			 User user = userServiceImpl.placeOrder(userId,addressDTO);
			  if(user!=null)
			  	return  Response.success("Order place successfully");
			  else
				  return Response.error("Cart is Empty");
		 }
	 
	 
	 @GetMapping("/admin/user")
	 public ResponseEntity<?> getAllUsers()
	 {
		 List<UserDTO> user = userServiceImpl.findAllUserList();
		 return Response.success(user);
	 }
	 
	 @GetMapping("/admin/seller")
	 public ResponseEntity<?> getAllSellers()
	 {
		 List<UserDTO> user = userServiceImpl.findAllSellerList();
		 return Response.success(user);
	 }
	 
	 @PostMapping("/admin/approve-seller")
	 public ResponseEntity<?> approveSellerByAdmin(@RequestBody UserDTO userDTO)
	 {
		 User user= userServiceImpl.ApproveSeller(userDTO);
		 return Response.success("seller approved");
	 }
	 
	 @PostMapping("/admin/suspend-seller")
	 public ResponseEntity<?> suspendSeelerByAdmin(@RequestBody UserDTO userDTO)
	 {
		 User user= userServiceImpl.suspendSeller(userDTO);
		 return Response.success("seller suspended");
	 }
	 
	 @PatchMapping("/admin/suspend_user/{id}")
	 public ResponseEntity<?> suspendUser(@PathVariable("id") int id )
	 {
		 User user= userServiceImpl.suspendUser(id);
		 return Response.success("user suspended");
	 }
	 
}
