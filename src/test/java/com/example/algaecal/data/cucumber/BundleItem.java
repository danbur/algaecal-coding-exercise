package com.example.algaecal.data.cucumber;

import lombok.Data;

/**
 * This represent the individual items in a bundle, in the Cucumber data tables
 */
@Data
public class BundleItem {
    private String productName;
    private String priceInDollars;
    private String quantity;
}
