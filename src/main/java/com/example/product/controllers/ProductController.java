package com.example.product.controllers;

import com.example.product.dtos.ProductRequestDto;
import com.example.product.exceptions.InvalidProductException;
import com.example.product.exceptions.ProductDoesNotExistException;
import com.example.product.models.Category;
import com.example.product.models.Product;
import com.example.product.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {




    private IProductService productService;

   @Autowired
   ProductController(@Qualifier("selfProductService") IProductService productService){
       this.productService=productService;
   }

    //get all products from fakestore
    @GetMapping("/products")
    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }

    //get single product from fakestore
    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id) throws InvalidProductException {

        return productService.getSingleProduct(id);
    }


    //add new product to fakestore
    //use post method, to add a product the method should take body as input
    //https://fakestoreapi.com/products
    @PostMapping("/products")
    public Product addProduct(@RequestBody ProductRequestDto productRequestDto){
        Product product=new Product();
        product.setName(productRequestDto.getTitle());
        product.setPrice(productRequestDto.getPrice());
        product.setDescription(productRequestDto.getDescription());
        product.setImage(productRequestDto.getImage());
        product.setCategory(new Category());
        product.getCategory().setName(productRequestDto.getCategory());

        Product savedProduct=productService.addProduct(product);
        return savedProduct;
    }

    //update existing product in fakestore
    //to update product in fakestore method takes product id and new body of the product
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") Long id,@RequestBody ProductRequestDto productRequestDto) throws ProductDoesNotExistException {
         Product product = new Product();
        product.setId(id);
        product.setName(productRequestDto.getTitle());
        product.setPrice(productRequestDto.getPrice());
        product.setDescription(productRequestDto.getDescription());
        product.setImage(productRequestDto.getImage());
        product.setCategory(new Category());
        product.getCategory().setName(productRequestDto.getCategory());

        Product updatedProduct = productService.updateProduct(id,product);
        return updatedProduct;
    }

    //delete product from fakestore
    @DeleteMapping("/products/{id}")
    public Product deleteProduct(@PathVariable Long id){

        return (Product) productService.deleteProduct(id);
    }

}
