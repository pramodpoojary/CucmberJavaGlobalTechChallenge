Feature: Verify cart functionality for Magento website with multiple items and discounts

  @cart
  Scenario: The user adds and updates the items in the cart with different sizes and colors
    Given the user is on the magento homepage
    When the user adds "4" - "Gwyn Endurance Tee" with "Medium" size and "Green" color to the cart
    And the user selects "United Kingdom" as the delivery address
    Then the cart total is "$92.00"
    And the discount is applied
    When the user updates the quantity of "Gwyn Endurance Tee" to "3"
    And the user adds "1" - "Gwyn Endurance Tee" with "Small" size and "Yellow" color to the cart
    And the user adds "1" - "Quest Lumaflex™ Band" to the cart
    And the user navigates to checkout page
    Then the cart total is "$116.00"
