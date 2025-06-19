package com.example.Ecommerce.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;


@Data
@Entity
public class Product {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;
   private String description;
   private double price;
   private String imageUrl;
   @ManyToOne
   @JoinColumn(name="category_id")
    @JsonBackReference // 
   private Category category;
   @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    @JsonManagedReference(value = "product-cart")
   private List<Cart> cart;




    
}
