package com.example.product.inheritanceDemo.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="st_mentor")
@DiscriminatorValue("1")
public class Mentor extends User {
    private String company;
    private Float avgRating;
}
