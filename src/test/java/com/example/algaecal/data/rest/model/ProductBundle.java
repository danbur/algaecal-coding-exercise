package com.example.algaecal.data.rest.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/** DTO for product bundles in the back-end service endpoint */
@Data
public class ProductBundle {
  private String name;
  private String id;
  private List<ProductIdAndQuantity> items;
  private BigDecimal discount;
}
