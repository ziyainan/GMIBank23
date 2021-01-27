package gmibank.step_defs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import gmibank.pages.US_006_UserInfoSegment;
import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class US_006_UserInfoSegmentStepDef {
    US_006_UserInfoSegment us_006_userInfoSegment = new US_006_UserInfoSegment();

    @Given("user signIn with valid credentials")
    public void user_signIn_with_valid_credentials() {
        Driver.loginAll("employee");

    }

    @Given("user clicks username validentions")
    public void user_clicks_username_validentions() throws InterruptedException {
        us_006_userInfoSegment.usernameValidate.click();
        Thread.sleep(2000);
    }

    @Then("user clicks user info Button")
    public void user_clicks_user_info_Button() throws InterruptedException {
        us_006_userInfoSegment.userInfoButton.click();
        Thread.sleep(2000);

    }

    @When("user click the firstname Text box")
    public void user_click_the_firstname_Text_box() {
        Driver.waitAndClick(us_006_userInfoSegment.firstNameBox);
    }

    @When("Get the firstname from firstname Text box")
    public void get_the_firstname_from_firstname_Text_box() {
        String currentFirstName = us_006_userInfoSegment.firstNameBox.getText();
    }

    @When("user click the lastname Text box")
    public void user_click_the_lastname_Text_box() {
        Driver.waitAndClick(us_006_userInfoSegment.lastNameBox);
    }

    @When("Get the lastname from lastname Text box")
    public void get_the_lastname_from_lastname_Text_box() {
        String currentLastName = us_006_userInfoSegment.lastNameBox.getText();
    }

    @When("user click email box")
    public void user_click_email_box() {
        Driver.waitAndClick(us_006_userInfoSegment.emailBox);
    }

    @When("Get the email from email Text box")
    public void get_the_email_from_email_Text_box() {
        String currentEmail = us_006_userInfoSegment.emailBox.getText();
    }

    @When("Get the language from language Text box")
    public void get_the_language_from_language_Text_box() {
        String currentLanguage = us_006_userInfoSegment.languageBox.getText();
    }

    @Then("Verify all boxes are not null")
    public void verify_all_boxes_are_not_null() {
        Assert.assertTrue(us_006_userInfoSegment.saveButton.isEnabled());
    }


    @Then("user clicks signOut Button")
    public void user_clicks_signOut_Button() throws InterruptedException {
        Driver.waitAndClick(us_006_userInfoSegment.signOut);
        Thread.sleep(2000);

    }

    @Given("Clicks the language dropdown menu")
    public void clicks_the_language_dropdown_menu() {
        Driver.waitAndClick(us_006_userInfoSegment.languageBox);
    }

    @Then("Verify the English and Turkish is available")
    public void verify_the_English_and_Turkish_is_available() {
        Select lang= new Select(us_006_userInfoSegment.languageBox);
        List<WebElement> allLanguage = lang.getOptions();
        String one= allLanguage.get(0).getText();
        String two= allLanguage.get(1).getText();
        String total=one+","+two;
        String expected="English,Türkçe";
        org.junit.Assert.assertEquals(expected,total);
        System.out.println(expected);
        System.out.println(total);
    }


    @Given("user enters firstName {string}")
    public void user_enters_firstName(String firstname) {
        us_006_userInfoSegment.firstNameBox.clear();
        Driver.wait(2);
        us_006_userInfoSegment.firstNameBox.sendKeys(firstname);

    }

    @Given("user clicks save button")
    public void user_clicks_save_button() {
        Driver.waitAndClick(us_006_userInfoSegment.saveButton);
    }

    @Given("And user clicks username validentions")
    public void and_user_clicks_username_validentions() {
        Driver.waitAndClick(us_006_userInfoSegment.usernameValidate);

    }

    @Given("user enters lastName {string}")
    public void user_enters_lastName(String lastName) {
        us_006_userInfoSegment.lastNameBox.clear();
        Driver.wait(2);
        us_006_userInfoSegment.lastNameBox.sendKeys(lastName);
    }

    @Given("user enters email {string}")
    public void user_enters_email(String email) {
        us_006_userInfoSegment.emailBox.clear();
        Driver.wait(2);
        us_006_userInfoSegment.emailBox.sendKeys(email);

    }

}
