package backend.shopproject1.src.main.java.com.shop.controller;

import com.shop.dto.MyOrderDTO;
import com.shop.dto.Response;
import com.shop.service.MyOderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class MyOrderController {
    @Autowired
    private MyOderServiceImpl myOderServiceImpl;
    @GetMapping("/myorder")
    ResponseEntity<?> getMyOrder(@RequestHeader HashMap<String,String>map)
    {
         List<MyOrderDTO>list = myOderServiceImpl.getMyOrders(Integer.parseInt(map.get("token")));

         return Response.success(list);
    }

    @PutMapping("/updateMyorder")
    ResponseEntity<?> updateMyOrder(@RequestBody MyOrderDTO myOrderDTO)
    {
       myOderServiceImpl.updateMyOrder(myOrderDTO);
      return Response.success("Order cancelled");
    }

//    @GetMapping("/orderdetails")
//    ResponseEntity<?> getOrderDetails()
//    {
//        List<MyOrderDTO>list = myOderServiceImpl.findAll();
//       list.forEach(System.out::println);
//        return Response.success();
//    }

}
