@US005
Feature: Login page should not be accessible with invalid credentials

  Background: access login page
    Given I visit login page
    And click on Sign in icon
@TC_001
  Scenario Outline: login page with invalid username
    When I enter invalid "<username>"
    Then Validate the error message
    Examples:
      | username |
      | invalid  |
      | whoAmI   |
      | user123  |
      | nope     |
      | Pretty   |
      | 132945   |
      | S2945h   |
@TC_002
  Scenario Outline: login page with invalid password
    When I enter valid username but invalid "<password>"
    And click on sign in button
    Then Validate the error message

    Examples:
    |password     |
    |S6873s       |
    |bn45         |
    |1238246      |
    |asdf         |
    |asdfghjkl    |
    |ASDFGHJKL    |

  @TC_003
  Scenario Outline: login page with invalid username and password
    When I enter invalid "<username> "but invalid "<password>"
    And click on sign in button
    Then Validate the error message

    Examples:
      |password     |username      |
      |S6873s       |invalid       |
      |bn45         |Pretty        |
      |1238246      |whoAmI        |
      |asdf         |132945        |
      |asdfghjkl    |S2945h        |
      |ASDFGHJKL    |user123       |

  @TC_004
  Scenario:
    Given Validate reset password option

  @TC_005
  Scenario:
    Given Validate the navigate to register page



  @TC_006
  Scenario: login page with empty username
    When I enter empty username
    And click on sign in button
    Then Validate the error message
    Then Validate the user check


  @TC_007
  Scenario: login page with empty password
    When I enter empty password
    And click on sign in button
    Then Validate the error message
    Then Validate the password check


  @TC_008
  Scenario: login page with empty username and password
    When I enter empty username and empty password
#    And click on sign in button
    Then Validate the error message
    Then Validate the user and password check








