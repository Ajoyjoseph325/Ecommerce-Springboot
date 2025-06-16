package com.example.Ecommerce.repository;



import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Ecommerce.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

Optional<Category> findById(Long id);


    
}
