package gmibank.step_defs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gmibank.pages.US003_US0007_US0015_US0016_StoriesPages;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class US0016_MoneyTransferSteps {

    US003_US0007_US0015_US0016_StoriesPages money=new US003_US0007_US0015_US0016_StoriesPages();
    @Given("Go to website")
    public void go_to_http_gmibank_com() {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmibank_login_url"));
    }

    @Given("Sign in as a user username {string} and password {string}")
    public void sign_in_as_a_user_username_and_password(String string, String string2) {
        Driver.waitAndClick(money.loginDropdown,3);
        Driver.waitAndClick(money.loginitem,3);
        Driver.waitAndSendText(money.username, string, 3);
        Driver.waitAndSendText(money.password,string2,3);
        Driver.waitAndClick(money.submit,3);
    }

    @Given("Click the My Operations then click My accounts")
    public void click_the_My_Operations_then_click_My_accounts() {
        Driver.waitAndClick(money.myoperations,3);
        Driver.waitAndClick(money.tranferMoneyBttn,3);
    }

    @When("user click the From dropdown")
    public void user_click_the_From_dropdown() {
        Driver.waitAndClick(money.accountid);

    }

    @Then("user can see at least two account and user can choose first one")
    public void user_can_see_at_least_account_and_user_can_choose_first_one() {
        Select slc=new Select(money.accountid);
        int a=slc.getOptions().size();
        //   System.out.println(a);
        Assert.assertTrue(a>2);
    }

    @When("user click the To dropdown")
    public void user_click_the_To_dropdown() {
       Driver.waitAndClick(money.toPart);
    }

    @Then("user can choose an account for sending money")
    public void user_can_choose_an_account_for_sending_money() {
        Driver.waitAndClick(money.toPart);
       Select select=new Select(money.toPart);
       select.getFirstSelectedOption();

    }

    @When("user click the amount part")
    public void user_click_the_amount_part() {
        Driver.waitAndClick(money.balanceplace);
    }

    @Then("user can enter amount of money what you want send {string}")
    public void user_can_enter_amount_of_money_what_you_want_send(String string) {
        Driver.waitAndSendText(money.balanceplace,string);
    }

    @When("user click the description  part")
    public void user_click_the_description_part() {
        Driver.waitAndClick(money.description,3);
    }

    @Then("user can enter description about transaction {string}")
    public void user_can_enter_description_about_transaction(String string) {
        Driver.waitAndSendText(money.description,string);
    }

    @When("user click the description without enter amount of money for send")
    public void user_click_the_description_without_enter_amount_of_money_for_send() {
        Driver.waitAndClick(money.description,3);
    }

    @Then("When System shows This field is required. error")
    public void System_shows_This_field_is_required_error() {
        Assert.assertEquals("This field is required.", Driver.waitAndGetText(money.firstinvalidate,3));
    }

    @When("user click the Make Transfer without enter any description note")
    public void user_click_the_Make_Transfer_without_enter_any_description_note() {
        Driver.waitAndClick(money.maketransfer,3);
    }

    @Then("System shows This field is required. error")
    public void system_shows_This_field_is_required_error() {
        Assert.assertEquals("This field is required.", Driver.waitAndGetText(money.secondinvalidate,3));
    }

    @When("user click the From dropdown and chose first account")
    public void user_click_the_dropdown_and_chose_first_account() {

        Select slcfrom = new Select(money.accountid);

//        List<WebElement> alloptions = slcfrom.getOptions();
//        for (WebElement option : alloptions) {
//            System.out.println(option.getText());
            slcfrom.selectByValue("2301");
        }


        @When("user Click the To dropdown and chose one account")
        public void user_Click_the_dropdown_and_chose_one_account() {

              Select slcto=new Select(money.toPart);
            slcto.selectByValue("3977");

         }
    @When("user Click the amount and enter the amount of money")
    public void user_Click_the_amount_and_enter_the_amount_of_money() {
        Driver.waitAndSendText(money.balanceplace,"50");

    }

    @When("user Click the description and enter your description about transaction {string}")
    public void user_Click_the_description_and_enter_your_description_about_transaction(String string) {
        Driver.waitAndSendText(money.description,string);

    }

    @When("user Click the Make transfer button")
    public void user_Click_the_Make_transfer_button() {
        Driver.waitAndClick(money.maketransfer,3);

    }

    @Then("System should make the transfer and give me a success message for about it.")
    public void system_should_make_the_transfer_and_give_me_a_success_message_for_about_it() throws InterruptedException {

            Thread.sleep(2000);
            Assert.assertTrue(Driver.waitAndGetText(money.success,3).contains("succesfull"));
    }
}
