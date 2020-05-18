package com.example.algaecal.teststeps;

import com.example.algaecal.data.cucumber.ProductLineItem;
import com.example.algaecal.data.rest.model.Product;
import com.example.algaecal.data.rest.model.ProductBundle;
import com.example.algaecal.data.rest.model.ProductIdAndQuantity;
import com.example.algaecal.rest.client.ProductClient;
import lombok.extern.slf4j.Slf4j;
import net.thucydides.core.annotations.Step;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/** Test steps related to the product API */
@Slf4j
public class ProductApiTestSteps extends BaseTestSteps {
  @Autowired private ProductClient productClient;

  @Step("Create the bundle {}, with the discount price {} and the line items {}")
  public void createOrUpdateBundle(
      String bundleName, BigDecimal discountPrice, List<ProductLineItem> productLineItems) {
    log.info("Creating/updating product bundle");
    // I am assuming the product API is a REST API.
    // These are fake endpoints, as I do not know what the API looks like
    List<ProductIdAndQuantity> productsIdsAndQuantities = new ArrayList<>();
    productLineItems.forEach(
        item -> {
          Product product = new Product();
          product.setName(item.getProductName());
          product.setId(item.getProductName().replace(" ", "-"));
          product.setPrice(item.getPriceInDollars());
          Product result = productClient.createOrUpdateProduct(product);
          ProductIdAndQuantity productIdAndQuantity = new ProductIdAndQuantity();
          productIdAndQuantity.setProductId(result.getId());
          productIdAndQuantity.setQuantity(item.getQuantity());
          productsIdsAndQuantities.add(productIdAndQuantity);
        });
    ProductBundle bundle = new ProductBundle();
    bundle.setName(bundleName);
    bundle.setId(bundleName.replace(" ", "-"));
    bundle.setDiscount(discountPrice);
    bundle.setItems(productsIdsAndQuantities);
    productClient.createOrUpdateBundle(bundle);
  }
}
