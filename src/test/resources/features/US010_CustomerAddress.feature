
@CreateCustomer

Feature: CreateCustomer feature

  Background:
    Given User goes signing page
    And user provides username, "Team26Employee" and password "Team26Employee*"
    And user click on manage customer button
    And user Click on Create New Customer Button

  @US010_TC001
  Scenario: Provide City
    Given user provides city


  @US010_TC002
  Scenario: Provide Country
    Given user provides country

  @US010_TC001
  Scenario: Provide States
    Given user provides state


