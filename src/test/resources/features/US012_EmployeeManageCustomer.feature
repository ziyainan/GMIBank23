@US012
Feature: An Employee can manage Customer
  Background: Login the account
    Given Login in the employee account
    Then Navigate to Manage Customers page


  @US012_TC001
  Scenario: All customers should show up on manage customers module
  populating the account information of the customer
  "First Name, Last Name, Middle Initial Email Mobile Phone Number
  Phone Number  Address,Create Date "

    And Validate the customer information

  @US012_TC002
  Scenario: "There should be a View option where customer can be navigated to all customer info and see
  edit button there"
    Then Validate in customer information the View option
    And User can navigate the customer information after click the View option
    And User see Edit button in customer info page

  @US012_TC003
  Scenario: The Edit portal can allow user to create or update the user info
    Then User can navigate to create or update the user info page with edit portal
    And User can create and update user info

  @US012_TC004
  Scenario: User can delete a customer, but seeing a message if the user is sure about deletion
    Then User can delete customer
    And User when delete the customer see a message about confirm deleting

