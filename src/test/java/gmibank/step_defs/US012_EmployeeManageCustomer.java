package gmibank.step_defs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmibank.pages.US012_EmpManCustPage;

import static gmibank.utilities.Driver.loginAll;

public class US012_EmployeeManageCustomer {
    US012_EmpManCustPage US012_Page = new US012_EmpManCustPage();

    @Given("Login in the employee account")
    public void loginInTheEmployeeAccount() {
        loginAll("employee");
    }

    @Then("Navigate to Manage Customers page")
    public void navigateToManageCustomersPage() {
       US012_Page.myOperation.click();
       US012_Page.manageCustomers.click();
    }

//
//    @And("Validate the customer information")
//    public void validateTheCustomerInformation() {
//
//    }
//
//    @Then("Validate in customer information the View option")
//    public void validateInCustomerInformationTheViewOption() {
//
//    }
//
//    @And("User can navigate the customer information after click the View option")
//    public void userCanNavigateTheCustomerInformationAfterClickTheViewOption() {
//
//    }
//
//    @And("User see Edit button in customer info page")
//    public void userSeeEditButtonInCustomerInfoPage() {
//    }
//
//
//    @Then("User can navigate to create or update the user info page with edit portal")
//    public void userCanNavigateToCreateOrUpdateTheUserInfoPageWithEditPortal() {
//    }
//
//    @And("User can create and update user info")
//    public void userCanCreateAndUpdateUserInfo() {
//    }
//
//    @Then("User can delete customer")
//    public void userCanDeleteCustomer() {
//    }
//
//    @And("User when delete the customer see a message about confirm deleting")
//    public void userWhenDeleteTheCustomerSeeAMessageAboutConfirmDeleting() {
//    }
}
