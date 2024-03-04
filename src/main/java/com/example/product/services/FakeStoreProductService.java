package com.example.product.services;

import com.example.product.dtos.ProductRequestDto;
import com.example.product.dtos.ProductResponseDto;
import com.example.product.exceptions.ProductDoesNotExistException;
import com.example.product.models.Category;
import com.example.product.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
@Qualifier("fakeStoreProductService")
public class FakeStoreProductService implements IProductService{

    //to interact with fakestoreAPI.com we need web service so we are considering Rest Template
    @Autowired
    RestTemplate restTemplate;

    public Product getProductFromProductResponseDto(ProductResponseDto responseDto){
        Product product=new Product();
        product.setId(responseDto.getId());
        product.setName(responseDto.getTitle());
        product.setImage(responseDto.getImage());
        product.setDescription(responseDto.getDescription());
        product.setPrice(responseDto.getPrice());

        Category category=new Category();
        category.setName(responseDto.getCategory());

        product.setCategory(category);
        return product;
    }


    @Override
    public Product getSingleProduct(Long id) {
        //We should pass "id" to fakestore & get corresponding product
        // POC for fakestore: 'https://fakestoreapi.com/products/1'
        // Now we need to interact with other service from our application
        //for this we have multipe options(RestTemplate, Web Service.. )

        ProductResponseDto response = restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                ProductResponseDto.class);
        return getProductFromProductResponseDto(response);
    }

    @Override
    public List<Product> getAllProducts() {
        ProductResponseDto[] responseDtoList=
                restTemplate.getForObject("https://fakestoreapi.com/products",
                ProductResponseDto[].class);
        List<Product> output=new ArrayList<>();
        for(ProductResponseDto productResponseDto:responseDtoList){
            output.add(getProductFromProductResponseDto(productResponseDto));
        }
        return output;
    }

    @Override
    public Product updateProduct(Long id, Product product) throws ProductDoesNotExistException {
        return null;
    }



   /* @Override
    public Product updateProduct(Long id, ProductRequestDto productRequestDto) {
        *//*
        //This is not returning the object that it as modified
        restTemplate.put("https://fakestoreapi.com/products/"+id,ProductRequestDto.class);

 //        //But we need to get the object that has been updated.
//        return getSingleProduct(id);
//        //But this is happening in two network calls
//        if we use PUT method to update we have to make two network calls
//        to update the product and return updated product

         *//*
        RequestCallback requestCallback=restTemplate.httpEntityCallback(productRequestDto, ProductResponseDto.class);
        HttpMessageConverterExtractor<ProductResponseDto> responseExtractor=
                new HttpMessageConverterExtractor<>(ProductResponseDto.class,
                        restTemplate.getMessageConverters());
        ProductResponseDto responseDto=restTemplate.execute("https://fakestoreapi.com/products/"+id,
                HttpMethod.PUT,requestCallback,responseExtractor);
        return getProductFromProductResponseDto(responseDto);

        //restTemplate.getForObject("https://fakestoreapi.com/products/"+id, ProductRequestDto.class);
    }*/

    @Override
    public Product deleteProduct(Long Id) {
        return null;
    }

    @Override
    public Product addProduct(Product product) {
        return null;
    }
}
