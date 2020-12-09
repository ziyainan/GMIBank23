@Registration
Feature: System should allow any user to register with valid credentials

  @RegistrationPage
  Scenario: Go to gmibank web page
    Given Main web page for the gmi bank "https://www.gmibank.com"
    Given user should click icon first then click register
    And user should fill in the SSN box with given SSN
    And there should be a valid name for the first name
    And there should be valid name for the last name
    And provide address box with valid address and zip code
    And user should provide a valid ten digit valid phone number
    And Enter user name
    And provide a valid email in to the email box
    And user should provide a valid password at any length using char and digits
    And user enters New password confirmation
    And user clicks register button
    Then validate the success message
