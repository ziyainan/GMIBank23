package gmibank.step_defs;

import com.github.javafaker.Faker;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmibank.pages.US001_AllowAnyUserToRegisterPage;
import gmibank.utilities.BrowserUtils;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;
import org.junit.Assert;

public class US001_AllowAnyUserToRegisterStep {

     static Faker faker = new Faker();

    US001_AllowAnyUserToRegisterPage allowAnyUserToRegisterPage = new US001_AllowAnyUserToRegisterPage();

    @Given("Main web page for the gmi bank {string}")
    public void main_web_page_for_the_gmi_bank(String string) {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmibank_login_url"));

    }

    @Given("user should click icon first then click register")
    public void user_should_click_icon_first_then_click_register() {
        allowAnyUserToRegisterPage.registerIcon.click();
        Driver.wait(2);
        allowAnyUserToRegisterPage.register.click();


    }

    @Given("user should fill in the SSN box with given SSN")
    public void user_should_fill_in_the_SSN_box_with_given_SSN() {
        Driver.wait(2);
        allowAnyUserToRegisterPage.ssnBox.sendKeys(faker.idNumber().ssnValid());

    }

    @Given("there should be a valid name for the first name")
    public void there_should_be_a_valid_name_for_the_first_name() {
        allowAnyUserToRegisterPage.firstNameBox.sendKeys(faker.name().firstName());
        Driver.wait(2);

    }

    @Given("there should be valid name for the last name")
    public void there_should_be_valid_name_for_the_last_name() {
        allowAnyUserToRegisterPage.lastNameBox.sendKeys(faker.name().lastName());
    }

    @Given("provide address box with valid address and zip code")
    public void provide_address_box_with_valid_address_and_zip_code() {
        allowAnyUserToRegisterPage.addressBox.sendKeys(faker.address().fullAddress());

    }

    @Given("user should provide a valid ten digit valid phone number")
    public void user_should_provide_a_valid_ten_digit_valid_phone_number() {
        allowAnyUserToRegisterPage.phoneNumberBox.sendKeys(faker.phoneNumber().cellPhone());

    }

    @Given("Enter user name")
    public void enter_user_name() {
        allowAnyUserToRegisterPage.userNameBox.sendKeys(faker.name().username());
    }

    @Given("provide a valid email in to the email box")
    public void provide_a_valid_email_in_to_the_email_box() {
        allowAnyUserToRegisterPage.emailBox.sendKeys(faker.name().username()+"@gmail.com");
        Driver.wait(2);
    }

    @Given("user should provide a valid password at any length using char and digits")
    public void user_should_provide_a_valid_password_at_any_length_using_char_and_digits() {
        allowAnyUserToRegisterPage.newPasswordBox.sendKeys(ConfigurationReader.getProperty("US001Password"));

    }

    @Given("user enters New password confirmation")
    public void user_enters_New_password_confirmation() {
        allowAnyUserToRegisterPage.secondPasswordBox.sendKeys(ConfigurationReader.getProperty("US001Password"));
    }

    @Given("user clicks register button")
    public void user_clicks_register_button() {
        allowAnyUserToRegisterPage.registerButton.click();
    }

    @Then("validate the success message")
    public void validate_the_success_message() {
        Driver.waitAndClick(allowAnyUserToRegisterPage.registrationConfirmation,5);
        System.out.println(Driver.waitAndGetText(allowAnyUserToRegisterPage.registrationConfirmation,5));
        Assert.assertTrue(Driver.waitAndGetText(allowAnyUserToRegisterPage.registrationConfirmation,5).contains(ConfigurationReader.getProperty("SuccessMessage")));


    }

}
