@US_15_SmokeTest
Feature:Login page should not be accessible with invalid credentials

  Background: User go to Homepage
    Given User go to homepage
    And User clicks person icon
    And User clicks signIn link

  @US_15_TC_01
  Scenario Outline:User cannot login with invalid username validating the error message
    Given User enters invalid username "<username>"
    And User enters valid password "MerhabaDunya123*"
    And User clicks signInButton
    Then Verify error message

    Examples:
      | username      |
      | Hello         |
      | deneme4user   |
      | &MerhabaDunya |
      | MerhabaDunya1 |
      | merhabadunya  |

  @US_15_TC_02
  Scenario Outline: User cannot login with invalid username and password validating the error message
    Given User enters valid username "MerhabaDunya"
    And User enters invalid password "<password>"
    And User clicks signInButton
    Then Verify error message

    Examples:
      | password          |
      | 12deneme4user     |
      | 123MerhabaDunya*  |
      | &MerhabaDunya123* |
      | MerhabaDunya123   |
      | merhabaDunya123*  |

  @US_15_TC_03
  Scenario Outline: User cannot login with invalid username and password validating the error message
    Given User enters invalid username "<username>"
    And User enters invalid password "<password>"
    And User clicks signInButton
    Then Verify error message

    Examples:
      | username      | password          |
      | Hello         | Hello123          |
      | deneme4user   | 12deneme4user     |
      | &MerhabaDunya | &MerhabaDunya123* |
      | MerhabaDunya1 | MerhabaDunya123   |
      | merhabaDunya  | merhabaDunya123*  |

  @US_15_TC_04
  Scenario: User with invalid credentials should be given an option to reset their password
    Given User should enter invalid username "MerhabaDunya"
    And User should enter invalid password "merhabaDunya123*"
    And User clicks signInButton
    Then validate error message
    And User clicks Did you forget your password? button
    And User enters the email address you used to register "MerhabaDunya@gmail.com"
    And User clicks reset password
    Then Verify user should see password reset message

  @US_15_TC_05
  Scenario: User should be given the option to navigate to registration page if they did not register yet
    Given User should enter invalid username "MerhabaDunya1"
    And User should enter invalid password "merhabaDunya123*"
    And User clicks signInButton
    Then validate error message
    Given User clicks You don't have an account yet? Register a new account
    And Verify user see registration page





