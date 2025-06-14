package com.example.Ecommerce.entity;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
@Data
@Entity
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> product;


    
}
