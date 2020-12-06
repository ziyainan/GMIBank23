package gmibank.step_defs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gmibank.pages.US009_CreateCustomerPage;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;

public class US009_CreateCustomerSteps {

    US009_CreateCustomerPage us009_createCustomerPage=new US009_CreateCustomerPage();

    @Given("User goes signing page")
    public void user_goes_signing_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmibank_login_url"));
    }

    @Given("user click on manage customer button")
    public void user_click_on_manage_customer_button() {

    }

    @Given("user Click on Create New Customer Button")
    public void user_Click_on_Create_New_Customer_Button() {

    }

    @When("user provides SSN {string}")
    public void user_provides_SSN(String string) {
    }

    @When("user clicks search button")
    public void user_clicks_search_button() {

    }

    @Then("system displays customer info")
    public void system_displays_customer_info() {

    }

    @Then("system displays please type SSN Number.")
    public void system_displays_please_type_SSN_Number() {

    }

    @Then("system displays translation-not-found [error.SSN not found].")
    public void system_displays_translation_not_found_error_SSN_not_found() {

    }

}
