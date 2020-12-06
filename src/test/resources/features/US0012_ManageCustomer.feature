@US0012_ManageCustomer
  Feature: An Employee can manage Customer
Background: US0012
  Given user is on the website
  And user signs in as an employee "username" and "password"
  And user goes to Manage Customers module on My Operations link

  @US0012_TC01
  Scenario: verifying customer's info populated
    Then verify all customer info has been populated

  @US0012_TC02
  Scenario: verifying view option
    Then verify there is View button

  @US0012_TC03
   Scenario: verifying edit button
    Then verify Edit button is on the Customer information page

   @US0012_TC04
    Scenario: updating from edit portal
     Then edit the first name, mobile phone number and account type

   @US0012_TC05
    Scenario: deleting a customer
      Then user clicks on Delete button and verifies deleting message has poped up




