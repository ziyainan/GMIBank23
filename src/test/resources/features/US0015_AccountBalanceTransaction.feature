@Account
Feature: account feature

  Background:

    Given User sigin as an employee






  Scenario:account
    When user click the manage accounts
    Then user can see all types of accounts

  Scenario: balances
    When user click the manage accounts
    Then user can see all balances

  Scenario: balances
    Then user see the transaction
