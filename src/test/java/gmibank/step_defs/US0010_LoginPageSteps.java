package gmibank.step_defs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gmibank.pages.US0010_LoginPages;
import gmibank.utilities.Driver;

public class US0010_LoginPageSteps {


        US0010_LoginPages gmiPage = new US0010_LoginPages();

        static String url = "https://gmibank.com/";

        @Given("I as a user navigate to GMI bank webPage")
        public void i_as_a_user_navigate_to_GMI_bank_webPage() {
                Driver.getDriver().get(url);
        }

        @Given("I as a user click to login sign")
        public void i_as_a_user_click_to_login_sign() {
                gmiPage.accountIcon.click();
        }

        @And("I as a user choose sign from dropdown menu")
        public void i_as_a_user_choose_register_from_dropdown_menu() {
                gmiPage.signInIcon.click();
        }

        @When("I as a user enter my UserName and Password in to opened frame")
        public void i_as_a_user_enter_my_UserName_and_Password_in_to_opened_frame() {
                gmiPage.usernameBox.sendKeys("Team26Customer");
                gmiPage.passwordBox.sendKeys("Team26Customer*");
        }

        @Then("I click sign in button and sign in")
        public void i_click_sign_in_button_and_sign_in() {
                gmiPage.submitSignIn.click();
        }

        @Then("I click to My Operation button")
        public void i_click_to_My_Operation_button() {
                gmiPage.myOperations.click();
        }

        @Then("I click to Manage Customers link")
        public void i_click_to_Manage_Customers_link() {
                gmiPage.manageCustomers.click();
        }

        @Then("I Click on Create a new Customer button to navigate Create Customer page")
        public void i_Click_on_Create_a_new_Customer_buttun_to_navigate_Create_Customer_page() {
                gmiPage.NewCustomer.click();
        }

}