package gmibank.step_defs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmibank.pages.US_005_LoginPageInvalidCredentials;
import gmibank.utilities.BrowserUtils;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;
import org.junit.Assert;

public class US_005_LoginPageInvalidCredentialsStepDef {

    US_005_LoginPageInvalidCredentials us_005_loginPageInvalidCredentials = new US_005_LoginPageInvalidCredentials();
    @Given("User go to homepage")
    public void user_go_to_homepage() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("login_url"));
    }

    @Given("User clicks person icon")
    public void user_clicks_person_icon() throws InterruptedException {
        Driver.waitAndClick(us_005_loginPageInvalidCredentials.personIcon);


    }

    @Given("User clicks signIn link")
    public void user_clicks_signIn_link() throws InterruptedException {
        Driver.waitAndClick(us_005_loginPageInvalidCredentials.signInLink);


    }

    @Given("User enters invalid username {string}")
    public void user_enters_invalid_username(String username) throws InterruptedException {
        us_005_loginPageInvalidCredentials.username.sendKeys(username);
        Driver.wait(1);

    }

    @Given("User enters valid password {string}")
    public void user_enters_valid_password(String password) throws InterruptedException {
        Driver.waitAndSendText(us_005_loginPageInvalidCredentials.password,password);


    }

    @Given("User clicks signInButton")
    public void user_clicks_signInButton() throws InterruptedException {
        Driver.waitAndClick(us_005_loginPageInvalidCredentials.signInButton);
        Driver.wait(1);


    }

    @Then("Verify error message")
    public void verify_error_message() throws InterruptedException {
        Assert.assertTrue(us_005_loginPageInvalidCredentials.errorMessage.isDisplayed());


    }

    @Given("User enters valid username {string}")
    public void user_enters_valid_username(String username) throws InterruptedException {
        Driver.waitAndSendText(us_005_loginPageInvalidCredentials.username,username);
        Driver.wait(1);

    }

    @Given("User enters invalid password {string}")
    public void user_enters_invalid_password(String password) throws InterruptedException {
        Driver.waitAndSendText(us_005_loginPageInvalidCredentials.password,password);
        Driver.wait(1);

    }

    @Given("User should enter invalid username {string}")
    public void user_should_enter_invalid_username(String username) {
        Driver.waitAndSendText(us_005_loginPageInvalidCredentials.username,username);
        Driver.wait(1);
    }

    @Given("User should enter invalid password {string}")
    public void user_should_enter_invalid_password(String password) {
        Driver.waitAndSendText(us_005_loginPageInvalidCredentials.password,password);
        Driver.wait(1);
    }

    @Then("validate error message")
    public void validate_error_message() {
        BrowserUtils.verifyElementDisplayed(us_005_loginPageInvalidCredentials.errorMessage);
    }



    @Given("User clicks Did you forget your password? button")
    public void user_clicks_Did_you_forget_your_password_button() throws InterruptedException {
        Driver.waitAndClick(us_005_loginPageInvalidCredentials.forgetPasswordButton);
        Driver.wait(1);
    }

    @Given("User enters the email address you used to register {string}")
    public void user_enters_the_email_address_you_used_to_register(String email) throws InterruptedException {
        Driver.waitAndSendText(us_005_loginPageInvalidCredentials.emailTextBox,email);
        Driver.wait(1);
    }

    @Given("User clicks reset password")
    public void user_clicks_reset_password() throws InterruptedException {
        Driver.waitAndClick(us_005_loginPageInvalidCredentials.resetPasswordButton);
    }

    @Then("Verify user should see password reset message")
    public void verify_user_should_see_password_reset_message() throws InterruptedException {
        Assert.assertTrue(us_005_loginPageInvalidCredentials.resetPasswordMessage.isDisplayed());
        Driver.wait(1);
    }

    @Given("User clicks You don't have an account yet? Register a new account")
    public void user_clicks_You_don_t_have_an_account_yet_Register_a_new_account() throws InterruptedException {
        Driver.waitAndClick(us_005_loginPageInvalidCredentials.registrationsButton);


    }

    @Given("Verify user see registration page")
    public void verify_user_see_registration_page() throws InterruptedException {
        BrowserUtils.verifyElementDisplayed(us_005_loginPageInvalidCredentials.registrationValidate);


    }

}
