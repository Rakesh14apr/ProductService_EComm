package com.example.product.services;

import com.example.product.dtos.ProductRequestDto;
import com.example.product.exceptions.InvalidProductException;
import com.example.product.models.Category;
import com.example.product.models.Product;
import com.example.product.repositories.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
@Qualifier("selfProductService")
public class SelfProductService implements IProductService{

    @Autowired
    ProductRespository productRespository;

    /*@Autowired
    SelfProductService(ProductRespository productRespository){
        this.productRespository=productRespository;
    }*/

    @Override
    public Product getSingleProduct(Long id) throws InvalidProductException {
        Optional<Product> optionalProduct = productRespository.findById(id);
        if(optionalProduct.isEmpty()){
            throw new InvalidProductException(" Product with Id "+id +" Not found ");
        }
        Product product=optionalProduct.get();

        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = productRespository.findAll();
        return productList;
    }

    @Override
    public Product updateProduct(Long id, ProductRequestDto productRequestDto) {
        return null;
    }

    @Override
    public Product deleteProduct(Long Id) {
        productRespository.deleteById(Id);
        return null;
    }

    @Override
    public Product addProduct(Product product) {
        Category categoryToCheck = cat
        return null;
    }
}
