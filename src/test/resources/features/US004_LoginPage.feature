@US004
Feature: Login page should  be accessible with invalid credentials

  @US004_TC001
  Scenario: login page with valid credentials
    Given Go to login page
    And Click on account Icon
    And Click on Sign in Icon
    When User is on the login page
    Then Click on submit Icon
    Then Validate the log in the page
   @US004_TC002
  Scenario: LogOut
    Then Click on LadyGagaTeamTryCatch
    And  Click on sign out button
    And  Validate the sign out  


