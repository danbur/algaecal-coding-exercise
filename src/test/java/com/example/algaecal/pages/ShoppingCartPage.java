package com.example.algaecal.pages;

import com.example.algaecal.data.cucumber.ProductLineItem;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.FluentWait;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartPage extends PageObject {
  // Selectors for elements inside of other web elements:

  // Here I am assuming each shopping cart item has a name inside of an HTML element with the class
  // name "orderLineItemName"
  public static final String ORDER_LINE_ITEM_NAME_SELECTOR = "orderLineItemName";
  // Here I am assuming each shopping cart item has a price inside of an HTML element with the class
  // name "orderLineItemPrice" and it starts with a "$", like $123.33
  private static final String ORDER_LINE_ITEM_PRICE_SELECTOR = "orderLineItemPrice";
  // Here I am assuming each shopping cart item has a name inside of an HTML element with the class
  // name "orderLineItemName"
  public static final String ORDER_LINE_ITEM_QUANTITY_SELECTOR = "orderLineItemQuantity";

  // Top-level web elements:

  // Here, I am assuming there is a list of items and the quantity and price for each, inside of an
  // HTML element with the class name "lineItem"
  @FindBy(className = "lineItem")
  private List<WebElementFacade> lineItems;
  // Here I am assuming all of the line items appear inside of an HTML element with the name
  // "lineItemsList" and that it does not appear until the shopping cart has loaded
  @FindBy(id = "lineItemsList")
  private WebElementFacade lineItemsList;
  // Here, I am assuming the total order price appears inside of an HTML element with the id
  // "totalPrice" and that it
  // begins with a "$", such as $234.33
  @FindBy(id = "totalPrice")
  private WebElementFacade totalPrice;

  @Value("${ui.shoppingCart.itemsLoadTimeoutInMs}")
  private int itemsLoadTimeoutInMs;

  /** Waits for the line items list to become visible */
  public void waitForVisibilityOfLineItemsList() {
    new FluentWait<>(lineItemsList)
        .withTimeout(Duration.ofMillis(itemsLoadTimeoutInMs))
        .until(WebElementFacade::isVisible);
  }

  /**
   * Returns the shopping cart line items
   *
   * @return Product name/price/quantity line items
   */
  public List<ProductLineItem> getOrderLineItems() {
    List<ProductLineItem> productLineItems = new ArrayList<>();
    lineItems.forEach(
        lineItemElement -> {
          ProductLineItem productLineItem = new ProductLineItem();
          productLineItem.setProductName(
              lineItemElement.findElement(By.className(ORDER_LINE_ITEM_NAME_SELECTOR)).getText());
          productLineItem.setPriceInDollars(
              new BigDecimal(
                  lineItemElement
                      .findElement(By.className(ORDER_LINE_ITEM_PRICE_SELECTOR))
                      .getText()
                      .replace("$", "")));
          productLineItem.setQuantity(
              Integer.valueOf(
                  lineItemElement
                      .findElement(By.className(ORDER_LINE_ITEM_QUANTITY_SELECTOR))
                      .getText()));
          productLineItems.add(productLineItem);
        });
    return productLineItems;
  }

  /**
   * Returns the shopping cart total price
   *
   * @return Total price
   */
  public BigDecimal getTotalPrice() {
    return new BigDecimal(totalPrice.getText().replace("$", ""));
  }
}
