package com.example.algaecal.teststeps;

import com.example.algaecal.data.cucumber.ProductLineItem;
import com.example.algaecal.pages.ShoppingCartPage;
import net.thucydides.core.annotations.Step;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/** Test steps related to the shopping cart page */
public class ShoppingCartPageTestSteps {
  private ShoppingCartPage shoppingCartPage;

  @Step("Wait for the shopping cart to load")
  public void waitForShoppingCartToLoad() {
    // Here I am assuming that the line items could take a little while to load, and we have to wait
    // for them to appear
    // before performing any verifications on the cart
    shoppingCartPage.waitForVisibilityOfLineItemsList();
  }

  @Step("Verify that the item {} is present in the cart")
  public void verifyItemIsPresentInCart(ProductLineItem expectedItem) {
    List<ProductLineItem> shoppingCartItems = shoppingCartPage.getOrderLineItems();
    assertThat(shoppingCartItems)
        .as(
            "The shopping cart should contain an item with the name \"%s\", price $%s, and quantity %d",
            expectedItem.getProductName(),
            expectedItem.getPriceInDollars(),
            expectedItem.getQuantity())
        .contains(expectedItem);
  }

  @Step("Verify that the total price is ${}")
  public void verifyTotalPrice(BigDecimal expectedPrice) {
    assertThat(shoppingCartPage.getTotalPrice())
        .as("The total price should be equal to $%s", expectedPrice)
        .isEqualTo(expectedPrice);
  }
}
