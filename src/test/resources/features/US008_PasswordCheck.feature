@US008
Feature: User Update password

  Background: US008
    Given User Go to Home Page
    Then User click Sign in button
    Then User enter Username and Password
    Then User click Sign in Box
    And User click password
    And User enter Current password

  Scenario Outline: TC001 User Should not add old password
    Given Enter new password like the same old password "<password>"
    Then Check the new password different than old one
    Examples:
      | password|
      | Team26User*|

  Scenario Outline: TC002 User add new password diffrent than old one
    Given Enter the new password diffent then old one "<password>"
    Then Compare the new pasword is diffrent than old one
    Examples:
      | password|
      | 26TeamUser*|

  Scenario Outline: TC003 User add new password with at least 1 lowercase
    Given Enter the new password with at least one lowercase "<password>"
    Then User see full password strength
    Examples:
      | password|
      |TEAM26USEr*|

  Scenario Outline: TC004 User add new password without lowercase
    Given Enter the new password without lowercase "<password>"
    Then User not see full password strength
    Examples:
      | password|
      | STARTEAM23/|


  Scenario Outline: TC005 User add new password with at least 1 uppercase
    Given Enter the new password with at least one uppercase "<password>"
    Then User see full password strength
    Examples:
      | password|
      | Starteam23/|

  Scenario Outline: TC006 User add new password without uppercase
    Given Enter the new password without uppercase "<password>"
    Then User not see full password strength
    Examples:
      | password|
      | starteam23/|

  Scenario Outline: TC007 User add new password with at least 1 digit
    Given Enter the new password with at least one digit "<password>"
    Then User see full password strength
    Examples:
      | password|
      | Starteam2/|

  Scenario Outline: TC008 User add new password without digit
    Given Enter the new password without digit "<password>"
    Then User not see full password strength
    Examples:
      | password|
      | Starteam/|

  Scenario Outline: TC009 User add new password with at least 1 special chracter
    Given Enter the new password with at least one special chracter "<password>"
    Then User see full password strength
    Examples:
      | password|
      | Starteam2/|

  Scenario Outline: TC010 User add new password without special character
    Given Enter the new password without special character "<password>"
    Then User not see full password strength
    Examples:
      | password|
      | starteam23|

  Scenario Outline: TC011 User add new password with at least 7 character
    Given Enter the new password with at least seven character "<password>"
    Then User see full password strength
    Examples:
      | password|
      | Start2/|

  Scenario Outline: TC012 User add new password with less than 7 character
    Given Enter the new password with less than seven character "<password>"
    Then User not see full password strength
    Examples:
      | password|
      | Star2/|

  Scenario Outline: TC013 User Enter comfirm password same like new password
    Given Enter the new password "<new password>"
    Then Enter the confirm password "<confirm password>"
    And Compare the new and confirm password are same
    Examples:
      | new password| confirm password|
      | 23Starteam/ | 23Starteam/     |

  Scenario Outline: TC014 User Enter comfirm password different than new password
    Given Enter the new password "<new password>"
    Then Enter the confirm password whic diffrent than new password "<confirm password>"
    And Check the error message
    Examples:
      | new password| confirm password|
      | 23Starteam/ | 23Starteam      |
