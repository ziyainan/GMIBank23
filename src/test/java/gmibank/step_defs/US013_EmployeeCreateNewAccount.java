package gmibank.step_defs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmibank.pages.US013_EmployeeCreateNewAccountPage;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;
import gmibank.utilities.YZMethods;
import org.junit.Assert;

public class US013_EmployeeCreateNewAccount {

    US013_EmployeeCreateNewAccountPage locators = new US013_EmployeeCreateNewAccountPage();

    @Given("Employee is on GMI Bank webpage")
    public void employee_is_on_GMI_Bank_webpage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmibank_login_url"));
    }

    @Then("Employee sign in")
    public void employee_sign_in() {
        Driver.waitAndClick(locators.accountMenu, 1);
        Driver.waitAndClick(locators.signIn, 1);
        Driver.waitAndSendText(locators.userName, ConfigurationReader.getProperty("userName"), 1);
        Driver.waitAndSendText(locators.password, ConfigurationReader.getProperty("password"), 1);
        Driver.waitAndClick(locators.signInButton, 1);
    }

    @Then("User click on My Operation")
    public void user_click_on_My_Operation() {
        Driver.waitAndClick(locators.myOperations,1);
    }

    @Then("Click on Manage Accounts")
    public void click_on_Manage_Accounts() {
        Driver.waitAndClick(locators.manageAccounts,1);
    }

    @Then("Click on Create a new Account")
    public void click_on_Create_a_new_Account() {
        Driver.waitAndClick(locators.createNewAccount,1);
    }

    @Then("Enter Description {string}")
    public void enter_Description(String description) {
        Driver.waitAndSendText(locators.description,description,1);
    }

    @Then("Fill all fields except description")
    public void fillAllFieldsExceptDescription() {
        Driver.waitAndSendText(locators.balance,ConfigurationReader.getProperty("balance"),1);
    }

    @Then("Click on save")
    public void click_on_save() throws InterruptedException {
        Driver.waitAndClick(locators.saveButton,1);
    }


    @Then("Leave Description Blank")
    public void leaveDescriptionBlank() {

    }

    @Then("User see error message")
    public void userSeeErrorMessage() {
        Driver.waitForVisibility(locators.errorMessage,1);
    }

    @And("User enter amount {string}")
    public void UserEnterAmount(String balance) throws InterruptedException {
        Driver.waitAndSendText(locators.balance, balance, 1);
    }

    @Then("Fill all fields except balance")
    public void fillAllFieldsExceptBalance() throws InterruptedException {
        Driver.waitAndSendText(locators.description,ConfigurationReader.getProperty("description"),1);
    }

    @Then("Create unsuccessful")
    public void createUnsuccessful() throws InterruptedException {
        Driver.wait(1);
        Assert.assertFalse(locators.toastify.isDisplayed());
        Driver.wait(1);
    }

    @And("User select account type {string}")
    public void userSelectAccountType(String accountType) {
        Driver.selectAnItemFromDropdown(locators.accountType,accountType);
    }

    @Then("Fill all fields except account type")
    public void fillAllFieldsExceptAccountType() {
        Driver.waitAndSendText(locators.balance,ConfigurationReader.getProperty("balance"),1);
        Driver.waitAndSendText(locators.description,ConfigurationReader.getProperty("description"),1);
    }

    @Then("Fill all fields except account status type")
    public void fillAllFieldsExceptAccountStatusType() {
        Driver.waitAndSendText(locators.balance,ConfigurationReader.getProperty("balance"),1);
        Driver.waitAndSendText(locators.description,ConfigurationReader.getProperty("description"),1);
    }

    @And("Fill all fields except employee")
    public void fillAllFieldsExceptEmployee() {
        Driver.waitAndSendText(locators.balance,ConfigurationReader.getProperty("balance"),1);
        Driver.waitAndSendText(locators.description,ConfigurationReader.getProperty("description"),1);
    }

    @And("User select account Status type {string}")
    public void userSelectAccountStatusType(String accountStatusType) {
        Driver.selectAnItemFromDropdown(locators.accountStatusType,accountStatusType);
    }

    @Then("User select an employee {string}")
    public void userSelectAnEmployee(String Employee) {
        Driver.selectAnItemFromDropdown(locators.employee,Employee);
    }

    @Then("Account Create Successful")
    public void accountCreateSuccessful() {
        Driver.wait(1);
        Assert.assertTrue(locators.toastify.getText().contains("created"));
        Driver.wait(1);
    }
}
