@SearchbySSN

Feature: SearchbySSN feature

Background:
  Given User goes signing page
  And user provides username, "turker" and password "turker123"
  And user click on manage customer button
  And user Click on Create New Customer Button


  @CreateCustomer
  Scenario: go to GMIBank

    Given user provides SSN "444-33-4545"
    And user clicks search button
    Then system displays customer info


  Scenario: go to GMIBank

    Given user provides SSN "   "
    And user clicks search button
    Then system displays please type SSN Number.


  Scenario: go to GMIBank

    Given user provides SSN "443-43-23453 "
    And user clicks search button
    Then system displays translation-not-found [error.SSN not found].













