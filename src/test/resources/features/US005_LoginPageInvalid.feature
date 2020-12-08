@US005_TC001
Feature: Login page should not be accessible with invalid credentials

  Scenario Outline: login page with invalid username
    Given I visit login page
    And click on Sign in icon
    When I enter invalid "<username>"
    Then Validate the error message
    Examples:
      | username |
      | invalid  |
      | whoAmI   |
      | user123  |
#      | nope     |
#      | Pretty   |
#      | 132945   |
#      | S2945h   |




