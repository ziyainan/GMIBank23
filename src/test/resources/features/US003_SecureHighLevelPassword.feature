@US003
  Feature: "Registration page should restrict password usage to a secure
    and high level passcode"

    @US003_TC001
    Scenario Outline: Password with at least one lowercase
      Given Go to GMIBANK dashboard
      And   Navigate to registration page
      And   Click on new password textbox
      When  Type the TCOne"<password>"
      Then Validate level chart change accordingly

    Examples:
              |password |
              |12345cKT/|

    @US003_TC002
    Scenario Outline: Password with at least one uppercase

      Given Go to GMIBANK dashboard
      And   Navigate to registration page
      And   Click on new password textbox
      When  Type the TCTwo"<password>"
      Then Validate level chart change accordingly

      Examples:
        |password |
        |12345Abc/|

    @US003_TC003
    Scenario Outline: There should be at least 1 digit  and see the level  chart change accordingly

      Given Go to GMIBANK dashboard
      And   Navigate to registration page
      And   Click on new password textbox
      When  Type the TCThree"<password>"
      Then Validate level chart change accordingly


      Examples:
        |password |
        |abcdefg/1|

    @US003_TC004
    Scenario Outline:There should be at least 1 special char and see the level bar change accordingly

      Given Go to GMIBANK dashboard
      And   Navigate to registration page
      And   Click on new password textbox
      When  Type the TCFour"<password>"
      Then Validate level chart change accordingly
      Examples:
        |password |
        |12345ABbc&|

    @US003_TC005
    Scenario Outline: There should be at least 7 chars for a stronger password
      Given Go to GMIBANK dashboard
      And   Navigate to registration page
      And   Click on new password textbox
      When  Type the TCFive"<password>"
      Then Validate level chart change accordingly

      Examples:
        |password |
        |12@#$%^&*|
