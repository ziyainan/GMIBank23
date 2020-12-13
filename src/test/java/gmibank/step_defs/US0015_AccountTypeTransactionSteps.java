package gmibank.step_defs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gmibank.pages.US003_US0007_US0015_US0016_StoriesPages;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;
import org.testng.asserts.SoftAssert;

public class US0015_AccountTypeTransactionSteps {
    SoftAssert soft;
    US003_US0007_US0015_US0016_StoriesPages page=new US003_US0007_US0015_US0016_StoriesPages();
    @Given("User sign in as a user")
    public void sign_in() {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmibank_login_url"));
        Driver.waitAndClick(page.loginDropdown,3);
        Driver.waitAndClick(page.loginitem,3);
        Driver.waitAndSendText(page.username,"abul",3);
        Driver.waitAndSendText(page.password,"Abul432!",3);
        Driver.waitAndClick(page.submit,3);

    }

    @Given("Click on my operation dropdown menu button")
    public void click_on_my_operation_dropdown_menu_button() {
        Driver.waitAndClick(page.myoperations,3);


    }

    @Given("click on my accounts button")
    public void click_on_my_accounts_button() {
        Driver.waitAndClick(page.manaccount,3);

    }

       @Then("user see all accounts type")
    public void user_see_all_accounts_type() {
            soft=new SoftAssert();
        for (int i = 0; i < page.accountType.size(); i++) {
               System.out.println(page.accountType.get(i).getText());
           soft.assertEquals(page.accountType.get(i).getText(), "SAVING");
           }
           soft.assertAll();

    }

    @Then("user see all balance")
    public void user_see_all_balance() {
        soft=new SoftAssert();
        for (int i = 0; i < page.balance.size(); i++) {
            System.out.println(page.balance.get(i).getText());
            soft.assertNotNull(page.balance.get(i).getText() );
        }
        soft.assertAll();
    }

    @When("user click on view transaction button, user should see transaction")
    public void user_click_on_view_transaction_button() {
        soft=new SoftAssert();
        for (int i = 0; i < page.transactionBttn.size(); i++) {
            Driver.waitAndClick(page.transactionBttn.get(i),3);
            soft.assertEquals(page.transAmount.getText(),"Amount" );
        }
        soft.assertAll();
    }
}
