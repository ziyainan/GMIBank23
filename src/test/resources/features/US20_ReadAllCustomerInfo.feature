@CustomersGMI
Feature:Test all Costumers

  Background:api end point is set up for response
    Given user provides the api end point to set the response "https://www.gmibank.com/api/tp-customers"

  @CustomerDataTest
  Scenario:validate all costumers data
    And validate them from your data set
