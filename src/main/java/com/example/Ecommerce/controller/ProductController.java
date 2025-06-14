package com.example.Ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

  @GetMapping("/hii")
  public String hello(){
    return "hii";
  }
    
}
