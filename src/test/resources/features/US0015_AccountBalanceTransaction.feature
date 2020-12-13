@Account
Feature: account feature

  Background:
    Given User sign in as a user
    And Click on my operation dropdown menu button
    And click on my accounts button
    When click on my accounts button

  Scenario:User should see all account types populated
    Then user see all accounts type

    Scenario:User should see balance populated
      Then user see all balance
@last
      Scenario: user can view transaction
        When user click on view transaction button, user should see transaction