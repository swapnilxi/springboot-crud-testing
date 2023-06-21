Feature: Product Management
  Scenario: Create a Product
    Given the user has opened the product creation page
    When the user enters product details
    And clicks on the save button
    Then the product should be created successfully
