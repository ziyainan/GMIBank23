package gmibank.step_defs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gmibank.pages.US0002_RegistrationPageWebElements;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.security.Key;
import java.security.KeyStore;

public class US0002_RegistrationPageStepDef {

    US0002_RegistrationPageWebElements obj = new US0002_RegistrationPageWebElements();

    @Given("go to bank main page")
    public void go_to_bank_main_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmibank_login_url"));
    }
    @Given("click on arrow")
    public void click_on_arrow() {
        Driver.waitAndClick(obj.arrow);
    }
    @Given("click on dropdonwnregister button")
    public void click_on_dropdonwnregister_button() {
        Driver.waitAndClick(obj.dropdownRegister);
    }
    @Given("leave the ssn box blank")
    public void leave_the_ssn_box_blank() {
        Driver.waitAndClick(obj.ssnBox);
    }
    @Given("enter a valid firstname {string}")
    public void enter_a_valid_firstname(String string) {
        Driver.waitAndSendText(obj.firstNameBox,string);
    }
    @When("click on register button")
    public void click_on_register_button() {
        Driver.waitAndClick(obj.register);
    }
    @Then("i should see SSN message")
    public void i_should_see_SSN_message() {
        Assert.assertTrue(obj.ssnBlankMessage.getText().contains("translation-not-found[Your SSN is required]"));
    }
    @Given("leave the first name box blank")
    public void leave_the_first_name_box_blank() {
        Driver.waitAndClick(obj.firstNameBox);
    }
    @Given("enter a valid lastname {string}")
    public void enter_a_valid_lastname(String string) {
        Driver.waitAndSendText(obj.lastNameBox,string);
    }
    @Then("i should see a first name message")
    public void i_should_see_a_first_name_message() {
        Assert.assertTrue(obj.firstNameBlankMessage.getText().contains("Your First Name is required"));
    }
    @Given("leave the lastname box blank")
    public void leave_the_lastname_box_blank() {
        Driver.waitAndClick(obj.lastNameBox);
    }
    @Then("i should see a last name message")
    public void i_should_see_a_last_name_message() {
        Assert.assertTrue(obj.lastNameBlankMessage.getText().contains("Your Last Name is required"));
    }
    @Given("enter a valid SSNfirst {string}")
    public void enter_a_valid_SSNfirst(String string) {
        Driver.waitAndSendText(obj.ssnBox,string);
    }
    @Given("leave the address box blank")
    public void leave_the_address_box_blank() {
        Driver.waitAndClick(obj.addressBox);
    }
    @Given("enter a mobile phone number {string}")
    public void enter_a_mobile_phone_number(String string) {
        Driver.waitAndSendText(obj.mobilePhoneBox,string);
    }
    @Given("enter a valid username {string}")
    public void enter_a_valid_username(String string) {
        Driver.waitAndSendText(obj.usernameBox,string);
    }
    @Given("enter a valid email {string}")
    public void enter_a_valid_email(String string) {
        Driver.waitAndSendText(obj.emailBox,string);
    }
    @Given("enter a valid password {string}")
    public void enter_a_valid_password(String string) {
        Driver.waitAndSendText(obj.newPasswordBox,string);
    }
    @Given("enter the same password for confirmation {string}")
    public void enter_the_same_password_for_confirmation(String string) {
        Driver.waitAndSendText(obj.newPasswordConfirmationBox,string);
    }
    @Then("i shouldn't see a success message")
    public void i_shouldn_t_see_a_success_message() {
        Assert.assertFalse(obj.registrationConfirmation.getText().contains("Registration saved!"));
    }
    @Given("enter a valid SSNsecond {string}")
    public void enter_a_valid_SSNsecond(String string) {
        Driver.waitAndSendText(obj.ssnBox,string);
    }
    @Given("enter a valid address {string}")
    public void enter_a_valid_address(String string) {
        Driver.waitAndSendText(obj.addressBox,string);
    }
    @Given("leave the mobile phone number box empty")
    public void leave_the_mobile_phone_number_box_empty() {
        Driver.waitAndClick(obj.mobilePhoneBox);
    }
    @Given("leave the username box blank")
    public void leave_the_username_box_blank() {
        Driver.waitAndClick(obj.usernameBox);
    }
    @Then("i should see a username message")
    public void i_should_see_a_username_message() {
        Assert.assertTrue(obj.usernameBlankMessage.getText().contains("Your username is required."));
    }
    @Given("leave the email box blank")
    public void leave_the_email_box_blank() {
        Driver.waitAndClick(obj.emailBox);
    }
    @Then("i should see a emailbox message")
    public void i_should_see_a_emailbox_message() {
        Assert.assertTrue(obj.emailBlankMessage.getText().contains("Your email is required."));
    }
    @Given("leave the new password box blank")
    public void leave_the_new_password_box_blank() {
        Driver.waitAndClick(obj.newPasswordBox);
    }
    @Then("i should see a newpassword message")
    public void i_should_see_a_newpassword_message() {
        Assert.assertTrue(obj.newPasswordMessage.getText().contains("Your password is required."));
    }
    @Given("leave the new password confirmation box blank")
    public void leave_the_new_password_confirmation_box_blank() {
        Driver.waitAndClick(obj.newPasswordBox);
    }
    @Then("i should see a newpasswordconfirmation message")
    public void i_should_see_a_newpasswordconfirmation_message() {
        Assert.assertTrue(obj.newPasswordConfirmationMessage.getText().contains("Your confirmation password is required."));
    }
    @Given("i enter an invalid ssn and click enter {string}")
    public void i_enter_an_invalid_ssn_and_click_enter(String string) {
        Driver.waitAndSendText(obj.ssnBox,string+ Keys.ENTER);
    }
    @Then("i should see your ssn is invalid message")
    public void i_should_see_your_ssn_is_invalid_message() {
        Assert.assertTrue(obj.ssnBlankMessage.getText().contains("Your SSN is invalid"));
    }
    @Given("i enter an invalid phone number and click enter {string}")
    public void i_enter_an_invalid_phone_number_and_click_enter(String string) {
        Driver.waitAndSendText(obj.mobilePhoneBox,string+Keys.ENTER);
    }
    @Then("i should see your mobile phone number is invalid message")
    public void i_should_see_your_mobile_phone_number_is_invalid_message() {
        Assert.assertTrue(obj.mobilePhoneInvalidMessage.getText().contains("Your mobile phone number is invalid"));
    }
    @Given("i enter an invalid email and click enter {string}")
    public void i_enter_an_invalid_email_and_click_enter(String string) {
        Driver.waitAndSendText(obj.emailBox,string+Keys.ENTER);
    }
    @Then("i should see this field is invalid message")
    public void i_should_see_this_field_is_invalid_message() {
        Assert.assertTrue(obj.emailInvalidMessage.getText().contains("This field is invalid"));
    }

}
