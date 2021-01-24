
@SearchbySSN

Feature: SearchbySSN feature

  Background:
    Given User goes signing page
    And user provides username, "Team26Employee" and password "Team26Employee*"
    And user click on manage customer button
    And user Click on Create New Customer Button


  @CreateCustomer
  Scenario: go to GMIBank

    Given user provides SSN "546-43-6574"
    And user clicks search button
    Then system displays customer info

