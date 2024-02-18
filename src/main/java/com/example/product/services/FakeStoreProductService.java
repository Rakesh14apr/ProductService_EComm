package com.example.product.services;

import com.example.product.dtos.ProductResponseDto;
import com.example.product.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements IProductService{


    //@Override
    public Product getSingleProduct(Long id) {
        //We should pass "id" to fakestore & get corresponding product
        // POC for fakestore: 'https://fakestoreapi.com/products/1'
        // Now we need to interact with other service from our application
        //for this we have multipe options(RestTemplate, Web Service.. )

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject("https://fakestoreapi.com/products/"+id, ProductResponseDto.class);
        return null;
    }
}
