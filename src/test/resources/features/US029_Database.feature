@us29
Feature: Turkers
  Background: connections
    Given user connects database

  Scenario: TC_001_user customer reads data template.
    And user communicates with customer data and "145-76-9874" asserts

  Scenario: TC_002_user admin reads data template.
    And user communicates admin data and asserts

  Scenario: TC_003_user reads employee data template.
    And user communicates employee and asserts

  Scenario: TC_004 country.
    And user communicates with country data and asserts

  Scenario: TC_005_user reads state data template.
    And user communicates with  state data and asserts