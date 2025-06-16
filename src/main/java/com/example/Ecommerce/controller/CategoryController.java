package com.example.Ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ecommerce.entity.Category;
import com.example.Ecommerce.service.CategoryService;

@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/addcategory")
    public Category addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);



            
        }

    
    
}
