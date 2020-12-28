@US021
Feature: System should allow to read countries using api end point "https://www.gmibank.com/api/tp-countries"
  Background: Read all countries you created
    When In Countries user sets all response using end point "https://www.gmibank.com/api/tp-countries"
    And In Countries user deserialization data json to java pojo
  Scenario: TC001 Validate them from your data set
    Then In Countries user validates data
  Scenario: TC002 Validate them 1 by 1
   Then In Countries user validates data 1 by 1