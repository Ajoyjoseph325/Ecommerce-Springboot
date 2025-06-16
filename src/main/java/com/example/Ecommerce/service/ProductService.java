package com.example.Ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Ecommerce.entity.Product;
import com.example.Ecommerce.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    ProductRepository productrepo;


    public Product saveProduct(Product product){
        
        return productrepo.save(product);




        
    }
    
}
