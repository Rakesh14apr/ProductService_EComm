package com.example.product.services;

import com.example.product.models.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
//@Component
public interface IProductService {
    public Product getSingleProduct(Long id);
}
