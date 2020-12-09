package gmibank.step_defs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gmibank.pages.US009_CreateCustomerPage;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;
import org.testng.Assert;


public class US009_CreateCustomerSteps {

    US009_CreateCustomerPage us009_createCustomerPage=new US009_CreateCustomerPage();

    @Given("User goes signing page")
    public void user_goes_signing_page() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmibank_login_url"));
        Driver.waitAndClick(us009_createCustomerPage.menu,4);
        Driver.waitAndClick(us009_createCustomerPage.login,4);






    }

    @Given("user click on manage customer button")
    public void user_click_on_manage_customer_button() {
        Driver.waitAndClick(us009_createCustomerPage.getmenu,4);



    }

    @Given("user Click on Create New Customer Button")
    public void user_Click_on_Create_New_Customer_Button() {
        Driver.waitAndClick(us009_createCustomerPage.managecustomers,4);
        Driver.waitAndClick(us009_createCustomerPage.createnewcustomer,4);

    }

    @When("user provides SSN {string}")
    public void user_provides_SSN(String string) {
        Driver.waitAndSendText(us009_createCustomerPage.searchssn,string,5);


    }

    @When("user clicks search button")
    public void user_clicks_search_button() {

        Driver.waitAndClick(us009_createCustomerPage.searchclick,5);


    }

    @Then("system displays customer info")
    public void system_displays_customer_info() throws InterruptedException {
        Thread.sleep(2000);
        String firstName=Driver.waitAndGetText(us009_createCustomerPage.firstName,5);
      //  Assert.assertEquals(firstName,"Kevin");


    }

    @Then("system displays please type SSN Number.")
    public void system_displays_please_type_SSN_Number() {
        String notssn="Please type an SSN number Bad";
        Driver.wait(2);
        Assert.assertTrue(us009_createCustomerPage.toastContainer.getText().contains("Bad") || us009_createCustomerPage.toastContainer.getText().contains("Please type an SSN"));

    }

    @Then("system displays translation-not-found [error.SSN not found].")
    public void system_displays_translation_not_found_error_SSN_not_found() {
        Driver.wait(2);
        Assert.assertTrue(us009_createCustomerPage.toastContainer.getText().contains("not found"));

    }

    @And("user provides username, {string} and password {string}")
    public void userProvidesUsernameAndPassword(String userName, String Password) throws InterruptedException {

        Driver.waitAndSendText(us009_createCustomerPage.usernamebox,userName,4);
        Driver.waitAndSendText(us009_createCustomerPage.passwordbox,Password,4);


        Thread.sleep(2000);
        Driver.waitAndClick(us009_createCustomerPage.sign,4);

    }
}
