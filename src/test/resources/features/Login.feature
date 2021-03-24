@login
  Feature: Sauce Demo Login

    Scenario: Login with valid username and password
      Given user is on the login page
      When user enters valid username and password
      Then I validate that user is logged in