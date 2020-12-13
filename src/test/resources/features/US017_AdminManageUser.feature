@US017_AdminManageUser
  Feature: System should allow the Admin to manage users
    Background: user is on the page

      Given user is on the website
      And user signs in as an admin "username" and "password"
      And user goes to Administration module and goes to User management segment

      @US017_TC01
      Scenario: role user
        Given admin activates the role as user with login name pixie

      @US017_TC02
      Scenario: role employee
        Given admin activates the role as employee with login name pixie_employee

      @US017_TC03
      Scenario: role manager
        Given admin activates the role as manager with login name pixie_manager

      @US017_TC04
      Scenario: role admin
        Given admin activates the role as admin with login name pixie_admin

      @US017_TC05
      Scenario: view all user info
        Then admin clicks on View button and verify all user info

      @US017_TC06
      Scenario: edit all user info
        Then admin clicks on Edit button and edit all user info

      @US017_TC07
      Scenario: delete all user info
        Then admin clicks on Delete button and delete all user info