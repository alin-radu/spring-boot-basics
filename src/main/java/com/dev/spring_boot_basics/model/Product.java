package com.dev.spring_boot_basics.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Entity
@Data
public class Product {

    @Id
    private int prodId;
    private String prodName;
    private int price;
}
