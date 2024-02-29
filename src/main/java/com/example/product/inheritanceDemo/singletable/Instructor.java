package com.example.product.inheritanceDemo.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="st_instuctor")
@DiscriminatorValue("2")
public class Instructor extends User {
    private String specialization;
}
