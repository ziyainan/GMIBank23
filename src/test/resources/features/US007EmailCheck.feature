@Email
Feature: email check feature
  Background:
    Given user go to the login page
    And user login as an admin by username "Sunny" password "Jsunny34*"
    And user click the user info and navigate user setting page

  Scenario Outline: email
    When user enter an email "<email>" which is not contain . extension
    Then system displays This field is invalid.


    Examples:
      | email |
      |admin20@gmailcom|
      |admin20gmail.com|

  Scenario: language
    When user click the language bar
    Then user there is only two language options and these are English or Turkish