package com.example.Ecommerce.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ecommerce.entity.Cart;
import com.example.Ecommerce.entity.Product;
import com.example.Ecommerce.entity.User;
import com.example.Ecommerce.repository.CartRepository;
import com.example.Ecommerce.repository.ProductRepository;
import com.example.Ecommerce.repository.UserRepository;
import com.example.Ecommerce.service.CartService;

@RestController
public class CartController {
    @Autowired
    UserRepository userrepo;

    @Autowired
    ProductRepository productrepo;

    @Autowired
    CartRepository cartrepo;

    @Autowired
    CartService cartservice;



    @PostMapping("/addtocart/{productid}/{userid}")
    public Cart addtoCart(@RequestBody Cart cart,@PathVariable Long productid,@PathVariable Long userid){
     
        return cartservice.addtocart(cart, userid, productid);
    

    }
 @PostMapping("/plusquantity/{userid}/{productid}")
 public Cart increaseQunatity(@PathVariable long userid,@PathVariable long productid){

        return cartservice.increaseQuantity(userid, productid);
                
}


 @PostMapping("/minusquantity/{userid}/{productid}")
 public Cart decreaseQunatity(@PathVariable long userid,@PathVariable long productid){

        return cartservice.decreaseQuantity(userid, productid);
                
}

@GetMapping("/test")
public void test(){
    cartservice.fullcart();
}




  
































    
}
