@Transfer
  Feature: money transfer feature

  Background:
    Given Go to website
    And Sign in as a user username "Asimbul" and password "Asi432!"
    And Click the My Operations then click My accounts

  Scenario: Test1
    When user click the From dropdown
    Then user can see at least two account and user can choose first one

  Scenario: Test2
    When user click the To dropdown
    Then user can choose an account for sending money

  Scenario: Test3
    When user click the amount part
    Then user can enter amount of money what you want send "50"

  Scenario:Test4
    When user click the description  part
    Then user can enter description about transaction "first transfer"

    Scenario:Test5
    When user click the From dropdown and chose first account
    And user Click the To dropdown and chose one account
    And user Click the amount and enter the amount of money
    And user Click the description and enter your description about transaction "Money transfer"
    And user Click the Make transfer button
    Then System should make the transfer and give me a success message for about it.






