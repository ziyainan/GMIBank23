@US011
Feature: Date should be created on the time of customer creation

  Background: GMI Bank website
    Given I visit GMI Bank
    And I sign in as valid employee
    And I select My Operations Menu -> Management Customers -> Create New Customer
    And Fill out necessary information

  @TC001
  Scenario: TC001 The date cannot be typed in the future at the time of creation of a customer
    Then Created date should be in the future
    And it should not save it

  @TC002
  Scenario: TC002 The date cannot be typed in the past at the time of creation of a customer
    Then Created date should be in the past
    And it should not save it

  @TC003
  Scenario: TC002 The date should be created as month, day, year, hour and minute
    Then Created date should be as month, day, year, hour and minute
    And save it

  @TC004
  Scenario: TC004 User can choose a user from the registration and it cannot be blank
    When User can choose a user from the registration and leave it as be blank
    Then it should not save it

  @TC005
  Scenario: TC005 There user can choose an account created on manage accounts
    When There user can choose an account created on manage accounts
    Then save it

  @TC006
  Scenario: TC006 User can select Zelle Enrolled optionally and save it
    When User can select Zelle Enrolled optionally
    Then save it

