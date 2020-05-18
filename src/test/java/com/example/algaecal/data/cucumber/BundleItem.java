package com.example.algaecal.data.cucumber;

import lombok.Data;

import java.math.BigDecimal;

/**
 * This represent the individual items in a bundle, in the Cucumber data tables
 */
@Data
public class BundleItem {
    private String productName;
    private BigDecimal priceInDollars;
    private String quantity;
}
