package com.example.product.services;

import com.example.product.dtos.ProductRequestDto;
import com.example.product.exceptions.InvalidProductException;
import com.example.product.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Component
public interface IProductService {
    public Product getSingleProduct(Long id) throws InvalidProductException;

    public List<Product> getAllProducts();

    Product updateProduct(Long id, ProductRequestDto productRequestDto);

    Product deleteProduct(Long Id);
    Product addProduct(Product product);

}
