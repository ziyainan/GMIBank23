@Password
  Feature: password feature

   Background:

   Given user go to registration




    Scenario Outline:test1


      When user provides password "<password>"
    Then user see the level  chart change accordingly



      Examples:
        | password |
        | ASDEWQr  |
        | 123456q  |
        | @#$%^&q  |
        | asdqweR  |
        | 123456Q  |
        | @#$%^&Q  |
        | asdqwe1  |
        | ASDEWQ1  |
        | @#$%^&1  |
        | asdqwe#  |
        | ASDEWQ#  |
        | 123456#  |


    Scenario Outline:test2
      When user provides password "<password>"
      Then user can't see the level  chart change accordingly


      Examples:
        | password |
        | ASDEWQR  |
        | 1234567  |
        | @#$%^&*  |
        | asdqwer  |


    Scenario Outline:test3

      When user provides least 7 chars for a stronger password "<password>"
      Then user see the stronger password

      Examples:
        | password |
        | As1Qw#$  |

    Scenario Outline:test4

      When user provides less than 7 chars for a stronger password "<password>"
      Then user can not see the stronger password

      Examples:
       | password |
       | As1Qw#  |
