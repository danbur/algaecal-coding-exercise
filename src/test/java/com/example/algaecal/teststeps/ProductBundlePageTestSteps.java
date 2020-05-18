package com.example.algaecal.teststeps;

import com.example.algaecal.pages.ProductBundlePage;
import net.thucydides.core.annotations.Step;

/** Test steps related to the product bundles page */
public class ProductBundlePageTestSteps extends BaseTestSteps {
  private ProductBundlePage productBundlePage;

  public void openPage() {
    productBundlePage.open();
  }

  @Step("Click on the add to cart button for the product bundle {}")
  public void clickOnAddToCartButton(String bundleName) {
    productBundlePage.clickOnAddButton(bundleName);
  }

  @Step("Click on the shopping cart button")
  public void clickOnShoppingCartButton() {
    productBundlePage.clickOnShoppingCartButton();
  }
}
