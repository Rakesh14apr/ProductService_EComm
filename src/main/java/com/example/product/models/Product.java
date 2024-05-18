package com.example.product.models;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.Cache;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@JsonSerialize
public class Product extends BaseModel implements Serializable {

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
