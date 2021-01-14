package gmibank.step_defs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gmibank.pages.US005_LoginPageWithInvalidPage;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.testng.asserts.SoftAssert;

public class US005_LoginPageInvalid {

 US005_LoginPageWithInvalidPage input = new US005_LoginPageWithInvalidPage();

    @Given("I visit login page")
    public void visitLoginPage() {
        String url = ConfigurationReader.getProperty("login_url");
        Driver.getDriver().get(url);
        Assert.assertEquals("Cannot go to the website.", Driver.getDriver().getCurrentUrl(), url);
    }

    @Given("click on Sign in icon")
    public void clickSignInIcon() {
    Driver.waitAndClick(input.accountIcon,5);
    Driver.waitAndClick(input.signInLink,5);
    Assert.assertEquals("Cannot go to login page.", Driver.getDriver().getCurrentUrl(),"https://gmibank.com/login");
    }

    @When("I enter invalid {string}")
    public void invalidUsername(String username) throws InterruptedException {

        Driver.waitAndSendText(input.userName,username+Keys.ENTER,5);
        Thread.sleep(1000);
           // Assert.assertFalse("UserCheck is visible", input.userCheck.isDisplayed());
            Assert.assertNotNull(input.userName.getText());
    }


    @Then("Validate the error message")
    public void errorMessage() {
        SoftAssert softAssert = new SoftAssert();
        String errorNotification = Driver.waitAndGetText(input.errorMessage,5);
        softAssert.assertTrue(input.errorMessage.getText().contains("Failed"),"background error message not found");
        String errorMessage= Driver.waitAndGetText(input.errorMessageBackground,5);
        System.out.println(errorMessage);
        softAssert.assertTrue(input.errorMessageBackground.getText().contains("not-found"),"background error message not found");
        softAssert.assertAll();
    }
}
