@US021X
  Feature: "System should allow to read all countries info using api end point
    ""https://www.gmibank.com/api/tp-countries"" "

    @US021_TC001_2
  Scenario Outline: Create new Countries
    Given User create new countries using in api end "<endpoint>" "<name>" "<state>"
    #Then User deserialization countries data json to pojo

      Examples:

      |state | endpoint                                      |name  |
      |Texas | point https://www.gmibank.com/api/tp-countries|France|

    @US021_TC002_2
  Scenario: Read all countries you created and validate them 1 by 1
    Given user read all countries and sets response using api end point "https://www.gmibank.com/api/tp-countries"
    Then user validates all countries data