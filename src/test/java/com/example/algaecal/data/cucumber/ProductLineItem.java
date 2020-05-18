package com.example.algaecal.data.cucumber;

import lombok.Data;

import java.math.BigDecimal;

/** DTO for individual items in a bundle, in the Cucumber data tables */
@Data
public class ProductLineItem {
  private String productName;
  private BigDecimal priceInDollars;
  private Integer quantity;
}
