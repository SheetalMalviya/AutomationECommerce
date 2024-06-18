Feature: Address Page Validation

  Scenario: Enter data in all mandatory fields
    Given when user is on address page
    When user enters "whitestone" in address field

  Scenario:
    Given User is on Address Page
    Then The page title should be "Addgitress -My Shop"