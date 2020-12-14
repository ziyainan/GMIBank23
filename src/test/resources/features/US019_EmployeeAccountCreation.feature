@US019
Feature: Date should be created on the time of customer creation

  Background: GMI Bank website
    Given I visit GMI Bank
    And I sign in as valid employee
    And I select My Operations Menu -> Manage Accounts -> Create a new Account

  @TC001
  Scenario: TC001 User should create a description for the new account and it cannot be blank
    Then Click and leave the description field blank
    And Check error message

  @TC002
  Scenario: TC002 User should provide a balance for the first time account creation as Dollar
    Then Balance field shouldn't accept letters, symbols or leaving blank
    And Check error message

  @TC003
  Scenario: TC003 User can select an account type as CHECKING, SAVING, CREDIT_CARD or INVESTING
    Then Check available account types

  @TC004
  Scenario: TC004 Account status should be defined as ACTIVE, SUSPENDED or CLOSED
    Then Check available account statuses

  @TC005
  Scenario: TC005 User can select an employee from the drop-down
    Then Check available employee options

