Feature: Add product to the shopping cart
  As a User of the online shop
  I want to select any product
  and add that product to the shopping cart
  Scenario: User adds a product to the shopping cart
    Given The users enters to the online shop new experience
    When  The user searches a 'blouse'
    And   The users adds the item to the shopping cart
    Then  The product is added successfully

