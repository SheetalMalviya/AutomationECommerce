Feature: Account Page Functionality

  Background:
    Given User is on Login Page
    When User enters credentials on login page
      | EmailId               | Password  |
      | sheetal8815@gmail.com | Sairam@45 |

  Scenario: Verify Account page Title
    Given User is on Accounts Page
    Then The title of the accounts page is "My account - My Shop"

  Scenario: Verify My Account Section List and Count
    Given  User is on Accounts Page
    Then The account section list has items in below Order
      | ADD MY FIRST ADDRESS      |
      | ORDER HISTORY AND DETAILS |
      | MY CREDIT SLIPS           |
      | MY ADDRESSES              |
      | MY PERSONAL INFORMATION   |
      | Home                      |
    And Then The Account section has 6 items
