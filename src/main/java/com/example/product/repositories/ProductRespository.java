package com.example.product.repositories;

import com.example.product.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRespository extends JpaRepository<Product,Long> {
    Product findByName(String name);
    Optional<Product> findById(Long id);
    List<Product> findProductByPriceLessThan(int price);
    void deleteById(Long Id);

    Product save(Product product);

}
