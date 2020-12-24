@AllCustomerData
Feature: Test all customer`s data

    Background: api end point is being set in response
        Given user provides the api end point to set the response using "https://www.gmibank.com/api/tp-customers"

    @customerDataTest
    Scenario: Validate All Customer`s data
        Given manuplate all customer`s data
        And user sets the data in correspondent files
        Then user validate all data
        And as a user i want to print All userName  as a pdf file