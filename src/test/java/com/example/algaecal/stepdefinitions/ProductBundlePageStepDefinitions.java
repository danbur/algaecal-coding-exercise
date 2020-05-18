package com.example.algaecal.stepdefinitions;

import cucumber.api.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class ProductBundlePageStepDefinitions {
    @And("I am on the product bundles page")
    public void i_am_on_the_product_bundles_page() {
        throw new PendingException();
    }

    @When("I click on the Add to cart button for the bundle {string}")
    public void i_click_on_the_add_to_cart_button_for_the_bundle_bundleName(String bundleName) {
        throw new PendingException();
    }

    @And("I click on the shopping cart button")
    public void i_click_on_the_shopping_cart_button() {
        throw new PendingException();
    }
}
