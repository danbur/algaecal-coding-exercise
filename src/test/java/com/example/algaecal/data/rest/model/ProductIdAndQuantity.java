package com.example.algaecal.data.rest.model;

import lombok.Data;

/** DTO for the individual items in a product bundle */
@Data
public class ProductIdAndQuantity {
  String productId;
  Integer quantity;
}
