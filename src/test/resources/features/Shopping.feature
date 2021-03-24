@shoppingSteps
Feature: Shopping test steps

  Scenario: custom shopping steps
    Given user is on the login page
    When user enters valid username and password
    Then user selects price low to high
    Then user should be able to adds items by clicking ADD TO CART button
    Then user clicks on SHOPPING CART icon
    And verifies that the selected items are displayed
      | Sauce Labs Onesie       |
      | Sauce Labs Bike Light   |
      | Sauce Labs Bolt T-Shirt |

    Then user should be able to remove "Sauce Labs Onesie"
    And user click on the CONTINUE SHOPPING button
    Then user should be able to add "Sauce Labs Fleece Jacket" item
    Then user clicks on SHOPPING CART icon
    And user click on the checkout button
    And user enters the following information
      | firstname    | lastname     | zipcode   |
      | testFistName | testLastName | 12345     |

    And user click on continue button
    Then user verify the items name matches with fallowing items
      | Sauce Labs Bike Light   |
      | Sauce Labs Bolt T-Shirt |
      | Sauce Labs Fleece Jacket|
    Then assert that items prizes are as expected
    |    $9.99   |   $15.99    |  $49.99     |
    Then user verifies that total price is "$75.97"

    Then when user click finish button verify that THANK YOU FOR YOUR ORDER massage is displayed.


