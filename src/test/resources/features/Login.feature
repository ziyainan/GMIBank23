@Login
  Feature: login page feature


    @login
    Scenario Outline: go to registration
      Given user goes to login page
      And user provides username "<username>" and password "<password>"
      Then user logs in

      Examples:
        | username | password |
        | admin2   | TechAdmin2  |