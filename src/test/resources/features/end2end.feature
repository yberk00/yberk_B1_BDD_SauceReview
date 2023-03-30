@wip
Feature: Login and E2E Test
  Scenario: Login and End to End Test
    Given The user is on the login page
    When The user enters "standard_user" and "secret_sauce"
    Then The suer should be anle to login and see "Products"
    And The user should be able to sort products "Price (high to low)"
    When The user clicks the cheapest as "7.99" and second costline as "29.99" products
    Then The user click cart button and click checkout button
    And The user enters details as "Ahmet" "Falanca" "34000"
    And The user click continue button
    Then The user verifys that the items are "41.02" and total is "Total: $41.02"
