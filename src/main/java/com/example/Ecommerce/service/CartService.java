package com.example.Ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Ecommerce.entity.Cart;
import com.example.Ecommerce.entity.Product;
import com.example.Ecommerce.entity.User;
import com.example.Ecommerce.repository.CartRepository;
import com.example.Ecommerce.repository.ProductRepository;
import com.example.Ecommerce.repository.UserRepository;



@Service
public class CartService {
    @Autowired
    CartRepository cartrepo;

    @Autowired
    ProductRepository productrepo;

    @Autowired
    UserRepository userrepo;

    public Cart addtocart(Cart cart,Long userid,Long productid){
           Optional<User> user = userrepo.findById(userid);

        Optional<Product> product = productrepo.findById(productid);
        
        if(user.isPresent()&&product.isPresent()){
                cart.setUser(user.get());
                cart.setProduct(product.get());
                return cartrepo.save(cart);
            
            
        }
        else{
                throw new RuntimeException("User or Product not found");
        }

     
        
    }

    public void fullcart(){

       List<Cart> cartitems = cartrepo.findAllByUserId(1);
       for(Cart c : cartitems){
        long q =c.getQuantity();
        Optional<Product> Optionalprod = productrepo.findById(c.getProduct().getId());
        if(Optionalprod.isPresent()){

            Product p = Optionalprod.get();

            System.out.println("product name "+p.getName()+" product price "+p.getPrice()+" quantity "+q);
        }

       }

        
        
    }



    public Cart increaseQuantity(long userid,long productid){
        Optional<Cart> cartOptional = cartrepo.findByUserIdAndProductId(userid,productid);
        if(cartOptional.isPresent()){
             Cart cart = cartOptional.get();
            cart.setQuantity(cart.getQuantity()+1);
            cartrepo.save(cart);
            
            return cart;
        }
            throw new RuntimeException("Cart item not found for userId: " + userid + " and productId: " + productid);
        

    }


        public Cart decreaseQuantity(long userid,long productid){
        Optional<Cart> cartOptional = cartrepo.findByUserIdAndProductId(userid,productid);
        if(cartOptional.isPresent()){
             Cart cart = cartOptional.get();
            cart.setQuantity(cart.getQuantity()-1);
            cartrepo.save(cart);
            
            return cart;
        }
            throw new RuntimeException("Cart item not found for userId: " + userid + " and productId: " + productid);
        

    }



}
