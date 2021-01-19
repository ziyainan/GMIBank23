package gmibank.step_defs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gmibank.pages.US003_SecurePasswordPage;
import gmibank.utilities.Driver;
import org.junit.Assert;

public class US003_SecureAndHighLevelPassword {
     US003_SecurePasswordPage US003_Page = new US003_SecurePasswordPage();

    @Given("Go to GMIBANK dashboard")
    public void goToGMIBANKDashboard() {
        US003_Page.getPageTitle();
        String actualTitle =  Driver.getDriver().getTitle();
        String expectedTitle = "GMIBANK";
        Assert.assertEquals(expectedTitle,actualTitle,"GMIBANK");
    }

    @And("Navigate to registration page")
     public void navigateToRegistrationPage() {
        US003_Page.accountIcon.click();
        US003_Page.registerIcon.click();
    }

    @Given("Click on new password textbox")
    public void click_on_new_password_textbox() {
        US003_Page.passwordTextBox.click();
    }

    @When("Type the {string}")
    public void type_the(String string) {
        US003_Page.firstPasswordTextBox.sendKeys(string);
    }

    @Then("Validate level chart change accordingly")
    public void validate_level_chart_change_accordingly() {

    }
}
