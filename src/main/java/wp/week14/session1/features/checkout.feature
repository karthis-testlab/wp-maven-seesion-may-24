Feature: Checkout Page Data

  Background: Saucelab demo site lauch and login flow
    Given saucelab demo registered user entered the login page
    And the user enters the valid username "standard_user" and "secret_sauce" password
    And the user clicks on the login button

  @smoke @regression
  Scenario: Validate the data added in the checout page
    Given user select the first product in the inventory page
    And user goto add cart page and confirm the product name
    When the user clicks on the checout page
    And the user enters their personal information
      | John | King | 45782 |
    And click on the contiue button
    Then validate the information displayed in the checout area

  @regression
  Scenario Outline: Validate the data added in the checout page based on the given product selection
    Given the user selects given <productName> product name from inventory list
    And user goto add cart page and confirm the product name
    When the user clicks on the checout page
    And the user enters their personal information
      | John | King | 45782 |
    And click on the contiue button
    Then validate the information displayed in the checout area

    Examples: 
      | productName              |
      | Sauce Labs Bike Light    |
      | Sauce Labs Fleece Jacket |
