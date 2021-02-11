@US029
Feature:   user page with database validation

  Background: create a connection with GMI Bank Database
    Given user connecting GMI database

  @TC_2901
  Scenario Outline: All users info (user, employee, manager and admin) should be retrieved
  by database and validated
    And user read all  data from database "<query>"
    Examples:
    |query|
    |select * from tp_customer;|

  Scenario Outline: Check all column Data
      Given  user provides "<query>" and "<columnName>" nad gets column data
      Then user validate all column data

      Examples:  all data set
    |query                      |columnName|
    |select * from tp_customer; |  id      |

    @pdf1
  Scenario Outline: Check all column Data2
    Given  user provides "<query>" and "<columnName1>" "<columnName2>" "<columnName3>" "<columnName4>" nad gets column data
    And user print all column data
    Examples:  all datas set
      |query                      |columnName1| columnName2|columnName3|columnName4|
      |select * from tp_customer; |first_name |  ssn       |state     |zip_code   |

  @TC_2902
  Scenario Outline:  All countries' info should be retrieved by database and validated

    And user read all countries info from database "<query>"
    Then user validate all countries info
  Examples:
         |query|
         |select * from tp_country;|
#
#  @TC_2903
#  Scenario: All states should related to USA should be  retrieved by database and validated
#    And  user read all states of related  to USA from database
#    Then  user validate all states of  related to USA
