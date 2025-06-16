package com.example.Ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Ecommerce.entity.Product;
@Repository
public interface ProductRepository extends  JpaRepository<Product,Long>{

    
}
