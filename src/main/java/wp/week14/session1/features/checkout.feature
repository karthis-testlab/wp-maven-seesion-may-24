Feature: Checkout Page Data

  Scenario: Validate the data added in the checout page
    Given saucelab demo registered user entered the login page
    And the user enters the valid username "standard_user" and "secret_sauce" password
    And the user clicks on the login button
    And user select the first product in the inventory page
    And user goto add cart page and confirm the product name
    When the user clicks on the checout page
    And the user enters their personal information
    And click on the contiue button
    Then validate the information displayed in the checout area
