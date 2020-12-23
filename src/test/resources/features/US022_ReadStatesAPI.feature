@US022
Feature: System should allow to read states using api end point "https://www.gmibank.com/api/tp-states"

  Background: Read all states you created
    When In States user sets all response using end point "https://www.gmibank.com/api/tp-states"
    And In States user deserialization data json to java pojo

  Scenario: TC001 Validate them from your data set
    Then In States user validates data

  Scenario: TC002 Validate them 1 by 1
    Then In States user validates data 1 by 1



