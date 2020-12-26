package gmibank.step_defs;

import cucumber.api.java.en.*;
import gmibank.pages.US014_DateCreationOfAccountPage;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;
import gmibank.utilities.ZiyaMethods;
import org.testng.Assert;

public class US014_DateCreationOfAccountStepDef {



US014_DateCreationOfAccountPage US014Page= new US014_DateCreationOfAccountPage();


    @Given("User on the main page")
    public void user_on_the_main_page() {
   Driver.getDriver().get(ConfigurationReader.getProperty("gmibank_login_url"));
    }

    @Then("User click on log in sign")
    public void user_click_on_log_in_sign() {
        Driver.waitAndClick(US014Page.loginDropDown,5);
    }


    @Then("User signs in as an employee with {string} and {string}")
    public void userSignsInAsAnEmployeeWithAnd(String arg0, String arg1) {
        Driver.waitAndSendText(US014Page.usernameTextbox,"empz01",5);
        Driver.waitAndSendText(US014Page.passwordTextbox,"Gmibank",5);
    }

    @Then("User click on login icon")
    public void userClickOnLoginIcon() {
        Driver.waitAndClick(US014Page.loginDropDown,5);
    }

    @Then("User click on sign in")
    public void userClickOnSignIn() {
        Driver.waitAndClick(US014Page.signIn,5);
    }

    @Then("User click on sign in button")
    public void userClickOnSignInButton() {
        Driver.waitAndClick(US014Page.signInButton,4);
    }

    @And("User fills {string} and {string} fields")
    public void userFillsAndFields(String arg0, String arg1) {
        Driver.waitAndSendText(US014Page.description,ConfigurationReader.getProperty("ZAccountName"));
        //Driver.waitAndSendText(US014Page.description,"ZChecking Account",4);
        Driver.waitAndSendText(US014Page.balance,"5000",5);

    }

    @Then("User click on date picker box and send an {string}")
    public void userClickOnDatePickerBoxAndSendAn(String arg0) {
        Driver.waitAndSendText(US014Page.date,"09181970",5);
    }

    @And("user click on save button")
    public void userClickOnSaveButton() {
        Driver.waitAndClick(US014Page.saveButton,5);
    }


    @Then("user scroll dowmn the buttom")
    public void userScrollDowmnTheButtom() {
        ZiyaMethods.JSuntillButton();
    }

    @Then("find the created element")
    public void findTheCreatedElement() {
     //  ZiyaMethods.JSfindElement(US014Page.createdAccount);
        ZiyaMethods.JSuntillButton();
    }

    @Then("verify if the account is created")
    public void verifyIfTheAccountIsCreated() {
        Assert.assertTrue(US014Page.createdAccount.isDisplayed(),"ERROR= You cannot create an account at the previous date");
        // Burada mantikta bir hata olabilir . Normalde account eraly date de create edilememisi
        //lazim ama ediyorsa bu bir bug olmali. Burada Assertion nasil olmali ??? Bug olan
        // otomasyon sonu gecmeli mi? kalmali mi?

    }

    @Then("User click on date picker box and send  {string}")
    public void userClickOnDatePickerBoxAndSend(String arg0) {
        Driver.waitAndSendText(US014Page.date,"01/01/20210000",5);
    }



//    @Then("verify if the account is created")
//    public void verifyIfTheAccountIsCreated() {
//        ZiyaMethods.JSuntillButton();
//        Assert.assertFalse();
//    }
}
