package com.example.Ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Ecommerce.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long>{
    Optional<Cart>  findByUserIdAndProductId(long userid,long productid);
    
     List<Cart> findAllByUserId(long userid);
    
}
