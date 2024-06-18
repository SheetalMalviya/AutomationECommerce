Feature: Login Page Functionalities

@Test
  Scenario: Login Page Validation
    Given User is on Login Page
    When  User gets the title of the page
    Then Page title should be "Login - My Shop"

  Scenario: Forgot Password link Validation
    Given User is on Login Page
    Then Forgot password link should be visible

  Scenario: User Login with Valid Credentials
    Given User is on Login Page
    When  User enter the username "sheetal8815@gmail.com"
    And   User enter the password "Sairam@45"
    When User clicks on Login Button
    Then  User should be able to land on accounts page and title should be "My account - My Shop"
