package com.example.algaecal.stepdefinitions;

import com.example.algaecal.teststeps.ProductBundlePageTestSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

/** Step definitions related to the product bundles page */
public class ProductBundlePageStepDefinitions {
  @Steps private ProductBundlePageTestSteps productBundlePageTestSteps;

  @And("I am on the product bundles page")
  public void i_am_on_the_product_bundles_page() {
    productBundlePageTestSteps.openPage();
  }

  @When("I click on the Add to cart button for the bundle {string}")
  public void i_click_on_the_add_to_cart_button_for_the_bundle_bundleName(String bundleName) {
    productBundlePageTestSteps.clickOnAddToCartButton(bundleName);
  }

  @And("I click on the shopping cart button")
  public void i_click_on_the_shopping_cart_button() {
    productBundlePageTestSteps.clickOnShoppingCartButton();
  }
}
