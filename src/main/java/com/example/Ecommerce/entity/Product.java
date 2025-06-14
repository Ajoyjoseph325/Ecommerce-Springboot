package com.example.Ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
   private Category category;



    
}
