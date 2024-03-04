package com.example.product.services;

import com.example.product.dtos.ProductRequestDto;
import com.example.product.exceptions.InvalidProductException;
import com.example.product.exceptions.ProductDoesNotExistException;
import com.example.product.models.Category;
import com.example.product.models.Product;
import com.example.product.repositories.CategoryRepository;
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


    private ProductRespository productRespository;

    private CategoryRepository categoryRepository;

    @Autowired
    public SelfProductService(ProductRespository productRespository,CategoryRepository categoryRepository){
        this.productRespository=productRespository;
        this.categoryRepository=categoryRepository;
    }

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
    public Product deleteProduct(Long Id) {
        productRespository.deleteById(Id);
        return null;
    }

    //this updateProduct is implementaion of FakeStoreAPI please ignore



    @Override
    public Product updateProduct(Long id, Product product) throws ProductDoesNotExistException {
        //Step1: Get Existing product to update
        Optional<Product> productOptional = productRespository.findById(id);
        if(productOptional.isEmpty()){
            throw new ProductDoesNotExistException(" Product with id " +id+" does not exist ");
        }

        Product existingProduct=productOptional.get();
        Product updateProduct = new Product();

        updateProduct.setName(
                product.getName()!=null?
                        product.getName():
                        existingProduct.getName()

        );

        updateProduct.setDescription(
                product.getDescription()!=null?
                        product.getDescription():
                        existingProduct.getDescription()

        );

        updateProduct.setImage(
                product.getImage()!=null?
                        product.getImage():
                        existingProduct.getImage()

        );

        updateProduct.setPrice(
                product.getPrice()>0?
                        product.getPrice():
                        existingProduct.getPrice()

        );

        Optional<Category> categoryOptional = categoryRepository.findByName(product.getCategory().getName());
        if(categoryOptional.isEmpty()){
            Category categoryToSave=new Category();
            categoryToSave.setName(product.getCategory().getName());
            Category savedCategory=categoryRepository.save(categoryToSave);
            updateProduct.setCategory(savedCategory);
        } else {
            updateProduct.setCategory(categoryOptional.get());
        }

        Product savedUpdatedProduct=productRespository.save(updateProduct);
        return savedUpdatedProduct;
    }

    @Override
    public Product addProduct(Product product) {
        Optional<Category> categoryOptional = categoryRepository.findByName(product.getCategory().getName());
        if(categoryOptional.isEmpty()){
            Category categoryToSave=new Category();
            categoryToSave.setName(product.getCategory().getName());
            Category savedCategory=categoryRepository.save(categoryToSave);
            product.setCategory(savedCategory);
        } else {
              product.setCategory(categoryOptional.get());
        }

        Product savedProduct = productRespository.save(product);
        return savedProduct;
    }

}
