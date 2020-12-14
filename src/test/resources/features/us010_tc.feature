@us001tc010
Feature: Address should be provided and cannot be left blank


  Background:
    Given I as a user navigate to GMI bank webPage
    And I as a user click to login sign
    And I as a user choose sign from dropdown menu
    When I as a user enter my UserName and Password in to opened frame
    Then I click sign in button and sign in

  Scenario: Adress file provided
    Then I click to My Operation button
    Then I click to Manage Customers link
    Then I Click on Create a new Customer buttun to navigate Create Customer page
  #  Then I Enter a Valid SSN number
    Then I Enter a valid First Name
    Then I Enter a valid last name
    Then I Enter a valid middle name
    Then I Enter a valid email
    Then I Enter a valid mobile phone number
    Then I Enter a valid phone number
    Then I Enter a valid Zip Code

    Then I Enter a valid City name
    Then I Enter a valid SSN number
    Then I Enter a valid State name
    Then I Enter a valid Country name

    Then I Enter a valid Adress including a Street Number
    And I clisk Save Button