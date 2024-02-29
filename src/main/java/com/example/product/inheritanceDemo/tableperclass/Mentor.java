package com.example.product.inheritanceDemo.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tpc_mentor")
public class Mentor extends User {
    private String company;
    private Float avgRating;
}
