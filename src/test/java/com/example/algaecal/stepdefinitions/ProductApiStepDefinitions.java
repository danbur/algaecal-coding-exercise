package com.example.algaecal.stepdefinitions;

import com.example.algaecal.data.cucumber.BundleItem;
import com.example.algaecal.teststeps.ProductApiTestSteps;
import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;

import java.util.List;

/** Step definitions related to the product API */
public class ProductApiStepDefinitions {
  @Steps private ProductApiTestSteps productApiTestSteps;

  @Given("I have a bundle {string} with the following items and a discount of ${int}:")
  public void i_have_a_bundle_bundleName_with_the_following_items_and_a_discount_of_discountPrice(
      String bundleName, int discountPrice, List<BundleItem> bundleItems) {
    // I am assuming here that we do not necessarily have this bundle as static data and need to
    // create it through
    // the product API
    productApiTestSteps.createOrUpdateBundle(bundleName, discountPrice, bundleItems);
  }

}
