package gmibank.step_defs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gmibank.pages.US004_LoginPage;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;
import org.testng.Assert;

public class LoginStepDef {

    US004_LoginPage loginPage = new US004_LoginPage();

    @Given("Go to login page")
    public void go_to_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("login_url")) ;
    }

    @Given("Click on account Icon")
    public void click_on_account_Icon() {
        loginPage.accountIcon.click();
    }

    @Given("Click on Sign in Icon")
    public void click_on_Sign_in_Icon() {
        loginPage.signInIcon.click();
    }

    @When("User is on the login page")
    public void enterUsernameAndPassword() {
        loginPage.login();
    }

    @Then("Click on submit Icon")
    public void clickOnSubmitIcon() {
        loginPage.submitSignIn.click();
    }

    @Then("Validate the log in the page")
    public void validate_the_log_in_the_page() {
        String actual = loginPage.myOperations.getText() ;
        String expected = "My Operations" ;
       Assert.assertEquals(actual,expected);
    }


    @Then("Click on LadyGagaTeamTryCatch")
    public void clickOnLadyGagaTeamTryCatch() {
        loginPage.accountIconLogout.click();
    }

    @And("Click on sign out button")
    public void clickOnSignOutButton() {
        loginPage.signOut.click();
    }

    @And("Validate the sign out")
    public void validateTheSignOut() {
        String actual = loginPage.loggedOut.getText();
        String expected = "SIGN IN AGAIN";
        Assert.assertEquals(actual,expected);
    }
}
