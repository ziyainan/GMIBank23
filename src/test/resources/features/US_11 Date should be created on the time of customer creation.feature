@US11_TC001
Feature: Date should be created on time of customer creation

@s1
  Scenario Outline:The date cannot be typed earlier, in the past, at the time of creation a customer
    Given I visit login page
    Then click on Sign in icon
    And enter valid username "<username>"
    And enter valid password "<password>"
    And click sign in button
    And click my operations blog
    And click manage customers
    And click create a new customer
    And enter firstname"<first name>"
    And enter lastname"<last name>"
    And enter middle"<middle initial>"
    And enter email"<email>"
    And enter mobil phone"<mobil phone number>"
    And enter phone"<phone number>"
    And enter zip code"<zip code>"
    And enter address"<address>"
    And enter city"<city>"
    And enter ssn again"<ssn2>"
    And Create earlier "<date>"
    And enter country
    And enter state"<state>"
    And choose user
    And choose account
    And select zelle enrolled
    And and saved
    And verify save button is displayed

    Examples:
      | username |password|first name|last name|middle initial|email           |mobil phone number|phone number|zip code|address  |city  |ssn2       |date               |state|
      |mehmet    |Mehmet1*|selim     |deri     |sd           |49pdr@gmail.com|123-123-6785      |123-345-6578|03234   |goffstown|boston|111-11-4444|01/14/2021 12:00 AM|boston|

    @s2
    Scenario Outline: The date should be created as month, day, year, hour and minute
      Given I visit login page
      Then click on Sign in icon
      And enter valid username "<username>"
      And enter valid password "<password>"
      And click sign in button
      And click my operations blog
      And click manage customers
      And click create a new customer
      And enter date "01-26-2021 15:14"
      And verify date is match as month,day, year and minute

      Examples:
      |username|password|
      |mehmet  |Mehmet1*|



  @s3
  Scenario Outline: User can choose a user from the registration and it cannot be blank
    Given I visit login page
    Then click on Sign in icon
    And enter valid username "<username>"
    And enter valid password "<password>"
    And click sign in button
    And click my operations blog
    And click manage customers
    And click create a new customer
    And enter firstname"<first name>"
    And enter lastname"<last name>"
    And enter middle"<middle initial>"
    And enter email"<email>"
    And enter mobil phone"<mobil phone number>"
    And enter phone"<phone number>"
    And enter zip code"<zip code>"
    And enter address"<address>"
    And enter city"<city>"
    And enter ssn again"<ssn2>"
    And enter date of today
    And enter country
    And enter state"<state>"
    And choose user as a blank
    And choose account
    And select zelle enrolled
    And and saved
    And verify cancel button is displayed

      Examples:
        | username |password|first name|last name|middle initial|email           |mobil phone number|phone number|zip code|address  |city  |ssn2      |state|
        |mehmet    |Mehmet1*|selim     |deri     |sd           |49pdr@gmail.com|123-123-6785      |123-345-6578|03234   |goffstown|boston|111-11-4444|boston|


    @s4
  Scenario Outline:There user can choose an account created on manage accounts
    Given I visit login page
    Then click on Sign in icon
    And enter valid username "<username>"
    And enter valid password "<password>"
    And click sign in button
    And click my operations blog
    And click manage customers
    And click create a new customer
    And enter firstname"<first name>"
    And enter lastname"<last name>"
    And enter middle"<middle initial>"
    And enter email"<email>"
    And enter mobil phone"<mobil phone number>"
    And enter phone"<phone number>"
    And enter zip code"<zip code>"
    And enter address"<address>"
    And enter city"<city>"
    And enter ssn again"<ssn2>"
    And enter date of today
    And enter country
    And enter state"<state>"
    And choose user
    And choose account
    And select zelle enrolled
    And and saved
    And verify home page link is displayed

    Examples:
      | username |password|first name|last name|middle initial|email           |mobil phone number|phone number|zip code|address  |city  |ssn2      |state|
      |mehmet    |Mehmet1*|selim     |deri     |sd           |49pdr@gmail.com|123-123-6785      |123-345-6578|03234   |goffstown|boston|111-11-4444|boston|


  @s5
  Scenario Outline:User can select Zelle Enrolled optionally and save it
    Given I visit login page
    Then click on Sign in icon
    And enter valid username "<username>"
    And enter valid password "<password>"
    And click sign in button
    And click my operations blog
    And click manage customers
    And click create a new customer
    And enter firstname"<first name>"
    And enter lastname"<last name>"
    And enter middle"<middle initial>"
    And enter email"<email>"
    And enter mobil phone"<mobil phone number>"
    And enter phone"<phone number>"
    And enter zip code"<zip code>"
    And enter address"<address>"
    And enter city"<city>"
    And enter ssn again"<ssn2>"
    And enter date of today
    And enter country
    And enter state"<state>"
    And choose user
    And choose account
    And select zelle enrolled
    And verify zelle enrolled selected
    And and saved
    And verify create a custmoer button is displayed

    Examples:
      | username |password|first name|last name|middle initial|email           |mobil phone number|phone number|zip code|address  |city  |ssn2       |state|
      |mehmet    |Mehmet1*|selim     |deri     |sd           |49pdr@gmail.com|123-123-6785      |123-345-6578|03234   |goffstown|boston|111-11-4444|boston|
