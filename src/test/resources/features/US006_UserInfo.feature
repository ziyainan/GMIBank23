@US006_UserInfo
  Feature: User info segment (User Settings) should be editable on Homepage

    Background: User info should be populated
      Given user is on the website
      And user signs in as an employee "username" and "password"
      And user goes to User Info segment and click on it

      @US06_TC01
      Scenario: verifying all infos are populated
        Then verify firstname, lastname, email and language is populated

      @US06_TC02
      Scenario: verifying two languages
        Then verify there are two languages available from dropdown

      @US06_TC03
      Scenario: update the first name
        Then update the firstname and click on Save button

      @US06_TC04
      Scenario: update the last name
         Then update the lastname and click on Save button

      @US06_TC05
      Scenario: update the email
         Then update the email with @ and . sign and click on Save button



