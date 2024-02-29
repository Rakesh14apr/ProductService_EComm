package com.example.product.models;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
public class Category extends BaseModel {

    private String name;
}
