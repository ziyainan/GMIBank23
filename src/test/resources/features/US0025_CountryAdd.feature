@Country

  Feature:
    Background: create a new country
    Given user provide the API endpoint response "https://www.gmibank.com/api/tp-countries"

      Scenario Outline:
        Given user create a new country by endpoint "https://www.gmibank.com/api/tp-countries"  "<countryname>"
        Examples:
        |countryname|
        |Tajikistan |


        Scenario:
        And user deserialize to java
        And user add all data corresponding file
        Then user validate the country successfully created



