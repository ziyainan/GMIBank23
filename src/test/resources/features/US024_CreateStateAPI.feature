@US24CreateState
Feature: Create a new state
  Background: API endpoint is being set to response
    Given user provides the Api endponit to set the response "https://www.gmibank.com/api/tp-countries"

    Scenario: read all states
      Given user deserializes all states to pojo
      And user generates all states' data in correspondent files
      Then user validates data for all states