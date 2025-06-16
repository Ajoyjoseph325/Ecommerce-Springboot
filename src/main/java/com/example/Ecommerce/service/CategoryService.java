package com.example.Ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Ecommerce.entity.Category;
import com.example.Ecommerce.repository.CategoryRepository;



@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryrepo;


public Category addCategory(Category c){
    return categoryrepo.save(c);
}
    
}
