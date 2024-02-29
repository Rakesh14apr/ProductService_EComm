package com.example.product.repositories;

import com.example.product.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(String name);
    Category save(Category category);
}
