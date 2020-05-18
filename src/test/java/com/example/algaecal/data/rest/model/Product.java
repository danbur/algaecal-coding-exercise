package com.example.algaecal.data.rest.model;

import lombok.Data;

import java.math.BigDecimal;

/** DTO for products in the back-end service endpoint */
@Data
public class Product {
  String name;
  String id;
  BigDecimal price;
}
