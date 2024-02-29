package com.example.product.dtos;

import com.example.product.models.Category;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {
    private Long id;
    private String title;
    private int price;
    private String description;
    private String image;
    //@JsonProperty("category")
    private String category;
}
