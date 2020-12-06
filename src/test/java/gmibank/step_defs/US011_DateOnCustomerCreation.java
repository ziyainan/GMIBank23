package gmibank.step_defs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gmibank.pages.US011_DateOnCustomerCreationPage;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.DateUtil;
import gmibank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class US011_DateOnCustomerCreation {
	
	US011_DateOnCustomerCreationPage page = new US011_DateOnCustomerCreationPage();
	
	@When("I go to GMI Bank")
	public void visitGMIBank() {
		String url = ConfigurationReader.getProperty("gmibank_login_url");
		Driver.getDriver().get(url);
		Assert.assertEquals(
				"Cannot get into the website",
				url,
				Driver.getDriver().getCurrentUrl());
	}
	
	@And("Sign in as valid admin")
	public void signInAsValidAdmin() {
		Driver.waitAndClick(page.accountIcon);
		Driver.waitAndClick(page.signInLink);
		Driver.waitAndSendText(page.username,ConfigurationReader.getProperty("admin_username"));
		Driver.waitAndSendText(page.password,ConfigurationReader.getProperty("admin_password"));
		Driver.waitAndClick(page.signInButton);
		Assert.assertNotNull("Cannot login with given credentials",
				page.administrationMenu);
	}
	
	@Then("Select Administration Menu -> User Management -> Create New User")
	public void createNewUser() {
		Driver.waitAndClick(page.administrationMenu);
		Driver.waitAndClick(page.userManagementMenu);
		Driver.waitAndClick(page.createNewUserButton);
		Assert.assertEquals("",
				"https://gmibank.com/admin/user-management/new",
				Driver.getDriver().getCurrentUrl());
	}
	
	@Then("Fill out valid information and Save")
	public void fill_out_valid_information_and_Save() {
		String firstUrl = Driver.getDriver().getCurrentUrl();
		Driver.waitAndSendText(page.loginField, DateUtil.todaysDate5());
		Driver.waitAndSendText(page.firstNameField,"US011");
		Driver.waitAndSendText(page.lastNameField,"US011");
		Driver.waitAndSendText(page.emailField,DateUtil.todaysDate5()+"@US011.com");
		Driver.selectAnItemFromDropdown(page.authoritiesField,"ROLE_USER");
		Driver.waitAndClick(page.submitButton);
		Assert.assertNotEquals("User unable to be saved",
				firstUrl,
				Driver.getDriver().getCurrentUrl());
	}
	
	@Then("Created date should not be in the past")
	public void created_date_should_not_be_in_the_past() throws InterruptedException {
		Thread.sleep(1000);
		Driver.waitAndClick(page.dateSort);
		Thread.sleep(1000);
		String date = Driver.waitAndGetText(page.lastCreatedDate);
		String login = Driver.waitAndGetText(page.lastCreatedLogin);
		int dateDifference = Integer.parseInt(date.replaceAll("[ :/-]","")) -
				Integer.parseInt(login.replaceAll("[ :/-]",""));
		Assert.assertTrue(date+" is different than "+login,
				dateDifference < 2);
	}
	
}
