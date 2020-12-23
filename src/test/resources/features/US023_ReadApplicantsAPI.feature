@US023
Feature:System should allow to read all Applicants using api end point

  Background: Read all applicants you created
    When user sets all applicants response using end point "https://www.gmibank.com/api/tp-account-registrations"

  Scenario: TC001 Validate them from your data set
    Then user validates all applicants data
#
#  Scenario: TC002 Validate them 1 by 1
#    Then user validates data 1 by 1



