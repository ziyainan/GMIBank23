@LoginValid
Feature: login page feature

  @US004_TC01

  Scenario Outline: go to registration
    Given time to go login page
    And user provides username "<username>" and password "<password>"
    Then time to go login page

    Examples:
      | username | password |
      | Memo   | 123456  |

  @US004_TC02
  Scenario: go to registration
    Given time to go login page
    Then time to cancel logs in