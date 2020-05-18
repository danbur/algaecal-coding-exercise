@AddBundleToCart
Feature: Add to cart button for bundles
  As a customer,
  I would like to have an add cart button for bundles
  So that I can add the bundle to my cart and purchase the items

  Scenario: Add a bundle to the cart
    Given I have a bundle "6 Month Supply" with the following items and a discount of $216:
      | productName     | priceInDollars | quantity |
      | AlgaeCal Plus   | 40             | 6        |
      | Strontium Boost | 45             | 6        |
    And I am on the product bundles page
    When I click on the Add to cart button for the bundle "6 Month Supply"
    And I click on the cart button
    Then I should have 12 items in my cart
    And the cart total should be $294