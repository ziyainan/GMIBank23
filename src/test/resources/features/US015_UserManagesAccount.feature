@US015
Feature: System should allow user to manage their account

  Background:
    Given I login as a user
    And Click on My Operations dropdown
    And Select My Accounts

  Scenario: User should see all account types and balance populated
    Then I should see all account types and balance

  Scenario: User can view transaction
    Then I should see transactions
