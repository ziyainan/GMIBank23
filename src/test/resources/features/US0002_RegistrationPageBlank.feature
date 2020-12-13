@metin
  Feature: Any field on the registration page should not be left blank
    Background: user goes to registration page
      Given go to bank main page
      And click on arrow
      And click on dropdonwnregister button

    Scenario: registration page with ssn box blank
      Given leave the ssn box blank
      And enter a valid firstname "metin"
      When click on register button
      Then i should see SSN message

    Scenario: registration page with first name box blank
      Given leave the first name box blank
      And enter a valid lastname "nesli"
      When click on register button
      Then i should see a first name message

    Scenario: registration page with lastname box blank
      Given enter a valid firstname "metin"
      And leave the lastname box blank
      When click on register button
      Then i should see a last name message

     Scenario: registration page with address box blank
      Given enter a valid SSNfirst "141-63-2572"
      And enter a valid firstname "nesli"
      And enter a valid lastname "metin"
      And leave the address box blank
      And enter a mobile phone number "111-222-3456"
      And enter a valid username "metin"
      And enter a valid email "metin@gmail.com"
      And enter a valid password "123asd"
      And enter the same password for confirmation "123asd"
      When click on register button
      Then i shouldn't see a success message

      Scenario: registration page with mobile number box blank
      Given enter a valid SSNsecond "263-53-7382"
      And enter a valid firstname "metin"
      And enter a valid lastname "nesli"
      And enter a valid address "123 asd street"
      And leave the mobile phone number box empty
      And enter a valid username "metin"
      And enter a valid email "metin@hotmail.com"
      And enter a valid password "123asd."
      And enter the same password for confirmation "123asd."
      When click on register button
      Then i shouldn't see a success message

      Scenario: registration page with username box blank
      Given enter a valid firstname "metin"
      And leave the username box blank
      When click on register button
      Then i should see a username message

      Scenario: registration page with email box blank
      Given enter a valid firstname "metin"
      And leave the email box blank
      When click on register button
      Then i should see a emailbox message

      Scenario: registration page with new password box blank
      Given enter a valid firstname "metin"
      And leave the new password box blank
      When click on register button
      Then i should see a newpassword message

      Scenario: registration page with new password confirmation box blank
      Given enter a valid firstname "metin"
      And leave the new password confirmation box blank
      When click on register button
      Then i should see a newpasswordconfirmation message

      Scenario: ssn number can't be of any chars nor spec chars except "-"
        Given i enter an invalid ssn and click enter "a6-7?8-82b#"
        Then i should see your ssn is invalid message

     Scenario: mobile number can't be of any chars nor spec chars except "-"
        Given i enter an invalid phone number and click enter "a?5-6m@-76b!"
        Then i should see your mobile phone number is invalid message

      Scenario: email id can't be created without "@" sign and "." extension
      Given i enter an invalid email and click enter "metingmailcom"
      Then i should see this field is invalid message

