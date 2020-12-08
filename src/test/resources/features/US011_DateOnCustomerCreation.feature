@US011
Feature: Date should be created on the time of customer creation

  Scenario: TC001
    When I go to GMI Bank
    And Sign in as valid admin
    Then Select Administration Menu -> User Management -> Create New User
    Then Fill out valid information and Save
    Then Created date should not be in the past

