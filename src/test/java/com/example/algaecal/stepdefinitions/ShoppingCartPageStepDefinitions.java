package com.example.algaecal.stepdefinitions;

import com.example.algaecal.data.cucumber.ProductLineItem;
import com.example.algaecal.teststeps.ShoppingCartPageTestSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;

import java.math.BigDecimal;
import java.util.List;

public class ShoppingCartPageStepDefinitions {
  @Steps private ShoppingCartPageTestSteps shoppingCartPageTestSteps;

  @And("the shopping cart total should be ${float}")
  public void the_shopping_cart_total_should_be_totalPrice(BigDecimal totalPrice) {
    shoppingCartPageTestSteps.verifyTotalPrice(totalPrice);
  }

  @Then("I should see the following items on the shopping cart page:")
  public void iShouldSeeTheFollowingItemsOnTheShoppingCartPage(
      List<ProductLineItem> productLineItems) {
    shoppingCartPageTestSteps.waitForShoppingCartToLoad();
    productLineItems.forEach(item -> shoppingCartPageTestSteps.verifyItemIsPresentInCart(item));
  }
}
