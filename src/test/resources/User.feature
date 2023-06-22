Feature: New user Onboarding
  Scenario: New user creation
    Given the user api has triggred
    When  checking user exist
    And new user created
    Then duplicate record rejected
