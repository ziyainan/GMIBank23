package gmibank.step_defs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmibank.pages.US006_UserInfoPage;
import gmibank.utilities.BrowserUtils;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;

public class US006_UserInfoSteps {

    US006_UserInfoPage us006_userInfoPage = new US006_UserInfoPage();

    @Given("user is on the website")
    public void user_is_on_the_website() {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmibank_login_url"));
    }

    @Given("user signs in as an employee {string} and {string}")
    public void user_signs_in_as_an_employee_and(String username, String password) {
        Driver.waitAndClick(us006_userInfoPage.accountMenu,2);
        Driver.waitAndClick(us006_userInfoPage.signInLink,2);
        Driver.waitAndSendText(us006_userInfoPage.usernameTextbox,ConfigurationReader.getProperty("employee_username"),2);
        Driver.waitAndSendText(us006_userInfoPage.passwordTextbox,ConfigurationReader.getProperty("employee_password"),2);
        Driver.waitAndClick(us006_userInfoPage.signInButton,2);

    }

    @Given("user goes to User Info segment and click on it")
    public void user_goes_to_User_Info_segment_and_click_on_it() {
        Driver.waitAndClick(us006_userInfoPage.lindaPineLink,2);
        Driver.waitAndClick(us006_userInfoPage.userInfoSegment,2);

    }

    @Then("verify firstname, lastname, email and language is populated")
    public void verify_firstname_lastname_email_and_language_is_populated() {
        BrowserUtils.verifyElementDisplayed(us006_userInfoPage.firstNameText);
        BrowserUtils.verifyElementDisplayed(us006_userInfoPage.lastNameText);
        BrowserUtils.verifyElementDisplayed(us006_userInfoPage.emailText);
        BrowserUtils.verifyElementDisplayed(us006_userInfoPage.languageText);
    }

    @Then("verify there are two languages available from dropdown")
    public void verify_there_are_two_languages_available_from_dropdown() {
        Driver.selectAnItemFromDropdown(us006_userInfoPage.languageDropDown,"Türkçe");
        Driver.selectAnItemFromDropdown(us006_userInfoPage.languageDropDown,"English");
    }

    @Then("update the firstname and click on Save button")
    public void update_the_firstname_and_click_on_Save_button() {
        Driver.waitAndClearAndUpdate(us006_userInfoPage.firstnameTextbox,"UpdatedLinda",2);
    }

    @Then("update the lastname and click on Save button")
    public void update_the_lastname_and_click_on_Save_button() {
        Driver.waitAndClearAndUpdate(us006_userInfoPage.lastnameTextbox,"UpdatedPine",2);
    }

    @Then("update the email with @ and . sign and click on Save button")
    public void update_the_email_with_and_sign_and_click_on_Save_button() {
        Driver.waitAndClearAndUpdate(us006_userInfoPage.emailTextbox,"linda.pine@gmail.com",2);
    }

}
