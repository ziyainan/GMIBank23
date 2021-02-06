@US021
  Feature: "System should allow to read all countries info using api end point
    ""https://www.gmibank.com/api/tp-countries""

    @US021_TC001
    Scenario Outline: Create new Countries
      Given User create new countries using in api end point "<url>", "<idJson>" , "<nameJson>"

      Examples:   create country
        |url|idJson|nameJson|
        |https://www.gmibank.com/api/tp-countries| name  | France |


    Scenario: User read all country you created
    Given user read all countries and sets response using api end point "https://www.gmibank.com/api/tp-countries"
    Then User deserialization countries data json to pojo

   @US021_TC002
    Scenario: Read all countries you created and validate them 1 by 1
      Given user read all countries and sets response using api end point "https://www.gmibank.com/api/tp-countries"
      Then user validates all countries you created

