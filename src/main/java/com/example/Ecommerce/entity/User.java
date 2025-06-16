package com.example.Ecommerce.entity;

import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String fullname;
    private String email;
    private String password;
    private String phonenumber;
    private String address;
    private String landmark;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Cart> cart;



    
}
