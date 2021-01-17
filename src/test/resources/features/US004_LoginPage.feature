@US004_TC001
Feature: Login page should  be accessible with invalid credentials

  Scenario: login page with valid credentials
    Given Go to login page
    And Click on account Icon
    And Click on Sign in Icon
    When Enter username and password
    Then Click on submit Icon
    Then Validate the log in the page
    Then Click on LadyGagaTeamTryCatch
    And  Click on sign out button
    And Validate the sign out  


