package com.example.Ecommerce.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ecommerce.entity.Category;
import com.example.Ecommerce.entity.Product;
import com.example.Ecommerce.repository.CategoryRepository;
import com.example.Ecommerce.repository.ProductRepository;

@RestController
public class ProductController {  

  @Autowired
  ProductRepository productrepo;

  @Autowired
  CategoryRepository categoryrepo;


  @GetMapping("/hii")
  public String hello(){
    return "hii";


  }
  @PostMapping("/addproduct")
  public Product addProduct(@RequestBody Product product,@RequestParam Long id){


  Optional<Category> categoryOptional = categoryrepo.findById(id);
    
    if (categoryOptional.isPresent()) {
        product.setCategory(categoryOptional.get());
        return productrepo.save(product);
    } else {
        throw new RuntimeException("Category with ID " + id + " not found.");
    }

  
  }


}