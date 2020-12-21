@Country
  Feature: check country and add

    Scenario: check country
      Given I perform GET operation for end_point "https://www.gmibank.com/api/tp-countries"
      Then I should see all the countries

    Scenario: Add country
      Given I perform POST operation for end_point "https://www.gmibank.com/api/tp-countries"
      Then I should get success added message