package com.example.algaecal.stepdefinitions;

import cucumber.api.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ShoppingCartPageStepDefinition {
    @Then("I should see {int} items on the shopping cart page")
    public void i_should_see_numberOfItems_items_on_the_shopping_cart_page(int numberOfItems) {
        throw new PendingException();
    }

    @And("the shopping cart total should be ${int}")
    public void the_shopping_cart_total_should_be_totalPrice(int totalPrice) {
        throw new PendingException();
    }
}
