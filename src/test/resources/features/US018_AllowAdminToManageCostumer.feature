@US018
Feature:  should allow admin to manage costumer

  Scenario: Go to Gmi Bank Web page
    Given Go to Main Web Page of GMI BANK "https://www.gmibank.com"
    Given admin should click on the man icon first
    And then admin should click on sign in to log in to Gmi Bank
    And fill in the user-name and password as a admin
    And admin should be able to log into main page using admin, to click on administration
    And then admin should click user-management to open up all the costumers info
    Then There should be a View option where admin can be navigated to all customer info and see (edit button/This is a bug) there
    Then There should be an Edit button where all customer information can be populated
    And  Edit portal can allow user to create or update the user info
    Then admin can delete a customer, but seeing a message if the user is sure about deletion



