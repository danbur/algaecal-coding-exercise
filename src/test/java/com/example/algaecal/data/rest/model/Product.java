package com.example.algaecal.data.rest.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * DTO for products
 */
@Data
public class Product {
    String name;
    String id;
    BigDecimal price;
}
