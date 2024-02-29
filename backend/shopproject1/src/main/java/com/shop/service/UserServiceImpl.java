package backend.shopproject1.src.main.java.com.shop.service;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;


import com.shop.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shop.DTOConvert.OrderDetailsConverterFromCart;
import com.shop.DTOConvert.UserDTOConverter;
import com.shop.DTOConvert.UserSignInDTOConverter;
import com.shop.DTOConvert.UserSignUpDTOConverter;
import com.shop.dao.CartDAO;
import com.shop.dao.MyOrderDAO;
import com.shop.dao.OrderDetailsDao;
import com.shop.dao.PaymentDAO;
import com.shop.dao.ProductDao;
import com.shop.dao.UserDao;
import com.shop.dto.AddressDTO;
import com.shop.dto.Credentials;
import com.shop.dto.UserDTO;
import com.shop.dto.UserEditDTO;
import com.shop.dto.UserSignInDTO;
import com.shop.dto.UserSignUpDTO;

@Transactional
@Service
public class UserServiceImpl {

	
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserSignInDTOConverter userSignInDTOConverter;
	@Autowired
	private UserSignUpDTOConverter userSignUpDTOConverter;
	@Autowired
	ProductDao productDao;
	@Autowired
	MyOrderDAO myOrderDAO;
	@Autowired
	OrderDetailsConverterFromCart orderDetailsConverterFromCart;
	@Autowired
	OrderDetailsDao orderDetailsDao;
	@Autowired
	PaymentDAO paymentDAO;
	@Autowired
	CartDAO cartDAO;
	@Autowired
	UserDTOConverter userDTOConverter;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	public User findUserByEmail(String email)
	{
		return userDao.findByUserEmail(email);
	}
	
	public User findUserById(int id)
	{
		return userDao.findByUserId(id);
	}
	
//	public UserSignInDTO findUserByEmailAndPassword(Credentials cred)
//	{
//		User user =  userDao.findByUserEmailAndUserPassword(cred.getEmail(), cred.getPassword());
//		if(user != null)
//			return userSignInDTOConverter.toUserSignInDTO(user);
//		return null;
//	}
public UserSignInDTO findUserByEmailAndPassword(Credentials cred)
{
	String encPass = passwordEncoder.encode(cred.getPassword());
	User user =  userDao.findByUserEmail (cred.getEmail());
	if(user != null )
		if(passwordEncoder.matches(cred.getPassword(), user.getUserPassword()))

		{
			return userSignInDTOConverter.toUserSignInDTO(user);
		}
	return null;
}
	public User saveUser(UserSignUpDTO userSignUpDTO)
	{

		return userDao.save(userSignUpDTOConverter.toEntityUserSignUpDTO(userSignUpDTO));
	}
	
	public User editUser(int token, @Valid UserEditDTO userEditDTO) {
		User user = userDao.findByUserId( token);
		user.setUserName(userEditDTO.getName());
		user.setUserPassword(passwordEncoder.encode(userEditDTO.getPassword()));
		user.setUserPhone(userEditDTO.getPhone());
	     User user1=	userDao.save(user); 
		return user1;
	}
	

	
	public User updateRole(int id)
	{
		User user = userDao.findByUserId(id);
		user.setUserRole("CUSTSELL");
		return userDao.save(user);
	}
	
	
	public User placeOrder(int userId, AddressDTO addressDTO) {
		User user;
		user = userDao.findByUserId(userId);
		if (user.getCartList() != null) {

			double totalPriceInDouble = user.getCartList()
					.stream()
					.mapToDouble(p -> p.getCartQuantity() * productDao.findByProdId(p.getProdId()).getProdPrice()).sum();
			float totalPrice = (float) totalPriceInDouble;

			MyOrder myOrderBefore = new MyOrder();
			myOrderBefore.setUserId(user.getUserId());
			myOrderBefore.setOrderDate(LocalDate.now().toString());
			myOrderBefore.setStatus(0);
			myOrderBefore.setTotalPrice(totalPrice);
			myOrderBefore.setAddId(addressDTO.getAdd_id());

			MyOrder myOrderAfter = myOrderDAO.save(myOrderBefore);

			List<OrderDetail> orderDetailList = user.getCartList().stream()
					.map(p -> orderDetailsConverterFromCart.toOrderDetailFromCart(p, myOrderAfter.getMyorderId()))
					.collect(Collectors.toList());

			List<OrderDetail> orderDetailAfterAdd = new ArrayList<>();
			for (OrderDetail orderDetail : orderDetailList) {
				orderDetailAfterAdd.add(orderDetailsDao.save(orderDetail));
			}
			Payment payment = new Payment();
			payment.setUserId(user.getUserId());
			payment.setPayAmount(totalPrice);
			payment.setMyorderId(myOrderAfter.getMyorderId());
			payment.setPayDate(myOrderAfter.getOrderDate());
			payment.setPayType(1);
			Payment paymentAfter = paymentDAO.save(payment);

			List<Cart>list = cartDAO.findByUserId(userId);
			List<Product> products= list.stream().map(
					p->{ Product product= productDao.findByProdId(p.getProdId());
						 product.setProdQty(product.getProdQty()-p.getCartQuantity());
						 Product product1 =productDao.save(product);
						 return  product1;}
			).collect(Collectors.toList());


			cartDAO.deleteAllByUserId(user.getUserId());
			return user;

		}

			else
				return user=null;
		}
	
	

	
	public List<UserDTO> findAllUserList()

	{
		return userDao.findAllByUserRole("CUSTOMER")
		.stream()
		.map(p->userDTOConverter.toUserDTO(p))
		.collect(Collectors.toList());
	}
	
	public List<UserDTO> findAllSellerList()
	{
		List<String> list = new ArrayList<>();
		list.add("CUSTOMER");
		return userDao.findAllByUserRoleNotIn(list)
		.stream()
		.map(p->userDTOConverter.toUserDTO(p))
		.collect(Collectors.toList());
	}
	
	public User ApproveSeller(UserDTO userDTo)
	{
		User user= userDao.findByUserId(userDTo.getUser_id());
		user.setUserRole("SELLER");
		
		return userDao.save(user);
	}
	
	public User suspendSeller(UserDTO userDTo)
	{
		User user= userDao.findByUserId(userDTo.getUser_id());
		user.setUserRole("CUSTOMER");
		
		return userDao.save(user);
	}
	
	
	public User suspendUser(int id)
	{
		User user= userDao.findByUserId(id);
		user.setUserStatus(2);
		return userDao.save(user);
	} 
	
}
