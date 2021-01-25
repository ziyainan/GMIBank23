package gmibank.step_defs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gmibank.pages.US015_UserAccountsPage;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class US015_UserManagesAccountSteps {
	
	US015_UserAccountsPage page = new US015_UserAccountsPage();
	
	@Given("I login as a user")
	public void i_login_as_a_user() {
		String url = ConfigurationReader.getProperty("login_url");
		Driver.getDriver().get(url);
		Driver.waitAndClick(page.loginDropdown);
		Driver.waitAndClick(page.loginMenu);
		Driver.waitAndSendText(page.username,"abul");
		Driver.waitAndSendText(page.password,"Abul432!");
		Driver.waitAndClick(page.submit);
		Assert.assertNotEquals(Driver.getDriver().getCurrentUrl(),url,"Cannot login");
	}
	
	@Given("Click on My Operations dropdown")
	public void click_on_My_Operations_dropdown() {
		Driver.waitAndClick(page.myOperations);
	}
	
	@Given("Select My Accounts")
	public void select_My_Accounts() {
		Driver.waitAndClick(page.myAccounts);
	}
	
	@Then("I should see all account types and balance")
	public void i_should_see_all_account_types_and_balance() {
		SoftAssert soft=new SoftAssert();
		for(WebElement el : page.accountType)
			soft.assertEquals(el.getText(), "SAVING","Account Type is not SAVING");
		for (WebElement el : page.balance)
			soft.assertNotNull(el.getText(),"Balance is not visible");
		soft.assertAll();
	}
	
	@Then("I should see transactions")
	public void i_should_see_transactions() {
		SoftAssert soft=new SoftAssert();
		for (int i = 0; i < page.transaction.size(); i++) {
			Driver.waitAndClick(page.transaction.get(i));
			soft.assertEquals(page.amount.getText(),"Amount" ,"Amount is not visible");
		}
		soft.assertAll();
	}
	
}
