package com.example.Ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Cart {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private Long quantity;
@ManyToOne
@JoinColumn(name="product_id")
@JsonBackReference(value = "product-cart")
private Product product; 
@ManyToOne
@JoinColumn(name="user_id")
@JsonBackReference(value = "user-cart")
private User user;





    
}
