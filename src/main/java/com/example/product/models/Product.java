package com.example.product.models;


import jakarta.persistence.Cache;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {

    private String name;
    private String description;
    private int price;
    private String image;

    //Cardinality should be added as this is not primitive data type
    /*1P : 1C
    MP : 1C*/
    @ManyToOne
    private Category category;
}
