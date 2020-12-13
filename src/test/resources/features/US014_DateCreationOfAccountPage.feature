@DateCreation

Feature: Date of Account cretaion can not be earlier than current date

  Background: Employee is on the GMI BankWeb Page
    Given Employee is on GMI Bank webpage
    Then User click on login icon
    Then User click on sign in
    Then User signs in as an employee with "username" and "password"
    Then User click on sign in button
    Then User click on My Operation

    @US014_TC001
    Scenario: Date can not be earlier account creation
      Then Click on Manage Accounts
      Then Click on Create a new Account
      And User fills "description" and "balance" fields
      Then User click on date picker box and send an "previous_date"
      And user click on save button
#      Then user scroll dowmn the buttom
  Then find the created element


