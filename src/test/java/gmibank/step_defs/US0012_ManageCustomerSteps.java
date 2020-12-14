package gmibank.step_defs;

import cucumber.api.java.en.*;
import gmibank.pages.US0012_ManageCustomerPages;
import gmibank.utilities.BrowserUtils;
import gmibank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;

public class US0012_ManageCustomerSteps {

    US0012_ManageCustomerPages us0012_manageCustomerPages=new US0012_ManageCustomerPages();

    @Given("user goes to Manage Customers module on My Operations link")
    public void user_goes_to_Manage_Customers_module_on_My_Operations_link() {
        Driver.waitAndClick(us0012_manageCustomerPages.myOperationsLink,2);
        Driver.waitAndClick(us0012_manageCustomerPages.manageCustomersLink,2);

    }

    @Then("verify all customer info has been populated")
    public void verify_all_customer_info_has_been_populated() {
        BrowserUtils.verifyElementDisplayed(us0012_manageCustomerPages.firstnameText);
        BrowserUtils.verifyElementDisplayed(us0012_manageCustomerPages.lastnameText);
        BrowserUtils.verifyElementDisplayed(us0012_manageCustomerPages.middleInitialText);
        BrowserUtils.verifyElementDisplayed(us0012_manageCustomerPages.mobilePhoneNumberText);
        BrowserUtils.verifyElementDisplayed(us0012_manageCustomerPages.phoneNumberText);
        BrowserUtils.verifyElementDisplayed(us0012_manageCustomerPages.emailText);
        BrowserUtils.verifyElementDisplayed(us0012_manageCustomerPages.addressText);
        BrowserUtils.verifyElementDisplayed(us0012_manageCustomerPages.createDateText);
    }

    @Then("verify there is View button")
    public void verify_there_is_View_button() {
        BrowserUtils.verifyElementDisplayed(us0012_manageCustomerPages.viewButton);
    }

    @Then("verify Edit button is on the Customer information page")
    public void verify_Edit_button_is_on_the_Customer_information_page() {
        Driver.waitAndClick(us0012_manageCustomerPages.viewButton,2);
        BrowserUtils.verifyElementDisplayed(us0012_manageCustomerPages.editButtoninView);
    }

    @Then("edit the first name, mobile phone number and account type")
    public void edit_the_first_name_mobile_phone_number_and_account_type() {
        Driver.waitAndClick(us0012_manageCustomerPages.viewButton,2);
        Driver.waitAndClick(us0012_manageCustomerPages.editButtoninView,2);
        Driver.waitAndClearAndUpdate(us0012_manageCustomerPages.firstnameTextbox,"Edited",2);
        Driver.waitAndClearAndUpdate(us0012_manageCustomerPages.mobilePhoneTextbox,"555-444-3333",2);
        Driver.selectAnItemFromDropdown(us0012_manageCustomerPages.accountDropdown,"Global Account2");
}
    @Then("user clicks on Delete button and verifies deleting message has poped up")
    public void user_clicks_on_Delete_button_and_verifies_deleting_message_has_poped_up() {
        Driver.waitAndClick(us0012_manageCustomerPages.deleteButton,2);
//        BrowserUtils.verifyElementDisplayed(us0012_manageCustomerPages.deletionMessage);
        //Assert.assertTrue(us0012_manageCustomerPages.deletionMessage.getText().contains("Are you sure you want to delete Customer 5427?"));

//        String alert = Driver.getDriver().switchTo().alert().getText();
//        System.out.println(alert);

        System.out.println(us0012_manageCustomerPages.deletionMessage.getText());
        //Assert.assertTrue(us0012_manageCustomerPages.deletionMessage.isDisplayed());

    }
}
