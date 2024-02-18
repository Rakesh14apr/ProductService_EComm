package com.example.product.controllers;

import com.example.product.dtos.ProductRequestDto;
import com.example.product.models.Product;
import com.example.product.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {


    @Qualifier("fakeStoreProductService")
    @Autowired
    private IProductService productService;

    //get all products from fakestore
    @GetMapping("/products")
    public List<Product> getAllProducts(){

        return new ArrayList<>();
    }

    //get single product from fakestore
    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id){

        return productService.getSingleProduct(id);
    }

    //add new product to fakestore
    //use post method, to add a product the method should take body as input
    //https://fakestoreapi.com/products
    @PostMapping("/Products")
    public Product addProduct(@RequestBody ProductRequestDto productRequestDto){

        return new Product();
    }


    //update existing product in fakestore
    //to update product in fakestore method takes product id and new body of the product
    @PutMapping("/Products/{id}")
    public Product updateProduct(@PathVariable("id") Long id,@RequestBody ProductRequestDto productRequestDto){

        return new Product();
    }

    //delete product from fakestore
    @DeleteMapping("/Products/{id}")
    public boolean deleteProduct(@PathVariable Long id){

        return true;
    }

}
