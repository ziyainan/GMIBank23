package gmibank.step_defs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmibank.pages.US004_LoginValidPage;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;

public class US004_LoginValidStepDef {

    gmibank.pages.US004_LoginValidPage US004_LoginValidPage = new US004_LoginValidPage();

    @Given("time to go login page")
    public void time_to_go_login_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("gmibank_login_url"));
//        loginPage.loginDropdown.click();
        Driver.waitAndClick(US004_LoginValidPage.myloginDropdown,5);
        US004_LoginValidPage.mysignInButton.click();
    }

    @Given("user provides a valid username {string} and password {string}")
    public void user_provides_a_valid_username_and_password(String username, String password) {

        Driver.waitAndSendText(US004_LoginValidPage.myusername,username,5);

        Driver.waitAndSendText(US004_LoginValidPage.mypassword,password,5);


    }

    @Then("time to logs in")
    public void time_to_logs_in() {


        Driver.waitAndClick(US004_LoginValidPage.myLoginButton,5);
    }


    @Then("time to cancel logs in")
    public void time_to_cance_logs_in() {

        Driver.waitAndClick(US004_LoginValidPage.myCancelButton,5);
    }
}
