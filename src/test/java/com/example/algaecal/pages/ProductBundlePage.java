package com.example.algaecal.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;
import java.util.Optional;

/** Page object for the Product bundle page */
@DefaultUrl("http://example.com/bundles")
public class ProductBundlePage extends PageObject {
  // Here I am assuming there is some page where you can view all product bundles that are currently
  // available
  // The base URL can be overridden with the webdriver.base.url property.

  // Selectors for elements within other web elements:

  // Here I am assuming that the bundle name is inside an HTML element whose ID is something like
  // "product-bundle-name-for-123423" (where the last part varies by bundle)
  public static final String PRODUCT_BUNDLE_NAME_SELECTOR = "*[id^=product-bundle-name-for-]";
  // Here I am assuming that the add button name is inside an HTML element whose classname is
  // something like "add-button-for-123423" (where the last part varies by bundle), inside of a div
  // with the classname "bottomBar"
  //
  // This is just to give an example of what I might do if there were multiple add buttons with the
  // same class name, one hidden, and one active, and I had to find the right one.
  private static final String PRODUCT_BUNDLE_ADD_BUTTON_SELECTOR =
      "div.bottomBar *[class^=add-button-for-]";

  // Top-level web elements:

  // Here, I am assuming there is a list of product bundles, each one inside of a box HTML element
  // with the class name
  // "bundleContainer"
  @FindBy(className = "bundleContainer")
  private List<WebElementFacade> bundles;
  // Here, I am assuming there is a shopping cart button with the ID "cartButton"
  @FindBy(id = "cartButton")
  private WebElementFacade shoppingCartButton;

  /**
   * Click on the Add button for the provided bundle name
   *
   * @param bundleName Bundle name
   */
  public void clickOnAddButton(String bundleName) {
    Optional<WebElementFacade> optionalBundleElement =
        bundles.stream()
            .filter(
                bundle ->
                    bundle
                        .findElement(By.cssSelector(PRODUCT_BUNDLE_NAME_SELECTOR))
                        .getText()
                        .equals(bundleName))
            .findFirst();
    if (optionalBundleElement.isEmpty()) {
      throw new NoSuchElementException("No bundle with the name \"" + bundleName + "\" was found");
    }
    optionalBundleElement
        .get()
        .findElement(By.cssSelector(PRODUCT_BUNDLE_ADD_BUTTON_SELECTOR))
        .click();
  }

  /** Clicks on the shopping cart button */
  public void clickOnShoppingCartButton() {
    shoppingCartButton.click();
  }
}
