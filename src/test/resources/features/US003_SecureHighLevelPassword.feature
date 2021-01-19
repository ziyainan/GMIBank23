@US003_TC001
  Feature: "There should be at least 1 lowercase char for stronger password and
    see the level chart change accordingly"

  Scenario Outline: Password with at least one lowercase

    Given Go to GMIBANK dashboard
    And   Navigate to registration page
    And   Click on new password textbox
    When  Type the "<password>"
    Then Validate level chart change accordingly


    Examples:
              |password |
              |12345cKT/|
