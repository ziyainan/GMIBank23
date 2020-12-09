@employeeAccount
Feature: Employee Create New Account

    Background: Employee is on the GMI BankWeb Page
      Given Employee is on GMI Bank webpage
      Then Employee sign in
      Then User click on My Operation
      Then Click on Manage Accounts
      Then Click on Create a new Account

  @tc001
  Scenario: TC_001 User provides valid Description
    And Enter Description "Ziya Test"
    Then Fill all fields except description
    Then Click on save
    Then Account Create Successful

  @tc002
  Scenario: TC_002 User leaves Description Blank
    And Leave Description Blank
    Then Fill all fields except description
    Then Click on save
    Then User see error message

  @tc003-004
  Scenario Outline: TC_003/004 User provides Positive Balance Amount
    And User enter amount "<balance>"
    Then Fill all fields except balance
    Then Click on save
    Then Account Create Successful

    Examples: Positive Balance Amount
      |balance|
      |1      |
      |10000  |

  @tc005-006-007
  Scenario Outline: TC_005/006/007 User provides Negative & Blank Balance Amount
    And User enter amount "<balance>"
    Then Fill all fields except balance
    Then Click on save
    Then Create unsuccessful

    Examples: Negative and Blank Balance Amount
      |balance|
      |0      |
      |-500   |
      |       |

  @tc008-009-010-011
  Scenario Outline: TC_008/009/010/011 User selects different type of account
    And User select account type "<accountType>"
    Then Fill all fields except account type
    Then Click on save
    Then Account Create Successful

    Examples: Account Types
      |accountType   |
      |CREDIT_CARD   |
      |CHECKING      |
      |SAVING        |
      |INVESTING     |

  @tc012-013-014
  Scenario Outline: TC_012/013/014 User selects different Account Status Type
    And User select account Status type "<accountStatusType>"
    Then Fill all fields except account status type
    Then Click on save
    Then Account Create Successful

    Examples: Positive Balance Amount
      |accountStatusType   |
      |ACTIVE              |
      |CLOSED              |
      |SUSPENDED           |

  @tc015
  Scenario: TC_015 User Select an Employee
    And Fill all fields except employee
    Then User select an employee "Ziya Employee"
    Then Click on save
    Then Create unsuccessful