@US_006_SmokeTest
Feature: User info segment (User Settings) should be editable on Homepage

  Background: User navigate user info page
    Given user signIn with valid credentials
    And user clicks username validentions
    Then user clicks user info Button

  @US_006_TC1
  Scenario: There should be user info being populated when navigating to user info "firstname, lastname email and language"
    When user click the firstname Text box
    And Get the firstname from firstname Text box
    When user click the lastname Text box
    And Get the lastname from lastname Text box
    When user click email box
    And Get the email from email Text box
    And Get the language from language Text box
    Then Verify all boxes are not null

  @US_006_TC2
  Scenario: There should be 2 languages available "English and Turkish"
    Given Clicks the language dropdown menu
    Then Verify the English and Turkish is available

  @US_006_TC3
  Scenario: There should be an option to update firstname
    Given user enters firstName "Team26New"
    And user clicks save button
    And And user clicks username validentions
    Then user clicks signOut Button

  @US_006_TC4
  Scenario: There should be an option to update lastname
    Given user enters lastName "Hello"
    And user clicks save button
    And And user clicks username validentions
    Then user clicks signOut Button

  @US_006_TC5
  Scenario Outline: There should be an option to update email id adding "@" sign and ".com" extension
    Given user enters email "<email>"
    And user clicks save button
    And And user clicks username validentions
    Then user clicks signOut Button
    Examples:
      | email             |
      | 26Team@yahoo.com  |
      | 26Team@yandex.com |