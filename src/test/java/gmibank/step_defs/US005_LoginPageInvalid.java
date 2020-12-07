package gmibank.step_defs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gmibank.pages.US005_LoginPageWithInvalidPage;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;
import gmibank.utilities.TxtUtil;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class US005_LoginPageInvalid {

 US005_LoginPageWithInvalidPage input = new US005_LoginPageWithInvalidPage();

    @Given("I visit login page")
    public void visitLoginPage() {
        String url = ConfigurationReader.getProperty("gmibank_login_url");
        Driver.getDriver().get(url);
        Assert.assertEquals("Cannot go to the website.", Driver.getDriver().getCurrentUrl(), url);
    }

    @Given("click on Sign in icon")
    public void clickSignInIcon() {
    Driver.waitAndClick(input.accountIcon);
    Driver.waitAndClick(input.signInLink);
    Assert.assertEquals("Cannot go to login page.", Driver.getDriver().getCurrentUrl(),"https://gmibank.com/login");
    }

    @When("I enter invalid {string}")
    public void invalidUsername(String username) throws InterruptedException {

        Driver.waitAndSendText(input.userName,username+Keys.ENTER);
        Driver.waitAndSendText(input.password,ConfigurationReader.getProperty("employee_password"));
        Thread.sleep(1000);

           // Assert.assertFalse("UserCheck is visible", input.userCheck.isDisplayed());
            Assert.assertNotNull(input.userName.getText());
    }

//
//    @When("I enter valid username but invalid password")
//    public void invalidPassword() {
//        String username = ConfigurationReader.getProperty("admin_username");
//        Driver.waitAndSendText(input.userName,username);
////        List<Map<String, String>> list = dataTable.asMaps(String.class,String.class);
////        for (int i = 0; i <list.size() ; i++) {
////            System.out.println(list.get(i).get("password"));
////            Driver.waitAndSendText(input.password, list.get(i).get("password")+Keys.ENTER);
////        }
//        SoftAssert soft = new SoftAssert();
//        List<String> list =  TxtUtil.getAllLines("data/AllPasswords.txt");
//        for (int i = 0; i < list.size(); i++) {
//            Driver.waitAndSendText(input.password, list.get(i)+Keys.ENTER);
//
//        }
//        System.out.println(list.size());
//        System.out.println(list.get(0));
//    }

    @And("click on sign in button")
    public void clickOnSignInButton() {
        Driver.waitAndClick(input.signInButton);
    }

    @Then("Validate the error message")
    public void errorMessage() {
        SoftAssert softAssert = new SoftAssert();
        String errorNotification = Driver.waitAndGetText(input.errorMessage);
//        System.out.println(input.errorMessage.getText());
        softAssert.assertTrue(errorNotification.contains("Failed"),"error message not found");
        String errorBMessage= Driver.waitAndGetText(input.errorMessageBackground);
//        System.out.println(errorBMessage);
        softAssert.assertTrue(errorBMessage.contains("not-found"),"background error message not found");
        softAssert.assertAll();
    }

    @When("I enter valid username but invalid {string}")
    public void invalidPassword(String password) throws InterruptedException {
        String username = ConfigurationReader.getProperty("admin_username");
        Driver.waitAndSendText(input.userName,username);
        Driver.waitAndSendText(input.password,password+Keys.ENTER);
        Thread.sleep(1000);
        // Assert.assertFalse("UserCheck is visible", input.userCheck.isDisplayed());
        Assert.assertNotNull(input.password.getText());
    }

    @When("I enter invalid {string}but invalid {string}")
    public void invalidUsernamePassword(String username, String password) throws InterruptedException {
        Driver.waitAndSendText(input.userName,username+Keys.ENTER);
        Driver.waitAndSendText(input.password,password+Keys.ENTER);
        Thread.sleep(1000);
//        Assert.assertNotNull(input.userName.getText(), input.password.getText());
////        Assert.assertNotNull(input.password.getText());

    }

    @Then("Validate the user check")
    public void userCheck() {
        Assert.assertNotNull(input.userCheck);
    }

    @Then("Validate the password check")
    public void passwordCheck() {
        Assert.assertNotNull(input.passwordCheck);
    }

    @Then("Validate the user and password check")
    public void userPasswordCheck() {
        Assert.assertNotNull(input.userCheck);
        Assert.assertNotNull(input.passwordCheck);
    }

    @When("I enter empty username")
    public void emptyUsername() {
        Driver.waitAndSendText(input.userName,""+Keys.ENTER);
        String password = ConfigurationReader.getProperty("admin_password");
        Driver.waitAndSendText(input.password,password+Keys.ENTER);
//        Assert.assertNull(input.userName.getText());
    }

    @When("I enter empty password")
    public void emptyPassword() throws InterruptedException {
        String username = ConfigurationReader.getProperty("admin_username");
        Driver.waitAndSendText(input.userName,username+Keys.ENTER);
        Driver.waitAndSendText(input.password,""+Keys.ENTER);
        Thread.sleep(1000);
//        Assert.assertNull(input.password.getText());
    }

    @When("I enter empty username and empty password")
    public void emptyUsernamePassword() throws InterruptedException {
        Driver.waitAndSendText(input.userName,""+Keys.ENTER);
        Driver.waitAndSendText(input.password,""+Keys.ENTER);
        Thread.sleep(1000);
        clickOnSignInButton();

    }

    @Given("Validate reset password option")
    public void resetPasswordOption() {
    Driver.waitAndSendText(input.userName,ConfigurationReader.getProperty("admin_username"));
    Driver.waitAndClick(input.resetOption);
    Driver.getDriver().manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
    Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("reset"));
    }

    @Given("Validate the navigate to register page")
    public void navigateToRegisterPage() throws InterruptedException {
        invalidUsernamePassword(ConfigurationReader.getProperty("admin_username"),ConfigurationReader.getProperty("employee_password"));
        Driver.waitAndClick(input.registerOption);
        String url=ConfigurationReader.getProperty("registerUrl");
        Assert.assertEquals(url,Driver.getDriver().getCurrentUrl());
    }
}
